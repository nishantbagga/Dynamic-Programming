import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        int i,j,n,m;
        Scanner obj = new Scanner(System.in);
        n =obj.nextInt();
        m=obj.nextInt();
        int arr[][]=new int[n][m];
        int dp[][]=new int[n][m];
        
        for( i=0;i<n;i++)
        {
        for( j=0;j<m;j++)
        {
        arr[i][j]=obj.nextInt();
        dp[i][j]=-1;
        }
        }
        
        //int ans = mincost(0,0,n-1,m-1,arr,dp); Memoization
        //System.out.print(ans);
        
        int ans = tab(arr);  
       System.out.print(ans);
    }
    
    
    static int mincost(int sr,int sc,int dr,int dc,int[][]arr,int [][]dp)
    {
        
        if(sr>dr || sc>dc)
        return Integer.MAX_VALUE;
        
        if(sr==dr&&sc==dc)
        return arr[sr][sc];
        
        int min=Integer.MAX_VALUE;
        int right=0,down=0;
        
        if(dp[sr][sc]!=-1)
        return dp[sr][sc];
        
         right = mincost(sr,sc+1,dr,dc,arr,dp);
        
         down = mincost(sr+1,sc,dr,dc,arr,dp);
        
        min = arr[sr][sc] + Math.min(right,down);
        
        dp[sr][sc]=min;
        return min;
        
        
        
    }
    
     static int tab(int[][]arr)
     {
         
         int n=arr.length;
         int m =arr[0].length;
       int dp[][]=new int[n][m];
       int i,j;
       for(i=n-1;i>=0;i--)
       {
       for(j=m-1;j>=0;j--)
       {
            if(i+1<n && j+1<m)
          dp[i][j]=arr[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
          
          else if(i==n-1&&j==m-1)
          dp[i][j]=arr[i][j];
          
          else if(i+1==n)
          {
            dp[i][j]=arr[i][j]+dp[i][j+1];
          }
          else if(j+1==m)
          dp[i][j]=arr[i][j]+dp[i+1][j];
          
          
       }
       }
       return dp[0][0];
     }

}
