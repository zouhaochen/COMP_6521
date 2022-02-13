package assignment1;

    // Java program to merge k sorted arrays of size n each
    public class MergeKSortedLists {

        /* Takes two lists sorted in increasing order, and merge
        their nodes together to make one big sorted list. Below
        function takes O(Log n) extra space for recursive calls,
        but it can be easily modified to work with same time and
        O(1) extra space */
        public static Node SortedMerge(Node a, Node b)
        {
            Node result = null;
            /* Base cases */
            if (a == null)
                return b;
            else if (b == null)
                return a;

            /* Pick either a or b, and recur */
            if (a.data <= b.data) {
                result = a;
                result.next = SortedMerge(a.next, b);
            }
            else {
                result = b;
                result.next = SortedMerge(a, b.next);
            }

            return result;
        }

        // The main function that takes an array of lists
        // arr[0..last] and generates the sorted output
        public static Node mergeKLists(Node arr[], int last)
        {
            // repeat until only one list is left
            while (last != 0) {
                int i = 0, j = last;

                // (i, j) forms a pair
                while (i < j) {
                    // merge List i with List j and store
                    // merged list in List i
                    arr[i] = SortedMerge(arr[i], arr[j]);

                    // consider next pair
                    i++;
                    j--;

                    // If all pairs are merged, update last
                    if (i >= j)
                        last = j;
                }
            }

            return arr[0];
        }

        /* Function to print nodes in a given linked list */
        public static void printList(Node node)
        {
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }


        public static Node[] arr(int BlockNum)
        {


            // an array of pointers storing the head nodes
            // of the linked lists
            Node arr[] = new Node[BlockNum];
            for(int i =0; i < BlockNum+1; i++){
                int BlockSize = 4;
                for(int j =0; j< BlockSize; j++)
                {
                    if(j == 0)
                    {
                        arr[i] = new Node(Phase2.sortList(BlockNum).get(i).get(j));
                    }
                    else
                    {
                        arr[i].next = new Node(Phase2.sortList(BlockNum).get(i).get(j));
                        arr[i] = arr[i].next;
                    }
                }
            // Merge all lists
            Node head = mergeKLists(arr, BlockNum - 1);
            printList(head);
        }
            return arr;
    }

    static class Node {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
        public static Node getNext(Node node){
            node = node.next;
            return node;
        }
    }
    }

