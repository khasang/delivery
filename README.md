# Delivery
## Инетграция Яндекс карт 
Интегрированная Яндекс-карта позволяет:

* <a href="#addOffice">Добавлять офис</a> компании на карту

* <a href="#addDescription">Добавлять пояснения</a> к офису, отображаемому на карте

* <a href="#removeOffice">Удалять</a> офис с карты
### <a name="addOffice"></a> Добавление офиса

<p>
Для добавления нового офиса на карту, необходимо щелкнуть по карте в месте расположения офиса. Офис будет добавлен. После добавления офиса его можно сохранить в базу данных, однако рекомендуется <a href="#addDescription">добавить описание</a> офиса.
</p>

![Добавление офиса](http://image.prntscr.com/image/1401f7b3d15f49c08e0439f8090295ff.png)

### <a name="addDescription"></a>Добавление описания офиса
<p>
После добавления офиса на карту, можно добавить описание данному офису. Для этого в форме, расположенной ниже карты в строке "Описание офиса" задать необходимо описание офиса. Добавив описание офиса, необходимо нажать но кнопку Сохранить, при этом метка на карте изменит свою подпись  с адреса офиса на его описание. Адрес офиса будет доступен по щелчку по метке.
</p>

![Добавление офиса](http://image.prntscr.com/image/7e56b59ffa08469da34e16bbaa31f08b.png)

### <a name="removeOffice"></a>Удаление офиса
<p>
Для удаления офиса с карты необходимо кликнуть по удаляемому офису и во всплывающей подсказке нажать кнопку Удалить. Офис будет удален с карты, а также с базы данных.
</p>

![Добавление офиса](http://image.prntscr.com/image/ddff9b7895fe41f4bb1945306b309c1b.png)

_______

## Customer feature
>Данный функционал призван обеспечить управление (создание, получение, изменение, удаление) сущностью заказчика в базе данных.

*Реализован на уровнях:*
- [**Entity**](#entity)
- [**Dao**](#dao)
- **Service**
- **Controller**
_____

### <a name="entity">Entity</a>
>Реализацией Entity является **Customer.java**. Данный класс описывает сущность заказчика, помечен аннотацией @Entity, имеет приватные поля, являющиеся колонками таблицы customers, доступ к которым организован с помощью гетторв и сеттеров.
##### Класс *Customer.java* содержит следующие поля:
1. ***id** - (доступ private, тип long) характеризует уникальный идентификационный номер заказчика. Является первичным ключом таблицы customers. Не может иметь нулевого значения. Автоинкрементируемо на стороне хибернейта. Имеет кастомизированное имя колонки **"customer_id"** в таблице customers.*
2. ***name** - (доступ private, тип String) содержит наименование заказчика.*
3. ***address** - (доступ private, тип String) содержит адрес заказчика. Не может иметь нулевого значения.*
4. ***phoneNumber** - (доступ private, тип String) содержит номер телефона заказчика. Не может иметь нулевого значения. Имеет кастомизированное имя колонки **"phone_number"** в таблице customers. Содержит только уникальные данные.*
5. ***eMail** - (доступ private, тип String) содержит адрес электронной почты заказчика. Не может иметь нулевого значения. Имеет кастомизированное имя колонки **"e_mail"** в таблице customers. Содержит только уникальные данные.*

##### Класс *Customer.java* имеет методы:
###### *Сеттеры:*
- ***public void setId(Long id)** - сеттер для поля **id**.* 
- ***public void setName(String name)** - сеттер для поля **name**.*
- ***public void setAddress(String address)** - сеттер для поля **address**.*
- ***public void setPhoneNumber(String phoneNumber)** - сеттер для поля **phoneNumber**.*
- ***public void seteMail(String eMail)** - сеттер для поля **eMail**.*
>Сеттеры задают значение соответствующего поля класса равным переданному в них значению аргумента.
###### *Геттеры:*
- ***public long getId()** - геттер для поля **id**.*
- ***public String getName()** - геттер для поля **Name**.*
- ***public String getAddress()** - геттер для поля **Address**.*
- ***public String getPhoneNumber()** - геттер для поля **PhoneNumber**.*
- ***public String geteMail()** - геттер для поля **eMail**.*
>Геттеры возвращают значение соответствующего поля класса.
_____

### <a name="dao">DAO</a>
> DAO слой создан для непосредственного взаимодействует с базой данных. 
###### *Включает в себя интерфейсы:*
- [***BasicDao***](#basicDao)
- [***CustomerDao***](#customerDao) *extends BasicDao*
###### *И реализующий их класс [**CustomerDaoImpl.java**](#customerDaoImpl)*
_____

##### <a name="basicDao">*BasicDao interface*</a> 
>Является дженерик интерфейсом, описывающим базовые CRUD-операции.<Br>Реализацией интерфейса является **CustomerDaoImpl.java** 
###### Интерфейс BasicDao содержит методы:
- ***Session getCurrentSession()** - возвращает текущую сессию Хибернейта.*
- ***List<T> getList()** - возвращает список сущностей из базы данных.*
- ***T create(T entity)** - создает сущность в базе данных, переданную в метод в качестве параметра.*
- ***T update(T entity)** - изменяет сущность в базе данных, переданную в метод в качестве параметра.*
- ***T findById(long id)** - возвращает сущность из базы данных по параметру id.*
- ***T delete(T entity)** - удаляет сущность в базе данных, переданную в метод в качестве параметра.**
____

##### <a name="customerDao">*CustomerDao interface*</a> 
>Является интерфейсом, унаследованным от BasicDao и расширяющим его функционал дополнительными методами взаимодействия сущности заказчика с базой данных.<Br>Реализацией интерфейса является **CustomerDaoImpl.java**

###### Интерфейс CustomerDao содержит методы:
- ***List\<Customer> findCustomerByName(String name)** - возвращает список заказчиков, имя которых соответстует переданному в метод параметру.*
- ***List\<Customer> findCustomerByAddress(String address)** - возвращает список заказчиков, адрес которых соответстует переданному в метод параметру.*
- ***Customer findCustomerByPhoneNumber(String phoneNumber)** - возвращает уникального заказчика, номер телефона которого соответстует переданному в метод параметру.*
- ***Customer findCustomerByEmail(String eMail)** - возвращает уникального заказчика, адрес электронной почты которого соответстует переданному в метод параметру.*
_______

##### <a name="customerDaoImpl">*CusomerDaoImpl.java*</a>
> Класс, реализующий интерфейсы [***BasicDao***](#basicDao) и [***CustomerDao***](#customerDao). Работает с Entity [Customer.java](#entity).

_______

### <a name="service">Service</a>
> Service слой обеспечивает взаимосвязь между controller и dao слоем.
###### *Включает в себя интерфейсы:*
- [***CustomerService***](#customerService)
###### *Включает в себя классы:*
- [***CustomerServiceImpl***](#customerServiceImpl) который имплементирует интерфейс *CustomerService*
_____

##### <a name="customerService">*CustomerService interface*</a> 
>Является дженерик интерфейсом, описывающим основные операции по получении имени, адреса, почты, телефона заказчика а также id заказчика, получение списка всех заказчиков, создание, обновление и удаление заказчика. <Br>Реализацией интерфейса является **CustomerServiceImpl.java** 
###### Интерфейс CustomerService содержит методы:
- ***List\<Customer> getCustomerByName()** - получение списка по имени заказчика*
- ***List\<Customer> getCustomerByAddress** - получение списка по адресу заказчика*
- ***getCustomerByPhoneNumber()** - получение номера телефона заказчика*
- ***getCustomerByEmail()** - получение почты заказчика*
- ***getCustomerById()** - получение заказчика по id*
- ***List\<Customer> getAllCustomers()** - получение списка всех заказчиков*
- ***Customer createCustomer()** - создание заказчика*
- ***Customer updateCustomer()** - изменение заказчика*
- ***Customer deleteCustomer()** - удаление заказчика по его id*
____

##### <a name="customerServiceImpl">*CustomerServiceImpl.java*</a> 
> Класс описывает методы заказчика, такие как: поиск заказчика по имени, телефону, почте, адресу, по id, выводит список всех заказчиков, а также создание, обновление и удаление заказчика по его id. Класс помечен аннотацией @Service, имеет автосвязку с интерфейсом [***CustomerDao***](#customerDao) и работает через него.
###### Класс CustomerServiceImpl содержит методы:
- ***List\<Customer> findCustomerByName(String name)** - возвращает список заказчиков, имя которых соответстует переданному в метод параметру.*
- ***List\<Customer> findCustomerByAddress(String address)** - возвращает список заказчиков, адрес которых соответстует переданному в метод параметру.*
- ***Customer findCustomerByPhoneNumber(String phoneNumber)** - возвращает уникального заказчика, номер телефона которого соответстует переданному в метод параметру.*
- ***Customer findCustomerByEmail(String eMail)** - возвращает уникального заказчика, адрес электронной почты которого соответстует переданному в метод параметру.*
- ***getCustomerById()** - получение заказчика по id*
- ***getAllCustomers()** - получение списка всех заказчиков*
- ***Customer createCustomer()** - создание заказчика*
- ***Customer updateCustomer()** - изменение заказчика*
- ***Customer deleteCustomer()** - удаление заказчика по его id*
____

#### *To be continued...*

## Order feature
## Заказ

- [**Структура Order**](#структура-полей-класса-order)
- [**Методы класса Order**](#доступные-публичные-методы-класса-order)
- [**Структура BasketUnit**](#структура-полей-класса-basketunit)
- [**Методы класса BasketUnit**](#доступные-публичные-методы-класса-basketunit)
- [**Методы интерфейса сервиса OrderService**](#доступные-публичные-методы-интерфейса-сервиса-orderservice)
- [**REST запросы**](#rest-запросы)

Реализованы сущности ***Заказ*** и связанная с ним сущность ***Элемент корзины***

>Заказ реализован классом **Order.java** и таблицей **orders** в базе

### Структура полей класса Order:

| Назначение      | Тип              | Имя в классе     | Имя в таблице   |
| --------------- | ---------------- | ---------------- | --------------- |
| Ид заказа       | Long	         | id               | id              |
| Дата доставки	  | Date             | deliveryDate	    | delivery_date   |
| Время доставки  | Time             | deliveryTime	    | delivery_time   |
| Ид клиента	  | Long             | userId		    | user_id         |
| Адрес доставки  | String           | deliveryAddress  | delivery_address|
| Ид исполнителя  | Long             | executorId	    | executor_id     |
| Комментарий     | String           | comment		    | comment         |
| Корзина  		  | List<BasketUnit> | basketUnitList   |                 |

##### Доступные публичные методы класса Order:

###### *Сеттеры:*

- ***void setDeliveryDate(Date deliveryDate)*** - установить дату доставки
- ***void setDeliveryTime(Time deliveryTime)*** - установить время доставки
- ***void setUserId(Long userId)*** - уставновить ID пользователя
- ***void setDeliveryAddress(String deliveryAdress)*** - установить адрес доставки
- ***void setExecutorId(Long executorId)*** - установить ID исполнителя доставки
- ***void setComment(String comment)*** - установить комментарий
- ***void setBasketUnitList(List<BasketUnit> basketUnitList)*** - задать список юнитов/элементов*

###### *Геттеры:*

- ***Long getId()*** - получить ID заказа
- ***Date getDeliveryDate()*** - получить дату доставки
- ***Time getDeliveryTime()*** - получить время доставки
- ***Long getUserId()*** - получить ID пользователя
- ***String getDeliveryAddress()*** - получить адрес доставки
- ***Long getExecutorId()*** - получить ID исполнителя
- ***String getComment()*** - получить комментарий к заказу
- ***List<BasketUnit> getBasketUnitList()*** - получить список юнитов/элементов* в заказе

###### *Другие:*

- ***void addBasketUnit(BasketUnit basketUnit)*** - добавить юнит/элемент* в корзину заказа
- ***void removeBasketUnit(BasketUnit basketUnit)*** - удалить юнит/элемент* из корзины заказа
___
>Элемент корзины реализован классом **BasketUnit.java**, хранение элементов заказа в таблице **basket** в базе
*Юнит - элемент корзины, содержащий в себе ID товара, его количество и ID заказа

### Структура полей класса BasketUnit:
| Назначение	     | Тип	    | Имя в классе	| Имя в таблице |
| ------------------ | -------- | ------------- | ------------  |
| Ид заказа          |Long	    | Order			| order_id      |
| Ид единицы корзины |Long      | id		    | id            |
| Ид товара          |Long	    | itemId		| item_id       |
| Количество	     |quantity  | quantity      |               |

>Таблицы связаны двусторонней связью ОдинКоМногим по ключу order_id

##### Доступные публичные методы класса BasketUnit:

###### *Конструкторы:*

- ***BasketUnit()*** - создать юнит
- ***BasketUnit(Long itemId)*** - создать юнит с ID товара

###### *Сеттеры:*

- ***void setQuantity(int quantity)*** - указать количество единиц товара
- ***void setOrder(Order order)*** - указать заказ

###### *Геттеры:*

- ***Long getId()*** - получить ID юнита
- ***Order getOrder()*** - получить заказ
- ***Long getItemId()*** - получить ID товара
- ***int getQuantity()*** - получить количество единиц товара
___

### Доступные публичные методы интерфейса сервиса OrderService:

- ***Order create(Order order)*** - создать заказ
- ***Order findById(long id)*** - получить заказ по ID
- ***Order deleteOrder(long id)*** - удалить заказ по ID
- ***Order updateOrder(Order order)*** - обновить заказ
- ***List<Order> getOrderList()*** - получить список заказов
- ***List<Order> findByUserId(long uid)*** - получить список заказов по ID пользователя
- ***BasketUnit findBasketUnitById(long id)*** - получить юнит из корзины по ID
- ***BasketUnit deleteBasketUnitById(long id)*** - удалить юнит из корзины по ID

### REST запросы

* /order/add - добавить заказ
`http://localhost.com/order/add`

* /order/get/id/ - получить заказ по ID
`http://localhost.com/order/get/id/35`

* /order/get/uid/ - получить заказ по  ID пользователя
`http://localhost.com/order/order/get/uid/100`

* /order/update - обновить заказ
`http://localhost.com/order/update`

* /order/delete/ - удалить заказ по ID
`http://localhost.com/order/delete/35`

* /order/basket/delete/id/ - удалить единицу корзины по ID
`http://localhost.com/order/basket/delete/id/35`

* /order/basket/get/id/ - получить единицу корзины по ID
`http://localhost.com/order/basket/get/id/72`

