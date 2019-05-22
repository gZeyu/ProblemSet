import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> wordDict = new ArrayList<>();
    Collections.addAll(wordDict, "cats", "dog", "sand", "and", "cat");
    System.out.println(s.wordBreak("catsandog", wordDict));
    wordDict.clear();
    Collections.addAll(wordDict, "apple", "pen");
    System.out.println(s.wordBreak("applepenapple", wordDict));
    wordDict.clear();
    Collections.addAll(wordDict, "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
        "aaaaaaaaaa");
    System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
  }

  public boolean wordBreak(String s, List<String> wordDict) {

    boolean[] visited = new boolean[s.length()];
    return wordBreakCore(s, 0, wordDict, visited);
  }

  public boolean wordBreakCore(String s, int begin, List<String> wordDict, boolean[] visited) {
    if (begin >= s.length()) {
      return true;
    }
    if (visited[begin]) {
      return false;
    }
    for (String word : wordDict) {
      int end = begin + word.length();
      if (end <= s.length() && word.equals(s.substring(begin, end))) {
        if (wordBreakCore(s, end, wordDict, visited)) {
          return true;
        }
      }
    }
    visited[begin] = true;
    return false;
  }
}
