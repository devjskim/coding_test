package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 24;
        int b = 18;

        System.out.println(gcd(a,b));
        System.out.println(gcd1(a,b));
        System.out.println(gcd2(a,b));

    }

    public static int gcd(int a, int b){
        int g=1;
        for (int i=2; i<min(a,b); i++){
            if(a%i == 0 & b%i == 0){
                g = i;
            }
        }
        return g;
    }

    /* Using Euclid algorithm with recursive*/
    public static int gcd1(int a, int b){
        if(b == 0) {
            return a;
        } else{
            return gcd1(b, a%b);
        }

    }
    /* Using Euclid algorithm without recursive*/
    public static int gcd2(int a, int b){
        while (b!=0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int min(int a, int b){
        if(a > b){
            return b;
        }
        else{
            return a;
        }
    }

}
