import java.util.Arrays;

public class MergeAlgorithm {

    public static void mergeSort(Comparable[] list, int start, int end) {
        if (start == end) {
            return;
        } else if (start == end-1) {
            if (list[start].compareTo(list[end]) <= 0) {
                return;
            } else { // swap
                Comparable temp = list[start];
                list[start] = list[end];
                list[end] = temp;
            }
        }
        
        int mid = (end-start)/2;
        mergeSort(list, start, start + mid);
        mergeSort(list, start + mid + 1, end);
        merge(list, start, start + mid, end);
    }
    private static void merge(Comparable[] list, int leftHalfStart, int rightHalfStart, int end) {
        int leftHalfSize = rightHalfStart - leftHalfStart + 1;
        int rightHalfSize = end - rightHalfStart;
    
        Comparable[] leftHalf = new Comparable[leftHalfSize];
        Comparable[] rightHalf = new Comparable[rightHalfSize];
    
        for (int i=0; i<leftHalfSize; ++i)
            leftHalf[i] = list[leftHalfStart + i];
        for (int j=0; j<rightHalfSize; ++j)
            rightHalf[j] = list[rightHalfStart + 1+ j];
    
        int i = 0;
        int j = 0;
    
        int k = leftHalfStart;
        while (i < leftHalfSize && j < rightHalfSize) {
            if (leftHalf[i].compareTo(rightHalf[j]) <= 0) {
                list[k] = leftHalf[i];
                i++;
            } else {
                list[k] = rightHalf[j];
                j++;
            }
            k++;
        }
    
        while (i < leftHalfSize) {
            list[k] = leftHalf[i];
            i++;
            k++;
        }
    
        while (j < rightHalfSize) {
            list[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        Comparable[] array1 = {1,6,21,84,351,2,3,8,484,3,8543,5};

        mergeSort(array1, 0, 11);
        System.out.println(Arrays.toString(array1));
    }
}
