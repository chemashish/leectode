//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution{
private:
   int solve(int val[],int wt[],int W,int N,int i,vector<vector<int>>&dp){
       if(i==0){
           if(wt[0]<=W){
               return ((int )W/wt[0])*val[0];
           }
           return 0;
       }
       int take=INT_MIN;
       if( dp[W][i]!=-1) return dp[W][i];
       if(W>=wt[i]){
           take=val[i]+solve(val,wt,W-wt[i],N,i,dp);
       }
       int notTake=solve(val,wt,W,N,i-1,dp);
       
       return dp[W][i]=max(take,notTake);
   }
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        vector<vector<int>>dp(W+1,vector<int>(N,-1));
        int profit= solve(val,wt,W,N,N-1,dp);
        if(profit==INT_MIN)
        return 0;
        return profit;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N, W;
        cin>>N>>W;
        int val[N], wt[N];
        for(int i = 0;i < N;i++)
            cin>>val[i];
        for(int i = 0;i < N;i++)
            cin>>wt[i];
        
        Solution ob;
        cout<<ob.knapSack(N, W, val, wt)<<endl;
    }
    return 0;
}
// } Driver Code Ends