public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> newword = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            newword.addLast(word.charAt(i));
        }
        return newword;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> a = wordToDeque(word);

        return testIsPalindrome(a);
    }

    //A helper function for the former function
    private boolean testIsPalindrome(Deque a) {
        if (a.removeFirst() == a.removeLast()) {
            if (a.size() < 2) return true;
            testIsPalindrome(a);
        }
        return false;
    }

    //Overload
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque a = wordToDeque(word);
        return testIsPalindrome(a, cc);
    }

    private boolean testIsPalindrome(Deque a, CharacterComparator cc) {
        /*if (a.size() < 2) return true;
        else if (!cc.equalChars((char) a.removeFirst(), (char) a.removeLast())) {
            return false;

        } else return testIsPalindrome(a, cc);*/

        if (a.size() < 2) return true;
        if (cc.equalChars((char) a.removeFirst(), (char) a.removeLast())) {
            return testIsPalindrome(a, cc);
        }
        return false;
    }
}
