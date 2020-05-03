package day8_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int [] memo = new int [100001];
    private static List<Integer> list;

    private static int N;
    private static int sum;
    private static int min;

    public static void main(String []args){
        long l = System.currentTimeMillis();

        list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        sum = scan.nextInt();

        for(int i=0; i<N; i++){
            list.add(scan.nextInt());
        }

        min = sum + 1;

        for(int i=0; i<N; i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }

        memo[min] = 1;

        int dfs = dfs(sum);

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

        if(memo[N] != 0) {
            return memo[N];
        }
        else{
            int temp = 0;
            for(int i=0; i<N; i++){
                temp += dfs(N-list.get(i));
            }
            return temp;
        }
    }


}
