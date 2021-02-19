package pckg.mylibrary;

public class Series {

    public static long nSum(int n){
         return ((long) n *(n+1))/2;
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }

    public static int fibonacci(int n){
        if(n ==0){
            return 0;
        }else if (n == 1){
            return 1;

        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
