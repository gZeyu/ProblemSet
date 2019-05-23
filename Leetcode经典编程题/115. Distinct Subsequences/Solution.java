class Solution {

  public int numDistinct(String s, String t) {
    int[] dp = new int[t.length() + 1];
    for (int i = s.length() - 1; i > -1; i--) {
      for (int j = 0; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          dp[j] += j == t.length() - 1 ? 1 : dp[j + 1];
        }
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.numDistinct("rabbbit", "rabbit"));
    System.out.println(s.numDistinct("babgbag", "bag"));
    System.out.println(s.numDistinct("", "a"));
  }
}
