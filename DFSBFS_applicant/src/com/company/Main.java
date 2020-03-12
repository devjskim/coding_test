package com.company;

import java.util.*;

class Pair{
    int x, y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

}
public class Main {
    public static Boolean[] c;
    public static int[] dist;
    public static int MAX=1001;
    public static int[][] d;
    public static int[][] wall=
                    {{0,0,1,1,1,1},
                    {0,1,0,0,0,0},
                    {0,0,1,1,1,1},
                    {1,1,0,0,0,1},
                    {0,1,1,0,1,0},
                    {1,0,0,0,1,0}};
    public static Boolean[][] cw;
    public static int[][] wall_cost;

    public static void main(String[] args) {
	// write your code here

        c = new Boolean[MAX];
        Arrays.fill(c,false);
        dist = new int[MAX];
        Arrays.fill(dist, 0);
        d = new int[MAX+1][MAX+1];
        for(int i=0; i<MAX+1;i++){
            Arrays.fill(d[i], -1);
        }

        cw = new Boolean[wall.length][wall[0].length];
        for(int i=0; i<wall[0].length; i++){
            Arrays.fill(cw[i], false);
        }
        wall_cost = new int[wall.length][wall[0].length];
        for(int i=0; i<wall[0].length; i++){
            Arrays.fill(wall_cost[i], 0);
        }

        int start = 5;
        int destination = 17;
        int s = 18;

        //hide_seek(start, destination);
        //hide_seek_adv(start,destination);
        //emoticon(s);
        wall_cost_cal();
    }

    public static void hide_seek(int start, int destination){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.remove();
            if(now-1 > 0) {
                if (!c[now - 1]) {
                    q.add(now - 1);
                    c[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                }
            }
            if(now+1 < MAX){
                if(!c[now+1]){
                    q.add(now+1);
                    c[now+1] = true;
                    dist[now+1] = dist[now] +1;
                }
            }
            if(now*2 < MAX){
                if(!c[now*2]){
                    q.add(now*2);
                    c[now*2] = true;
                    dist[now*2] = dist[now]+1;
                }
            }
        }

        System.out.println(dist[destination]);
    }

    public static void emoticon(int S){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;
        while(!q.isEmpty()){
            int s = q.remove();
            int c = q.remove();
            //copy case
            if(d[s][s] == -1){
                d[s][s] = d[s][c] +1;
                q.add(s);
                q.add(s);
            }
            if(s+c <= S){
                if(d[s+c][c] == -1){
                    d[s+c][c] = d[s][c] +1;
                    q.add(s+c);
                    q.add(c);
                }
            }
            if(s-1 >= 0) {
                if (d[s-1][c] == -1) {
                    d[s-1][c] = d[s][c] + 1;
                    q.add(s - 1);
                    q.add(c);
                }
            }
        }
        int ans = -1;
        for(int i=0; i<S; i++){
            if(d[S][i] != -1){
                if(ans == -1 || ans > d[S][i])
                    ans = d[S][i];
            }
        }
        System.out.println(ans);
    }

    /*          https://www.acmicpc.net/problem/13549           */
    /*          same as hide_seek, but the *2 cost is 0         */
    public static void hide_seek_adv(int start, int destination){
        Deque<Integer> dq = new LinkedList<Integer>();
        dq.addFirst(start);
        dist[start] = 0;
        c[start] = true;
        while(!dq.isEmpty()){
            int y = dq.pollFirst();
            if(y*2 < MAX){
                if(!c[y*2]){
                    c[y*2] = true;
                    dq.addFirst(y*2);
                    dist[y*2] = dist[y];
                }
            }
            if(y+1 < MAX){
                if(!c[y+1]){
                    c[y+1] = true;
                    dq.addLast(y+1);
                    dist[y+1] = dist[y] +1;
                }
            }
            if(y-1 > 0){
                if(!c[y-1]){
                    c[y-1] = true;
                    dq.addLast(y-1);
                    dist[y-1] = dist[y] +1;
                }
            }
        }
        System.out.println(dist[destination]);
    }


    /*          https://www.acmicpc.net/problem/1261            */
    /*                  if break wall = cost + 1                */
    /*              if not break wall = cost + 0                */
    public static void wall_cost_cal(){
        Deque<Pair> dq = new LinkedList<Pair>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        cw[0][0] = true;
        Pair p = new Pair(0,0);
        dq.addFirst(p);
        while(!dq.isEmpty()){
            Pair pa = dq.pollFirst();
            int x = pa.x;
            int y = pa.y;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx >= wall.length || nx < 0 || ny >= wall[0].length || ny <0) continue;
                if(wall[nx][ny] == 0 & !cw[nx][ny]){
                    dq.addFirst(new Pair(nx,ny));
                    cw[nx][ny] = true;
                    wall_cost[nx][ny] = wall_cost[x][y];
                }
                if(wall[nx][ny] == 1 & !cw[nx][ny]){
                    dq.addLast(new Pair(nx,ny));
                    cw[nx][ny] = true;
                    wall_cost[nx][ny] = wall_cost[x][y] + 1;
                }
            }
        }
        System.out.println(wall_cost[wall.length-1][wall[0].length-1]);

    }

}


