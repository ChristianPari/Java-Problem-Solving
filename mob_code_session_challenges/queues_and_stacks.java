package mob_code_session_challenges;

import java.io.*;
import java.util.*;

public class queues_and_stacks {
  LinkedList<Character> stack = new LinkedList<>();
  LinkedList<Character> queue = new LinkedList<>();

  // stack methods
  private void pushCharacter(char ch) {
    stack.addFirst(ch);
  }

  private char popCharacter() {
    return stack.removeFirst();
  }

  // queue methods
  private void enqueueCharacter(char ch) {
    queue.addLast(ch);
  }

  private char dequeueCharacter() {
    return queue.removeFirst();
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    scan.close();

    // Convert input String to an array of characters:
    char[] s = input.toCharArray();

    // Create a Solution object:
    queues_and_stacks p = new queues_and_stacks();

    // Enqueue/Push all chars to their respective data structures:
    for (char c : s) {
      p.pushCharacter(c);
      p.enqueueCharacter(c);
    }

    // Pop/Dequeue the chars at the head of both data structures and compare them:
    boolean isPalindrome = true;
    for (int i = 0; i < s.length/2; i++) {
      if (p.popCharacter() != p.dequeueCharacter()) {
        isPalindrome = false;
        break;
      }
    }

    //Finally, print whether string s is palindrome or not.
    System.out.println( "The word, " + input + ", is "
      + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
  }
}

// MY CODE
/*
import java.io.*;
import java.util.*;

public class Solution {
    // Write your code here.
    private LinkedList<Character> queue;
    private Stack<Character> stack;

    public Solution () {
      queue = new LinkedList<>();
      stack = new Stack<>();
    }

    private void pushCharacter(char ch) {
      stack.add(ch);
    }

    private void enqueueCharacter(char ch) {
      queue.add(ch);
    }

    private char popCharacter() {
      return stack.pop();
    }

    private char dequeueCharacter() {
      return queue.pop();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
 */