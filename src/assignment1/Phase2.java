package assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Object;
import java.util.LinkedList;

public class Phase2 {

    //Merge sorting for all sub lists
    public static List<List<Integer>>sortList (int BlockNum) {
        Scanner sc = null;
        List<List<Integer>> readInput = new ArrayList<>();

        //read all subFiles
        for (int i = 0; i < BlockNum; i++) {
            List<Integer> subInput = new ArrayList<>();
            try {
                sc = new Scanner(new FileInputStream("./src/assignment1/subfile/subFile" + (i + 1) + ".txt"));
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file");
                System.exit(0);
            }
            while (sc.hasNextLine()) {
                String num = sc.nextLine();
                subInput.add(Integer.parseInt(num));
            }
            readInput.add(subInput);
            System.out.println(subInput);
        }
        System.out.println(readInput);
        return readInput;

//    /* Method to print linked list */
//    void printList()
//    {
//        ListNode temp = head;
//        while (temp != null)
//        {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }

//        public static ListNode mergeKLists(ListNode[] lists) {
//            ListNode result = null; // no result yet
//
//            // merge lists one by one
//            for(int i = 0; i < lists.length; i++) {
//                ListNode list = lists[i];
//
//                // merge current list with the prevuous result
//                result = new Gfg().sortedMerge(result, list);
//            }
//
//            return result;
//        }

//    public static void main(String[] args){
//        MergeLists m1 = sortList(3).get(1);
//        MergeLists m2 = sortList(3).get(2);
//        m1.head = new Gfg().sortedMerge(m1.head,
//                m2.head);
//        m1.printList();
//    }
    }

//        static class Gfg
//        {
//            /* Takes two lists sorted in
//            increasing order, and splices
//            their nodes together to make
//            one big sorted list which is
//            returned. */
//            ListNode sortedMerge(ListNode headA, ListNode headB)
//            {
//
//    /* a dummy first node to
//       hang the result on */
//                ListNode dummyNode = new ListNode(0);
//
//    /* tail points to the
//    last result node */
//                ListNode tail = dummyNode;
//                while(true)
//                {
//
//        /* if either list runs out,
//        use the other list */
//                    if(headA == null)
//                    {
//                        tail.next = headB;
//                        break;
//                    }
//                    if(headB == null)
//                    {
//                        tail.next = headA;
//                        break;
//                    }
//
//        /* Compare the data of the two
//        lists whichever lists' data is
//        smaller, append it into tail and
//        advance the head to the next Node
//        */
//                    if(headA.val <= headB.val)
//                    {
//                        tail.next = headA;
//                        headA = headA.next;
//                    }
//                    else
//                    {
//                        tail.next = headB;
//                        headB = headB.next;
//                    }
//
//                    /* Advance the tail */
//                    tail = tail.next;
//                }
//                return dummyNode.next;
//            }
//        }



}
