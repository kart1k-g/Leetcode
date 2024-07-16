public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
    
        StringBuilder ans=new StringBuilder();
        Queue<TreeNode > q=new LinkedList<TreeNode>();
        TreeNode temp;
        int size;
        q.add(root);
        while(!q.isEmpty()){
            size=q.size();

            for(int i=1;i<=size;i++){
                temp=q.poll();
                if(temp!=null){
                    q.add(temp.left);
                    q.add(temp.right);
                    ans.append((char)(temp.val+2000));
                }else{
                    ans.append('N');
                }
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len;
        if((len=data.length())==0)
            return null;

        TreeNode root=new TreeNode((int)(data.charAt(0)-2000));
        Queue<TreeNode > q=new LinkedList<TreeNode>();
        TreeNode temp;
        int idx=1;
        char ch;
        q.add(root);
        
        while(idx<len){
            temp=q.poll();

            ch=data.charAt(idx);
            if(ch!='N'){
                temp.left=new TreeNode((ch-2000));
                q.add(temp.left);
            }
            idx++;

            ch=data.charAt(idx);
            if(ch!='N'){
                temp.right=new TreeNode((ch-2000));
                q.add(temp.right);
            }
            idx++;
        }
        return root;
    }
}
