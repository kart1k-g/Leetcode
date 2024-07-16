class Solution {
    public int kthSmallest(TreeNode root, int k) {//Morris Traversal
        TreeNode curr, temp;
        curr=root;
        while(curr!=null){
            if(curr.left==null){
                k--;
                if(k==0)
                    return curr.val;
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
                    k--;
                    if(k==0)
                        return curr.val;
                    curr=curr.right;
                }
            }
        }
        return -1;
    }
}