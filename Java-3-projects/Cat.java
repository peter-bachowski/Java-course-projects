public class Cat extends Pet{
    private int miceCaught;
    public static final int DEFAULT_MICECAUGHT = 0;

    //constructors
    public Cat(String name, double health, int painLevel){
        this(name, health, painLevel, DEFAULT_MICECAUGHT);
    }
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        if(miceCaught < 0){
            miceCaught = 0;
        }
        else
        this.miceCaught = miceCaught;
    }

    //setters and getters
    public int getMiceCaught(){
        return miceCaught;
    }
    public void setMiceCaught(int newMiceCaught){
        miceCaught = newMiceCaught;
    }

    //methods
    public int treat(){
        int painLevel = getPainLevel();
        double health = getHealth();
        heal();
        if(miceCaught < 4){
            return (int)((painLevel*2)/health); 
        }
        else if(miceCaught >= 4 && miceCaught <= 7){
            return (int)(painLevel/health);
        }
        else{
            return (int)(painLevel/(health * 2)); 
        }
    }

    public void speak(){
        super.speak();
        String meow = "meow ";

        if(getPainLevel() > 5){
            for(int i = 0; i < getPainLevel(); i++){
                System.out.print(meow.toUpperCase());
            }
        }
        else{
            for(int i = 0; i < getPainLevel(); i++){
                System.out.print(meow);
            }
        }
        System.out.println("");
    }

    public boolean equals(Object o){
        
        if(o instanceof Cat){
            Cat cat = (Cat) o;
            return super.equals(o) && this.getMiceCaught() == cat.getMiceCaught();
        }
        return false;
    }
}

