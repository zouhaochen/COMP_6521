package assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Object;
import java.util.LinkedList;

public class Phase2 {
//  public static class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//      public static addNode()
//  }
    //Merge sorting for all sub lists
    public static  void sortList (int BlockNum){
        Scanner sc = null;
//        List<List<Integer>> readInput = new ArrayList<>();

        //read all subFiles
        for(int i = 0; i < BlockNum; i++){
//            List<Integer> subInput = new ArrayList<>();
            LinkedList<Integer> subInput = new LinkedList<>();
            try {
                sc = new Scanner(new FileInputStream("./src/assignment1/subFile" + (i+1) + ".txt"));
            }catch (FileNotFoundException e){
                System.out.println("Could not open input file");
                System.exit(0);
            }
            while (sc.hasNextLine()){
                String num = sc.nextLine();
                subInput.addLast(Integer.parseInt(num));
            }
//            readInput.add(subInput);
        }
//        for(int i = 0; i < readInput.size(); i +=2){
//            for (int index1 = 0, index2 = 0; index2 < readInput.get(i+1).size(); index1++) {
//                if (index1 == readInput.get(i).size() || readInput.get(i).get(index1) > readInput.get(i+1).get(index2)) {
//                    readInput.get(i).add(index1, readInput.get(i+1).get(index2++));
//                }
//            }
//        }
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            }
//            else if (l2 == null) {
//                return l1;
//            }
//            else if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            }
//            else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//
//        }



    }
}
