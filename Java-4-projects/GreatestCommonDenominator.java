public class GreatestCommonDenominator {

    public static void main(String[] args) {
        System.out.println(denominator(6565, 819));
    }


    public static int denominator(int numerator, int denominator){
        if(denominator == 0){
            return numerator;
        }
        else {
            int remainder = numerator % denominator;
            return denominator(denominator, remainder);
        }

    }
}
