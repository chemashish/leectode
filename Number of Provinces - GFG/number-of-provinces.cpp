//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
    void dfs(int node,vector<int> adj_list[],int V,vector<int> &vis){
        vis[node]=1;
        for(int x:adj_list[node]){
            if(vis[x]!=1){
                dfs(x,adj_list,V,vis);
            }
        }
    }
  public:
    int numProvinces(vector<vector<int>> adj, int V) {
        // code here
        vector<int> adj_list[V+1];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j]==1)
                  adj_list[i].push_back(j);
            }
        }
        vector<int>vis(V,0);
        int count=0;
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                count++;
                dfs(i,adj_list,V,vis);
            }
        }
        return count;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V,x;
        cin>>V;
        
        vector<vector<int>> adj;
        
        for(int i=0; i<V; i++)
        {
            vector<int> temp;
            for(int j=0; j<V; j++)
            {
                cin>>x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }
        

        Solution ob;
        cout << ob.numProvinces(adj,V) << endl;
    }
    return 0;
}
// } Driver Code Ends