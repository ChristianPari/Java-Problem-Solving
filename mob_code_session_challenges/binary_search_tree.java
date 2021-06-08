package mob_code_session_challenges;

import java.util.*;
import java.io.*;

class Node{
  Node left,right;
  int data;
  Node(int data){
    this.data=data;
    left=right=null;
  }
}

public class binary_search_tree {

  public static int getHeight(Node root){
    // FIRST ATTEMPT, VERY VERBOSE
//    // if root.left and root.right are null
//    // return 0
//    if (root.left == null && root.right == null)
//      return 0;
//
//    // find the heights of left and right nodes
//    int leftHeight = 0;
//    int rightHeight = 0;
//
//    // if root.left is not null
//    if (root.left != null) {
//      // increase height by 1
//      leftHeight++;
//      // find height of root.left and add to leftHeight
//      leftHeight += getHeight(root.left);
//    } // else height of branch is 0
//
//    // if root.right is not null
//    if (root.right != null) {
//      // increase height by 1
//      rightHeight++;
//      // find height of root.right and add to rightHeight
//      rightHeight += getHeight(root.right);
//    } // else height of branch is 0
//
//    // compare the heights and return the largest value
//    return Math.max(leftHeight, rightHeight);

    // SECOND ATTEMPT, LESS VERBOSE AND EFFICIENT
    // if (root == null) {
    //   return -1;
    // } else {
    //   return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    // }

    // FINAL ATTEMPT, ONE LINER AND STRAIGHT FORWARD
    return root == null ? -1 : 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

  public static Node insert(Node root,int data){
    if(root==null){
      return new Node(data);
    }
    else{
      Node cur;
      if(data<=root.data){
        cur=insert(root.left,data);
        root.left=cur;
      }
      else{
        cur=insert(root.right,data);
        root.right=cur;
      }
      return root;
    }
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    Node root=null;
    while(T-->0){
      int data=sc.nextInt();
      root=insert(root,data);
    }
    int height=getHeight(root);
    System.out.println(height);
  }
}
