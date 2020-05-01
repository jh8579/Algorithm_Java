package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String []args){
        long l = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        scan.close();


        for(int i=1; i<=A; i++){
            list.add(i);
        }

        for(int i=0; i<list.size(); i++){
            cal(i, B-1, "");
        }

        System.out.println(System.currentTimeMillis()-l);
    }

    public static void cal(int lastIndex, int num, String result){

        Integer last = list.get(lastIndex);
        list.remove(lastIndex);
        result += last;
        result += " ";

        if(num == 0){
            System.out.print(result + "\n");
            list.add(lastIndex, last);
            return;
        }

        for(int i=0; i<list.size(); i++){
            cal(i, num-1, result);
        }
        list.add(lastIndex, last);
    }

}
