class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[32];
        for(char ch: word.toCharArray()){
            freq[ch-91]++;
        }
        int multi=1, count=0;
        Arrays.sort(freq);
        for(int i=31;i>=6;i--){
            count+=freq[i]*multi;
            if(i%8==0){
                multi++;
            }
        }
        return count;
    }
}
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31