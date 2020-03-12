package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static Boolean[] c;
    public static int[][] w;

    public static void main(String[] args) {
	// write your code here
        c = new Boolean[4];
        Arrays.fill(c,false);

        w = new int[][]{{0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0}};

        //bfs(0);
        dfs(0);
    }

    /*          Depth first search using Adjacent Matrix        */

    public static void dfs(int x){
        //Queue<Integer> q = new LinkedList<Integer>();
        if(c[x])    return;
        c[x] = true;
        System.out.print(x+1 + " ");
        for(int i=0; i<w.length; i++){
            if(w[x][i]!=0 & !c[i]){
                dfs(i);
            }
        }

    }

    /*          Breath first search using Adjacent Matrix        */

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        c[x] = true;
        while(!q.isEmpty()){
            int y = q.remove();
            System.out.print(y+1 + " ");
            for(int i=0; i<c.length; i++){
                if(w[y][i]!=0 & !c[i]){
                    c[i] = true;
                    q.add(i);

                }
            }
        }
    }


}
