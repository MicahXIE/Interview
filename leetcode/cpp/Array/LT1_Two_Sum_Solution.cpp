class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        for (int i = 0; i < nums.size()-1; i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums[i] + nums[j] == target) {
                    res.push_back(i);
                    res.push_back(j);
                    return res;
                }
            }
        }
        return res;
    }
};

/*
Runtime: 144 ms, faster than 27.54% of C++ online submissions for Two Sum.
Memory Usage: 9.3 MB, less than 88.28% of C++ online submissions for Two Sum.
*/
