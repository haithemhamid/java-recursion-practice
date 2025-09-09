import java.util.Arrays;
import java.util.List;

public class TASKOne {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int totalSum=calculateSumRecursive( numbers, 0);
        System.out.println("--------------------------");
        System.out.println("The final sum is: " + totalSum);
    }
    public static int calculateSumRecursive(List<Integer> nums, int index){

    // TODO: Create a public static int calculateSumRecursive(List<Integer> nums, int index) function here.
        if(nums.size()==index) return 0;
        return nums.get(index)+calculateSumRecursive(nums,index+1);
}
}
