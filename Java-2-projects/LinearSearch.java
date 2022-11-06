import java.util.Random;

public class LinearSearch {

    public static int linearSearch(Comparable target, Comparable[] list) {
        int index = 0;
        while (index < list.length) {
            if (list[index].compareTo(target) == 0)
                return index;
            else
                index++;
        }
        return -1;
    }

    public static Integer[] makeReallyBigArray(int largeNumber) {

        Integer[] numbers = new Integer[largeNumber];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(largeNumber);
        }

        return numbers;
    }

    public static void main(String[] args) {


        

        long start = System.nanoTime();
        MergeAlgorithm.mergeSort(makeReallyBigArray(1000000), 0, 999999);
        long end = System.nanoTime();
        System.out.println("Elapsed time in ns:" + (end - start));
        
    }
    
}
