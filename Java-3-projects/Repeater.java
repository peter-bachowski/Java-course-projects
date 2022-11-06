public class Repeater { //simple example of recursion i.e. a program calls itself to repeat an action
    public static void main(String[] args) {
        repeatString("I <3 Java.", 5);
    }

    public static void repeatString(String s, int times){ //need an int counter so the loop is not infinite and not cause a stack overflow error
        if(times <=0){
            return;
        }
        System.out.println(s);
        repeatString(s, times - 1);
    }
}
