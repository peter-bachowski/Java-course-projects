public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    //constructors
    public Pet(String name, double health, int painLevel){
        this.name = name;

        if(health >= 0 && health <= 1){
            this.health = health;
        }
        else if(health < 0){
            this.health = 0;
        }
        else{this.health = 1;}

        if(painLevel >= 1 && painLevel <= 10){
            this.painLevel = painLevel;
        }
        else if(painLevel < 1){
            this.painLevel = 1;
        }
        else{this.painLevel = 10;}
    }

    //setters and getters
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }
    public double getHealth(){
        return health;
    }
    public void setHealth(double newHealth){
        health = newHealth;
    }
    public int getPainLevel(){
        return painLevel;
    }
    public void setPainLevel(int newPainLevel){
        painLevel = newPainLevel;
    }

    //methods
    public abstract int treat();

    public void speak(){
        String hello = "Hello! my name is " + getName() + ".";
        if(painLevel > 5){
            System.out.println(hello.toUpperCase());
        }
        else{
            System.out.println(hello);
        }
    }

    public boolean equals(Object o){
        if(o instanceof Pet){
            Pet pet = (Pet) o;
            return this.name.equals(pet.getName());
        }
        return false;
    }

    protected void heal(){
        this.setHealth(1.0);
        this.setPainLevel(1);
    }


}
