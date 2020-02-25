class JsonEncoder {
  public static String encode(int value) {
    return String.format("%d", value);
  }

  public static String encode(double value) {
    return String.format("%f", value);
  }

  public static String encode(boolean value) {
    return String.format("%b", value);
  }

  public static String encode(char value) {
    return String.format("\"%c\"", value);
  }

  public static String encode(String value) {
    if (value == null) {
      return "null";
    }
    return String.format("\"%s\"", value);
  }

  public static String encode(Point point) {
    if (point == null) {
      return "null";
    }
    return String.format(
        "{ \"x\": %s, \"y\": %s }",
        encode(point.getX()),
        encode(point.getY()));
  }

  public static String encode(int[] values) {
    if (values == null) {
      return "null";
    }

    String result = "[";
    for (int i = 0; i < values.length; ++i) {
      result += encode(values[i]);
      if (i < values.length - 1) {
        result += ", ";
      }
    }
    return result += "]";
  }

  public static String encode(double[] values) {
    if (values == null) {
      return "null";
    }

    String result = "[";
    for (int i = 0; i < values.length; ++i) {
      result += encode(values[i]);
      if (i < values.length - 1) {
        result += ", ";
      }
    }
    return result += "]";
  }

  public static String encode(boolean[] values) {
    if (values == null) {
      return "null";
    }

    String result = "[";
    for (int i = 0; i < values.length; ++i) {
      result += encode(values[i]);
      if (i < values.length - 1) {
        result += ", ";
      }
    }
    return result += "]";
  }

  public static String encode(char[] values) {
    if (values == null) {
      return "null";
    }

    String result = "[";
    for (int i = 0; i < values.length; ++i) {
      result += encode(values[i]);
      if (i < values.length - 1) {
        result += ", ";
      }
    }
    return result += "]";
  }

  public static String encode(String[] values) {
    if (values == null) {
      return "null";
    }

    String result = "[";
    for (int i = 0; i < values.length; ++i) {
      result += encode(values[i]);
      if (i < values.length - 1) {
        result += ", ";
      }
    }
    return result += "]";
  }

  public static String encode(Point[] values) {
    if (values == null) {
      return "null";
    }

    String result = "[";
    for (int i = 0; i < values.length; ++i) {
      result += encode(values[i]);
      if (i < values.length - 1) {
        result += ", ";
      }
    }
    return result += "]";
  }
}
