public class Craps {
    //private class members
    private Die die1, die2;
    private int point;

    //constructor
    public Craps(){
        die1 = new Die();
        die2 = new Die();
    }

    private int toss(){
        int total = die1.roll() + die2.roll();
        System.out.println("Die 1 roll: " + die1.getFaceValue());
        System.out.println("Die 2 roll: " + die2.getFaceValue());
        return total;
    }

    private void go(){
        point = toss();
        System.out.println("Points: " + point);
        if(point == 7 || point == 11){
            System.out.println("Winner!");
        }
        else if(point == 2 || point == 3 || point == 12){
            System.out.println("You lost!");
        }
        else{
            System.out.println("Entering stage 2!");
            stage2();
        }
    }

    private void stage2(){
        boolean endgame = false;

        while(!endgame){
            int total = toss();
            System.out.println("Total: " + total);
            if(total == point){
                System.out.println("Winner!");
                endgame = true;
            }
            else if(total == 7){
                System.out.println("You lost!");
                endgame = true;
            }
        }
    }

    public static void main(String[] args) {
        Craps game = new Craps();

        game.go();
    }
    
}
