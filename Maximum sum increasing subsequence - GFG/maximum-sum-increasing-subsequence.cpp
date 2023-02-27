//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	private:
	int solve(int arr[],int n,int i,int pre,vector<vector<int>> &dp){
	    if(i==n)
	    return 0;
	    if(dp[pre+1][i]!=-1) return dp[pre+1][i];
	    int take=0;
	    
	    if(pre==-1|| arr[pre]<arr[i]){
	        take=arr[i]+solve(arr,n,i+1,i,dp);
	    }
	    int nottake=solve(arr,n,i+1,pre,dp);
	    return dp[pre+1][i]=max(nottake,take);
	}
	

	public:
	int maxSumIS(int arr[], int n)  
	{  
	    // Your code goes here
	    vector<vector<int>> dp(n+1,vector<int>(n,-1));
	    return solve(arr,n,0,-1,dp);
	}  
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        int a[n];

        for(int i = 0; i < n; i++)
        	cin >> a[i];

      

	    Solution ob;
	    cout << ob.maxSumIS(a, n) << "\n";
	     
    }
    return 0;
}


// } Driver Code Ends