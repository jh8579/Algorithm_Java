package day3;

import java.util.Scanner;

public class Main {

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();


        int min = 0;
        for(int i=0; i<1000000; i++){
            int sum = i;

            String parse = String.valueOf(i);
            for(int j=0; j<parse.length(); j++){
                sum += Character.getNumericValue((parse.charAt(j)));
            }

            if(sum == N){
                min = i;
                break;
            }
        }

        System.out.println(min);

    }
}
