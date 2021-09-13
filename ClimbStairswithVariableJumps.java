import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        int n;
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=obj.nextInt();
        }
        
        //int ans = climbSt(0,n,arr);
        
        int dp[]=new int[n+1];
        
        Arrays.fill(dp,0);
        
        int ans= climbstMem(0,n,arr,dp);//through memoization
        
       System.out.println(ans);
       
        
       
       
    }
    
    static int climbSt(int src,int dest , int []arr)
    {
        if(src>dest)
        return 0;
        
        if(src==dest)
        return 1;
        
        int totalpaths=0;
        for(int jumps=1;jumps<=arr[src];jumps++)
        {
          int path = climbSt(src+jumps,dest,arr);
          totalpaths = totalpaths+path;
        }
        
        return totalpaths;
        
    }
    
    static int climbstMem(int src , int dest,int []arr,int []dp)
    {
        if(src>dest)
        return 0;
        
        if(src==dest)
        return 1;
        
        
        if(dp[src]!=0)
        return dp[src];
        
        int totalpaths=0;
        for(int jumps=1;jumps<=arr[src];jumps++)
        {
            int path =climbstMem(src+jumps,dest,arr,dp);
            totalpaths=totalpaths+path;
        }
        
        dp[src]=totalpaths;
        return totalpaths;
    }
    
    
    

}
