//this class practices using a cunstructor, as well as using public, private and static keywords 

public class Insect {
    //instance variables
    private double weight;
    private int x;
    private int y;

    //static constants and variables
    public static final int DEFAULT_WEIGHT = 0;
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final double DIST_WEIGHT_LOSS_FACTOR = 0.0001;
    private static int population = 0;

    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless.",
        "There are more than 1 million insect species.",
        "Insects are cold-blooded.",
        "Spiders are not considered insects."
    };

    //constructors
    public Insect() {
        this(DEFAULT_WEIGHT, DEFAULT_X, DEFAULT_Y);
    } 
    public Insect(double initWeight) {
        this(initWeight, DEFAULT_X, DEFAULT_Y);
    }
    public Insect(double weight, int x, int y) {
        this.weight = weight;
        this.x = x;
        this.y = y;
        population ++;
    }

    //getter and setter methods
    public double getWeight(){
        return weight;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        if (isLegalX(x)){
            this.x = x;
        }
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        if (isLegalY(y)){
            this.y = y;
        }
    }
    public int getPopulation(){
        return population;
    }


    public static boolean isLegalX(int newX){
        return (newX >= 0 ? true : false);
    }

    public static boolean isLegalY(int newY){
        return (newY >= 0 ? true : false);
    }

    //methods
    public void eat(double amount){
        System.out.println("Nibble Nibble");
        weight = weight + amount;
    }

    public void move(int newX, int newY){
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0){
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else {
            System.out.println("Staying put.");
        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt((y2 - y1) + (x2 - x1));
    }
    
    public static String getRandomFact() {
        int index = (int) (Math.random() * (FACTS.length - 1 +1));
        return FACTS[index];
    }

    public String toString(){
        return "weight: " + weight + ", x: " + x + ", y: " + y;
    }
    
    public static void main(String[] args) {
        System.out.println("Insect Population: " + population);
        Insect bug1 = new Insect(10, 100, 90);
        System.out.println("Insect Population: " + population);
        Insect bug2 = new Insect(9.5,-300, 400);
        System.out.println("Insect Population: " + population);

        bug1.move(1,10);
        bug2.move(-300,400);

        System.out.println(getRandomFact());
    }
}