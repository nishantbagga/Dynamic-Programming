import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        int i,j,n;
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int ans = climbst(n,dp);
        
        
        //System.out.print(ans);    //memoization
       
        ans  = tabulization(n,dp);//tabulization
      System.out.print(ans);
    }
    
    static int climbst(int n,int []dp)
    {
        if(n==0)
        return 1;
        
        if(n<0)
        return 0;
        
        if(dp[n-1]!=-1)
        return dp[n-1];
        
        int x=climbst(n-1,dp);
        int y=climbst(n-2,dp);
        int z =climbst(n-3,dp);
        
         dp[n-1] =x+y+z;
        return dp[n-1];
        
        
        
    }
    
    static int tabulization(int source,int []dp)
    {
        dp[source]=1;
        
        for(int i=source-1;i>=0;i--)
        {
            dp[i] = dp[i+1];
            if(i+2<dp.length)
            dp[i]+=dp[i+2];
            if(i+3<dp.length)
            dp[i]+=dp[i+3];
            
        }
        return dp[0];
    }

}
