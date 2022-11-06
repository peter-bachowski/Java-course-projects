import java.io.PrintWriter;
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class Wolf extends Canine implements Comparable<Wolf>{
    protected int rank;

    public Wolf(double size, int rank){
        this.size = size;
        this.rank = rank;
    }
    public int getRank(){
        return rank;
    }
    public double getSize(){
        return size;
    }
    public void bark(){
        for(int i = 0; i < 3; i++){
            super.bark();
        }
    }
    public void groom(){};

    //overrides the pay method from the Groomable interface
    public void pay() {
        System.out.println("Grrrr! Warning, don’t try and chase me for payment. I'm a wolf. Run Run Run!");
    }

    public int compareTo(Wolf anotherWolf){
        return -(rank-anotherWolf.rank);
    }

    public static void selectionSort(Comparable[] list){
        int minIndex;
        Comparable nextSmallest;

        for(int unSortedStart = 0; unSortedStart < list.length-1; unSortedStart++){
            minIndex = unSortedStart;
            for(int currentIndex = unSortedStart+1; currentIndex < list.length; currentIndex++){
                if(list[currentIndex].compareTo(list[minIndex]) < 0){
                    minIndex = currentIndex;
                }
            }
            nextSmallest = list[minIndex];
            list[minIndex] = list[unSortedStart];
            list[unSortedStart] = nextSmallest;
        }
    } 

    public String toString(){
        return ("Rank: " + rank + ", Size: " + size);
    }

    public static void main(String[] args) {
        
        Wolf[] pack = {
            new Wolf(17.1, 2),
            new Wolf(3, 10),
            new Wolf(9.2, 7),
            new Wolf(9.1, 8),
            new Wolf(17.01, 3),
            new Wolf(16.2, 1),
            new Wolf(16, 4),
            new Wolf(16, 5),
            new Wolf(10, 6),
            new Wolf(5, 9)
        };

        Arrays.sort(pack);

    File fileOut = new File("SortedWolves.csv");
    PrintWriter filePrint = null;

    try {
        filePrint = new PrintWriter(fileOut);
        for (Wolf wolf : pack) {
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

        /*
        Canine canine1 = new Dog("Pumpkin", 10);
        canine1.fetch();

        long start = System.nanoTime();
        InsertionSort.insertionSort(pack); //you can change this to any code block to collect its runtime
        long end = System.nanoTime();
        System.out.println("Elapsed time in ns:" + (end - start));
        System.out.println("Sorted pack: " + Arrays.toString(pack));

        System.out.println("Unsorted pack: " + Arrays.toString(pack));
        selectionSort(pack);
        System.out.println("Sorted pack: " + Arrays.toString(pack));

        MergeAlgorithm.mergeSort(pack, 0, 9);
        System.out.println("Sorted pack: " + Arrays.toString(pack));

        long start = System.nanoTime();
        Arrays.sort(pack);
        long end = System.nanoTime();
        System.out.println("Elapsed time in ns:" + (end - start));
        System.out.println("Sorted pack: " + Arrays.toString(pack));
        */



    }

}
