class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr, temp;
        int prev=Integer.MIN_VALUE;
        curr=root;
        boolean first=true;
        while(curr!=null){
            if(curr.left==null){
                if(prev>=curr.val && !first){
                    return false;
                }
                first=false;
                prev=curr.val;
                curr=curr.right;
            }else{
                temp=curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }else{
                    temp.right=null;
                    if(prev>=curr.val && !first){
                        return false;
                    }
                    first=false;
                    prev=curr.val;
                    curr=curr.right;
                }
            }
        }
        return true;
    }
}