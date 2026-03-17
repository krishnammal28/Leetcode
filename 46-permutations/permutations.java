class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>>result = new ArrayList<>();
      List<Integer>temp=new ArrayList<>();
      backtrack(nums,result,temp);
        return result;
      }  
      public void backtrack(int[]nums,List<List<Integer>>result,List<Integer>temp)
      {
      if(temp.size()==nums.length)
      {
        result.add(new ArrayList<>(temp));
      }
      for(int i=0;i<nums.length;i++)
      {
        if(temp.contains(nums[i]))
        {
             continue;
        }
        temp.add(nums[i]);
        backtrack(nums,result,temp);
        temp.remove(temp.size()-1);
      }
    }
}