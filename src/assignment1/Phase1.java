package assignment1;
import java.io.*;
import java.util.*;

public class Phase1 {
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
    //Generate sorted Blocks
    public static List<List<Integer>> sortBlocks(ArrayList<Integer> readInput){
        System.out.println("Phase 1: ");
        System.out.println("-----------------");
        Scanner kb = new Scanner(System.in);
        int blockSize;
        System.out.println("Please enter block size : ");
        blockSize = kb.nextInt();
        kb.close();
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < readInput.size(); i += blockSize) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < i + blockSize && j < readInput.size(); j++) {
                list.add(readInput.get(j));
            }
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
            al.add(list);
        }
        return al;
    }
    public static void generateSubFiles(List<List<Integer>> Blocks){
        for (int i = 0; i < Blocks.size(); i++){
            try
            {
                String path = "./src/assignment1/subFile" + (i+1) + ".txt";

                File f = new File(path);
                BufferedWriter out = new BufferedWriter(new FileWriter(f,true));
                for(int each : Blocks.get(i))
                {
                    out.write(each +"\r\n");
                }
                out.close();
                System.out.println("SubList text file is created");
            }
            catch (IOException e)
            {
                System.out.println("Exception occurs");
            }
            System.out.println(i);
        }

    }
}
