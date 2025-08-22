import src.main.java.domain.ListNode;

public class ConvertBinary1290 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        var decimalValue = new ConvertBinary1290().getDecimalValue(head);

        System.out.println(decimalValue + " _ " +head.val);
    }
}
