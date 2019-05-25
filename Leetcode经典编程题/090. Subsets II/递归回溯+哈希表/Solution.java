import java.util.*;

class Solution {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    List<Integer> set = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    subsets.add(new ArrayList<>(set));
    Arrays.sort(nums);
    subsetsWithDupCore(nums, 0, set, subsets, visited);
    return subsets;
  }

  private void subsetsWithDupCore(int[] nums, int i, List<Integer> set, List<List<Integer>> subsets,
      Set<String> visited) {
    if (i >= nums.length) {
      return;
    }
    for (int j = i; j < nums.length; j++) {
      set.add(nums[j]);
      if (!visited.contains(set.toString())) {
        visited.add(set.toString());
        subsets.add(new ArrayList<>(set));
      }
      subsetsWithDupCore(nums, j + 1, set, subsets, visited);
      set.remove(set.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subsetsWithDup(new int[] { 1, 2, 2 }));
  }
}
