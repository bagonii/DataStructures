import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class AssignmentNo2 {

    public static void main(String[] args) {

        String sentence1 = "Mom";
        String sentence2 = "Was it a car or a cat I saw?";
        String sentence3 = "Madam, in Eden, I`m Adam.";
        String sentence4 = "Yo, banana boy!";
        System.out.format("\n'%s' is a palindrome: " + stackMethod(sentence1) +
                "\n'%s' is a palindrome: " + stackMethod(sentence2) +
                "\n'%s' is a palindrome: " + stackMethod(sentence3) +
                "\n'%s' is a palindrome: " + stackMethod(sentence4), sentence1, sentence2, sentence3, sentence4);
        System.out.format("\n\n'%s' is a palindrome: " + arrayBlockingQueueMethod(sentence1) +
                "\n'%s' is a palindrome: " + arrayBlockingQueueMethod(sentence2) +
                "\n'%s' is a palindrome: " + arrayBlockingQueueMethod(sentence3) +
                "\n'%s' is a palindrome: " + arrayBlockingQueueMethod(sentence4), sentence1, sentence2, sentence3, sentence4);
        System.out.format("\n\n'%s' is a palindrome: " + arrayDequeMethod(sentence1) +
                "\n'%s' is a palindrome: " + arrayDequeMethod(sentence2) +
                "\n'%s' is a palindrome: " + arrayDequeMethod(sentence3) +
                "\n'%s' is a palindrome: " + arrayDequeMethod(sentence4), sentence1, sentence2, sentence3, sentence4);
    }

    public static boolean stackMethod(String sentence) {
        Stack stack = new Stack();
        String reverseSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
        for (int i = 0; i < reverseSentence.length(); i++) {
            stack.push(reverseSentence.charAt(i));
        }
        StringBuilder reverseString = new StringBuilder();
        while (!stack.isEmpty()) {
            reverseString.append(stack.pop());
        }
        return reverseSentence.equals(reverseString.toString());
    }

    public static boolean arrayBlockingQueueMethod(String sentence) {
        ArrayBlockingQueue<Character> abq = new ArrayBlockingQueue<>(sentence.length());
        String reverseSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
        for (int i = reverseSentence.length() - 1; i >= 0; i--) {
            abq.add(reverseSentence.charAt(i));
        }
        StringBuilder reverseString = new StringBuilder();
        while (!abq.isEmpty()) {
            reverseString.append(abq.remove());
        }
        return reverseSentence.equals(reverseString.toString());
    }

    public static boolean arrayDequeMethod(String sentence) {
        Deque<Character> de_que = new ArrayDeque<>(sentence.length());
        String reverseSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
        for (int i = reverseSentence.length() - 1; i >= 0; i--) {
            de_que.add(reverseSentence.charAt(i));
        }
        StringBuilder reverseString = new StringBuilder();
        while (!de_que.isEmpty()) {
            reverseString.append(de_que.remove());
        }
        return reverseSentence.equals(reverseString.toString());
    }
}












