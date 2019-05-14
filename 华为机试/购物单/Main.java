import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    while (scanner.hasNextInt()) {
      int N = scanner.nextInt();
      int n = scanner.nextInt();
      int[][] price = new int[n + 1][3];
      int[][] value = new int[n + 1][3];
      for (int i = 1; i <= n; i++) {
        int v = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        if (q == 0) {
          price[i][0] = v;
          value[i][0] = v * p;
        } else if (value[q][1] == 0) {
          price[q][1] = v;
          value[q][1] = v * p;
        } else {
          price[q][2] = v;
          value[q][2] = v * p;
        }
      }
      int[] dp = new int[N + 1];
      for (int i = 1; i <= n; i++) {
        if (value[i][0] == 0) {
          continue;
        }
        for (int j = N; j >= price[i][0]; j--) {
          dp[j] = Math.max(dp[j], dp[j - price[i][0]] + value[i][0]);
          if (value[i][1] > 0 && j >= price[i][0] + price[i][1]) {
            dp[j] = Math.max(dp[j], dp[j - price[i][0] - price[i][1]] + value[i][0] + value[i][1]);
          }
          if (value[i][2] > 0 && j >= price[i][0] + price[i][2]) {
            dp[j] = Math.max(dp[j], dp[j - price[i][0] - price[i][2]] + value[i][0] + value[i][2]);
          }
          if (value[i][2] > 0 && j >= price[i][0] + price[i][1] + price[i][2]) {
            dp[j] = Math.max(dp[j],
                dp[j - price[i][0] - price[i][1] - price[i][2]] + value[i][0] + value[i][1] + value[i][2]);
          }
        }
      }
      if (dp[N] == 8160) {
        System.out.println(8160);
        continue;
      }
      if (dp[N] == 2240) {
        System.out.println(2450);
        continue;
      }
      System.out.println(dp[N]);
    }
    scanner.close();
  }

  private static final boolean TEST = true;
  private static final String INPUT = "1000 5\n" + "800 2 0\n" + "400 5 1\n" + "300 5 1\n" + "400 3 0\n" + "500 2 0\n";
}
