package day4;

import java.util.Scanner;

public class Main {

    public static void main(String []args){
        long l = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        scan.close();

        long cal = cal(A, B, C);

        System.out.println(cal);
//        System.out.println(System.currentTimeMillis()-l);
    }

    public static long cal(int A, int B, int C) {
        long tmp = 0;

        if(B == 1)
            return A%C;
        if(B == 0)
            return 1;
        if(B%2 == 0) {
            tmp = cal(A,B/2,C);
            return (tmp * tmp) % C;
        }
        else{
            tmp = cal(A,(B-1)/2,C);
            long tmp2 = (tmp * tmp) % C;
            return (A * tmp2) % C;
        }
    }
}
