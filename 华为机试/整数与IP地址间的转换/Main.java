import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      long value = Long.valueOf(scanner.nextLine());
      System.out.println(getIPValue(str));
      System.out.println(getIPString(value));
    }
    scanner.close();
  }

  private static long getIPValue(String str) {
    String[] numberString = str.split("\\.");
    long value = 0;
    for (String s : numberString) {
      value <<= 8;
      value += Integer.valueOf(s);
    }
    return value;
  }

  private static String getIPString(long value) {
    return String.valueOf((value & 0xff000000) >> 24) + '.' + ((value & 0x00ff0000) >> 16) + '.'
        + ((value & 0x0000ff00) >> 8) + '.' + (value & 0x000000ff);
  }

  private static final boolean TEST = true;
  private static final String INPUT = "10.0.3.193\n" + "167969729\n";
}
