/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node {
        int row, val;
        Node(int row,int val) {
            this.row = row;
            this.val = val;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        
        dfs(root, 0, 0, map);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (List<Node> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a.row == b.row) return a.val - b.val;
                return a.row - b.row;
            });
            
            List<Integer> col = new ArrayList<>();
            for (Node n : list) {
                col.add(n.val);
            }
            
            result.add(col);
        }
        
        return result;
    }
    
    private void dfs(TreeNode root, int row, int col, TreeMap<Integer, List<Node>> map) {
        if (root == null) return;
        
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Node(row, root.val));
        
        dfs(root.left, row + 1, col - 1, map);
        dfs(root.right, row + 1, col + 1, map);
    }
}