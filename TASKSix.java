public class TASKSix {
    public static void main(String[] args) {
        int count = 10;
        System.out.println("Generating the first " + count + " Fibonacci numbers iteratively...");
        // The main method will then be changed to:
         for (int i = 0; i < count; i++) {
             System.out.print(fibonacciRecursive(i) + " ");
         }
        System.out.println();
    }
    // TODO: Create a public static int fibonacciRecursive(int n) function here.
    public static int fibonacciRecursive(int n){
        if(n<=1)return 1;
        return fibonacciRecursive(n-2)+fibonacciRecursive(n-1);
    }

}
