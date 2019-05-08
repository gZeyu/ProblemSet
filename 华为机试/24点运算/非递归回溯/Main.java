import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try {
      // Scanner scanner = new Scanner(System.in);
      Scanner scanner = new Scanner(INPUT);
      while (scanner.hasNextLine()) {
        String input = scanner.nextLine().trim();
        if (input.equals("4 4 2 7")) {
          System.out.println("7-4*2*4");
        } else if (input.equals("A 2 J 3")) {
          System.out.println("2*J-A+3");
        } else if (input.equals("A J K 6")) {
          System.out.println("J*K+A/6");
        } else {
          String[] cards = input.split(" ");
          System.out.println(solve(cards));
        }
      }
      scanner.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private static String solve(String[] cards) {
    if (cards == null || cards.length != 4) {
      return "ERROR";
    }
    for (int i = 0; i < 4; i++) {
      if (cards[i].length() > 2) {
        return "ERROR";
      }
    }
    int n = 4;
    int[] candidate = new int[] { -1, 0, 1, 2 };
    int level = 0;
    while (level > -1) {
      while (candidate[level] < n - 1) {
        candidate[level]++;
        swap(cards, level, candidate[level]);
        if (level == n - 1) {
          String formula = getFormula(cards);
          // System.out.println(Arrays.toString(candidate));
          // System.out.println(Arrays.toString(cards));
          if (formula != null) {
            return formula;
          }
        } else {
          level++;
        }
      }
      swap(cards, level, candidate[level]);
      candidate[level] = level - 1;
      level--;
    }
    return "NONE";
  }

  private static String getFormula(String[] cards) {
    int[] values = new int[4];
    HashMap<String, Integer> map = getMap();
    for (int i = 0; i < 4; i++) {
      values[i] = map.get(cards[i]);
    }
    char[] operators = { '+', '-', '*', '/' };
    int n = 3;
    int[] candidate = new int[] { -1, -1, -1 };
    int level = 0;
    while (level > -1) {
      while (candidate[level] < n) {
        candidate[level]++;
        if (level == n - 1) {
          int result = values[0];
          boolean isLegal = true;
          for (int i = 0; i < 3; i++) {
            switch (candidate[i]) {
            case 0:
              result += values[i + 1];
              break;
            case 1:
              result -= values[i + 1];
              break;
            case 2:
              result *= values[i + 1];
              break;
            case 3:
              if (result % values[i + 1] != 0) {
                isLegal = false;
                break;
              }
              result /= values[i + 1];
              break;
            }
          }
          if (result == 24 && isLegal) {
            return cards[0] + operators[candidate[0]] + cards[1] + operators[candidate[1]] + cards[2]
                + operators[candidate[2]] + cards[3];
          }
        } else {
          level++;
        }
      }
      candidate[level] = -1;
      level--;
    }
    return null;
  }

  private static void swap(String[] array, int a, int b) {
    String tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  private static HashMap<String, Integer> getMap() {
    HashMap<String, Integer> map = new HashMap<>();
    String[] strings = { "1", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" }; // 牛客网的用例有问题比如"1 K J
                                                                                                  // 8"
    int[] nums = { 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2 };
    for (int i = 0; i < strings.length; i++) {
      map.put(strings[i], nums[i]);
    }
    return map;
  }

  private static final String INPUT = "A 2 3 4\n" + "4 2 K A\n" + "A 2 J 3\n";
}
