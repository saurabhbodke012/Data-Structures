class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        dict = {}

        for i in range (len(nums)): 
            sum = target - nums[i]

            if sum in dict:
                return [dict[sum], i]
            else:
                dict[nums[i]] = i
            
        return None

        
        