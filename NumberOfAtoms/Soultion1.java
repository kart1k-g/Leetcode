class Solution {
    int idx, len;
    String formula;

    public String countOfAtoms(String formula) {
        idx=0;
        len=formula.length();
        this.formula=formula;

        HashMap <String, Integer> elements=getElements();
        List<Map.Entry<String, Integer>> sorted=new ArrayList<>(elements.entrySet());
        sorted.sort((lhs, rhs)-> lhs.getKey().compareTo(rhs.getKey()));

        StringBuilder ans=new StringBuilder();
        int freq;
        for(Map.Entry<String, Integer> item: sorted){
            freq=item.getValue();
            if(freq==1){
                ans.append(item.getKey());
            }else{
                ans.append(item.getKey()+freq);
            }
        }
        return ans.toString();
    }

    private HashMap<String, Integer> getElements(){
        HashMap<String, Integer> temp=new HashMap< String, Integer>(), sub;
        char ch;
        String str="";
        int multi, freq, count;

        while(idx<len){
            ch=formula.charAt(idx);
            
            if(ch=='('){
                idx++;
                sub=getElements();
                multi=extractNum();
                for(Map.Entry<String, Integer> element: sub.entrySet()){
                    freq=element.getValue();
                    addElement(element.getKey(), freq*multi, temp);
                }
                sub=null;
            }else if(ch==')'){
                idx++;
                break;
            }else if( ch<='9' && ch>='0' ){
                freq=extractNum();
                addElement(str, freq, temp);
                str="";
            }else{
                if(!str.equals("") && ch<='Z'){
                    addElement(str, 1, temp);
                    str="";
                }
                str+=ch;
                idx++;
            }
        }

        if(!str.equals("")){
            addElement(str, 1, temp);
        }
        return temp;
    }

    private void addElement(String str, int freq, HashMap<String, Integer> map){
        int count=0;
        if(map.containsKey(str) ){
            count=map.get(str);
        }
        map.put(str, count+freq);
    }

    private int extractNum(){
        int num=0;
        char ch;
        while( idx<len && (ch=formula.charAt(idx))<='9' && ch>='0' ) {
            num=(num*10)+(ch-'0');
            idx++;
        }
        return num==0?1:num;
    }
}