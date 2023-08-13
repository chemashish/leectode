//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    int fun(int []price,int n,int l,int [][] dp){
        if(n==0||l==0) return 0;
        if(dp[n][l]!=-1) return dp[n][l];
        if(n<=l){
            return dp[n][l]=Math.max(price[n-1]+fun(price,n,l-n,dp),fun(price,n-1,l,dp));
        }else{
            return dp[n][l]=fun(price,n-1,l,dp);
        }
    }
    public int cutRod(int price[], int n) {
        //code here
        int [][] dp=new int[n+1][n+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
       
        return fun(price,n,n,dp);
    }
}