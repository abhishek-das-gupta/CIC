    package com.codeforces.dp.lcs.gargi_and_permutations;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.List;

    public class Main {
        static List<Integer> res=null;
        public static void main(String[] args) throws IOException{
            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);

            List<Integer> v1 = new ArrayList<>();
            str = br.readLine().split(" ");
            for(int i=0; i<n; ++i) v1.add(Integer.parseInt(str[i]));
            List<Integer> v2 = new ArrayList<>();
            str = br.readLine().split(" ");
            for(int i=0; i<n; ++i) v2.add(Integer.parseInt(str[i]));
            k -= 2;
            lcs(v1,v2);
            while(k-- != 0){
                v1 = res;
                str = br.readLine().split(" ");
                for(int i=0; i<n; ++i) v2.set(i,Integer.parseInt(str[i]));
                lcs(v1,v2);
            }
            System.out.println(res.size());
        }
        public static void lcs(List<Integer> v1, List<Integer> v2){
            int m = v1.size();
            int n = v2.size();
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<=m; ++i){
                for(int j=0; j<=n; ++j){
                    if(i==0 || j==0) dp[i][j] = 0;
                    else if(v1.get(i - 1).equals(v2.get(j - 1))) dp[i][j] = 1+dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            res = new ArrayList<>();
            int l = dp[m][n];
            int i=m,j=n;
            while(i >0 && j>0){
                if(v1.get(i - 1).equals(v2.get(j - 1))){
                    res.add(0,v1.get(i-1));
                    i--;
                    j--;
                }
                else if(dp[i-1][j] >= dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
    }
