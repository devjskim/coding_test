package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 3, 2, 1};
        int[] c = {20, 1, 15, 8, 4, 10};
        int[][] w = {{0, 10, 15, 20},
                {5, 0, 9, 10},
                {6, 13, 0, 12,},
                {8, 8, 9, 0}};

        int[][] w1 = {{0, 10, 15},
                {5, 0, 9},
                {6, 13, 0}};


        TSP(4, w);

    }


    /*      Calculate next permutation and print calculate result       */
    /*              https://www.acmicpc.net/problem/10972               */
    public static void next_permu(int[] a){
        int i = a.length - 1;
        int j = a.length - 1;
        while(i>0 && a[i-1] >= a[i]) i--;
        if(i == 0){
            System.out.println("input array is the last permutaion");
            for(int k = 0; k<a.length; k++){
                System.out.print(a[k] + " ");
            }
            System.out.println(" ");
        }
        else {
            while (a[j] <= a[i - 1]) j--;
            swap(a, i - 1, j);
            j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }

            for(int k = 0; k<a.length; k++){
                System.out.print(a[k] + " ");
            }
            System.out.println(" ");
        }
    }

    /*      Boolean return version this is for calculate all permutation function       */
    public static Boolean next(int[] a){
        Boolean flag = true;
        int i = a.length - 1;
        int j = a.length - 1;
        while(i>0 && a[i-1] >= a[i]) i--;
        if(i == 0){
            return false;
        }
        else {
            while (a[j] <= a[i - 1]) j--;
            swap(a, i - 1, j);
            j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        return true;
    }

    public static int[] swap(int[] a, int b, int c){
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
        return a;
    }



    /*      Calculate previous permutation and print calculate result       */
    public static void prev_permu(int[] a){
        int i = a.length - 1;
        int j = a.length - 1;
        while(i>0 && a[i-1] <= a[i]) i--;
        if(i == 0){
            System.out.println("input array is the last permutaion");
            for(int k = 0; k<a.length; k++){
                System.out.print(a[k] + " ");
            }
            System.out.println(" ");
        }
        else {
            while (a[j] >= a[i - 1]) j--;
            swap(a, i - 1, j);
            j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }

            for(int k = 0; k<a.length; k++){
                System.out.print(a[k] + " ");
            }
            System.out.println(" ");
        }
    }

    /*      Calculate all the possible permutation using next_permu function      */
    public static void all_permu(int[] a){
        Boolean flag = true;
        Arrays.sort(a);
        for(int k = 0; k<a.length; k++){
            System.out.print(a[k] + " ");
        }
        System.out.println(" ");
        while(flag){
            flag = next(a);
            if(flag) {
                for (int k = 0; k < a.length; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println(" ");
            }
        }
    }
    /*          https://www.acmicpc.net/problem/10819                               */
    /*          find the biggest differential following equation                    */
    /*          |A[0] - A[1]| + |A[1] - A[2]| + .... + |A[N-2] - A[N-1]             */
    /*          calculate all the possible permutaion using next_permu function     */
    public static void biggest_diff(int[] a){
        int sum = 0;
        int temp = 0;
        Boolean flag = true;
        Arrays.sort(a);
        sum = diffsum(a);
        while(flag){
            flag = next(a);
            if(flag){
                temp = diffsum(a);
                if( temp > sum){
                    sum = temp;
                }
            }
        }
        System.out.println(sum);
    }

    /*          calculate |A[0] - A[1]| + |A[1] - A[2]| + .... + |A[N-2] - A[N-1]             */
    public static int diffsum(int[] a){
        int sum = 0;
        for(int i=0; i<a.length-1; i++){
            sum += Math.abs(a[i] - a[i+1]);
        }

        return sum;
    }


    /*          https://www.acmicpc.net/problem/10971             */
    public static void TSP(int a, int[][] w){
        int cost = 0;

        int[] route = new int[a];
        for(int i=0; i<a; i++){
            route[i] = i;
        }
        do {
            Boolean ok = true;
            int temp = 0;
            for (int i = 0; i < route.length - 1; i++) {
                if(w[route[i]][route[i+1]] == 0) ok=false;
                else temp+=w[route[i]][route[i+1]];
            }
            if(ok & w[route[route.length-1]][route[0]] !=0){
                temp += w[route[route.length-1]][route[0]];
                if(cost == 0) cost = temp;
                else if (temp < cost) cost = temp;
            }
        } while(next(route));

        System.out.println(cost);
    }

}
