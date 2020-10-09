## Да се напише програма за следене на влакове в пътна мрежа
Програмата да се осъщетсви на езика Java и да се предаде като архив, съдържащ целия проект.
Изискванията за всяка оценка надграждат над тези за предишната оценка. Някои изисквания изменят предишни, за това четете внимателно.

## Изисквания за 3
Да се дефинират класове за релси. Те могат да бъдат различни видове, така че ще трябва да използвате някой вид абстракция.

- Общи характеристики на всички релси
  - идентификатор - стринг от букви и цифри, който уникално идентифицира всяка една релса
  - лява и дясна релси, с които е свързана. Ако не е свързана от някоя страна съответната референция трябва да е NULL
- Нормална релса
  - по нея може да минава само 1 влак
- Разклонение
  - може да е свързана с повече повече от 1 друга релса вляво и вдясно. С нея може да се осъществи сложна пътна мрежа
  - по нея може да минава само 1 влак
- Следяща релса
  - съща като нормалната релса, но всеки път, когато през нея мине влак изписва съобщение в конзолата
  - по нея може да минава само 1 влак
- Гара
  - има име
  - може да се ползва като крайна точка на пътуване на влак
  - по нея може да минава само 1 влак

Да се направи демонстрация в `main`, като се създаде проста мрежа от 6-7 релси с гари и разклонения.


## Изисквания за 4
Да се разшири работата на релсите:

Да им се добави атрибут от тип `Map<String, String>`. Той ще представлява таблица на свързаност, показваща как от текущата релса може да се стигне до гарите в мрежата. В нея:
- ключовете са имената на гарите
- стойностите са идентификаторите на релса, свързана с началната, през която се стига до гарата

Да се добави метод `void findConnectedStations()`. Когато бъде извикан трябва да тръгне от текущата релса, да обходи цялата мрежа и да намери всички гари. Гарите да се добавят в горната колекция.

Пример:
Ако имаме следната мрежа:
```
                                                                  /===> Гара 2(JKL123)
Гара 1(ABC123) <===> Релса 1(DEF123) <===> Разклонение 1(GHI123) <
                                                                  \===> Гара 3(MNO123)
```
то за `Релса 1` ще имаме

| ключ | стойност |
|-|-|
| Гара 1 | ABC123 |
| Гара 2 | GHI123 |
| Гара 3 | GHI123 |

Разширете демонстрацията в `main` като:
- след като съставите мрежата извикате метода `findConnectedStations` на всяка една релса и гара
- изведете в конзолата резултата в таблицата на свързаност за всяка една релса и гара

## Изисквания за 5
Допълнително да се разшири работата на релсите:
Да им се добави нов положителен целочислен атрибут за тяхната дължина. Той може да има минимална стойност 1 и максимална 100.
Да се добави и референция към влак, който в момента се намира на тази релса. Ако на нея няма влак референцията да се пренасочва към NULL.

Да се добави клас за влак с атрибути:
- име на влака
- скорост
- референция към релса, на която се намира в момента
- име на гара, към която се движи

Влаковете трябва да се изпълняват независимо един от друг като нишки. Влакът се движи от текущата си релса към гарата, която му е указана. За целта се допитва да таблицата на свързаност на релсата за да знае по коя от свързаните към нея релси трябва да продължи.
Влакът се придвижва със `скорост` единици то дължината на релсата за 1 секунда. Това да се осъществи като нишката на влака се приспива за 1 секунда и след това се пресмята къде на релсата се намира той и колко още разстояние му остава до нейния край.
Когато стигне до края на текущата релса преминава на следващата. Когато пристигне в нужната гара спира да се движи, изписва съобщение в конзолата, и чака да му се даде нова дестинация.

## Изисквания за 6
Да се добави обработка на грешки:
- когато се извика `findConnectedStations`, но релсата не е свързана с нищо
- когато на влак се зададе гара, която не присъства в таблицата на свързаност на текущата релса
- когато 2 влака се *сблъскат* на дадена релса - оказали са се на нея в един и същи момент от време

Да се добавят съобщения в конзолата за всичко, което се случва. Съобщенията от влаковете да започват с `[име на нишка][име на влак]`.

Да се добавят юнит тестове за функционалността на релсите.