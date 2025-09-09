public class TASK3 {
    public static void main(String[] args) {
        int[] numbers = {45, 12, 89, 6, 23, 99, 20};
        int max = Integer.MIN_VALUE;
        System.out.println("Finding the maximum number with a loop...");
        // --- START OF BLOCK TO REPLACE ---
        max= findMaxRecursive(numbers,0);
        // --- END OF BLOCK TO REPLACE ---
        System.out.println("The maximum number is: " + max);
    }
    // TODO: Create a public static int findMaxRecursive(int[] nums, int index) function here.
    public static int findMaxRecursive(int[] nums, int index){
        if(index==nums.length-1) return nums[index];
        if(nums[index]>findMaxRecursive(nums,index+1)) return nums[index];
        return findMaxRecursive(nums,index+1);
    }
}
