public class GroomEverything {
    public static void main(String[] args) {
        Groomable[] groomer = {
                            new Wolf(17.01, 3) ,
                            new Poodle("richie", 9, "Lux brand", "Rich brand"),
                            new Wolf(5, 16),
                            new Poodle("Pixy", 4, "Top shelf", "Only the best"),
                            new Car("Yuhina", "Spark", 2037)
                };
        for( Groomable c : groomer){
            c.groom();
            c.pay();
        }

        System.out.println(Groomable.calculateTip(39.99, 20));
    }
    
}
