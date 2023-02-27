//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution

{
    private:
     int solve(int pre,int a[],int n,int i,vector<vector<int>>&dp){
         if(i==n){
             return 0;
         }
         int take=0;
         if(dp[pre+1][i]!=-1) return dp[pre+1][i];
         if(pre==-1 || a[pre]<a[i]){
             take= 1+solve(i,a,n,i+1,dp);
         }
         int nottake= solve(pre,a,n,i+1,dp);
         return dp[pre+1][i]=max(take,nottake);
     }
    public:
    //Function to find length of longest increasing subsequence.
    int longestSubsequence(int n, int a[])
    {
       // your code here
       int mini=-1;
       for(int i=0;i<n;i++){
           mini=max(a[i],mini);
       }
       vector<vector<int>>dp(n,vector<int>(n,-1));
       //for(int i=0;i<pre+2;i++){
       //    for(int j=0;j<n)
       //}
       return solve(-1,a,n,0,dp);
    }
};

//{ Driver Code Starts.
int main()
{
    //taking total testcases
    int t,n;
    cin>>t;
    while(t--)
    {
        //taking size of array
        cin>>n;
        int a[n];
        
        //inserting elements to the array
        for(int i=0;i<n;i++)
            cin>>a[i];
        Solution ob;
        //calling method longestSubsequence()
        cout << ob.longestSubsequence(n, a) << endl;
    }
}

// } Driver Code Ends