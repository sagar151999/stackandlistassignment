package day_23_assignment_stack_list;

import java.util.PriorityQueue;

public class merge_limk_list_in_one_list {

	public static class lnode {
        int val;
        lnode next;

        lnode(int val) {
            this.val = val;
        }
    }

    public lnode mergeKLists(lnode[] lists) {
        PriorityQueue<lnode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (lnode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        lnode no = new lnode(0);
        lnode prev = no;

        while (!minHeap.isEmpty()) {
            lnode current = minHeap.poll();
            prev.next = current;
            prev = current;

            if (current.next != null) {
                minHeap.add(current.next);
            }
        }

        return no.next;
    }

    public static void main(String[] args) {
    	merge_limk_list_in_one_list solution = new merge_limk_list_in_one_list();

       
        lnode list1 = new lnode(1);
        list1.next = new lnode(4);
        list1.next.next = new lnode(5);

        lnode list2 = new lnode(1);
        list2.next = new lnode(3);
        list2.next.next = new lnode(4);

        lnode list3 = new lnode(2);
        list3.next = new lnode(6);

        lnode[] listsToMerge = {list1, list2, list3};
        lnode mergedList = solution.mergeKLists(listsToMerge);

        
        System.out.println("Merged List:");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
