package day7;

import java.util.*;

public class Main {

    private static int [][] board;
    private static List<Integer> vil;
    private static Deque<location> queue = new ArrayDeque<>();

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int N;

    public static void main(String []args){
        long l = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        board = new int[26][26];
        vil = new ArrayList<>();

        for(int i=0; i<N; i++){
            String next = scan.next();
            for(int j=0; j<N; j++){
                board[i][j] = Character.getNumericValue(next.charAt(j));
            }
        }
        scan.close();

        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1 ){
                    count++;
                    vil.add(dfs(i, j, count + 1));
                }
            }
        }

        System.out.println(count);
        Collections.sort(vil);
        for (Integer integer : vil) {
            System.out.println(integer);
        }
//        System.out.println(System.currentTimeMillis()-l);
    }

    public static int dfs(int x1, int y1, int num) {
        int count = 1;
        queue.add(new location(x1, y1));

        while(!queue.isEmpty()){
            location pop = queue.pop();
            int x = pop.getX();
            int y = pop.getY();
            board[x][y] = num;

            for(int i=0; i<4; i++){
                int tempx = x + dx[i];
                int tempy = y + dy[i];
                if(tempx >= 0 && tempx < N && tempy >= 0 && tempy < N){
                    if(board[tempx][tempy] == 1){
                        count++;
                        board[tempx][tempy] = num;
                        queue.add(new location(tempx, tempy));
                    }
                }
            }

        }

        return count;
    }
}

class location{
    int x;
    int y;

    location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
