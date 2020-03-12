package com.company;

import java.util.Arrays;

public class Main {
    public static int[] a = new int[10];
    public static Boolean[] c = new Boolean[10];
    public static int n = 4;
    public static int m = 2;

    public static void main(String[] args) {
	// write your code here
        Arrays.fill(c, false);

        //NM15650(0,1);
        NM15652(0,1);

    }

    /*            https://www.acmicpc.net/problem/15650               */
    public static void NM15650(int index, int start){
        if(index == m){
            for(int i=0; i<m; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println(" ");
        }
        if(index > m)   return;
        for(int i=start; i<=n; i++){
            if(c[i]) continue;
            c[i] = true;
            a[index] = i;
            NM15650(index+1, i+1);
            c[i] = false;
        }

    }

    public static void NM15652(int index, int start) {
        if(index == m){
            for(int i=0; i<m; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println(" ");
        }
        if(index > m)   return;
        for(int i=start; i<=n; i++){
            //if(c[i]) continue;
            c[i] = true;
            a[index] = i;
            NM15652(index+1, i);
            c[i] = false;
        }
    }
}
