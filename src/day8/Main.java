package day8;

import java.util.*;

public class Main {

    private static int [] memo = new int [301];
    private static List<Integer> list;

    private static int N;

    public static void main(String []args){
        long l = System.currentTimeMillis();

        list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        for(int i=0; i<N; i++){
            list.add(scan.nextInt());
        }

        int dfs = dfs(N);

        System.out.println(dfs);

//        System.out.println(System.currentTimeMillis()-l);
    }

    public static int get(int N){
        if(N-1 < 0){
            return 0;
        }
        else{
            return list.get(N-1);
        }
    }

    public static int dfs(int N){
        if(N <= 0){
            return 0;
        }
        if(N == 1){
            return list.get(0);
        }

        if(memo[N] != 0) {
            return memo[N];
        } else{
            memo[N] = Math.max(dfs(N-3) + get(N-1) + get(N), Math.max(dfs(N-5) + get(N-3) + get(N-2), dfs(N-4) + get(N-2))+ get(N));
            return memo[N];
        }
    }


}
