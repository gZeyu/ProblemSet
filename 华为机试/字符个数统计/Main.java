import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    Scanner scanner = new Scanner(INPUT);
    char[] characters = scanner.nextLine().toCharArray();
    boolean[] map = new boolean[128];
    int count = 0;
    for (int i = 0; i < characters.length; i++) {
      if (!map[characters[i]]) {
        count++;
        map[characters[i]] = true;
      }
    }
    System.out.println(count);
    scanner.close();
  }

  private static final String INPUT = "uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx";
}
