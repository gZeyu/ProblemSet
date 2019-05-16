import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] password = scanner.nextLine().trim().toCharArray();
      for (int i = 0; i < password.length; i++) {
        if (password[i] >= 'A' && password[i] <= 'Z') {
          password[i] = (char) ((password[i] - 'A' + 1) % 26 + 'a');
        } else if (password[i] >= 'a' && password[i] <= 'o') {
          password[i] = (char) ((password[i] - 'a') / 3 + 2 + '0');
        } else if (password[i] >= 'p' && password[i] <= 's') {
          password[i] = '7';
        } else if (password[i] >= 't' && password[i] <= 'v') {
          password[i] = '8';
        } else if (password[i] >= 'w' && password[i] <= 'z') {
          password[i] = '9';
        }
      }
      System.out.println(String.valueOf(password));
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "YUANzhi1987\n";
}
