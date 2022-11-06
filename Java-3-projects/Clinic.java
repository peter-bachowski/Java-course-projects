import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile;
    private int day;
    private String patientFileInfoString;  

    public String name;
    public String typeOfPet;
    public double initialHealth;
    public int initialPainLevel;

    //constructors
    public Clinic(String fileName){
        this(new File(fileName));
    }
    public Clinic(File patientFile){
        this.patientFile = patientFile;

        patientFileInfoString = "";

        try{
            Scanner fileScan = new Scanner(patientFile);
            while(fileScan.hasNextLine()){
                patientFileInfoString += fileScan.nextLine() + "\n";
            }
            fileScan.close();
        }
        catch(FileNotFoundException fnfe){
            File newPatientFile = new File("Patients.csv");
            patientFile = newPatientFile;
            
        }

        day = 1;
    }

    //methods
    public String nextDay(String fileName)throws FileNotFoundException{
        return nextDay(new File(fileName));
    }
    public String nextDay(File f)throws FileNotFoundException{
        Scanner fileScan = new Scanner(f);
        Scanner input = new Scanner(System.in);

        String list = "";
        
        while(fileScan.hasNextLine()){
            String line = fileScan.nextLine();
            String[] tokens = line.split(",");
            name = tokens[0];
            typeOfPet = tokens[1];

            String timeIn = tokens[3];
            int timeOut = 0;
            int treatmentTime = 0;
            boolean success = false;
            
            while(!success){
                System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", name, typeOfPet, timeIn, name);
                if(input.hasNextDouble()){
                    initialHealth = input.nextDouble();
                    System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                    if(input.hasNextInt()){
                        initialPainLevel = input.nextInt();
                        success = true;
                    }
                    else System.out.println("Invalid number. Please try again.");
                }
                else System.out.println("Invalid number. Please try again.");
                             
            }
            if(!typeOfPet.equals("Dog") && !typeOfPet.equals("Cat")){
                fileScan.close();
                input.close();
                throw new InvalidPetException();
            }
            else if(typeOfPet.equals("Dog")){
                double droolRate = Double.parseDouble(tokens[2]);
                Dog dog = new Dog(name, initialHealth, initialPainLevel, droolRate);
                dog.speak();
                treatmentTime = dog.treat();
                timeOut = addTime(timeIn, treatmentTime); 
            }
            else if(typeOfPet.equals("Cat")){
                int miceCaught = Integer.parseInt(tokens[2]);
                Cat cat = new Cat(name, initialHealth, initialPainLevel, miceCaught);
                cat.speak();
                treatmentTime = cat.treat();
                timeOut = addTime(timeIn, treatmentTime);
            }
            list += (name + "," + typeOfPet + "," + (String)tokens[2] + "," + "Day " + day + "," + timeIn + "," + timeOut + "," + initialHealth + "," + initialPainLevel + "\n");
        }

        fileScan.close();
        input.close();

        day++;

        return list;
    }

    private int addTime(String timeIn, int treatmentTime){
        int timeTotal = Integer.parseInt(timeIn) + treatmentTime;
        String timeTotalString = String.valueOf(timeTotal);
        String[] tokens = timeTotalString.split("");
        int thirdNumber = Integer.parseInt(tokens[2]);
        if(thirdNumber >= 6){
            timeTotal = timeTotal - 60 + 100; //subtracts the difference by how much the last two digits are over 60, then adds another 100 to move to the next hour
        }
        return timeTotal;
    }

    public boolean addToFile(String patientInfo){

        String[] patientInfoLines = patientFileInfoString.split("\\n");
        String[] appointment = patientInfo.split(",");

        String _name = appointment[0];
        String _day = appointment[3];
        String _timeIn = appointment[4];
        String _timeOut = appointment[5];
        String _initPain = appointment[6];
        String _initHealth = appointment[7];

        PrintWriter filePrint = null;

        try{
            filePrint = new PrintWriter(patientFile);

            for(String line : patientInfoLines){
                String newInfo = line + "," + "Day " + _day + "," + _timeIn + "," + _timeOut + "," + _initPain + "," + _initHealth + ",";
                if(line.contains(_name)){
                    patientFileInfoString += newInfo;
                    filePrint.println(newInfo);
                }
                else{
                    filePrint.println(line);   
                }
            }
            if(!patientFileInfoString.contains(_name)){
                filePrint.println(patientInfo);
                patientFileInfoString += patientInfo + "\n";
            }

        }
        catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
            return false;
        }
        finally{
            filePrint.close();
        }
        return true;
    }
}
