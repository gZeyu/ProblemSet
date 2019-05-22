import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST == 1 ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      for (int i = 0; i < n; i++) {
        String str = scanner.next();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
          if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
          } else {
            map.put(ch, 1);
          }
        }
        ArrayList<Character> characters = new ArrayList<>(map.keySet());
        characters.sort((c1, c2) -> {
          return map.get(c2) - map.get(c1);
        });
        int value = 26;
        int result = 0;
        for (char ch : characters) {
          result += map.get(ch) * value--;
        }
        System.out.println(result);
      }
    }
    scanner.close();
  }

  private static byte TEST = 1;
  private static final String INPUT = "2\n" + "zhangsan\n" + "lisi\n";
}
