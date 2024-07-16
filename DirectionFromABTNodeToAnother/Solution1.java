class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder ans=new StringBuilder();
        getDirections(root, startValue, destValue, ans);
        return ans.toString();
    }

    private boolean getDirections(TreeNode root, int startValue, int destValue, StringBuilder ans){
        if(root==null)
            return false;//not found


        boolean found;
        if(root.val==startValue){
            found=searchAndMark(root, destValue, ans);
            if(found)
                return true;
            else{
                ans.append("U");
                return false;
            }
        }

        found=getDirections(root.left, startValue, destValue, ans);
        if(!found){
            if(ans.length()==0){//None of the two found
                found=getDirections(root.right, startValue, destValue, ans);

                if(!found){
                    if(ans.length()==0){//None of the two found
                        return false;
                    }else{//start found
                        if(root.val==destValue)
                            return true;
                        ans.append("L");
                        found=searchAndMark(root.left, destValue, ans);
                        if(!found){
                            ans.setLength(ans.length()-1);
                            ans.append("U");
                            return false;
                        }
                        return true;
                    }

                }
                return true;

            }else{//start found
                if(root.val==destValue)
                    return true;
                ans.append("R");
                found=searchAndMark(root.right, destValue, ans);
                if(!found){
                    ans.setLength(ans.length()-1);
                    ans.append("U");
                    return false;
                }
                return true;
            }

        }
        return true;        
    }

    private boolean searchAndMark(TreeNode root, int destValue, StringBuilder ans){
        if(root==null)
            return false;

        if(root.val==destValue)
            return true;

        ans.append("L");
        boolean found=searchAndMark(root.left, destValue, ans);
        if(!found){
            ans.setLength(ans.length()-1);
            ans.append("R");
            found=searchAndMark(root.right, destValue, ans);
            if(!found){
                ans.setLength(ans.length()-1);
                return false;
            }
            return true;
        }
        return true;
    }
}