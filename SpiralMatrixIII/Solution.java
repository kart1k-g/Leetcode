class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int len=rows*cols, idx=0;
        int ans[][]=new int[len][2];
        int step=1;
        boolean vertical=false;
        int rEnd=rStart, cEnd=cStart+1;

        while(idx<len){
            if(vertical){
                if(cStart>=0 && cStart<cols){
                    if(rStart<rEnd){
                        while(rStart<rEnd){
                            if(rStart<rows && rStart>=0){
                                ans[idx][0]=rStart;
                                ans[idx][1]=cStart;
                                idx++;
                            }     
                            rStart++;
                        }

                    }else{
                        while(rStart>rEnd){
                            if(rStart<rows && rStart>=0){
                                ans[idx][0]=rStart;
                                ans[idx][1]=cStart;
                                idx++;
                            }   
                            rStart--;
                        }
                    }
                }else{
                    rStart=rEnd;
                }
                step*=-1;
                if(step<0){
                    step-=1;
                }
                else{
                    step+=1;
                }
                cEnd+=step;
            }else{
                if(rStart>=0 && rStart<rows){
                    if(cStart<cEnd){
                        while(cStart<cEnd){
                            if(cStart<cols && cStart>=0){
                                ans[idx][0]=rStart;
                                ans[idx][1]=cStart;
                                idx++;
                            }   
                            cStart++;
                        }

                    }else{
                        while(cStart>cEnd){
                            if(cStart<cols && cStart>=0){
                                ans[idx][0]=rStart;
                                ans[idx][1]=cStart;
                                idx++;
                            }  
                            cStart--;
                        }
                    }

                }else{
                    cStart=cEnd;
                }
                rEnd+=step;
            }
            vertical=!vertical;
        }
        return ans;
    }
}