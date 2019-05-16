import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] characters = scanner.nextLine().toCharArray();
      int count = 0;
      for (int i = characters.length - 1; i > -1; i--) {
        if (characters[i] == ' ') {
          break;
        }
        count++;
      }
      System.out.println(count);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "hello world\n";
}
