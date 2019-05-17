import java.util.*;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> wordDict = new ArrayList<>();
    Collections.addAll(wordDict, "cats", "dog", "sand", "and", "cat");
    System.out.println(s.wordBreak("catsandog", wordDict));
    wordDict.clear();
    Collections.addAll(wordDict, "apple", "pen");
    System.out.println(s.wordBreak("applepenapple", wordDict));
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    Set<String> set = new HashSet<>(wordDict);
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }
}