Магазин за автомобили :blue_car:
================================

Ще създадем система за управление на магазин за автомобили, която предоставя
следните възможности:
* добавяне на нови автомобили
* премахване на вече добавени автомобили
* търсене на автомобил по регистрационен номер
* търсене на автомобили по даден модел
* предоставяне на информация за автомобилите в магазина, сортирани по определени
критерии

Магазин
-------
За целта създайте клас `CarStore`, който има следните методи:
```java
public class CarStore {
    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
    public boolean add(Car car) {
    }

    /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store cars are changed after the execution
     * (i.e. at least one new car is added to the store)
     */
    public boolean addAll(Collection<Car> cars) {
    }

    /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
    public boolean remove(Car car) {
    }

    /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this
     * registration number is not found in the store
     **/
    public Car getCarByRegistrationNumber(String registrationNumber)
            throws CarNotFoundException {
    }

    /**
     * Returns all cars of a given model.
     * The cars need to be sorted by year of manufacture (in ascending order).
     */
    public Collection<Car> getCarsByModel(Model model) {
    }

    /**
     * Returns all cars sorted by their natural ordering
     * (according to the implementation of the Comparable<Car> interface).
     **/
    public Collection<Car> getCars() {
    }

    /**
     * Returns all cars sorted according to the
     * order induced by the specified comparator.
     */
    public Collection<Car> getCars(Comparator<Car> comparator) {
    }

    /**
     * Returns all cars sorted according to the
     * given comparator and boolean flag for order.
     * @param isReversed if true, the cars should be returned in reverse order
     */
    public Collection<Car> getCars(Comparator<Car> comparator,
                                   boolean isReversed) {
    }

    /**
     * Returns the total number of cars in the store.
     */
    public int getNumberOfCars() {
    }

    /**
     * Returns the total price of all cars in the store.
     */
    public int getTotalPriceOfCars() {
    }
}
```

**Забележка**: Natural ordering (Естествената наредба) на `Car` е наредбата на
автомобилите, зададена спрямо Comparable<Car> интерфейса. Трябва да
имплементирате този интерфейс за автомобилите, като естествената наредба трябва
да подрежда автомобилите първо по модел (по азбучен ред) и след това по година
на производство (в нарастващ ред).

Описание на методите:
* `public boolean add(Car car)` - добавя подадения автомобил в магазина. Връща
`true`, ако автомобилът е добавен успешно в магазина, и `false` иначе.
* `public boolean addAll(Collection<Car> cars)` - добавя всички автомобили от
подадената колекция в магазина. Връща `true`, ако поне един автомобил от
колекцията е добавен успешно в магазина, и `false` иначе.
* `public boolean remove(Car car)` - премахва подадения автомобил от магазина.
Връща `true`, ако автомобилът е премахнат успешно от магазина, и `false` иначе.
* `public Car getCarByRegistrationNumber(String registrationNumber)` - връща
автомобила с регистрационен номер `registrationNumber` в магазина. Хвърля
`CarNotFoundException`, ако автомобил с регистрационен номер
`registrationNumber` не съществува в магазина.
* `public Collection<Car> getCarsByModel(Model model)` - връща колекция от
всички автомобили с модел `model` в магазина, сортирани по година на
производство във възходящ ред.
* `public Collection<Car> getCars()` - връща колекция от всички автомобили в
магазина, сортирани спрямо естествената им наредба (natural ordering), т.е.
спрямо имплементацията на `Comparable<Car>` интерфейса за автомобилите (вижте
забележката по-горе).
* `public Collection<Car> getCars(Comparator<Car> comparator)` - връща колекция
от всички автомобили в магазина, сортирани спрямо подадения компаратор
`comparator`.
* `public Collection<Car> getCars(Comparator<Car> comparator, boolean isReversed)` -
връща колекция от всички автомобили в магазина, сортирани спрямо подадения
компаратор `comparator` и булевия флаг за обръщане на наредбата `isReversed`.
Ако `isReversed` е `true`, наредбата спрямо компаратора `comparator` се обръща,
т.е. автомобилите трябва да бъдат върнати спрямо компаратора `comparator`, но в
обратен ред.
* `public int getNumberOfCars()` - връща броя на всички автомобили в магазина.
* `public int getTotalPriceOfCars()` - връща общата цена на всички автомобили в
магазина.

Автомобили
----------
Всеки автомобил има модел (`model`), година на производство (`year`), цена
(`price`), вид на двигателя (`engineType`) и регистрационен номер
(`registrationNumber`).

Създайте абстрактен клас или интерфейс `Car` със следните методи:
```java
public <type> Car {
    /**
     * Returns the model of the car.
     */
    public Model getModel();

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear();

    /**
     * Returns the price of the car.
     */
    public int getPrice();

    /**
     * Returns the engine type of the car.
     */
    public EngineType getEngineType();

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber();
}
```

Конкретните имплементации на `Car` са `OrdinaryCar` (обикновен автомобил) и
`SportsCar` (спортен автомобил) и трябва да имат следните конструктори:
```java
public OrdinaryCar(Model model, int year, int price, EngineType engineType, Region region);

public SportsCar(Model model, int year, int price, EngineType engineType, Region region);
```

* Моделът на автомобил се задава чрез `enum`-а `Model` със следните възможни
стойности: `ALFA_ROMEO`, `AUDI`, `BMW`, `MERCEDES`, `FERRARI`, `OPEL`.
* Видът на двигателя на автомобил се задава чрез `enum`-а `EngineType` със
следните възможни стойности: `DIESEL`, `GASOLINE`, `ELECTRIC`, `HYBRID`.
* `Region` е `enum` със следните възможни стойности: `SOFIA`, `BURGAS`, `VARNA`,
`PLOVDIV`, `RUSE`, `GABROVO`, `VIDIN`, `VRATSA`.
* Всеки автомобил се идентифицира уникално чрез регистрационния си номер. Той се
образува по следния начин:
`<region><number><random alphabet char><random alphabet char>`, където
`<number>` е цяло число, започващо от 1000 за всяка една област (т.е. ако
създадем първите два автомобила от различни области, `<number>` частта им от
регистрационния номер ще бъде 1000 и за двата автомобила) и увеличаващо се с 1
при всеки новосъздаден автомобил, `<random alphabet char>` e произволна буква от
латинската азбука, а `<region>` е един от следните областни кодове (буквите на
кодовете са от латинската азбука):
  * Бургас -> A
  * София -> CB
  * Варна -> B
  * Видин -> BH
  * Враца -> BP
  * Габрово -> EB
  * Пловдив -> PB
  * Русе -> P
  **Примери**: CB1111AA, P1234JA

`enum`-ът `Region` трябва да има метод `getPrefix()`, който връща областния код.

Забележки
---------
* Качен е проект с начални файлове, които може да използвате.
* Към началните файлове има и файл, съдържащ базови тестове
(`SampleCarStoreTest.java`). Може да си ги пускате, докато решавате задачата, за
да валидирате (поне частично, тъй като тестовете са малко и покриват само
няколко основни функционалности от задачата) вашето решение. Ще получите
**бонус**, ако напишете и допълнителни смислени тестове, покриващи цялата
функционалност на `CarStore` класа. Те ще ви помогнат и в имплементацията на
коректно решение на задачата.
