package three_alg_challenge;
/*
The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

    - root: a reference to the root of a binary tree.

 */

import java.util.*;
import java.io.*;

class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class height_of_a_binary_tree {

  public static int height(Node root) {
    int height = 0; // tracking height of all branches aka as it goes down a row this will increase
    int leftHeight = 0; // tracks branching lengths of left
    int rightHeight = 0; // tracks branching lengths of right

    // since doing "else if"s the height is only increased when an actual new row is reached
    if (root.left != null && root.right != null) { // both have Nodes then continue through both
      height += 1;
      leftHeight += height + height(root.left);
      rightHeight += height + height(root.right);

    } else if (root.left != null) { // reached a point where there is only the left branch
      height += 1;
      leftHeight += height + height(root.left);

    } else if (root.right != null) { // reached point where there is only the right branch
      height += 1;
      rightHeight += height + height(root.right);

    } else {
      return 0;
    }

    int max = Math.max(leftHeight, rightHeight);
    return max;
  }

  public static Node insert(Node root, int data) {
    if(root == null) {
      return new Node(data);
    } else {
      Node cur;
      if(data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    // MY TESTING
    Node root = null;
    int[] dataPoints = {3,5,2,1,4,6,7};
    for (int value : dataPoints) {
      int data = value;
      root = insert(root, data);
    }
    int height = height(root);
    System.out.println(height);

    // HACKERRANK CODE
//    Scanner scan = new Scanner(System.in);
//    int t = scan.nextInt();
//    Node root = null;
//    while(t-- > 0) {
//      int data = scan.nextInt();
//      root = insert(root, data);
//    }
//    scan.close();
//    int height = height(root);
//    System.out.println(height);
  }
}
