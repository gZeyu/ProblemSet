import java.util.*;

class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    subsets.add(new ArrayList<>());
    Arrays.sort(nums);
    for (int num : nums) {
      int n = subsets.size();
      for (int i = 0; i < n; i++) {
        List<Integer> set = new ArrayList<>(subsets.get(i));
        set.add(num);
        if (!visited.contains(set.toString())) {
          visited.add(set.toString());
          subsets.add(set);
        }
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subsetsWithDup(new int[] { 1, 2, 2 }));
  }
}
