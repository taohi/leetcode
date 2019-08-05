/** add-two-numbers
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
* 
* Example:
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = new ListNode(0);
        ListNode p = p3;
        int flag = 0;
        
        while(null!= p1 && null !=p2){   
            int tmp = p1.val + p2.val + flag;
            p3.val = tmp % 10;
            flag = tmp / 10;
            
            p1 = p1.next;
            p2 = p2.next;
            if(null != p1 || null != p2){
                ListNode tmpNode = new ListNode(0);
                p3.next = tmpNode; 
                p3 = tmpNode;
            }
        }
        while(null != p1){       
            int tmp = flag + p1.val;
            p3.val = tmp % 10;
            flag = tmp / 10;
            
            p1 = p1.next;
            if(null != p1){
                ListNode tmpNode = new ListNode(0);
                p3.next = tmpNode;
                p3 = tmpNode;
            }
        }
        while(null != p2){           
            int tmp = flag + p2.val;
            p3.val = tmp % 10;
            flag = tmp / 10;
            
            p2 = p2.next;
            if(null != p2){
                ListNode tmpNode = new ListNode(0);
                p3.next = tmpNode;
                p3 = tmpNode;
            }
        }
        if(0 != flag){
            ListNode tmpNode = new ListNode(flag);
            p3.next = tmpNode;
        }
        
        return p;
    }
}

//recursive
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, null);
    }
    
    public ListNode add(ListNode n1, ListNode n2,ListNode preNode){
        int val1 = 0;
        int val2 = 0;
        ListNode next1 = null;
        ListNode next2 = null;
        if(n1 != null){
            val1 = n1.val;
            next1 = n1.next;
        }
        if(n2 != null){
            val2 = n2.val;
            next2 = n2.next;
        }
        ListNode curNode = new ListNode(val1 + val2);
        if(preNode != null){
            if(preNode.val >= 10 ){
                preNode.val %= 10;
                curNode.val += 1;
            }
        }
        
        if(next1 != null || next2 != null)
            curNode.next = add(next1, next2, curNode);
        else if(curNode.val >= 10)
            curNode.next = add(null, null, curNode);
        else
            curNode.next = null;
        return curNode;
    }
}