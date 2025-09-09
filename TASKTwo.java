public class TASKTwo {
    public static void main(String[] args) {
        String original = "Hello World";
        String reversed=reverseStringRecursive(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

    // TODO: Create a public static String reverseStringRecursive(String str) function here.
    public static String reverseStringRecursive(String str){
        if(str.isEmpty()) return "";
        return str.charAt(str.length()-1)+reverseStringRecursive(str.substring(0,str.length()-1));
    }
}
