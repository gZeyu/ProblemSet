import java.util.Arrays;
import java.util.List;

class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i > -1; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[j] = triangle.get(i).get(j) + (dp[j] < dp[j + 1] ? dp[j] : dp[j + 1]);
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
        Arrays.asList(4, 1, 8, 3));
    System.out.println(s.minimumTotal(triangle));
  }
}
