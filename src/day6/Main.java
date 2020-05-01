package day6;

import java.util.*;

public class Main {

    private static Deque<Integer> queue = new ArrayDeque<>();
    private static List<Integer> dfs = new ArrayList<>();

    private static int A;
    private static int [][]board1;

    public static void main(String []args){
        long l = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int [][]board = new int[1002][1002];
        board1 = new int[1002][1002];

        for(int i=0; i<B; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            board[a][b] = 1;
            board[b][a] = 1;
            board1[a][b] = 1;
            board1[b][a] = 1;
        }
        scan.close();

        dfs(C);

        for(int i=0; i<dfs.size()-1; i++){
            System.out.print(dfs.get(i) + " ");
        }
        System.out.print(dfs.get(dfs.size()-1) + "\n");

        queue.clear();
        queue.add(C);
        // bfs
        List<Integer> bfs = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer pop = queue.pop();
            bfs.add(pop);

            for(int i=1; i<=A; i++){
                if(board[pop][i] == 1){
                    queue.add(i);
                }
            }

            for(int i=1; i<=A; i++){
                if(board[pop][i] == 1){
                    board[pop][i] = 0;
                    board[i][pop] = 0;
                }
            }

        }
        for(int i=0; i<bfs.size()-1; i++){
            System.out.print(bfs.get(i) + " ");
        }
        System.out.print(bfs.get(bfs.size()-1));

//        System.out.println(System.currentTimeMillis()-l);
    }

    public static void dfs(Integer start){
        // dfs
        dfs.add(start);

        for(int i=0; i<A; i++){
            if(board1[start][i] == 1){
                board1[start][i] = 0;
                board1[i][start] = 0;
                dfs(i);
                board1[start][i] = 1;
                board1[i][start] = 1;
            }
        }
    }

}
