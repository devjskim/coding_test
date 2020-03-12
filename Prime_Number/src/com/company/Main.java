package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 28;

        System.out.println(primeN(a));
        System.out.println(primeN2(a));
        goldhach(a);

    }

    /*Divide 2~N*/
    public static Boolean primeN(int a){
        if(a<2){
            return false;
        }
        for(int i=2; i<a; i++){
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }

    /*Divide 2 ~ sqrt(N)*/
    public static Boolean primeN2(int a){
        if (a<2){
            return false;
        }
        for (int i=2; i*i<a; i++){
            if (a%i == 0){
                return false;
            }
        }
        return true;
    }
    /*primeN2 is faster than primeN*/

    /*          find prime number smaller than N                        */
    /*          Using seive of Eratosthenes                             */
    /*          this algorithm's time complexity is O(log(log(N)))      */

    public static Boolean[] erothos(int a){
        int cnt = 0;
        Boolean[] check = new Boolean[a];
        check[0] = check[1] = true;
        for(int i=2; i<a; i++){
            check[i] = false;
        }
        for(int i=2; i*i<a; i++){
            if(check[i] == false){
                for (int j=2*i; j<a; j+=i){
                    check[j] = true;
                }
            }
        }
        return check;
        }
    /*Goldhach's conjecture*/

    public static void goldhach(int a){
        int cnt = 0;
        Boolean flag = false;
        Boolean[] check = new Boolean[a];
        check[0] = check[1] = true;
        for(int i=2; i<a; i++){
            check[i] = false;
        }
        for(int i=2; i*i<a; i++){
            if(check[i] == false){
                for (int j=2*i; j<a; j+=i){
                    check[j] = true;
                }
            }
        }
        for(int i=0; i<a; i++){
            if(check[i] == false){
                if(check[a-i] == false){
                    System.out.println(a+ " = " + i + " + " + (a-i));
                    break;
                }
            }
        }
        if(!flag){
            System.out.println("Goldbach's conjecture is wrong.");
        }
    }

}





