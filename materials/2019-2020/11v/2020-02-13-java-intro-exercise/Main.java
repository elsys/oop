class Main {
  private static int digitsCount(int number) {
    int count = 1;
    while (number > 9) {
      ++count;
      number /= 10;
    }
    return count;
  }

  private static int insertFiveMaxNegative(int number) {
    int numberAbs = Math.abs(number);
    int count = digitsCount(numberAbs);
    for (int i = count; i > 0; --i) {
      int powerOfTen = (int) Math.pow(10, i);
      int firstPart = numberAbs / powerOfTen;
      int secondPart = numberAbs % powerOfTen;
      int currentDigit = secondPart / (powerOfTen / 10);
      if (currentDigit > 5) {
        return -(firstPart * powerOfTen * 10 + 5 * powerOfTen + secondPart);
      }
    }
    return -(numberAbs * 10 + 5);
  }

  public static int insertFiveMax(int number) {
    if (number < 0) {
      return insertFiveMaxNegative(number);
    }

    int count = digitsCount(number);
    for (int i = count; i > 0; --i) {
      int powerOfTen = (int) Math.pow(10, i);
      int firstPart = number / powerOfTen;
      int secondPart = number % powerOfTen;
      int currentDigit = secondPart / (powerOfTen / 10);
      if (currentDigit < 5) {
        return firstPart * powerOfTen * 10 + 5 * powerOfTen + secondPart;
      }
    }
    return number * 10 + 5;
  }

  public static void main(String[] args) {
    System.out.println(insertFiveMax(268));
    System.out.println(insertFiveMax(670));
    System.out.println(insertFiveMax(9));
    System.out.println(insertFiveMax(4));
    System.out.println(insertFiveMax(5));
    System.out.println(insertFiveMax(0));
    System.out.println(insertFiveMax(55567));
    System.out.println(insertFiveMax(55564));
    System.out.println(insertFiveMax(-999));
    System.out.println(insertFiveMax(-55547));
  }
}
