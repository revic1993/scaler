package dsa.scaler.dynamicprogramming;

import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FibonacciSequence fs = new FibonacciSequence();
        System.out.println(fs.fib(n));
    }

    int fib(int n){
        if(n <= 1){
            return n;
        }
        int first = 0;
        int second = 1;
        int fib = 0;
        for(int i=2;i<=n;i++){
            fib = first+second;
            first = second;
            second = fib;
        }
        return fib;
    }
}
