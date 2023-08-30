//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static Boolean solve(int N,int []arr,int sum,int [][]dp){
       if(sum==0) return true;
       if(N==0) return false;
       if(dp[N][sum]!=-1) return dp[N][sum]==1?true:false;
       if(arr[N-1]<=sum){
            dp[N][sum]=solve(N-1,arr,sum-arr[N-1],dp)|| solve(N-1,arr,sum,dp)?1:0;
            return solve(N-1,arr,sum-arr[N-1],dp)|| solve(N-1,arr,sum,dp);
       }else{
            dp[N][sum]=solve(N-1,arr,sum,dp)?1:0;
            return solve(N-1,arr,sum,dp);
       }
   }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2!=0) return 0;
        sum/=2;
        int dp[][]=new int[N+1][sum+1];
        for(int row[]:dp)
          Arrays.fill(row,-1);
        return solve(N,arr,sum,dp)==true?1:0;
    }
}