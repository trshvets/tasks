package palindrome;

public class PalindromeExaminator {
	/* Easiest way for implementation
	private static boolean isPalindrome(String str) {
		return str.equals(new StringBuffer(str).reverse().toString()) ? true : false;
	} */
	
	private static boolean isPalindrome(String str) {
		for (Integer i = 0; i != str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
	        System.out.println("Usage : java PalindromeExaminator string");
	        System.exit(1);
        }
		System.out.println("String " + args[0] + " is " +
				(isPalindrome(args[0]) ? "" : "NOT ") + "a palindrome");
	}
}
