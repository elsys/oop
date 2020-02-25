class NumberHelperService {
  public static String formatNumber(int value) {
    return String.format("%d", value);
  }

  public static String formatNumber(double value) {
    return String.format("%f", value);
  }

  public static String formatNumber(String value) {
    return String.format("%.2f", Double.parseDouble(value));
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println(NumberHelperService.formatNumber(42));
    System.out.println(NumberHelperService.formatNumber(3.14));
    System.out.println(NumberHelperService.formatNumber("42.4242"));
  }
}
