class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int rSum = 0;
        int count =0;

        for(int i =0; i< nums.length; i++){

            rSum = rSum + nums[i];
            int diff = rSum - k;

            if( map.containsKey(diff)){
                count += map.get(diff);
            }

            if(map.containsKey(rSum)){
                map.put(rSum, map.get(rSum)+1);
            }else{
                map.put(rSum, 1);
            }

            

        }
        return count;
    }
}