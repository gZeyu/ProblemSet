import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] input = scanner.nextLine().toCharArray();
      int x = 0;
      int y = 0;
      int index = 0;
      while (index < input.length) {
        int end = index;
        while (input[end] != ';') {
          end++;
        }
        if (end - index < 2 || end - index > 3) {
          index = end + 1;
          continue;
        }
        if (input[index] != 'A' && input[index] != 'D' && input[index] != 'W' && input[index] != 'S') {
          index = end + 1;
          continue;
        }
        char direction = input[index++];
        int distance = 0;
        if (input[index] >= '0' && input[index] <= '9') {
          distance = input[index++] - '0';
        } else {
          index = end + 1;
          continue;
        }
        if (index < end) {
          if (input[index] >= '0' && input[index] <= '9') {
            distance = distance * 10 + input[index++] - '0';
          } else {
            index = end + 1;
            continue;
          }
        }
        switch (direction) {
        case 'A':
          x -= distance;
          break;
        case 'D':
          x += distance;
          break;
        case 'W':
          y += distance;
          break;
        case 'S':
          y -= distance;
          break;
        }
      }
      System.out.println(x + "," + y);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "A10;S20;W10;D30;X;A1A;B10A11;;A10;A5;\n";
}
