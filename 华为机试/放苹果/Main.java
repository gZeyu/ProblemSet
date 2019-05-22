import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST == 1 ? new Scanner(INPUT) : new Scanner(System.in);

    while (scanner.hasNext()) {
      int m = scanner.nextInt();
      int n = scanner.nextInt();
      int[][] dp = new int[m + 1][n + 1];
      dp[0][0] = 1;
      for (int i = 0; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          dp[i][j] = dp[i][j - 1];
          if (i >= j) {
            dp[i][j] += dp[i - j][j];
          }
        }
      }
      System.out.println(dp[m][n]);
    }
    scanner.close();
  }

  private static byte TEST = 1;
  private static final String INPUT = "7 3\n";
}
