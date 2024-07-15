class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes=new HashMap<Integer, TreeNode>(), ancestors=new HashMap<Integer, TreeNode>();

        TreeNode parent=new TreeNode(descriptions[0][0]), child;
        nodes.put(descriptions[0][0], parent);

        TreeNode root=parent;

        for(int[] desc: descriptions){
            if(!nodes.containsKey(desc[0])){
                parent=new TreeNode(desc[0]);
                nodes.put(desc[0], parent);
            }else{
                parent=nodes.get(desc[0]);
            }

            if(!nodes.containsKey(desc[1])){
                child=new TreeNode(desc[1]);
                nodes.put(desc[1], child);
            }else{
                child=nodes.get(desc[1]);
            }

            if(desc[2]==0){
                parent.right=child;
            }else{
                parent.left=child;
            }

            if(child==root){
                root=parent;
            }else{
                ancestors.put(desc[1], parent);
            }

            while(ancestors.containsKey(root.val)){
                root=ancestors.get(root.val);
                // ancestors.remove(root);//Will optimise the memory used but compromises the speed
            }
        }
        return root;
    }
}