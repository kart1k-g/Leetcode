class Solution {
    private class Pair{
        int idx;
        TreeNode node;
        Pair(int idx, TreeNode node){
            this.idx=idx;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<Pair>();
        Pair temp;
        int width=0, begin, end, size;
        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            size=q.size();
            temp=q.poll();
            begin=temp.idx;
            end=temp.idx;

            if(temp.node.left!=null){
                q.add(new Pair(2*end, temp.node.left));
            }
            if(temp.node.right!=null){
                q.add(new Pair((2*end)+1, temp.node.right));
            }
            for(int i=2;i<=size;i++){
                temp=q.poll();
                end=temp.idx;

                if(temp.node.left!=null){
                    q.add(new Pair(2*end, temp.node.left));
                }
                if(temp.node.right!=null){
                    q.add(new Pair((2*end)+1, temp.node.right));
                }
            }
            if(end-begin+1>width){
                width=end-begin+1;
            }
        }
        return width;
    }
}