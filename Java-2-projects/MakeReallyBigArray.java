import java.util.Random;
import java.util.Arrays;

public class MakeReallyBigArray {

    public static Integer[] makeReallyBigArray(int largeNumber) {

        Integer[] numbers = new Integer[largeNumber];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(largeNumber);
        }

        return numbers;
    }

    public static void main(String[] args) {
        Integer[] bigArray1 = makeReallyBigArray(1000);
        Arrays.sort(bigArray1);
        //System.out.println(bigArray1.length);
        System.out.println(Arrays.toString(bigArray1));

    }

    
}
