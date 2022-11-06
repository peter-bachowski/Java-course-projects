public class Dog extends Canine {
    protected String name;

    public Dog(String name, double size){
        super(size);
        this.name = name;
    }
    public void fetch(){
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return");
    }

    public void groom(){

    }

    public static void main(String[] args) {
        Dog kali = new Dog("Kali", 20.0);
        kali.bark();
        kali.fetch();
    }
}
