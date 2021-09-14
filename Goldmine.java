import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        int n,m,i,j;
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        m = obj.nextInt();
        
        int arr[][]=new int[n][m];
        int[][]dp=new int[n+1][m+1];
        for(i=0;i<n;i++)
        {
        for(j=0;j<m;j++)
        {
        arr[i][j]=obj.nextInt();
        dp[i][j]=-1;
        }
        }
        
     int max=Integer.MIN_VALUE;
     int ans=0;
      for(i=0;i<n;i++)
      {
       ans = maxGold(arr,i,0,dp);
       max =Math.max(max,ans);
      }
        
       //System.out.print(max);
        
      
       ans =  maxGoldtab(arr);
       System.out.print(ans);
      
        
    }
    
   public static int maxGold(int arr[][], int sr,int sc,int [][]dp)
    {
        
        if(sr<0||sr>arr.length-1)
        return 0;
        
        if(sc==arr[0].length-1)
        return arr[sr][sc];
        
        if(dp[sr][sc]!=-1)
        return dp[sr][sc];
        
        
        
        int up = maxGold(arr,sr-1,sc+1,dp);
        int right=maxGold(arr,sr,sc+1,dp);
        int down = maxGold(arr,sr+1,sc+1,dp);
        
        int max1 = Math.max(up,right);
        int max2 = Math.max(max1,down);
        
        dp[sr][sc]= max2+arr[sr][sc];
        return dp[sr][sc];
        
        
        
    }
     
      public static int maxGoldtab(int arr[][])
      {
        int n =arr.length;
        int m = arr[0].length;
        
        int dp[][]=new int[n][m];
        
        int i,j;
        for(j=m-1;j>=0;j--)
        {
        for(i=0;i<n;i++)
        {
            if(j==m-1)
            dp[i][j]=arr[i][j];
            else
            {
                int up = i-1>=0?dp[i-1][j+1]:0;
                int right = dp[i][j+1];
                int down = i+1<n?dp[i+1][j+1]:0;
                dp[i][j] = arr[i][j] + Math.max(up, Math.max(right, down));
            }
        }
        }
        
        int ans = 0;
        for( i=0; i<n; i++)
            ans = Math.max(ans, dp[i][0]);
        
        return ans;
        
        
      }
}
