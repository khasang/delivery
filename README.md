
# delivery
## Заказ
Реализованы сущности ***Заказ*** и связанная с ним сущность ***Корзина***

Заказ реализован классом **Order.java** и таблицей **orders** в базе **delivery**

### Структура полей класса Order:

| Назначение      | Тип              | Имя в классе     | Имя в таблице   |
| --------------- | ---------------- | ---------------- | --------------- |
| Ид заказа       | Long	           | id               | id              |
| Дата доставки	  | Date             | deliveryDate	    | delivery_date   |
| Время доставки  | Time             | deliveryTime	    | delivery_time   |
| Ид клиента			| Long             | userId		        | user_id         |
| Адрес доставки  | String           | deliveryAddress  | delivery_address|
| Ид исполнителя  | Long             | executorId	      | executor_id     |
| Комментарий		  | String           | comment		      | comment         |
| Корзина  			  | List<BasketUnit> | basketUnitList   |                 |

Корзина реализована классом **BasketUnit.java** и таблицей **basket** в базе **delivery**

### Структура полей класса BasketUnit:
| Назначение	       | Тип	    | Имя в классе	| Имя в таблице |
| ------------------ | -------- | ------------- | ------------  |
| Ид заказа          |Long	    | Order			    | order_id      |
| Ид единицы корзины |Long      | id		        | id            |
| Ид товара          |Long	    | itemId		    | item_id       |
| Количество	       |quantity  | quantity      |               |

Таблицы связаны двусторонней связью ОдинКоМногим по ключу order_id  

### REST сервис
* /order/add - добавить заказ
```web
http://localhost.com/order/add
```
* /order/get/id/ - получить заказ по ID
```web
http://localhost.com/order/get/id/35
```
* /order/get/uid/ - получить заказ по  ID пользователя
```web
http://localhost.com/order/order/get/uid/100
```
* /order/update - обновить заказ
```web
http://localhost.com/order/update
```
* /order/delete/ - удалить заказ по ID
```web
http://localhost.com/order/delete/35
```
* /order/basket/delete/id/ - удалить единицу корзины по ID
```web
http://localhost.com/order/basket/delete/id/35
```
* /order/basket/get/id/ - получить единицу корзины по ID
```web
http://localhost.com/order/basket/get/id/72
```
