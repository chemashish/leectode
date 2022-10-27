class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
       vector<int> twoSum;
         unordered_map<int ,int> mp;
       for(int i=0;i<nums.size();i++){
         auto f=mp.find(target-nums[i]);
         if(f==mp.end()){
           mp.insert(make_pair(nums[i],i));
         }else{
           twoSum.push_back(f->second);
           twoSum.push_back(i);
        }
      }
        return twoSum;
    }
    
};