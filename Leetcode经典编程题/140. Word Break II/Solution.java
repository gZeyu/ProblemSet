import java.util.*;

class Solution {

  public List<String> wordBreak(String s, List<String> wordDict) {
    Map<Integer, List<String>> visited = new HashMap<>();
    wordBreakCore(s, wordDict, 0, visited);
    return visited.get(0);
  }

  private void wordBreakCore(String s, List<String> wordDict, int begin, Map<Integer, List<String>> visited) {
    if (begin == s.length()||visited.containsKey(begin)) {
      return;
    }
    List<String> list = new ArrayList<>();
    for (String word : wordDict) {
      int end = begin + word.length();
      if (end <= s.length() && word.equals(s.substring(begin, end))) {
        wordBreakCore(s, wordDict, end, visited);
        if (end < s.length() && !visited.get(end).isEmpty()) {
          for (String str : visited.get(end)) {
            list.add(word + " " + str);
          }
        } else if (end == s.length()) {
          list.add(word);
        }
      }
    }
    visited.put(begin, list);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    System.out
        .println(s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    System.out.println(s.wordBreak(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
  }
}
