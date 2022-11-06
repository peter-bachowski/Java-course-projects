import java.util.Arrays;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class WolfSort implements Comparable<WolfSort>{

    private int rank;
    private double size;

    public WolfSort(double size, int rank){
        this.size = size;
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }
    public double getSize(){
        return size;
    }

    public String toString(){
        return "Rank: " + rank + " Size: " + size;
    }
    public int compareTo(WolfSort anotherWolf){
        return -(rank - anotherWolf.rank);
    }

    public static void main(String[] args) {
        WolfSort[] pack = {
            new WolfSort(15.0, 5),
            new WolfSort(12.0, 3),
            new WolfSort(10.6, 4),
            new WolfSort(14.01, 1),
            new WolfSort(13.2, 2)
            };
        
            Arrays.sort(pack);

            File fileOut = new File("SortedWolves.csv");
            PrintWriter filePrint = null;
        
            try {
                filePrint = new PrintWriter(fileOut);
                for (WolfSort wolf : pack) {
                    filePrint.println(wolf.getRank() + "," + wolf.getSize());
                }
            } 
        
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        
        
            finally {
                if (filePrint != null) {
                    filePrint.close();
                }
            }
    }
    
}
