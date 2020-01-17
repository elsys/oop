Последователности
=================

Да се създаде интерфейс `Sequence`, описващ последователност от цели числа
със следните операции:
- `int get(unsigned int i) const;` - намиране на `i`-тия елемент на
последователността
- `int sum() const;` - намиране на сумата на елементите на последователността
- `int product() const;` - намиране на произведението на елементите
на последователността
- `void print() const;` - извеждане на елементите на последователността

Да се създаде клас `Range`, представящ последователност от цели числа с начало,
край и стъпка. Класът `Range` трябва да имплементира интерфейса `Sequence`.
Пример:
```cpp
Range range1(3, 9, 3); // начало - 3, край - 9, стъпка - 3
range1.print(); // 3, 6, 9

Range range2(-3, 7, 4); // начало - (-3), край - 7, стъпка - 4
range2.print(); // -3, 1, 5
```

Да се създаде клас `EvenNumbers`, представящ последователността от първите `n`
четни числа. Класът `EvenNumbers` трябва да имплементира интерфейса `Sequence`.
Пример:
```cpp
EvenNumbers evens(3); // последователността от първите 3 четни числа
evens.print(); // 0, 2, 4
```

Да се създаде клас `OddNumbers`, представящ последователността от първите `n`
нечетни числа. Класът `OddNumbers` трябва да имплементира интерфейса `Sequence`.
Пример:
```cpp
OddNumbers odds(5); // последователността от първите 5 нечетни числа
odds.print(); // 1, 3, 5, 7, 9
```

Да се създаде клас `FibonacciNumbers`, представящ последователността от първите
`n` числа на Фибоначи, като първото и второто число са съответно 0 и 1.
Класът `FibonacciNumbers` трябва да имплементира интерфейса `Sequence`.
Пример:
```cpp
FibonacciNumbers fibs(8); // последователността от първите 8 числа на Фибоначи
fibs.print(); // 0, 1, 1, 2, 3, 5, 8, 13
```

Да се създаде клас `PrimeNumbers`, представящ последователността от първите
`n` прости числа. Класът `PrimeNumbers` трябва да имплементира
интерфейса `Sequence`.
Пример:
```cpp
PrimeNumbers primes(7); // последователността от първите 7 прости числа
primes.print(); // 2, 3, 5, 7, 11, 13, 17
```