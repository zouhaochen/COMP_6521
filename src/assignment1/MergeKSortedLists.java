package assignment1;

class Node
{
    int data;
    Node next;

    Node()
    {

    }
    // Utility function to create a new node.
    Node(int key)
    {
        data = key;
        next = null;
    }
}
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
            System.out.println("Fully sorted list : ");
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }


        public static void arr(int BlockNum)
        {


            // an array of pointers storing the head nodes
            // of the linked lists
            Node arr[] = new Node[BlockNum];
            for(int i = 0; i < arr.length; i++)
            {
                for(int j = Phase2.sortList(BlockNum).get(i).size() - 1 ; j >= 0; j--)
                {
                    arr[i] = push(arr[i], Phase2.sortList(BlockNum).get(i).get(j));
                }
            }
            // Merge all lists
            Node head = mergeKLists(arr, BlockNum - 1);
            printList(head);

    }

        public static assignment1.Node push(assignment1.Node head_ref, int new_data)
        {
            assignment1.Node new_node = new assignment1.Node();
            new_node.data = new_data;
            new_node.next = head_ref;
            head_ref = new_node;
            return head_ref;
        }
    }


