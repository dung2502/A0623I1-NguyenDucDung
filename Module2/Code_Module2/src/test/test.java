package test;

import java.util.Arrays;

public class test {
    class ac{
        public int a;
    }
    public static void main(String[] args) {
        int[] x = {5, 6, 7, 8};

        for(int a : x){

            if(a % 2 == 0){

                break;

            }

            System.out.print(a);

        }


    }
}
