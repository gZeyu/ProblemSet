import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST == 1 ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNext()) {
      String str = scanner.next();
      Map<Character, Integer> map = new HashMap<>();
      for (char ch : str.toCharArray()) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ' ') {
          if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
          } else {
            map.put(ch, 1);
          }
        }
      }
      ArrayList<Character> characters = new ArrayList<>(map.keySet());
      characters.sort((c1, c2) -> {
        if (map.get(c1) == map.get(c2)) {
          return c1 - c2;
        } else {
          return map.get(c2) - map.get(c1);
        }
      });
      for (char ch : characters) {
        System.out.print(ch);
      }
      System.out.println();
    }
    scanner.close();
  }

  private static byte TEST = 1;
  private static final String INPUT = "8v26ktzk069lm400061m0v965we88850o6omqi532ktir6esb55t0kqm026y8rk63aj82kcx48gd1tiylvs0xo32zem65q7z5ce2185d2ascz62a2p3ajr45h637t2p290lc043gicp5ldzzmx2\n";
}
