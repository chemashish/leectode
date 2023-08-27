//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    static int solve(int N,int []arr,int sum,int [][]dp){
       
       if(N==0){
           if(sum==0) return 1;
           return 0;
       }
           
       if(dp[N][sum]!=-1) return dp[N][sum];
       if(arr[N-1]<=sum){
            return dp[N][sum]=(solve(N-1,arr,sum-arr[N-1],dp)+ solve(N-1,arr,sum,dp))%1000000007;
             
       }else{
            return dp[N][sum]=solve(N-1,arr,sum,dp)%1000000007;
             
       }
   }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n+1][sum+1];
        for(int row[]:dp)
          Arrays.fill(row,-1);
        return solve(n,arr,sum,dp);
	} 
}