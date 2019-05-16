import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String input = scanner.nextLine().trim();
      byte[] map = new byte[26];
      byte min = 1;
      for (char ch : input.toCharArray()) {
        map[ch - 'a']++;
        min = map[ch - 'a'] < min ? map[ch - 'a'] : min;
      }
      for (char ch : input.toCharArray()) {
        if (map[ch - 'a'] > min) {
          System.out.print(ch);
        }
      }
      System.out.print("\n");
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "abcdd\n";
}
