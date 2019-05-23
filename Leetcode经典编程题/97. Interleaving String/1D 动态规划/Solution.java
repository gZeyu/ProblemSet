class Solution {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    boolean[] dp = new boolean[s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) {
          dp[0] = true;
        } else if (i == 0) {
          dp[j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[j - 1];
        } else if (j == 0) {
          dp[0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[0];
        } else {
          dp[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j])
              || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1]);
        }
      }
    }
    return dp[s2.length()];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    System.out.println(s.isInterleave("a", "b", "a"));
    System.out.println(s.isInterleave("", "b", "b"));
  }
}
