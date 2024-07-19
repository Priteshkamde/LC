class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        # [123]
        # run input 23
        # clip 1
        # 23 append 1
        # 32 append 1
        # append 1 at the end
        # 123
        
        result = []
        
        if (len(nums)==1):
            return [nums[:]]
        
        for i in range(len(nums)):
            n = nums.pop(0)
            perms = self.permute(nums)
            
            for perm in perms:
                perm.append(n)
            
            result.extend(perms)
            nums.append(n)
        return result
        
        

        