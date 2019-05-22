import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<List<String>> cache = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      cache.add(new ArrayList<>());
    }
    wordBreakCore(s, wordDict, 0, cache);
    return cache.get(0);
  }

  private void wordBreakCore(String s, List<String> wordDict, int begin, List<List<String>> cache) {
    if (begin == s.length()) {
      return;
    }
    if (cache.get(begin).size() > 0) {
      return;
    }
    System.out.println(begin + "," + cache.get(begin));
    for (String word : wordDict) {
      int end = begin + word.length();
      if (end <= s.length() && word.equals(s.substring(begin, end))) {
        wordBreakCore(s, wordDict, end, cache);
        if (end < s.length()) {
          for (String result : cache.get(end)) {
            cache.get(begin).add(word + " " + result);
          }
        } else {
          cache.get(begin).add(word);
        }
      }
    }
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
