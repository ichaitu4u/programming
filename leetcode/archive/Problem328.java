/**
 * URL:
 * 
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

public class Problem328 {
    
    public static void main(String[] args) {
        Problem328 obj = new Problem328();
        // Solution1 sol = new Solution1();
        Solution2 sol = new Solution2();

        System.out.println("\neven number of nodes");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        obj.printList(head);
        sol.oddEvenList(head);
        obj.printList(head);

        
        System.out.println("\nodd number of nodes");
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.printList(head);
        sol.oddEvenList(head);
        obj.printList(head);
        
        System.out.println("\nsingle node");
        head = new ListNode(1);
        obj.printList(head);
        sol.oddEvenList(head);
        obj.printList(head);
        
        
        System.out.println("\ntwo nodes");
        head.next = new ListNode(2);
        obj.printList(head);
        sol.oddEvenList(head);
        obj.printList(head);

        System.out.println("\nno nodes");
        head.next = null;
        obj.printList(head);
        sol.oddEvenList(head);
        obj.printList(head);
    }

    


    public void printList(ListNode head) {
        ListNode itr = head;

        while(itr != null){
            System.out.print(itr.val +" ");
            itr = itr.next;
        }
        System.out.println();
    }
}

class Solution1{
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode evenFirst = head.next;
        ListNode odd = head;
        ListNode even = evenFirst;

        while(true){
            if(even == null || even.next == null){
                odd.next = evenFirst;
                break;
            }

            odd.next = even.next;
            odd = odd.next;

            // no more even nodes
            if(odd.next == null){
                even.next = null;
                odd.next = evenFirst;
                break;
            }

            even.next = odd.next;
            even = even.next;
            
        }
        return head;
        
    }

}


class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode oddHead = head, evenHead = head.next;  
        ListNode lastOdd = null, odd = oddHead, even = evenHead;
        
        while(odd !=null && even != null){
            odd.next = even.next;
            odd = odd.next;
            
            if(even.next != null){
                even.next = even.next.next;    
            }
            
            even = even.next;
            if(odd != null){
                lastOdd = odd;
            }
        }
        
        
        lastOdd.next = evenHead;
        
        return oddHead;
        
    }

}
