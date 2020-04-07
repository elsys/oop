Приложение за виртуални портфейли
=================================
Да се създаде приложение за управление на виртуални карти.

Виртуален портфейл
------------------
Виртуаленият портфейл трябва да има следните функционалности:
* регистриране на нова карта
* премахване на съществуваща карта
* зареждане на конкретна карта с пари
* плащане с конкретна карта
* извличане на конкретна карта по име
* връщане на броя регистрирани карти
* сортиране на регистрираните карти по име и наличност

За целта да се съдаде следния интерфейс `IVirtualWallet`:
```java
public interface IVirtualWallet {
    /**
     * Registers a new card in the wallet.
     * Returns true if the operation is successful and false
     * if there is already a card with the same name.
     **/
    boolean registerCard(Card card);

    /**
     * Unregisters a card from the wallet.
     * Returns true if the operation is successful and false
     * if there is no such card.
     **/
    boolean unregisterCard(Card card);

    /**
     * Executes a payment from the given card. Returns true
     * if the operation is successful and false otherwise.
     **/
    boolean executePayment(Card card, PaymentInfo paymentInfo);

    /**
     * Feeds the given card with @amount money. Returns true
     * if the operation is successful and false otherwise.
     **/
    boolean feed(Card card, double amount);

    /**
     * Returns a card from the wallet with the given name.
     * If there is no such card, returns null.
     **/
    Card getCardByName(String name);

    /**
     * Returns the current number of registered cards in the wallet.
     **/
    int getTotalNumberOfCards();

    /**
     * Returns a new collection of all registered cards sorted by name.
     * This method does not modify the order of registered cards
     * stored in the wallet.
     **/
    Collection<Card> sortCardsByName();

    /**
     * Returns a new collection of all registered cards sorted by amount.
     * This method does not modify the order of registered cards
     * stored in the wallet.
     **/
    Collection<Card> sortCardsByAmount();
}
```

Описание на методите от интерфейса:
* `boolean registerCard(Card card);` - регистрира нова карта в портфейла. Връща
`true`, ако операцията е успешна, и `false`, ако има вече карта със същото име.
* `boolean unregisterCard(Card card);` - премахва регистрирана карта от
портфейла. Връща `true`, ако операцията е успешна, и `false`, ако няма такава
карта в портфейла.
* `boolean executePayment(Card card, PaymentInfo paymentInfo);` - извършва
плащане с подадената карта. Връща `true`, ако операцията е успешна, и `false`
иначе.
* `boolean feed(Card card, double amount);` - зарежда подадената карта с
`amount` пари. Връща `true`, ако операцията е успешна, и `false` иначе.
* `Card getCardByName(String name);` - връща карта от портфейла по име на
картата. Ако няма карта с това име в портфейла, връща `null`.
* `int getTotalNumberOfCards();` - връща броя на регистрираните карти в
портфейла.
* `Collection<Card> sortCardsByName();` - връща нова колекция от всички
регистрирани карти, сортирани по име. Методът не трябва да модифицира реда на
регистрираните карти, съхранени във виртуалния портфейл, а трябва да връща
винаги нова колекция със сортираните карти.
* `Collection<Card> sortCardsByAmount();` - връща нова колекция от всички
регистрирани карти, сортирани по налична сума пари. Методът не трябва да
модифицира реда на регистрираните карти, съхранени във виртуалния портфейл, а
трябва да връща винаги нова колекция със сортираните карти.

Помислете кога операциите `registerCard`, `unregisterCard`, `executePayment` и
`feed` могат да бъдат неуспешни (тоест да връщат `false`). Погрижете се и за
валидация на входните данни на горните операции - тоест горните операции са също
неуспешни, ако сме им подали невалиден вход.

Дефинирайте клас `VirtualWallet`, който имплементира интерфейса
`IVirtualWallet`.

Карти
-----
Създаденият `VirtualWallet` трябва да поддържа два типа карти - стандартни и
златни, съответно имплементирани от класовете `StandardCard` и `GoldenCard`.
Всяка карта има име (`name`) и налична сума пари (`amount`). Всяка карта се
конструира по име и има следните методи:
* `public String getName()` - връща името на картата.
* `public double getAmount()` - връща наличната сума пари в картата.
* `public boolean feed(double amount)` - зарежда картата с `amount` пари. Връща
`true`, ако операцията е успешна, и `false` иначе.
* `public boolean executePayment(double cost)` - извършва плащане на `cost` пари
чрез картата. Връща `true`, ако операцията е успешна, и `false` иначе.

Двата типа карти се различават в поведението си единствено при метода за плащане
на пари (`executePayment`). `StandardCard` извършва стандартно плащане - цялата
сума `cost` се изважда от наличната сума пари в картата, ако е достатъчна. При
всяко плащане с `GoldenCard` ни се връщат 15% от цената на покупката (`cost`),
като за да изпълним дадено плащане първо трябва наличността ни в картата да
покрива цената на покупката (`cost`) (преди да приложим "бонуса" от 15%).

Две карти са еднакви (спрямо `equals`), ако имат едно и също име.

Плащане
-------
Информацията за всяко плащане се съхранява в обекти от тип `PaymentInfo`. Класът
`PaymentInfo` трябва да има следните методи:
* `public double getCost()` - връща платената сума пари
* `public String getReason()` - връща причината за извършеното плащане
* `public String getLocation()` - връща местоположението на плащането

Обектите от класа `PaymentInfo` се конструират по причина за плащането
(`reason`), местоположение (`location`) и платена сума пари (`cost`).

Бонус задача
------------
Съхранявайте последните 10 транзакции, извършени през виртуалния портфейл. Всяка
транзакция трябва да съдържа:
* името на картата, от която е била направена транзакцията (плащането);
* дата на транзакцията;
* информация за самото плащане, тоест обект от тип `PaymentInfo`.

Когато вече няма свободно място за съхранение, премахвайте най-старата
транзакция. За работа с дати и време, може да използвате класовете от
`java.time` пакета, обръщайки по-специално внимание на `LocalDateTime` класа и
неговите методи (вижте в документацията).
