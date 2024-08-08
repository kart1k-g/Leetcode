class Solution {
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";

        int n=num;
        StringBuilder ans=new StringBuilder();
            int multi, digits=0;
            for(;n>0;n/=10, digits++);

            if(digits>=10)
                multi=1000000000;
            else if(digits>=7)
                multi=1000000;
            else if(digits>=4)
                multi=1000;
            else 
                multi=1;
            
            if(digits>=10){
                n=num/multi;
                num%=multi;
                multi/=1000;

                if(n!=0){
                    ans.append(getEng(n));
                    ans.append(" Billion ");
                }
            }
            if(digits>=7){
                n=num/multi;
                num%=multi;
                multi/=1000;

                if(n!=0){
                    ans.append(getEng(n));
                    ans.append(" Million ");   
                }
            }
            if(digits>=4){
                    n=num/multi;
                    num%=multi;
                    multi/=1000;

                    if(n!=0){

                        ans.append(getEng(n));
                        ans.append(" Thousand ");
                    }
            }
            if(num!=0){
                ans.append(getEng(num));
            }


        if( ans.charAt(ans.length()-1 )==' ' )
            ans.setLength( ans.length()-1 );
        return ans.toString();
    }
    // 2147483648

    private StringBuilder getEng(int n ){
        String nineteen[]={"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",  "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String tens[]={"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder ans=new StringBuilder();
        if(n<20){
            ans.append(nineteen[n-1]);
            return ans;
        }

        int r1=n/100;
        n%=100;

        if(r1!=0){
            ans.append(nineteen[r1-1]);
            ans.append(" Hundred ");
        }

        if(n>19){
            ans.append(tens[(n/10)-2] + " ");

            n%=10;
            if(n!=0)
                ans.append(nineteen[n-1]);
        }else if(n!=0){
            ans.append(nineteen[n-1]);
        }


        if( ans.charAt(ans.length()-1 )==' ' )
            ans.setLength( ans.length()-1 );
        return ans;
    }
}
//billion