package com.company;

import java.util.Arrays;

public class Main {
    public static int[] d;
    public static void main(String[] args) {
	// write your code here
        int n = 7;
        d = new int[n+1];
        Arrays.fill(d, 0);

        System.out.println(fibonacci_t(n));
    }

    /*      build fibonacci series (bottom-up)      */
    public static int fibonacci_b(int n){
        d[0] = 0;
        d[1] = 1;
        for(int i=2; i<n+1; i++){
            d[i] = d[i-1] + d[i-2];
        }

        return d[n];
    }
    /*      build fibonacci series (top-down)       */
    public static int fibonacci_t(int n){

        if(n <= 1)    return n;
        else{
            if(d[n] > 0)    return d[n];
            else{
                d[n] = fibonacci_t(n-1) + fibonacci_t(n-2);
                return d[n];
            }
        }
    }
}
