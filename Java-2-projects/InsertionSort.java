import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(Comparable [] list){
        for (int unSortedStart = 1; unSortedStart < list.length; unSortedStart++){
            Comparable nextInsert = list[unSortedStart];
            int currentIndex = unSortedStart -1;

            while(currentIndex >= 0 && (list[currentIndex].compareTo(nextInsert) > 0)){
                list[currentIndex + 1] = list[(int)currentIndex];
                currentIndex--;
            }

            list[currentIndex + 1] = nextInsert;

        }
    }

    public static void main(String[] args) {
        Integer[] bigArray1 = MakeReallyBigArray.makeReallyBigArray(100000);
        long start = System.nanoTime();
        InsertionSort.insertionSort(bigArray1);
        long end = System.nanoTime();
        System.out.println("Elapsed time in ns:" + (end - start));
        System.out.println(Arrays.toString(bigArray1));

    }
    
}
