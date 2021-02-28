package com.junior.training.cfB.coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int a=0,b=0,c=0;
        int k=3;
        while(k-- != 0){
            String s = fs.next();
            char opd1 = s.charAt(0);
            char opt = s.charAt(1);
            char opd2 = s.charAt(2);

            if(opt == '>'){
                if(opd1 == 'A') a++;
                else if(opd1 == 'B') b++;
                else c++;

                if(opd2 == 'A') a--;
                else if(opd2 == 'B') b--;
                else c--;
            }
            else{
                if(opd1 == 'A') a--;
                else if(opd1 == 'B') b--;
                else c--;

                if(opd2 == 'A') a++;
                else if(opd2 == 'B') b++;
                else c++;
            }
        }
        System.out.println( a + " " +  b + " " + c);

        if(a < b && b < c && a < c) System.out.println("ABC");
        else if(a < c && c < b && a < b) System.out.println("ACB");
        else if(b < a && a<c && b<c) System.out.println("BAC");
        else if(b<c && c < a && b<a) System.out.println("BCA");
        else if(c < a && a < b && c<b) System.out.println("CAB");
        else if(c<b && b<a && c<a) System.out.println("CBA");
        else System.out.println("Impossible");
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
