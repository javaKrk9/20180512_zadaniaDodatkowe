package fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

//        System.out.println("Podaj który wyraz ciągu chcesz obliczyć: ");
//        Scanner sc = new Scanner(System.in);
//        int pos = sc.nextInt();

//        System.out.println(pos+" wyraz ciągu Fibonacciego to "+fibonacciCount(pos));
//        System.out.println();
        for(int i=1; i< 100; i++)
        {
            System.out.println(i+" wyraz ciągu Fibonacciego to "+fibonacciCount(i));
        }

    }

    private static int fibonacciCount(int pos)
    {
        if(pos==0)return 0;
        if(pos==1)return 1;
        int x1 =0;
        int x2 =1;

        for(int i = 2; i <= pos; i++)
        {
            if(i%2==1)
            {
                x1=x1+x2;
            }
            else
            {
                x2=x1+x2;
            }
        }
        return x1>x2?x1:x2;
    }

}
