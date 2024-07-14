class Solution {
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans=new LinkedList<Integer>();
        getNodes(root, target, k);
        return ans;
    }

    private int getNodes(TreeNode root, TreeNode target, int k){
        if(root==null)
            return -2;//Node not yet found

        if(root==target){
            searchSubtree(root, k);
            return k-1;
        }

        int dist=getNodes(root.left, target, k);
        if(dist==-1){
            return -1;
        }else if(dist==0){
            ans.add(root.val);
            return -1;//No longer look
        }else if(dist>0){
            searchSubtree(root.right, dist-1);
            return dist-1;
        }else{
            dist=getNodes(root.right, target, k);
            if(dist==0){
                ans.add(root.val);
                return -1;//No longer look
            }else if(dist>0){
                searchSubtree(root.left, dist-1);
                return dist-1;
            }else{
                return dist;
            }
        }
    }

    private void searchSubtree(TreeNode root, int k){
        if(root==null)
            return;

        if(k==0){
            ans.add(root.val);
            return;
        }
        searchSubtree(root.left, k-1);
        searchSubtree(root.right, k-1);
    }
}