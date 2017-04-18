<%--
  Created by IntelliJ IDEA.
  User: ccomo
  Date: 29.03.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bootstrap 3</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!—Название сайта и кнопка раскрытия меню для мобильных-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Delivery</a>
        </div>

        <!—Само меню-->

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Главная</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Выпадающее меню 1<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Подменю 1</a></li>
                        <li><a href="#">Подменю 2</a></li>
                        <li><a href="#">Подменю 3</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Выпадающее меню 2<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Подменю 1</a></li>
                        <li><a href="#">Подменю 2</a></li>
                        <li><a href="#">Подменю 3</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Выпадающее меню 3<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Подменю 1</a></li>
                        <li><a href="#">Подменю 2</a></li>
                        <li><a href="#">Подменю 3</a></li>
                    </ul>
                </li>

                <li><a href="#">Новости</a></li>
                <li><a href="#">Контакты</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Войти</a></li>
                <li><a href="#">Регистрация</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="navbar-inner">
    <div class="container">
        <nav class="nav navbar-nav navbar-left">
            <div id="map" style="width: 600px; height: 400px" class="navbar-left">
                <script type="text/javascript">
                    var myMap;
                    var myPlacemark;
                    var placemarkCollection;
                    ymaps.ready(readDataFromDB);

                    function init() {

                        // Слушаем клик на карте.
                        window.myMap.events.add('click', function (e) {
                            var coords = e.get('coords');
                            // Если метка уже создана – просто передвигаем ее.
                            if (window.myPlacemark) {
                                window.myPlacemark.geometry.setCoordinates(coords);
                            }
                            // Если нет – создаем.
                            else {
                                window.myPlacemark = getNewPlacemark(coords);
                                window.myMap.geoObjects.add(window.myPlacemark);
                                // Слушаем событие окончания перетаскивания на метке.
                                window.myPlacemark.events.add('dragend', function () {
                                    getAddress(window.myPlacemark.geometry.getCoordinates());
                                });
                            }

                            getAddress(coords);
                            showPlacemarkInfo(coords);
                        });

                        // Определяем адрес по координатам (обратное геокодирование).
                        function getAddress(coords) {
                            window.myPlacemark.properties.set('iconCaption', 'поиск...');
                            ymaps.geocode(coords).then(function (res) {
                                var firstGeoObject = res.geoObjects.get(0);

                                window.myPlacemark.properties
                                    .set({
                                        iconCaption: firstGeoObject.properties.get('name'),
                                        balloonContent: firstGeoObject.properties.get('text')
                                    });
                            });
                        }

                        function showPlacemarkInfo(coords)
                        {
                            ymaps.geocode(coords).then(function (res)
                            {
                                var firstGeoObject = res.geoObjects.get(0);
                                var address = document.getElementById('address');
                                address.value = firstGeoObject.properties.get('text');

                                var coord = document.getElementById('coords');
                                coord.value = coords;
                            });
                        }
                    } //end of init()

                    function readDataFromDB() {
                        if (window.myPlacemark) {
                            window.myMap.geoObjects.remove(window.myPlacemark);
                            window.myPlacemark = undefined;
                        }

                        if (window.placemarkCollection)
                            window.placemarkCollection.removeAll();
                        else
                            window.placemarkCollection = new ymaps.GeoObjectCollection();

                        if (!window.myMap)
                        {
                            window.myMap = new ymaps.Map('map', {
                                center: [55.753994, 37.622093],
                                zoom: 9
                            }, {
                                searchControlProvider: 'yandex#search'
                            });

                        }

                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', '/office/all', false);
                        xhr.setRequestHeader('Content-Type', 'application/json');
                        xhr.send();
                        if(xhr.status == 200) {
                            //Парсим JSON
                            var placemarks = JSON.parse(xhr.responseText);
                            for (var i=0; i<placemarks.length; i++) {
                                buildPlacemark(placemarks[i]);
                            }
                        }
                        else {
                            alert(xhr.status);
                        }
                        myMap.geoObjects.add(window.placemarkCollection);
                        init();
                    }

                    // Создание метки.
                    function getNewPlacemark(coords) {
                        return new ymaps.Placemark(coords, {
                            iconCaption: 'поиск...'
                        }, {
                            preset: 'islands#violetDotIconWithCaption',
                            draggable: true
                        });
                    }

                    function buildPlacemark(point) {
                        var layout = ymaps.templateLayoutFactory.createClass(
                            '<div class="item">' +
                            '<p>{{properties.balloonContent}}</p>' +
                            '<button id="remove-placemark">{{properties.buttonText}}</button>' +
                            '</div>', {
                                build: function () {
                                    layout.superclass.build.call(this);
                                    document.getElementById('remove-placemark').addEventListener('click', this.onRemove);
                                },
                                clear: function () {
                                    document.getElementById('remove-placemark').removeEventListener('click', this.onRemove);
                                    layout.superclass.clear.call(this);
                                },
                                onRemove: function () {
                                    // post на сервер
                                    var xhr = new XMLHttpRequest();
                                    var body = '{"id":"'+point.id+'"}';
                                    xhr.open("POST", '/office/delete', false);
                                    xhr.setRequestHeader('Content-Type', 'application/json');
                                    xhr.send(body);
                                    //удаление метки с карты
                                    window.placemarkCollection.remove(placemark);
                                    //readDataFromDB();
                                }
                            });

                        var placemark = new ymaps.Placemark(pointFromString(point.coords), {
                            iconCaption: point.description,
                            balloonContent: point.address,
                            buttonText: "Удалить офис"
                        }, {
                            balloonContentLayout: layout,
                            preset: 'islands#violetDotIconWithCaption'// иконка растягивается под контент
                        });

                        window.placemarkCollection.add(placemark);
                    }

                    function pointFromString (point) {
                        var parts = point.split(',');
                        return [parseFloat(parts[0]), parseFloat(parts[1])];
                    }
                </script>
            </div>
        </nav>
    </div>
</div>

<form>
    <script type="text/javascript">
        function saveOffice() {
            //Запись координат в базу
            var address = document.getElementById('address');
            var coord = document.getElementById('coords');
            var descript = document.getElementById('description');

            var xhr = new XMLHttpRequest();
            var body = '{"address":"'+address.value+'", "coords":"'+coord.value+'", "description":"'+descript.value+'"}';
            xhr.open("POST", '/office/add', false);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(body);
            readDataFromDB();
        }
    </script>

    <div class="navbar-inner">
        <div class="container">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1"></span>
                <input id="address" type="text" class="form-control" placeholder="Адрес..." aria-describedby="basic-addon1" readonly>
            </div>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon2"></span>
                <input id="coords" type="text" class="form-control" placeholder="Координаты..." aria-describedby="basic-addon2" readonly>
            </div>

            <div class="input-group">
                <span class="input-group-addon"></span>
                <input id="description" type="text" class="form-control" placeholder="Описание офиса..." aria-describedby="basic-addon2">
            </div>
            <button type="button" class="btn btn-default navbar-btn" onclick="saveOffice()">Сохранить</button>
        </div>
    </div>
</form>

<div class="navbar-fixed-bottom row-fluid">
    <div class="navbar-inner">
        <div class="container">
            <nav class="nav navbar-nav navbar-left">
                (c) 2017<br>доставка
            </nav>
            <nav class="nav navbar-nav navbar-right">
                Бла-бла-бла
            </nav>
        </div>
    </div>
</div>

<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
</html>