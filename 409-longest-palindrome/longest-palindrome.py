class Solution:
    def longestPalindrome(self, s):
        ans = 0
        my_set = set()

        for char in s:
            if char not in my_set:
                my_set.add(char)
            else:
                ans += 2;
                my_set.remove(char)
        
        if len(my_set) == 0:
            return ans;
        
        return ans+1;