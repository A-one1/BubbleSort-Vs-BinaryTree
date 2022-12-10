import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TreeMain {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int[] numberArray = new int[1000];
        TreeBody tree = new TreeBody();

        tree.init();
        File file = new File("D://SELU//390//program 5//data.txt");
        Scanner input = new Scanner(file);
        int i = 0;

        while (input.hasNextLine()) {
            int number = input.nextInt();
            tree.makeTree(number);
            numberArray[i] = number;
            i++;

        }
        input.close();
        System.out.println("RECURSIVE");
        tree.sortedRecursive(tree.getRoot());
        System.out.println("NUMBER OP COMPARISON = " + tree.numberOfComparison());
        scanner.nextLine();


        System.out.println("ITERATIVE");
        tree.sortedIterative();
        scanner.nextLine();

        File output;
        output = new File("TREE.txt");
        FileWriter fileWriter = new FileWriter(output);
        tree.Recursive(tree.getRoot(), fileWriter);
        fileWriter.write("Number of comparsions = " + tree.numberOfComparison());
        fileWriter.close();

        System.out.println("BUBBLY BUBBLE");
        bubbleSort(numberArray);

        scanner.close();

    }

    public static void bubbleSort(int[] numberArray) {
        boolean swap = true;
        int i;
        int comparison = 0;

        while (swap) {
            swap = false;
            for (i = 1; i < numberArray.length; i++) {
                if (numberArray[i - 1] > numberArray[i]) {
                    swap = true;
                    int temp = numberArray[i];
                    numberArray[i] = numberArray[i-1];
                    numberArray[i-1] = temp;

                }
                comparison++;

            }
        }

        try {
            File outFile;
            outFile = new File("arrayOutput.txt");
            try (FileWriter fileWriter = new FileWriter(outFile)) {

                fileWriter.write("BUBBLE_SORT \n");
                for (i = 0; i < numberArray.length; i++) {
                fileWriter.write(numberArray[i] + "\n");
                System.out.println(numberArray[i]);
                }
                fileWriter.write("Number of comparisons = " + comparison);
                fileWriter.close();
            }
            } catch (Exception e) {
            System.out.println(e.getMessage());
            }
            System.out.println("Number of comparisons made during bubble sort : " + comparison);
            }

    }
     
