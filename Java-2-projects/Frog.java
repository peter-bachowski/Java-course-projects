public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species;
    
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUESPEED = 5;
    private int flyCount = 0;
    private static final String DEFAULT_SPECIES = "Rare Pepe";

    //constructors
    public Frog(String initName){
        this(initName, DEFAULT_AGE, DEFAULT_TONGUESPEED);
    }
    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name, (int)(ageInYears * 12), tongueSpeed);
    }
    public Frog(String name, int age, double tongueSpeed){
        this.name = name;
        if(age > 0){
            this.age = age;
        }
        else{this.age = DEFAULT_AGE;}
        if(tongueSpeed >= 5){
            this.tongueSpeed = tongueSpeed;
        }
        else{this.tongueSpeed = DEFAULT_TONGUESPEED;}        
        species = DEFAULT_SPECIES;

        if(age < 7){
            isFroglet = true;
        }
        else{isFroglet = false;}
    }
    //getters and setters
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String newSpecies){
        species = newSpecies;
    }

    //methods
    public void grow(){
        age++;
        if(age < 7 && age > 1){
            isFroglet = true;
        }
        else {isFroglet = false;}

        if(age <= 12){
            tongueSpeed++;
        }
        else if(age >= 30){
            tongueSpeed--;
            if (tongueSpeed <= 5){
                tongueSpeed = 5;
            }   
        }
        else{tongueSpeed = 12;}
    }
    public void grow(int months){
        age += months;

        if(age < 7 && age > 1){
            isFroglet = true;
        }
        else {isFroglet = false;}

        if(age <= 12){
            for(int i = 0; i < 12-months; i++){
                tongueSpeed++;
            }
        }
        else if(age >= 30){
            for(int i = 0; i < age-30; i++){
                if(tongueSpeed <= 5){
                    tongueSpeed = 5;
                    break;
                }
                tongueSpeed--;
                
            }
        }
        else{tongueSpeed = 12;}
    }

    public void eat(Fly fly1){
        if(fly1.isDead()){
            return;
        }

        if(tongueSpeed > fly1.getSpeed()){
            flyCount++;
            if(fly1.getMass() >= 0.5*age){
                grow();
            }
            fly1.setMass(0);
        }
        else{
            fly1.grow(1);
        }
    }

    public String toString(){
        if (isFroglet){
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f. I have eaten %d flie(s).", name, age, tongueSpeed, flyCount);
        }
        else{
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f. I have eaten %d flie(s).", name, age, tongueSpeed, flyCount);
        }
    }
    public static void main(String[] args) {
        Frog frog1 = new Frog("Jeeters");
        System.out.println(frog1);
    }


}
