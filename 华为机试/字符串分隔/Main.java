import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine().trim();
      if (str.length() == 0) {
        continue;
      }
      for (int i = 0; i < str.length(); i += 8) {
        if (i + 8 > str.length()) {
          System.out.print(str.substring(i, str.length()));
          for (int j = 0; j < i + 8 - str.length(); j++) {
            System.out.print('0');
          }
          System.out.print('\n');
        } else {
          System.out.println(str.substring(i, i + 8));
        }
      }
    }
    scanner.close();
  }

  private static final String INPUT = "abc\n" + "123456789";
}
