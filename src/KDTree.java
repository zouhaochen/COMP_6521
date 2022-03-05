public class KDTree<k>
{
    public static int k = 2;

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

    public static Node findMin(Node root, int d){
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
                root.right = deleteNodeFunction(root.left, min.point, depth+1);
            }
            else
                {
                    root = null;
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

    public static void main(String[] args)
    {
        Node root = null;
        int dataSet[][] = new int[][]{{30, 40}, {5, 25}, {70, 70}, {10, 12}, {50, 30}, {35, 45}};

        //int n = dataSet.length / dataSet[0].length;
        int n = 6;

        for(int i =0; i<n; i++)
        {
            root = insert(root, dataSet[i]);
        }

        root = deleteNode(root, dataSet[0]);
        System.out.println(" after delete (30,40) : "+ root.point[0]+ root.point[1]);
    }


}

