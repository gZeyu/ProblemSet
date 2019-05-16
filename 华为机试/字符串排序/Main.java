import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextLine()) {
      char[] input = scanner.nextLine().toCharArray();
      Queue<Integer> queue = new PriorityQueue<>((index1, index2) -> {
        char ch1 = input[index1];
        char ch2 = input[index2];
        if (ch1 < 'a') {
          ch1 += 'a' - 'A';
        }
        if (ch2 < 'a') {
          ch2 += 'a' - 'A';
        }
        if (ch1 == ch2) {
          return index1 - index2;
        } else {
          return ch1 - ch2;
        }
      });
      for (int i = 0; i < input.length; i++) {
        if ((input[i] >= 'a' && input[i] <= 'z') || (input[i] >= 'A' && input[i] <= 'Z')) {
          queue.offer(i);
        }
      }
      StringBuilder builder = new StringBuilder();
      for (char ch : input) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
          // noinspection ConstantConditions
          builder.append(input[queue.peek()]);
          queue.poll();
        } else {
          builder.append(ch);
        }
      }
      System.out.println(builder.toString());
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "A Famous Saying: Much Ado About Nothing (2012/8).\n";
}
