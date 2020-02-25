JSON Encoder
============

JSON (JavaScript Object Notation) е лек и удобен формат за съхраняване и
предаване на информация. Лесен е за писане и четене от хора. Лесно се генерира и
обработва от компютъра. Често се използва за предаване на данни между клиента и
сървъра на едно уеб приложение.

"JSON Encoder" се нарича програма, която трансформира данните представени във
формат на даден език за програмиране в JSON формат. Да се дефинира клас
`JsonEncoder`, който има един статичен метод
`public static String encode(<тип> value)`, който трансформира следните типове
данни в JSON формат:
1. `int`

   ```java
   JsonEncoder.encode(42); // -> "42"
   JsonEncoder.encode(0); // -> "0"
   JsonEncoder.encode(-42); // -> "-42"
   ```

2. `double`

   ```java
   JsonEncoder.encode(3.14159); // -> "3.14159"
   JsonEncoder.encode(0.0); // -> "0.0"
   JsonEncoder.encode(-3.14); // -> "-3.14"
   ```

3. `boolean`

   ```java
   JsonEncoder.encode(true); // -> "true"
   JsonEncoder.encode(false); // -> "false"
   ```

4. `char`

   ```java
   JsonEncoder.encode('a'); // -> ""a""
   JsonEncoder.encode('y'); // -> ""y""
   ```

5. `String`

   ```java
   JsonEncoder.encode("foo"); // -> ""foo""
   JsonEncoder.encode("hello world"); // -> ""hello world""
   ```

6. `Point` (типа, чрез който представяме точка в равнината)

   ```java
   Point point = new Point(1, 3.14);
   JsonEncoder.encode(point); // -> "{ "x": 1, "y": 3.14 }"
   ```

7. `int[]`

   ```java
   int[] numbers = new int[] { 1, 2, 42, -42 };
   JsonEncoder.encode(numbers); // -> "[1, 2, 42, -42]"
   ```

8. `double[]`

   ```java
   double[] numbers = new double[] { 1.0, 2.0, 3.14159, -3.14 };
   JsonEncoder.encode(numbers); // -> "[1.0, 2.0, 3.14159, -3.14]"
   ```

9. `boolean[]`

   ```java
   boolean[] bools = new boolean[] { true, false, false, true };
   JsonEncoder.encode(bools); // -> "[true, false, false, true]"
   ```

10. `char[]`

    ```java
    char[] characters = new char[] { 'a', 'b', 'c', 'x', 'y', 'z' };
    JsonEncoder.encode(characters); // -> "["a", "b", "c", "x", "y", "z"]"
    ```

11. `String[]`

    ```java
    String[] strings = new String[] { "foo", "hello world", "bar" };
    JsonEncoder.encode(characters); // -> "["foo", "hello world", "bar"]"
    ```

12. `Point[]`

    ```java
    Point[] points = new Point[] { new Point(), new Point(42, -3.14) };
    JsonEncoder.encode(characters); // -> "[{ "x": 0, "y": 0 }, { "x": 42, "y": -3.14 }]"
    ```

Да се напише клас `Main`, съдържащ `public static void main(String[] args)`
метод, който демонстрира работата на `JsonEncoder`.

*Бонус*: погрижете се за `null` препратките. `null` се трансформира до `"null"`.
