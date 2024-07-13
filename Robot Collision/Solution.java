class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Integer posIdx[]=sort(positions);
        Stack<Integer> s=new Stack<Integer>();
        int tos;
        for(int i=0;i<posIdx.length;i++){
            if(!s.empty() && directions.charAt(posIdx[i])=='L' && directions.charAt(s.peek())=='R' ){
                while(!s.empty() && directions.charAt(tos=s.peek())=='R'){
                    s.pop();
                    if(healths[posIdx[i]]> healths[tos]){
                        healths[tos]=0;
                        healths[posIdx[i]]-=1;
                    }else if(healths[posIdx[i]]< healths[tos]){
                        healths[tos]-=1;
                        healths[posIdx[i]]=0;
                        s.push(tos);
                        break;
                    }else{
                        healths[posIdx[i]]=0;
                        healths[tos]=0;
                        break;
                    }
                }
                if(healths[posIdx[i]]!=0 )
                    s.push(posIdx[i]);
            }else{
                s.push( posIdx[i] );
            }
        }

        List<Integer> ans=new LinkedList<Integer>();
        for(int health:healths){
            if(health!=0)
                ans.add(health);
        }
        return ans;
    }

    private Integer[] sort(int[] positions){
        Integer posIdx[]=new Integer[positions.length];

        for(int i=0;i<positions.length;i++)
            posIdx[i]=i;

        Arrays.sort(posIdx, (lhs, rhs)->Integer.compare(positions[lhs], positions[rhs] ));
        return posIdx;
    }   
}