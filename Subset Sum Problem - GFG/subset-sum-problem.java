//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

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

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][]=new int[N+1][sum+1];
        for(int row[]:dp)
          Arrays.fill(row,-1);
        return solve(N,arr,sum,dp);
    }
}