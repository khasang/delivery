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

______

### <a name="dao">DAO</a>
> DAO слой непосредственно взаимодействует с базой данных. 
###### *Включает в себя интерфейсы:*
- ***BasicDao** - дженерик интерфейс, описывающий базовые CRUD-операции.*
- ***CustomerDao** - интерфейс, унаследованный от BasicDao и расширяющий его функционал дополнительными методами взаимодействия сущности заказчика с базой данных*

#### *To be continued...*

## Feature products

Функционал отвечает за управление сущностями товаров и связанных с ними сущностями изображений товаров и разделов каталога товаров.

*Реализован на уровнях:*
- [**Entity**](#product_entity)
- [**Dao**](#product_dao)
- [**Service**](#product_service)
- [**Controller**](#product_controller)

### <a name = "product_entity"></a> Product entities 

Включают в себя следующие сущности, представленные одноименными java классами:

* **Product** - товар
* **ProductCatalogSection** - раздел каталога товаров
* **ProductImage** - изображение, связанное с товаром

Каждое поле имеет соответсвующие getter и setter.
##### Product.java
- `long id`
- `String name`
- `int price`
- `String description`
- `ProductCatalogSection productCatalogSection` - @ManyToOne
- `List<ProductImage> images` - @OneToMany

##### ProductCatalogSection.java
- `long id`
- `String name`
- `List<Product> products` - @OneToMany

##### ProductImage
- `long id`
- `Product product` - @ManyToOne
- `byte[] image`

### <a name = "product_dao"></a> Product DAOs

Представлены следующими DAO, каждый из которых является расширением базового **BasicDao**:

* **ProductDao** имеет следующие специфичные методы
    - `List<Product> findByName(String name)`
    - `List<Product> findByPriceRange(int min, int max)`
    - `List<Product> findByCatalogSectionId(long sectionId)`

* **ProductCatalogSectionDao**
* **ProductImageDao**

### <a name = "product_service"> </a> Product service
    
   - `List<Product> getAllProducts()`
   - `List<Product> getProductsByName(String name)`
   - `Product addProduct(Product product)`
   - `Product updateProduct(Product product)`
   - `Product deleteProduct(long id)`
   - `Product getProductById(long id)`
   - `List<Product> getProductsByPriceRange(int min, int max)`
   - `List<Product> getProductsByCatalogSectionId(long sectionId)`
   - `List<ProductCatalogSection> getAllCatalogSections()`
   - `ProductCatalogSection addCatalogSection(ProductCatalogSection section)`
   - `ProductCatalogSection getCatalogSectionById(long sectionId)`
   - `ProductCatalogSection updateCatalogSection(ProductCatalogSection section)`
   - `ProductCatalogSection deleteCatalogSection(long sectionId)`
   - `List<ProductImage> getImagesByProductId(long id)`
   - `ProductImage addImage(ProductImage image)`
   - `ProductImage deleteImage(long imageId)`
   - `ProductImage getImageById(long imageId)`
   
### <a name = "product_controller"> </a> Product controller 
Mapped to "/products":
##### Function mappings:
- `List<Product> getAllProducts()` - "/getAllProducts"
- `List<Product> getProductsByName(@PathVariable(value = "name") String name)` - "/getProductsByName/{name}"
- `Product addProduct(@RequestBody Product product)` - "/addProduct"
- `Product updateProduct(@RequestBody Product product)` - "/updateProduct"
- `Product deleteProduct(@PathVariable(value = "id") String inputId)` - "/deleteProduct/{id}"
- `Product getProductById(@PathVariable(value = "id") String id)`- "/getProductById/{id}"
- `List<Product> getProductsByPriceRange(@PathVariable(value = "min") int min, @PathVariable(value = "max") int max)` - "/getProductsByPriceRange/{min}/{max}"
- `List<Product> getProductsByCatalogSectionId(@PathVariable(value = "id") String id)` - "/getProductsByCatalogSectionId/{id}"
- `String showProductImageUploadForm()` - "/images/add"
- `String showProductImage()` - "/images/show"
- `Long uploadProductImage(@RequestParam("file") MultipartFile file, @RequestParam("productId") String productId)` - "/images/upload"
- `Long deleteImage(@PathVariable(value = "id") String inputId)` - "/deleteImage/{id}"
- `List<Long> getImageIdsByProductId(@PathVariable(value = "id") String productId)` - "/getImageIdsByProductId/{id}"
- `byte[] getImageById(@PathVariable(value = "id")` - "/getImageById/{id}"
- `List<ProductCatalogSection> getAllCatalogSections()` - "/getAllCatalogSections"
- `ProductCatalogSection addCatalogSection(@RequestBody ProductCatalogSection section)` - "/addCatalogSection"
- `ProductCatalogSection updateCatalogSection(@RequestBody ProductCatalogSection section)` - "/updateCatalogSection"
- `ProductCatalogSection deleteCatalogSection(@PathVariable(value = "id") String inputId)` - "deleteCatalogSection/{id}"
- `ProductCatalogSection getCatalogSectionById(@PathVariable(value = "id") String id)` - "/getCatalogSectionById/{id}"
