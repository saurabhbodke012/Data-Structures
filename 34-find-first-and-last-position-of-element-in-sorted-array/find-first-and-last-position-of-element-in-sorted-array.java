class Solution {
    public int[] searchRange(int[] nums, int target) {

        if ( nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }

        if( nums[0] > target || nums[nums.length-1] < target){
            return new int[]{-1,-1};
        }

        int[] res = new int[2];

        res[0] = searchFirst(nums,target);

        if ( res[0] == -1){
            res[1] = -1;
            return res;
        }
        res[1] = searchLast(nums, res[0], target);

        return res;
    }

    public static int searchFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length-1; 

        while( start <= end){

            int mid = start + (end - start)/2;

            if( nums[mid] == target){
                if( mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                   end = mid - 1;
                }
            }else if ( nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int searchLast(int[] nums,int first, int target){
        int start = first;
        int end = nums.length-1; 

        while( start <= end){

            int mid = start + (end - start)/2;

            if( nums[mid] == target){
                if( mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }else if ( nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

}