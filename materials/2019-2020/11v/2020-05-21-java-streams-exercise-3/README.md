# Статистики върху данни за планински върхове

В задачата ще имплементираме клас, който ще предоставя статистика върху
`dataset` с най-високите планински върхове в света. Данните ще бъдат
предоставени на вашата имплементация като файл
([mountains.txt](mountains.txt)), в който всеки ред съдържа данни за един връх в
CSV (Comma-Separated Values) формат както следва:
`Позиция,Име,Височина,Изпъкналост,Планина,Година,Брой изкачвания`

Допълнителни разяснения към данните:
  * Позиция по височина - мястото по височина на съответния връх
  * Име (на върха)
  * Височина (в метри)
  * Изпъкналост (в метри) - показва височината на върха от най-високата
  седловина, свързваща го с по-висок връх) (виж
  [Topographic prominence](https://en.wikipedia.org/wiki/Topographic_prominence))
  * Планина - планинската верига, от която е част върхът
  * Година на първо изкачване
  * Брой изкачвания след 2004 година

## Обработка на данните

Класът `Peak` е `immutable` и ще представя данните за един връх. С цел удобна
работа с ламбда изрази ще създаваме обекти от такъв тип чрез статичния метод
`createPeak`.

Създайте имплементация, която приема ред от `dataset`-a и връща инстанция на
`Peak`. Може да разчитате, че данните са в коректен формат.

```java
public static Peak createPeak(String line);
```

## Статистики

След като имаме тези обекти, можем да заредим данните в подходяща колекция, от
която да вземем поток и декларативно да изведем разнообразни статистики.

Класът, който ще предоставя API за статистиките, е `PeakStats`:
```java
public class PeakStats {
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public PeakStats(InputStream dataInput) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Returns all peaks loaded from the dataset.
     **/
    public Collection<Peak> getPeaks() {
        return null;
    }

    // Other methods...
}
```

### Методи

1. Връща височината на най-ниския връх, който никога не е бил изкачван.

   ```java
   public double shortestNotAscended();
   ```

2. Връща средния брой изкачвания на върховете в топ N (включително). Да се върне
`0`, ако няма изкачен връх в интервала.

   ```java
   public double averageAscentsInTopN(int n);
   ```

3. Сред най-високите върхове има и такива, които имат относително малка
изпъкналост - например четвъртият по височина връх Лхотце има скромните 610 м.,
за сравнение - първенецът на Балканите - Мусала - има цели 2473 м. Да се напише
метод, който приема изпъкналост и връща като стойност на кое място би се наредил
върхът по изпъкналост спрямо данните от нашия `dataset`. Ако има връх/върхове
със същата изпъкналост, считаме, че върхът с подадената изпъкналост е по-висок
от тях (т.е. ще има по-предна позиция).

   ```java
   public long getPositionByProminence(double prominence);
   ```

4. Връща най-високия връх, изкачен за пръв път през дадена година. Ако няма
върхове, изкачени през тази година, да се хвърля
`java.lang.IllegalArgumentException`.

   ```java
   public Peak getHighestAscentByYear(int year);
   ```

5. Връща списък от имената на върховете, които не са част от Хималаите (която и
да е планина, съдържащa `"Himalaya"` в името си), подредени по изпъкналост (от
най-висок към най-нисък).

   ```java
   List<String> getNonHimalayaNamesByProminence();
   ```

6. Връща името на планинската верига с най-много върхове в топ N (включително).
Ако няколко планински вериги имат максималния брой върхове в планинска верига,
няма значение коя от тях ще се върне.

   ```java
   public String getRangeWithGreatestNumberOfPeaks(int n);
   ```
