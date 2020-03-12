package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input1 = {20,7,23,19,10,15,25,8,13};
        int e = 1;
        int s = 2;
        int m = 3;
        //dwarf(input1);
        ESM_date(e,s,m);
    }

    /*      https://www.acmicpc.net/problem/2309                        */
    /*      9명의 난쟁이 중 7명을 골라서 키의 합이 100이 되게 하기          */
    public static void dwarf(int[] a){
        //a[9] = {20,7,23,19,10,15,25,8,13}
        int sum = 0;
        Arrays.sort(a);
        for(int i=0; i<a.length; i++){
            sum +=a[i];
        }
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if((sum - a[i] - a[j]) == 100){
                    for(int k=0; k<a.length; k++){
                        if(k != i & k != j){
                            System.out.print(a[k] + " ");
                        }
                    }
                }
            }
        }

    }

    /*      calculate ESM date                          */
    /*      1< E <= 15, 1< S <= 28, 1< M < 19           */
    /*      주어진 ESM 을 몇년도 인지 계산하자            */
    /*      https://www.acmicpc.net/problem/1476        */
    public static void ESM_date(int E, int S, int M){
        int e =1, s=1, m=1;

        for(int cnt=1;;cnt++){
            if(e==E & s==S & m==M){
                System.out.println(cnt);
                break;
            }
            else{
                e++;
                s++;
                m++;

                if(e>15){
                    e = 1;
                }
                if(s>28){
                    s = 1;
                }
                if(m>19){
                    m = 1;
                }
            }
        }
    }

    /*      Tetromino                                   */
    /*      https://www.acmicpc.net/problem/14500       */
    public static void tetromino(int[][] a){
        
    }
}
