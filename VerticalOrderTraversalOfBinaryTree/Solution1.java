//13/7/24
class Solution1 {
    private TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> myMap;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        myMap=new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();

        traverse(root, 0, 0);

        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> temp;
        PriorityQueue<Integer> conflicts;
        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> col: myMap.entrySet()){
            temp=new ArrayList<Integer>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> row: col.getValue().entrySet()){
                conflicts=row.getValue();
                while(!conflicts.isEmpty()){
                    temp.add(conflicts.poll());
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    private void traverse(TreeNode node, int x, int level){
        if(node==null){
            return;
        }

        TreeMap<Integer, PriorityQueue<Integer>> xLine;
        PriorityQueue<Integer> temp;

        if(myMap.containsKey(x)){
            xLine=myMap.get(x);
            if(xLine.containsKey(level)){
                temp=xLine.get(level);
            }else{  
                temp=new PriorityQueue<Integer>();
            }
        }else{
            xLine=new TreeMap<Integer, PriorityQueue<Integer>>();
            temp=new PriorityQueue<Integer>();
        }

        temp.add(node.val);
        xLine.put(level, temp);
        myMap.put(x, xLine);

        traverse(node.left, x-1, level+1);
        traverse(node.right, x+1, level+1);
    }
}