package assignment1;
import java.io.*;
import java.util.*;

public class Phase1
{

    //read input file and form an array
    public static ArrayList<Integer> input(){
        Scanner sc = null;
        ArrayList<Integer> readInput = new ArrayList<>();

        try {
            sc = new Scanner(new FileInputStream("./src/assignment1/input.txt"));
        }catch (FileNotFoundException e){
            System.out.println("Could not open input file");
            System.exit(0);
        }
        while (sc.hasNextLine()){
            String num = sc.nextLine();
            readInput.add(Integer.parseInt(num));
        }
        return readInput;

    }

    //Generate sorted Blocks using selection sort
    public static List<List<Integer>> sortBlocks(ArrayList<Integer> readInput){
        System.out.println("Phase 1: ");
        System.out.println("-----------------");
        Scanner kb = new Scanner(System.in);
        int blockSize;
        System.out.println("Please enter block size : ");
        blockSize = kb.nextInt();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < readInput.size(); i += blockSize) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < i + blockSize && j < readInput.size(); j++) {
                list.add(readInput.get(j));
            }
            System.out.println("Before sorting: " +list.toString());
            for (int k = 0; k < list.size(); k++) {
                // find position of smallest num between (i + 1)th element and last element
                int pos = k;
                for (int j = k; j < list.size(); j++) {
                    if (list.get(j) < list.get(pos))
                        pos = j;
                }
                // Swap min (smallest num) to current position on array
                int min = list.get(pos);
                list.set(pos, list.get(k));
                list.set(k, min);
            }
            System.out.println("After sorting: " +list.toString());
            System.out.println();
            al.add(list);
        }
        return al;
    }

    public static void generateSubFiles(List<List<Integer>> Blocks)
    {
        for (int i = 0; i < Blocks.size(); i++)
        {
            try
            {
                String path = "./src/assignment1/subfile/subFile" + (i+1) + ".txt";

                File f = new File(path);
                BufferedWriter out = new BufferedWriter(new FileWriter(f,true));
                for(int each : Blocks.get(i))
                {
                    out.write(each +"\r\n");
                }
                out.close();
            }
            catch (IOException e)
            {
                System.out.println("Exception occurs");
            }
        }
    }

    public static boolean delAllFile(String path)
    {
        boolean flag = false;

        File file = new File(path);

        if (!file.exists())
        {
            return flag;
        }

        if (!file.isDirectory())
        {
            return flag;
        }

        String[] tempList = file.list();

        File temp = null;

        for (int i = 0; i < tempList.length; i++)
        {
            if (path.endsWith(File.separator))
            {
                temp = new File(path + tempList[i]);
            }
            else { temp = new File(path + File.separator + tempList[i]); }

            if (temp.isFile())
            {
                temp.delete();
            }

            if (temp.isDirectory())
            {
                delAllFile(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }
}
