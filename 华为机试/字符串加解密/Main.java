import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] password1 = scanner.nextLine().trim().toCharArray();
      char[] result1 = new char[password1.length];
      char[] result2 = scanner.nextLine().trim().toCharArray();
      char[] password2 = new char[result2.length];
      encrypt(password1, result1);
      unEncrypt(result2, password2);
      System.out.println(String.valueOf(result1));
      System.out.println(String.valueOf(password2));
    }

    scanner.close();
  }

  private static void encrypt(char[] password, char[] result) {
    for (int i = 0; i < password.length; i++) {
      if (password[i] >= 'A' && password[i] <= 'Z') {
        result[i] = (char) ((password[i] - 'A' + 1) % 26 + 'a');
      } else if (password[i] >= 'a' && password[i] <= 'z') {
        result[i] = (char) ((password[i] - 'a' + 1) % 26 + 'A');
      } else if (password[i] >= '0' && password[i] <= '9') {
        result[i] = (char) ((password[i] - '0' + 1) % 10 + '0');
      }
    }
  }

  private static void unEncrypt(char[] result, char[] password) {
    for (int i = 0; i < result.length; i++) {
      if (result[i] >= 'A' && result[i] <= 'Z') {
        password[i] = (char) ((result[i] - 'A' + 25) % 26 + 'a');
      } else if (result[i] >= 'a' && result[i] <= 'z') {
        password[i] = (char) ((result[i] - 'a' + 25) % 26 + 'A');
      } else if (result[i] >= '0' && result[i] <= '9') {
        password[i] = (char) ((result[i] - '0' + 9) % 10 + '0');
      }
    }
  }

  private static final boolean TEST = true;
  private static final String INPUT = "abcdefg\n" + "BCDEFGH\n";
}
