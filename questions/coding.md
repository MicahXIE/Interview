## Coding Questions

- Leetcode 20 Valid Parentheses (Easy)
  
  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.


- Leetcode 160 Intersection of Two Linked Lists (Easy) fast-slow pointer
  
  Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
  If the two linked lists have no intersection at all, return null.
 

- LeetCode 141. Linked List Cycle （Easy) fast-slow pointer

  Given a linked list, determine if it has a cycle in it.

  To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.


- Leetcode 237 Delete Node in a Linked List

Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
     public void deleteNode(ListNode node) {
        if (node == null) return;
        ;
        if (node.next != null) {
            int nextValue = node.next.val;
            node.next = node.next.next;
            node.val = nextValue;
        }
    }
}


