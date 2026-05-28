class Solution {
    public int[] productExceptSelf(int[] nums) {
          int zeroCount = 0;
        int zeroPos=0;
        int pivot=1;
        int[]res = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroPos = i;
            } else {
                pivot *= nums[i];
            }
        }
        if(zeroCount>1){
            return new int[nums.length];
        }
        if(zeroCount==1) {
            res[zeroPos] = pivot;
            return res;
        }

       for(int i=0;i<nums.length;i++) {
           if (nums[i] != 0) {
              res[i] = pivot / nums[i];
           }
           else {
               res[i] = pivot;
           }
         
       }
        return res;
    }
}  
