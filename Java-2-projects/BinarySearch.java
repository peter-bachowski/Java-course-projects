public class BinarySearch {

    public static int search(Comparable[] list, Comparable target){
        int start = 0, end = list.length - 1, mid = 0;

        while(start <= 0){
            mid = (start + end) / 2;

            if(list[mid].compareTo(target) == 0){
                return mid;
            }
            else if(list[mid].compareTo(target) < 0){
                start = mid + 1;
            }
            else{
                start = mid - 1;
            }
        }

        return -1;
    }
    
}
