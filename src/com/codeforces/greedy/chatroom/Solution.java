package com.codeforces.greedy.chatroom;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine(); int m = t.length();
        String s = "hello"; int n = s.length();
        if(m < n){
            System.out.println("NO");
            return;
        }
        int i=0;
        int j=0;
        while(true){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
            if(i == n){
                System.out.println("YES");
                break;
            }else if(j == m){
                System.out.println("NO");
                break;
            }
        }
    }
}
