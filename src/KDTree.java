public class KDTree<k>
{
    public static int k = 2;
    static final int COUNT = 10;

    public static class Node
    {
        int point[]= new int[k];
        Node left, right;
    }

    public static Node newNode(int arr[])
    {
        Node temp = new Node();

        for (int i = 0; i<k; i++)
        {
            temp.point[i] = arr[i];
        }

        temp.left = null;
        temp.right = null;
        return temp;
    }

    public static Node insertFunction(Node root, int point[], int depth)
    {
        if(root == null)
        {
            return newNode(point);
        }
        int currentD = depth % k;

        if(point[currentD] < root.point[currentD])
        {
            root.left = insertFunction(root.left, point, depth +1);
        }
        else
            {
                root.right = insertFunction(root.right, point,depth+1);
            }
        return root;
    }

    public static Node insert(Node root, int point[]){
        return insertFunction(root, point, 0);
    }

    public static Node minNode(Node x, Node y, Node z, int d)
    {
        Node temp = x;
        if(y != null && y.point[d] < temp.point[d])
        {
            temp = y;
        }
        if(z != null && z.point[d] < temp.point[d])
        {
            temp = z;
        }
        return temp;
    }

    public static Node findMinFunction(Node root, int d, int depth)
    {
        if(root == null)
        {
            return null;
        }

        int currentD = depth % k;

        if(currentD == d)
        {
            if(root.left == null)
            {
                return root;
            }
            return  findMinFunction(root.left, d, depth+1);
        }
        return minNode(root,
                findMinFunction(root.left, d, depth+1),
                findMinFunction(root.right, d, depth+1),d);
    }

    public static Node findMin(Node root, int d)
    {
        return findMinFunction(root, d, 0);
    }

    public static boolean arePointsSame(int point1[], int point2[])
    {
        for(int i = 0; i < k; i++)
        {
            if(point1[i]!= point2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void copyPoint(int p1[], int p2[])
    {
        for(int i = 0; i < k; i++)
        {
            p1[i] = p2[i];
        }
    }

    public static Node deleteNodeFunction(Node root, int point[], int depth)
    {
        if(root == null)
        {
            return null;
        }

        int currentD = depth % k;

        if(arePointsSame(root.point, point))
        {
            if(root.right != null)
            {
                Node min = findMin(root.right, currentD);
                copyPoint(root.point, min.point);
                root.right = deleteNodeFunction(root.right, min.point,depth+1);
            }
            else if(root.left != null)
            {
                Node min = findMin(root.left, currentD);
                copyPoint(root.point, min.point);
                root.left = deleteNodeFunction(root.left, min.point, depth+1);
            }
            else
                {
                    return null;
                }
            return root;
        }

        if(point[currentD] < root.point[currentD])
        {
            root.left = deleteNodeFunction(root.left, point, depth+1);
        }
        else
            {
                root.right = deleteNodeFunction(root.right, point, depth+1);
            }
        return root;
    }

    public static Node deleteNode(Node root, int point[]){
        return deleteNodeFunction(root, point, 0);
    }

    static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");

        System.out.print("{" + root.point[0] +", "+ root.point[1] +"}"+"\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public static void main(String[] args)
    {
        Node root = null;
        int dataSet[][] = new int[][]{{3, 6}, {17, 15}, {13, 15}, {6, 12}, {9, 1}, {2, 7},{10,19}};

        int n = dataSet.length;

        for(int i =0; i<n; i++)
        {
            root = insert(root, dataSet[i]);
        }
        print2D(root);
        System.out.println("----------------------------------------------");

        root = deleteNode(root, dataSet[1]);
        print2D(root);
    }


}

