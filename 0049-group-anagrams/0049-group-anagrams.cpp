class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
       unordered_map<string, vector<string>> mp;
        for(int i=0;i<strs.size();i++){
            string temp=strs[i];
            sort(temp.begin(),temp.end());
            if(mp.find(temp)!=mp.end()){
                auto it=mp.find(temp);
                it->second.push_back(strs[i]);
            }else{
                vector<string> ans1;
                ans1.push_back(strs[i]);
                mp.insert({temp,ans1});
            }
        }
        vector<vector<string>> answer;
        for(auto x=mp.begin();x!=mp.end();x++){
            answer.push_back(x->second);
        }
        return answer;
    }
};