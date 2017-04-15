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
${status}
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
<nav>
    <div id="map" style="width: 600px; height: 400px">
        <script type="text/javascript">
            ymaps.ready(init);

            function init() {
                var myPlacemark,
                    myMap = new ymaps.Map('map', {
                        center: [55.753994, 37.622093],
                        zoom: 9
                    }, {
                        searchControlProvider: 'yandex#search'
                    });

                // Слушаем клик на карте.
                myMap.events.add('click', function (e) {
                    var coords = e.get('coords');

                    // Если метка уже создана – просто передвигаем ее.
                    if (myPlacemark) {
                        myPlacemark.geometry.setCoordinates(coords);
                    }
                    // Если нет – создаем.
                    else {
                        myPlacemark = createPlacemark(coords);
                        myMap.geoObjects.add(myPlacemark);
                        // Слушаем событие окончания перетаскивания на метке.
                        myPlacemark.events.add('dragend', function () {
                            getAddress(myPlacemark.geometry.getCoordinates());
                        });
                    }
                    getAddress(coords);
                });

                // Создание метки.
                function createPlacemark(coords) {
                    return new ymaps.Placemark(coords, {
                        iconCaption: 'поиск...'
                    }, {
                        preset: 'islands#violetDotIconWithCaption',
                        draggable: true
                    });
                }

                // Определяем адрес по координатам (обратное геокодирование).
                function getAddress(coords) {
                    myPlacemark.properties.set('iconCaption', 'поиск...');
                    ymaps.geocode(coords).then(function (res) {
                        var firstGeoObject = res.geoObjects.get(0);

                        myPlacemark.properties
                            .set({
                                iconCaption: firstGeoObject.properties.get('name'),
                                balloonContent: firstGeoObject.properties.get('text')
                            });
                    });
                }
            }

        </script>

    </div>
</nav>

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