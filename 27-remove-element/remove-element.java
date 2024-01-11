class Solution {
    public int removeElement(int[] nums, int val) {

        int ptr1 = 0;
        int ptr2 = nums.length;
        
        while ( ptr2 > ptr1 ){
           
            if ( nums[ptr1] == val){
                nums[ptr1] = nums[ptr2-1];
                ptr2--;
            }else{
                ptr1++;
            }

        }

        return ptr2;

    }
}