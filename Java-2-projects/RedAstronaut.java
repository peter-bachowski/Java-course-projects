import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
    
    private String skill;

    public static final int DEFAULT_SUSLEVEL = 15;
    public static final String DEFAULT_SKILL = "Experienced";

    //constructors
    public RedAstronaut(String newName){
        this(newName, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
    }
    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        String skillToLowerCase = skill.toLowerCase();
        switch(skillToLowerCase){
            case "inexperienced":
            case "experienced":
            case "expert":
                this.skill = skill;
                break;
            default: 
                this.skill = DEFAULT_SKILL;
        }
    }

    //getters and setters

    public String getSkill(){
        return skill;
    }

    public void setSkill(String newSkill){
        skill = newSkill;
    }

    //methods
    public void freeze(Player p){
        if(this.isFrozen() || p.isFrozen() || p instanceof Impostor){
        return;
        }
        else{
            if(getSusLevel() < p.getSusLevel()){
                p.setFrozen(true);
            }
            else{
                setSusLevel(getSusLevel()*2);
            }
        }
        gameOver();
    }

    public void sabotage(Player p){     
        if( this.isFrozen() || p.isFrozen() || p instanceof Impostor){
            return;
        }
        else{
            if(this.getSusLevel() < 20){
                p.setSusLevel((int)(p.getSusLevel()*1.5));
            }
            else{
                p.setSusLevel((int)(p.getSusLevel()*1.25));
            }
        }
    }

    public void emergencyMeeting(){
        if (this.isFrozen()){
            return;
        }
        else{
            Player[] playerArray = getPlayers();
            Arrays.sort(playerArray);

            for(int index = playerArray.length - 1 ; index >= 0; index--){
                if(!playerArray[index].isFrozen() && this != playerArray[index]){
                    if(playerArray[index].compareTo(playerArray[index-1]) == 0)
                    return;
                    else{
                        playerArray[index].setFrozen(true);
                        break;
                    }
                }
            }
        }
        gameOver();
    }
    
    //@overrides the equals method in the Player class
    public boolean equals(Object o){
        if (o instanceof RedAstronaut) {
            RedAstronaut player = (RedAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel();
        }
        return false;
    }

    //@overrides Player class toString method
    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        String statement = "My name is " + this.getName() + ", and I have a suslevel of "
        + this.getSusLevel() + ". I am currently " + frozenString + ". I am an " + this.skill + " player!";

        if(getSusLevel() > 15){
            return statement.toUpperCase();
        }
        else{
            return statement;
        }
    }


}
