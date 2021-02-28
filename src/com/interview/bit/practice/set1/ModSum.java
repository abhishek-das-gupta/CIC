package com.interview.bit.practice.set1;

import java.util.Arrays;

public class ModSum {
    static int mod = (int)(1e9 + 7);

    // Function to return the sum of (a[i] % a[j])
// for all valid pairs
    static int Sum_Modulo(int a[], int n)
    {
        int max = Arrays.stream(a).max().getAsInt();

        // To store the frequency of each element
        int []cnt=new int[max + 1];

        // Store the frequency of each element
        for (int i = 0; i < n; i++)
            cnt[a[i]]++;

        // To store the required answer
        long ans = 0;

        // For all valid pairs
        for (int i = 1; i <= max; i++)
        {
            for (int j = 1; j <= max; j++)
            {

                // Update the count
                ans = ans + cnt[i] *
                        cnt[j] * (i % j);
                ans = ans % mod;
            }
        }

        return (int)(ans);
    }

    // Driver code
    public static void main(String[] args)
    {
        int a[] = { 1, 2, 3 };
        int n = a.length;

        System.out.println(Sum_Modulo(a, n));
    }
}
