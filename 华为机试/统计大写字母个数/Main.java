import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] str = scanner.nextLine().toCharArray();
      int count = 0;
      for (char ch : str) {
        if (ch >= 'A' && ch <= 'Z') {
          count++;
        }
      }
      System.out.println(count);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "add123#$%#%#O\n";
}
