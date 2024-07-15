class Solution {
    private int time;
    public int amountOfTime(TreeNode root, int start) {
        time=0;
        findTime(root, start);
        return time;
    }

    private int findTime(TreeNode root, int start){
        if(root==null)
            return -1;//Not yet found

        if(root.val==start){
            time=getHeight(root);
            return 1;
        }

        int delta=findTime(root.left, start);
        if(delta>-1){
            time= Math.max(getHeight(root.right)+delta+1, time);
            return delta+1;
        }else{
            delta=findTime(root.right, start);
            if(delta>-1){
                time= Math.max(getHeight(root.left)+delta+1, time);
                return delta+1;
            }else{
                return -1;
            }
        }
    }

    private int getHeight(TreeNode root){
        if(root==null)
            return -1;

        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
}