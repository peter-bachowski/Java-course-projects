import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{

    private int numTasks;
    private int taskSpeed;
    private boolean isDone;

    public static final int DEFAULT_SUSLEVEL = 15;
    public static final int DEFAULT_NUMTASKS = 6;
    public static final int DEFAULT_TASKSPEED = 10;
    
    //constructors
    public BlueAstronaut(String newName){
        this(newName, DEFAULT_SUSLEVEL, DEFAULT_NUMTASKS, DEFAULT_TASKSPEED);
    }
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    //setters and getters
    public int getNumTasks(){
        return numTasks;
    }
    public void setNumTasks(int newNumTasks){
        numTasks = newNumTasks;
    }
    public int getTaskSpeed(){
        return taskSpeed;
    }
    public void setTaskSpeed(int newTaskSpeed){
        taskSpeed = newTaskSpeed;
    }

    //overrides the Player class method emergencyMeeting()
    public void emergencyMeeting(){
        if (this.isFrozen()){
            return;
        }
        else{
            Player[] playerArray = getPlayers();
            Arrays.sort(playerArray);
            
            for(int index = playerArray.length - 1 ; index >= 0; index--){
                if(!playerArray[index].isFrozen()){
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

    public void completeTask(){
        
        if(this.isFrozen()){
            return;
        }

        if(taskSpeed > 20)
        numTasks -= 2;
        else
        numTasks--;

        if(numTasks <= 0){
            numTasks = 0;
            if(!isDone){
            System.out.println("I have completed all my tasks.");
            this.setSusLevel((int)(this.getSusLevel()*0.5));
            isDone = true;
            }
        }
    }
    
    //@overrides the equals method in the Player class
    public boolean equals(Object o){
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.numTasks == player.numTasks && this.taskSpeed == player.taskSpeed;
        }
        return false;
    } 

    //@overrides Player class toString method
    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        String statement = "My name is " + getName() + ", and I have a suslevel of " + getSusLevel() + "." +
                            " I am currently " + frozenString + ". I have " + numTasks + " left over.";

        if(getSusLevel() > 15){
            return statement.toUpperCase();
        }
        else{
            return statement;
        }
    }
}
