import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int LengthOfI = scanner.nextInt();
      int[] I = new int[LengthOfI];
      for (int i = 0; i < LengthOfI; i++) {
        I[i] = scanner.nextInt();
      }
      int LengthOfR = scanner.nextInt();
      Set<Integer> R = new TreeSet<>();
      for (int i = 0; i < LengthOfR; i++) {
        R.add(scanner.nextInt());
      }
      ArrayList<Integer> result = new ArrayList<>();
      for (int r : R) {
        String rString = String.valueOf(r);
        ArrayList<Integer> subResult = new ArrayList<>();
        for (int i = 0; i < LengthOfI; i++) {
          if (String.valueOf(I[i]).contains(rString)) {
            subResult.add(i);
            subResult.add(I[i]);
          }
        }
        if (subResult.size() > 0) {
          result.add(r);
          result.add(subResult.size() / 2);
          result.addAll(subResult);
        }
      }
      StringBuilder builder = new StringBuilder();
      builder.append(result.size()).append(' ');
      for (int num : result) {
        builder.append(num).append(' ');
      }
      System.out.println(builder.toString());
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123\n" + "5 6 3 6 3 0\n";
}
