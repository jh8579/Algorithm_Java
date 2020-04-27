package day1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day_1 {

    public static void main(String []args) {
        Deque<Integer> queue = new LinkedList<Integer>();

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();

        for(int i=1; i<=N; i++){
            queue.add((Integer) i);
        }

        while(queue.size() > 1){
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);
        }

        System.out.println(queue.poll());
    }
}
