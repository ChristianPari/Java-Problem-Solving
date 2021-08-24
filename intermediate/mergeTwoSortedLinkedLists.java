package intermediate;

import java.util.Scanner;

public class mergeTwoSortedLinkedLists {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      SinglyLinkedList list1 = new SinglyLinkedList();
      int list1Count = sc.nextInt();
      for (int i = 0; i < list1Count; i++) {
        int elm = sc.nextInt();
        list1.insertNode(elm);
      }

      SinglyLinkedList list2 = new SinglyLinkedList();
      int list2Count = sc.nextInt();
      for (int i = 0; i < list2Count; i++) {
        int elm = sc.nextInt();
        list2.insertNode(elm);
      }

      SinglyLinkedListNode list3 = SinglyLinkedList.mergeLists(list1.head, list2.head);
      SinglyLinkedList.printSinglyLinkedList(list3, " ");
    }

    sc.close();
  }
}

class SinglyLinkedListNode {
  public int data;
  public SinglyLinkedListNode next;

  public SinglyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
  }
}

class SinglyLinkedList {
  public SinglyLinkedListNode head;
  public SinglyLinkedListNode tail;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void insertNode(int nodeData) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
    }

    this.tail = node;
  }

  public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    // create and initialize a newHead to null
    SinglyLinkedListNode newHead = null;
    // check if head1 and head2 are null
    if (head1 == null && head2 == null)
      // return newHead
      return newHead;
    // if head2 equals null
    if (head2 == null)
      // return head1
      return head1;
    // if head1 equals null
    if (head1 == null)
      // return head2
      return head2;

    // compare head1.data and head2.data
    // the smallest node.data becomes the newHead
    // the smallest node becomes its node.next
    if (head1.data < head2.data) {
      newHead = head1;
      head1 = head1.next;
    } else {
      newHead = head2;
      head2 = head2.next;
    }

    // newHead.next = mergeLists(head1, head2)
    newHead.next = mergeLists(head1, head2);
    // return newHead
    return newHead;
  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
    while (node != null) {
      System.out.print(node.data);

      node = node.next;

      if (node != null) {
        System.out.print(sep);
      }
    }
  }
}
