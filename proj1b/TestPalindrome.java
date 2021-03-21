import org.junit.Test;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();


    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        org.junit.Assert.assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testMyPalindrome() {
        org.junit.Assert.assertFalse(palindrome.isPalindrome("cat"));
        org.junit.Assert.assertTrue(palindrome.isPalindrome(""));
        org.junit.Assert.assertTrue(palindrome.isPalindrome("bob"));
    }

    @Test
    public void testMyOBOPalindrome() {
        CharacterComparator obo = new OffByOne();
        org.junit.Assert.assertTrue(palindrome.isPalindrome("cad", obo));
        org.junit.Assert.assertTrue(palindrome.isPalindrome("flake", obo));
        org.junit.Assert.assertTrue(palindrome.isPalindrome("", obo));
        org.junit.Assert.assertFalse(palindrome.isPalindrome("bob", obo));
    }
}
