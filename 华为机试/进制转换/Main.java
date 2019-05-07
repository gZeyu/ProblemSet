import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Scanner scanner = new Scanner(INPUT);
    while (scanner.hasNextLine()) {
      char[] hex = scanner.nextLine().trim().toUpperCase().toCharArray();
      int number = 0;
      for (int i = 2; i < hex.length; i++) {
        if (hex[i] >= '0' && hex[i] <= '9') {
          number <<= 4;
          number += (hex[i] - '0');
        } else {
          number <<= 4;
          number += (hex[i] - 'A' + 10);
        }
      }
      System.out.println(number);
    }
    scanner.close();
  }

  private static final String INPUT = "0xA\n0xFF";
}
