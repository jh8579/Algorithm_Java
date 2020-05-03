package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int [] memo = new int [301];
    private static List<Integer> list;

    private static int N;

    public static void main(String []args){
        long l = System.currentTimeMillis();

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        int p = scan.nextInt();
        int c = scan.nextInt();
        int v = scan.nextInt();

        node node = new node(p, 0);
        node.setChild(c, v);

        for(int i=1; i<N-1; i++){
            int p1 = scan.nextInt();
            int c1 = scan.nextInt();
            int v1 = scan.nextInt();

            node temp;
            node.getNode(p1).setChild(c1, v1);
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            int value = node.getNode(i).getValue(i);

            if( value > max){
                max = value;
            }
        }

        System.out.println(max);

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
}

class node {
    int id;
    int value;
    List<node> child;

    node(int id, int value){
        this.id = id;
        this.value = value;
        child = new ArrayList<>();
    }

    public void setChild(int n, int v){
        node node = new node(n, v);
        child.add(node);
    }

    public node getNode(int n){
        if(id == n){
            return this;
        }else{
            if(child == null){
                return null;
            }else{
                for(int i=0; i<child.size(); i++){
                    node node = child.get(i).getNode(n);
                    if(node != null){
                        return node;
                    }
                }
                return null;
            }
        }
    }

    public int getValue(int t){
        if(id == t && child.size() > 0){
            List<Integer> l = new ArrayList<>();
            for(node node: child){
                l.add(node.getValue(t));
            }
            Collections.sort(l);
            return l.get(l.size()-1) + l.get(l.size()-2);
        }
        if(child.size() > 0) {
            int max = 0;
            for(node node: child){
                int value = node.getValue(t);
                if(value > max){
                    max = value;
                }
            }
            return max + this.value;
        }
        else {
            return this.value;
        }
    }
}
