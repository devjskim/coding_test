package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static int[] a = new int[10];
    public static Boolean[] c= new Boolean[10];
    public static int n = 4;
    public static int m = 2;

    public static void main(String[] args) {
	// write your code here
        /*      java keyboard input     */
        /*
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        */
        /*      input two inputs         */

        initBo();
        //NM15649(0);
        NM15651(0);
    }


    /*            https://www.acmicpc.net/problem/15649               */
    public static void NM15649(int index){
        if(index == m){
            //System.out.println(a);
            for(int i=0; i<m; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println(" ");
        }
        for(int i=1; i<=n; i++){
            if(c[i])    continue;
            /*      check duplication     */
            c[i] = true;
            a[index] = i;
            NM15649(index+1);
            c[i] = false;
        }
    }

    public static void initBo(){
        for(int i=0; i<c.length; i++){
            c[i] = false;
        }
    }

    /*            https://www.acmicpc.net/problem/15651               */
    /*                 similar with 15649 problem                     */
    /*               but this problem allow duplication               */
    public static void NM15651(int index){
        if(index == m){
            //System.out.println(a);
            for(int i=0; i<m; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println(" ");
        }
        if(index > m) return;
        for(int i=1; i<=n; i++){
            //if(c[i])    continue;
            /*      remove duplication check point to allow duplication     */
            c[i] = true;
            a[index] = i;
            NM15651(index+1);
            c[i] = false;
        }
    }
}
