# Статистики върху данни от IMDb за филми

Ще създадем програма, която анализира и предоставя статистики върху реален
`dataset`, съдържащ информация за около 14000 филми, оценени от Motion Picture
Association of America ([MPAA](https://www.mpaa.org/)) с източник
[IMDb](https://www.imdb.com/). `Dataset`-ът можете да разгледате и изтеглите от
сайта на
[Princeton](https://introcs.cs.princeton.edu/java/data/movies-mpaa.txt).

Всеки ред от файла съдържа информация за даден филм: заглавие, година на пускане
по екраните и имена на актьорите, в следния формат:
`<заглавие> (<година на издаване>)/<фамилия>, <първо име>[/<фамилия>, <първо име>[/...]]`

**Забележки:**
* Има филми, които съдържат месец и година на издаване, разделени със запетая.
Интересува ни **само и единствено годината** на издаване. Например:
**(1920, I)**.
* Има филми, които съдържат допълнителни кръгли скоби в имената си.
* Има актьори, които използват само псевдоним. Приемаме псевдонима за малко име,
а не фамилия. Например Serena във филма *"Last Seduction"*.

## Зареждане и обработка на данните

Преди да започнем със същинската част на анализа на филмите от `dataset`-a, е
нужно да заредим данните в паметта.

Една от първите стъпки в задачите за анализ на данни и machine learning винаги е
"изчистване/подготовка" на данните. В общия случай допускаме, че може да има зле
форматирани данни, може да липсват елементи, на които разчитаме, или да има
такива, които не очакваме.

Понеже целта на занятието е да разберем и упражним Java Stream API-то, ще
получите [готови имплементации](src/org/elsys/duzunov) на `immutable` класовете
`Movie` и `Actor`, като `Movie` има метод за парсване на ред от информацията
във файла:
```java
public static Movie createMovie(String line)
```

С него създаваме обекти от тип `Movie` на базата на ред от `dataset`-a.

Ако все пак имате желание да упражните знанията си за работа с файлове и потоци,
окуражаваме ви да го имплементирате сами.

## Статистики

След като имаме тези обекти, можем да заредим данните в подходяща колекция, от
която да вземем поток и декларативно да изведем разнообразни статистики.

Класът, който ще предоставя API за статистиките, е `MoviesExplorer`:

```java
import java.io.InputStream;
import java.util.Collection;

public class MoviesExplorer {
    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public MoviesExplorer(InputStream dataInput) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    /**
     * Returns all the movies loaded from the dataset.
     **/
    public Collection<Movie> getMovies() {
        return null;
    }

    // Other methods ...
}
```

### Методи

1. :green_book: Намира броя на филмите, излезли на екран през `year` година.

   ```java
   public int countMoviesReleasedInYear(int year)
   ```

2. :green_book: Намира **първия** (по ред) филм в `dataset`-а, който съдържа
`title` в заглавието си. Ако такъв филм не бъде намерен, се хвърля
`IllegalArgumentException`.

   ```java
   public Movie findFirstMovieWithTitle(String title)
   ```

3. :green_book: Връща колекция от всички актьори, които се съдържат в
`dataset`-а.

   ```java
   public Collection<Actor> getAllActors()
   ```

4. :green_book: Намира годината на излизане на екран на филма (филмите), излязъл
(излезли) най-рано.

   ```java
   public int getFirstYear()
   ```

5. :orange_book: Връща колекция, съдържаща всички филми, в които участва
актьорът `actor`.

   ```java
   public Collection<Movie> getAllMoviesByActor(Actor actor)
   ```

6. :orange_book: Връща колекция от всички филми, сортирани според годината на
пускане на екрана (в нарастващ ред).

   ```java
   public Collection<Movie> getMoviesSortedByReleaseYear()
   ```

7. :orange_book: Намира годината, в която има най-малко излезли филми (ако в
`dataset`-a има повече от една година с (еднакъв) минимален брой излезли филми,
връщаме коя да е от тях).

   ```java
   public int findYearWithLeastNumberOfReleasedMovies()
   ```

8. :closed_book: Намира филма, в който участват най-много актьори (ако в
`dataset`-a има повече от един филм с (еднакъв) максимален брой актьори, връщаме
кой да е от тях).

   ```java
   public Movie findMovieWithGreatestNumberOfActors()
   ```
