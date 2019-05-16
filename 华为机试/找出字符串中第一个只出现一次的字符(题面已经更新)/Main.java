import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      Map<Character, Integer> map = new LinkedHashMap<>();
      for (char ch : str.toCharArray()) {
        if (map.containsKey(ch)) {
          map.put(ch, map.get(ch) + 1);
        } else {
          map.put(ch, 1);
        }
      }
      String output = "-1";
      for (char ch : map.keySet()) {
        if (map.get(ch) == 1) {
          output = ch + "";
          break;
        }
      }
      System.out.println(output);
    }

    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "lbrnsepcfjzcpfgzqdiujo\n";
}
