package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 7;
        check_sum(a);
    }


    /*      https://www.acmicpc.net/problem/9095        */
    /*                 N times for loop                 */
    public static void check_sum(int a){
        int ans = 0;
        for(int i1=1; i1<=3; i1++){
            if(i1 == a)   ans++;
            if(i1 > a)  break;
            for (int i2=1; i2<=3; i2++){
                if(i1 + i2 == a)  ans++;
                if(i1 + i2 > a) break;
                for (int i3=1; i3<=3; i3++){
                    if(i1 + i2 + i3 == a)  ans++;
                    if(i1 + i2 + i3 > a)    break;
                    for (int i4=1; i4<=3; i4++){
                        if(i1 + i2 + i3 + i4 == a)  ans++;
                        if(i1 + i2 + i3 + i4 > a)   break;
                        for (int i5=1; i5<=3; i5++){
                            if(i1 + i2 + i3 + i4 + i5 == a)  ans++;
                            if(i1 + i2 + i3 + i4 + i5 > a)  break;
                            for (int i6=1; i6<=3; i6++){
                                if(i1 + i2 + i3 + i4 + i5 + i6 == a)  ans++;
                                if(i1 + i2 + i3 + i4 + i5 + i6> a)  break;
                                for (int i7=1; i7<=3; i7++){
                                    if(i1 + i2 + i3 + i4 + i5 + i6 + i7 == a)  ans++;
                                    if(i1 + i2 + i3 + i4 + i5 + i6 + i7 > a)  break;
                                    for (int i8=1; i8<=3; i8++){
                                        if(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 == a)  ans++;
                                        if(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 > a)  break;
                                        for (int i9=1; i9<=3; i9++){
                                            if(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 == a)  ans++;
                                            if(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9> a)  break;
                                            for (int i0=1; i0<=3; i0++){
                                                if(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i0== a)  ans++;
                                                if(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i0 > a)  break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    /*      solve same problem using recursive function     */
    /*          https://www.acmicpc.net/problem/9095        */
    public static void check_sum_recursive(int a){

    }
}
