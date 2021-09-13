import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        int n;
        Scanner obj = new Scanner(System.in);
        n =obj.nextInt();
        int []arr= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=obj.nextInt();
        }
        int []dp=new int[n+1];
        
        Arrays.fill(dp,-1);
        int ans = minmoves(0,n-1,arr,dp);
        System.out.println(ans);
    }


static int minmoves(int src,int dest , int []arr,int[]dp)
{
    if(src>dest)
    return Integer.MAX_VALUE;
    
    if(src==dest)
    return 0;
    
    
    if(dp[src]!=-1)
    return dp[src];
    
    int min=Integer.MAX_VALUE;
    for(int jump=1;jump<=arr[src];jump++)
    {
        int ans = minmoves(src+jump,dest,arr,dp);
        if(ans!=Integer.MAX_VALUE)
         min = Math.min(min,ans+1);
    }
    
    dp[src]=min;
    return dp[src];
    
    
    
}

}
