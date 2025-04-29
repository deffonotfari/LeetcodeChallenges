class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        //sorting nums
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue; 
            } 
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; 
                    right--;

                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    } 
                    
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        //return result list
        return result;
    }
}
