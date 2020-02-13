Дефинирайте клас `Main` със следните публични статични методи:

1. `public static int insertFiveMax(int number)` - по дадено цяло число `number`
връща максималното число, получено след добавянето на цифрата 5 в десетичния
запис на `number`. Примери:

   ```java
   insertFiveMax(268); // -> 5268
   insertFiveMax(670); // -> 6750
   insertFiveMax(0); // -> 50
   insertFiveMax(-999); // -> -5999
   ```

2. `public static int insertedAsMaxCount(String string)` - по даден низ `string`
връща максималния брой на символите 'a', които могат да бъдат вмъкнати в
`string` (включително и в началото, и в края на `string`), така че полученият
низ да не съдържа три последователни срещания на символа 'a'. Ако низът `string`
съдържа подниз "aaa", методът трябва да връща -1. Примери:

   ```java
   insertedAsMaxCount("aabab"); // -> 3
   insertedAsMaxCount("dog"); // -> 8
   insertedAsMaxCount("aa"); // -> 0
   insertedAsMaxCount("baaaa"); // -> -1
   ```

3. `public static String weekdayAfter(String weekday, int daysCount)` - по
дадени ден от седмицата `weekday` ("Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
"Sun") и брой дни `daysCount` връща деня от седмицата, който се пада `daysCount`
дни след `weekday`.

   ```java
   weekdayAfter("Mon", 1); // -> "Tue"
   weekdayAfter("Fri", 7); // -> "Fri"
   weekdayAfter("Thu", 2); // -> "Sat"
   weekdayAfter("Thu", 4); // -> "Mon"
   weekdayAfter("Sun", 0); // -> "Sun"
   ```

Да се напише метод `public static void main(String[] args)`, в който да се
демонстрира работата на гореописаните методи.
