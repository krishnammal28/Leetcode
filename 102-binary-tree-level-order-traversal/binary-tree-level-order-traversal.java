import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new LinkedList<>();

            for(int i = 0; i < n; i++){
                TreeNode curr = queue.poll();

                level.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}