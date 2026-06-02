public class Classroom1 {

    // memoization
    public static int fib(int n, int f[]) {
        if (n == 0 || n == 1)
            return n;

        if(f[n]!=0){ // fib(n) is already calculated
            return f[n];
        }
        
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }


// tabulation
    public static int fibt(int n) { 
        if(n==1 || n==0) return n;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    // 0-1 Knapsack
    public static int knapsack(int val[],int wt[],int W, int n,int dp[][]){
        if(n==0 || W==0) return 0;

        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){// valid condition
            // include 
            int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1,dp);
            // exclude
            int ans2 = knapsack(val, wt, W, n-1,dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            return dp[n][W] = knapsack(val, wt, W, n-1,dp);
        }
        
    }

    // 0-1 knapsack tabulation
    public static int knapsack2(int val[],int wt[],int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0;i<n+1;i++){ // 0th column
            dp[i][0] = 0;
        }
        for(int j = 0;j<W+1;j++){// first row
                dp[0][j] = 0;
            }

        for(int i =1;i<n+1;i++){
            for(int j = 1;j<W+1;j++){
                int v = val[i-1];
                int w = wt[i-1];

                if(w<=j){
                    int incProfit = v+dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] =Math.max(incProfit, excProfit);
                }else{
                     dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    // Target sum subset
    //tabulation  O(n*W)
    public static boolean targetSumSubset(int arr[],int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // i  = items & j = target sum
        for(int i = 0;i<n+1;i++){
            dp[i][0] = true;
        }

        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<sum+1;j++){
                // include
                int v = arr[i-1];
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j] = true;
                }
                // exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true; 
                }

            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        // int n = 10;
        // int f[] = new int[n + 1];
        // System.out.println(fib(n, f));
        // System.out.println(fibt(n));

        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7; 
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i =0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(val, wt, W,n,dp));
        System.out.println(knapsack2(val, wt, W));
        System.out.println(targetSumSubset(val, 2));
    }
}