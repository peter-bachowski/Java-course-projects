import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadSortedWolves {
    public static void main(String[] args) {
        File fileIn = new File("SortedWolves.csv");
        Scanner fileScan = null;
        Scanner wolfScan = null;
        double[] allWeights = new double[10];
        int index = 0;
        try {
            fileScan = new Scanner(fileIn);
            String line = null;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                wolfScan = new Scanner(line);
                wolfScan.useDelimiter(",");
                wolfScan.nextInt(); //consume unused rank token
                allWeights[index] = wolfScan.nextDouble();
                index++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }
}
