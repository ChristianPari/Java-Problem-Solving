package advanced;

/*
For the purposes of this challenge, we define a binary tree to be a binary search tree with the following ordering requirements:
 - The data value of every node in a node's left subtree is less than the data
    value of that node.
 - The data value of every node in a node's right subtree is greater than the data   value of that node.

Given the root node of a binary tree, can you determine if it's also a binary search tree?

Complete the function in your editor below, which has 1 parameter:
  a pointer to the root of a binary tree.
It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.
 */
// THE REST OF THIS CODE IS HIDDEN BY HACKERRANK, THIS IS MY INPUT FOR THE SOLUTION
public class is_this_a_binary_search_tree {
  class Node {
    int data;
    Node left;
    Node right;
  }

  boolean checkBST(Node root) {
    boolean passed = true;
    if (root != null) {
      if (root.left != null) {
        if (root.left.data < root.data)
          checkBST(root.left);
        else
          passed = false;
      }
      if (root.right != null) {
        if (root.right.data > root.data)
          checkBST(root.right);
        else
          passed = false;
      }
    }
    return passed;
  }
}
