public class TASKEight {
    public static void main(String[] args) {
        int number = 12345;
        int sum = 0;
        System.out.println("Calculating the sum of digits for " + number + " with a loop...");
        sum=sumDigitsRecursive(number);
        System.out.println("The sum of the digits is: " + sum);
    }
    // TODO: Create a public static int sumDigitsRecursive(int number) function here.
    public static int sumDigitsRecursive(int number){
        if(number==0)return 0;
        return number%10+sumDigitsRecursive(number/10);
    }

}
