# Статистики за продажби на видео игри

Ще създадем програма, която анализира и предоставя статистики върху реален
`dataset`, съдържащ данни за видео игрите, продали над 100000 копия по света.
`Dataset`-ът е генериран от [vgchartz.com](https://www.vgchartz.com) и е взет от
[kaggle](https://www.kaggle.com/gregorut/videogamesales/data), онлайн платформа
за machine learning и data science на Google. Файла, съдържащ данните, може да
свалите и [от тук](vgsales.csv). Всеки ред от файла съдържа информация за
продажбите на една видео игра в CSV (Comma-separated Values) формат:
`Ранг,Име,Платформа,Година,Жанр,Издател,NA_продажби,EU_продажби,JP_продажби,Other_продажби,Global_продажби`

Допълнителни разяснения към данните:
* Ранг - позиция на играта в класацията по продажби в света
* Име - име на играта
* Платформа - платформа на играта
* Година - година на издаване на играта
* Жанр - жанр на играта
* Издател - издател на играта
* NA_продажби - продажби в Северна Америка (в милиони)
* EU_продажби - продажби в Европа (в милиони)
* JP_продажби - продажби в Япония (в милиони)
* Other_продажби - продажби в останалата част от света (без Северна Америка,
Европа и Япония)
* Global_продажби - общ брой продажби в света

**Забележки:**
* Първият ред на файла съдържа имената на полетата.
* Има игри с неизвестна година на издаване (означена с `"N/A"` в `dataset`-а).
При парсването за такива игри заместваме `"N/A"` с `0`.
* Има игри с неизвестен издател (означен с `"N/A"` или `"Unknown` в
`dataset`-а).

## Зареждане и обработка на данните

Преди да започнем със същинската част на анализа на видеата от `dataset`-a, ще
заредим данните в паметта.

Една от първите стъпки в задачите за анализ на данни и machine learning винаги е
"изчистване/подготовка" на данните. В общия случай допускаме, че може да има зле
форматирани данни, може да липсват елементи, на които разчитаме, или да има
такива, които не очакваме.

Понеже целта на занятието е да разберем и упражним Java Stream API-то, ще
получите [готова имплементация](src/org/elsys/duzunov/VideoGame.java) на
`immutable` класа `VideoGame` с метод за парсване на ред от информацията
във файла:
```java
public static VideoGame createVideoGame(String line);
```

С него създаваме обекти от тип `VideoGame` на базата на ред от `dataset`-a.

## Статистики

След като имаме тези обекти, можем да заредим данните в подходяща колекция, от
която да вземем поток и декларативно да изведем разнообразни статистики.

Класът, който ще предоставя API за статистиките, е `VideoGamesExplorer`:

```java
import java.io.InputStream;
import java.util.Collection;

public class VideoGamesExplorer {
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public VideoGamesExplorer(InputStream dataInput) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Returns all video games loaded from the dataset.
     **/
    public Collection<VideoGame> getVideoGames() {
        return null;
    }

    // Other methods...
}
```

### Методи

1. Връща името на играта с най-малко продажби в Япония.

   ```java
   public String findNameOfLeastSoldVideoGameInJapan()
   ```

2. Връща името на играта с най-голяма разлика в сумата от продажбите в Северна
Америка, Европа и Япония, и продажбите в останалата част от света.

   ```java
   public String findNameOfVideoGameWithLargestSaleDifference()
   ```

3. Връща списък от имената на `n`-те най-продавани игри в Европа, подредени в
намаляващ ред на продаванията в Европа.

   ```java
   public List<String> findNamesOfTopNVideoGamesBySalesInEurope(int n)
   ```

4. Връща средния брой продадени копия в света на игрите, публикувани от даден
издател `publisher`. Да се връща `0`, ако даденият издател `publisher` няма
продадени игри или не се среща в `dataset`-a.

   ```java
   public double findAverageSoldCopiesByPublisher(String publisher)
   ```

5. Връща ранга на най-продаваната игра в Северна Америка за дадена платформа
`platform` и даден жанр `genre`. Ако е подадена платформа и/или жанр, които не
се срещат в `dataset`-a, да се хвърля `IllegalArgumentException`.

   ```java
   public int findRankOfMostSoldVideoGameByPlatformAndGenre(String platform, String genre)
   ```

6. Връща издателя, който е издал най-много игри през дадена година `year`. Ако
през дадената година няма нито една издадена игра, да се хвърля
`IllegalArgumentException`. **Забележка:** Тук не разглеждаме игри с неизвестен
издател (`"N/A"` или `"Unknown"`).

   ```java
   public String findPublisherWithMostVideoGamesInYear(int year)
   ```
