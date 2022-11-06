public class Gameplay {
    
    public static void main(String[] args) {
        
        BlueAstronaut blue1 = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut blue2 = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut blue3 = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut blue4 = new BlueAstronaut("Angel", 0, 1, 0);
        //BlueAstronaut blue5 = new BlueAstronaut("Peter");

        RedAstronaut red1 = new RedAstronaut("Liam", 19, "Experienced");
        RedAstronaut red2 = new RedAstronaut("Suspicious Person", 100, "expert");
        //RedAstronaut red3 = new RedAstronaut("Billy");

        System.out.println(blue1.toString());
        red1.sabotage(blue1);
        System.out.println(blue1.toString());

        System.out.println(red2.toString());
        red1.freeze(red2);
        System.out.println(red2.toString());

        System.out.println(blue3.toString());
        red1.freeze(blue3);
        System.out.println(blue3.toString());

        blue3.emergencyMeeting();

        red2.emergencyMeeting();
        System.out.println(blue1.toString());
        System.out.println(blue2.toString());

        System.out.println(red2.toString());
        blue1.emergencyMeeting();
        System.out.println(red2.toString());

        System.out.println(blue2.toString());
        blue2.completeTask();
        System.out.println(blue2.toString());

        System.out.println(blue2.toString());
        blue2.completeTask();
        System.out.println(blue2.toString());

        System.out.println(blue2.toString());
        blue2.completeTask();
        System.out.println(blue2.toString());

        System.out.println(red1.toString());
        System.out.println(blue4.toString());
        red1.freeze(blue4);
        System.out.println(red1.toString());
        System.out.println(blue4.toString());

        System.out.println(blue1.toString());
        red1.sabotage(blue1);
        red1.sabotage(blue1);
        System.out.println(blue1.toString());

        red1.freeze(blue1);
        System.out.println(blue1.toString());

        System.out.println(red1.toString());
        blue4.emergencyMeeting();

        /*
        System.out.println(blue2.toString());
        red1.sabotage(blue2);
        red1.sabotage(blue2);
        red1.sabotage(blue2);
        red1.sabotage(blue2);
        red1.sabotage(blue2);
        System.out.println(blue2.toString());

        red1.freeze(blue2);
        */
    }
}
