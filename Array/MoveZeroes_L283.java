package AkashChoudhary_22BCS13892.Array;

class MoveZeroes_L283 {
    public void moveZeroes(int[] nums) {
        if(nums.length==1){
            return;
        }
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[idx]=nums[i];
                idx++;
            }
        }
        while(idx<nums.length){
            nums[idx]=0;
            idx++;
        }
    }
}