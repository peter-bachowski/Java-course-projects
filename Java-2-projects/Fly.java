public class Fly {

    private double mass;
    private double speed;

    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    //constructors
    public Fly(){
        this(DEFAULT_MASS,DEFAULT_SPEED);
    }
    public Fly(double initMass){
        this(initMass, DEFAULT_SPEED);
    }
    public Fly(double mass, double speed){
        if(mass >= 0){
            this.mass = mass;
        }
        if(speed >= 0){
            this.speed = speed;
        }
    }

    //setters and getters

    public double getMass(){
        return mass;
    }
    public void setMass(double mass){
        if(isLegalMass(mass)){
            this.mass = mass;
        }
    }
    public double getSpeed(){
        return speed;
    }
    public void setSpeed(double speed){
        if(isLegalSpeed(speed)){
            this.speed = speed;
        }
    }
    
    public static boolean isLegalMass(double newMass){
        return (newMass >= 0 ? true : false);
    }

    public static boolean isLegalSpeed(double newSpeed){
        return (newSpeed >= 0 ? true : false);
    }

    public void grow(int addedMass){
        mass += addedMass;
        if(mass < 20){
            for(int i = 0; i < addedMass; i++){
                speed++;
            }
        }
        else if(mass >= 20){
            speed = 25;
            for (int i = 0; i < mass-20; i++){
                speed -= 0.5;
            }
        }
    }

    public String toString(){
        if(mass == 0){
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
        }
        else{
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
    }

    public boolean isDead(){
        return (mass == 0 ? true : false);
    }
/*
    public static void main(String[] args) {
        Fly fly1 = new Fly(Math.random()*DEFAULT_MASS, Math.random()*DEFAULT_SPEED);
        System.out.println(fly1.toString());
    }
*/
}
