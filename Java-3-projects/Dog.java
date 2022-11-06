public class Dog extends Pet{
    private double droolRate;
    public static final double DEFAULT_DROOLRATE = 5.0;

    //constructors
    public Dog(String name, double health, int painLevel){
        this(name, health, painLevel, DEFAULT_DROOLRATE);
    }
    public Dog(String name, double health, int painLevel, double droolRate){
        super(name, health, painLevel);
        if(droolRate <= 0)
        this.droolRate = 0.5;
        else
        this.droolRate = droolRate;
    }
    //setters and getters
    public double getDroolRate(){
        return droolRate;
    }
    public void setDroolRate(double newDroolRate){
        droolRate = newDroolRate;
    }

    //methods
    public int treat(){
        int painLevel = getPainLevel();
        double health = getHealth();
        heal();
        if(droolRate < 3.5){
            return (int)((painLevel*2)/health);
        }
        else if(droolRate >= 3.5 && droolRate <= 7.5){
            return (int)(painLevel/health);
        }
        else{
            return (int)(painLevel/(health * 2)); 
        }
    }

    public void speak(){
        super.speak();
        String bark = "bark ";
        if(getPainLevel() > 5){
            for(int i = 0; i < getPainLevel(); i++){
                System.out.print(bark.toUpperCase());
            }
        }
        else{
            for(int i = 0; i < getPainLevel(); i++){
                System.out.print(bark);
            }
        }
        System.out.println("");
    }

    public boolean equals(Object o){
        
        if(o instanceof Dog){
            Dog dog = (Dog) o;
            return super.equals(o) && this.getDroolRate() == dog.getDroolRate();
        }
        return false;

    }
}
