# Сериализация на клас до JSON 

## Основна функционалност

Целта на настоящото упражнение е да се имплементира класът `JsonSerializer`, който
трябва да е в състояние за сериализира обикновен `Java` обект в низ в `JSON`
формат.

Например: ако имате обект от типа на класа `Student`:
```java
public class Student {
    
    private String name;
    
    private String lastName;
    
    private String fatherName;

    private List<Integer> grades;

    // ...
}
```

 със следните полета:

```java
Student student = new Student();
student.setName("Pesho");
student.setFatherName("Ivanov");
student.setLastName("Peshev");
student.setGrades(Arrays.asList(2, 5, 6));
```

то методът `serialize` на `JsonSerializer` трябва да върне следния `JSON` низ:
```
{ "name" : "Pesho", "lastName" : "Peshev", "grades" : [ "2", "5", "6" ], "fatherName" : "Ivanov" }
```

Ако дадено поле не е инициализирано, т.е. е `null`, трябва също да се върне в низа по следния начин `"fieldName" : "null"`.

Масивите и полетата от тип, наследник на `java.util.Collection` трябва да се сериализират, както полето `grades` от горния пример.
Забележете, че един масив или колекция може да съдържа не само елементи от прост тип, но и обекти. Както и всяко поле може да е от сложен тип.
Вложените обекти трябва да се сериализират рекурсивно.

Разгледайте методите в `org.elsys.serializer.AbstractSerializer`, които са имплементирани на готово. :)

Важно, докато имплементирате класа `org.elsys.serializer.JsonSerializer`, да мислите какви части от него биха били ползвани
от сериализатор със същия интерфейс (`org.elsys.serializer.Serializer`), но в различен формат (например - XML).

## Поддръжка на `includeNullFields(boolean)`

Нека имаме следния обект:
```java
Student student = new Student();
student.setName("Pesho");
student.setLastName("Peshev");
student.setGrades(Arrays.asList(2, 5, 6));
```

Ако `includeNullFileds` се установи в `true`, то методът `serialize` на 
`JsonSerializer` трябва да върне следния `JSON` низ:

```
{ "name" : "Pesho", "lastName" : "Peshev", "grades": [ "2", "5", "6" ], "fatherName" : "null" }
```
Обърнете внимание, че стойността на `fatherName` е `null`.

Ако `includeNullFileds` се установи във `false`, то методът `serialize` на 
`JsonSerializer` трябва да върне следния `JSON` низ:

```
{ name : "Pesho", lastName : "Peshev", grades : [ "2", "5", "6" ] }
```
Обърнете внимание, че полето `fatherName` е пропуснато.

По подразбиране стойността на `includeNullFields` е `true`.

## Поддръжка на анотацията `Ignore`

Ако класът се анотира по следния начин:
```java
public class Student {
    
    private String name;
    
    private String lastName;
    
    @Ignore
    private String fatherName;

    private List<Integer> grades;

    // ...
}
```

то методът `serialize` на `JsonSerializer` трябва да върне следния `JSON` низ:
```
{ "name" : "Pesho", "lastName" : "Peshev", "grades" : [ "2", "5", "6" ] }
```

## Поддръжка на анотацията `MapBy`

Ако полетата на класа се анотират по следния начин:
```java
public class Student {
    
    @MapBy("first_name")
    private String name;
    
    @MapBy("last_name")
    private String lastName;
    
    @MapBy("father_name")
    private String fatherName;

    private List<Integer> grades;

    // ...
}
```

то методът `serialize` на `JsonSerializer` трябва да върне следния `JSON` низ:
```
{ "first_name" : "Pesho", "last_name" : "Peshev", "grades" : [ "2", "5", "6" ], "father_name" : "Ivanov" }
```

## Поддръжка на `setPretty` и `isPretty`

Ако методът `isPretty` на `JsonSerializer` връща `true`, то низът, който
връща сериализатора, трябва да бъде форматиран така:
```
{
   "name" : "Pesho",
   "lastName" : "Peshev",
   "grades" : [
      "2",
      "5",
      "6"
   ]
}
```

Табулацията е 3 спейса.

## Оценяване

   *   Стил на програмиране - 1 т.
   *   Основна функционалност - 1.5 т.
   *   Поддръжка на `includeNullFields(boolean)` - 1 т.
   *   Поддръжка на анотацията `Ignore` - 1 т.
   *   Поддръжка на анотацията `MapBy` - 1 т.
   *   Поддръжка на `setPretty` и `isPretty` - 1 т.

Оценката за стил включва познатите ни общи правила, адекватна употреба на учените неща от стандартната библиотека
(неща като колекции, потоци, reflection) и споменатото в последния параграф на първата точка от условието.

## Срок

Крайният срок за предаване на домашното в мудъл е 08.05.2017 16:00.
