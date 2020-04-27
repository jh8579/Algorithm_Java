package day2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class day_2 {

    public static void main(String []args) {
        Deque<Integer> queue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int temp = scan.nextInt();
            if(temp == 0) {
                queue.pop();
                continue;
            }
            queue.addFirst(temp);
        }
        scan.close();

        int sum = 0;

        while (!queue.isEmpty()){
            Integer pop = queue.pop();
            sum += pop;
        }

        System.out.println(sum);
    }
}
