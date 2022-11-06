public abstract class Canine implements Groomable {
    protected double size;

    public static final double initSize = 10;

    public Canine(){
        this(initSize);
    }    
    public Canine(double size){
        this.size = size;  
    }

    public void bark(){
        System.out.println("Woof woof");
    }

    public abstract void groom();

    public static void main(String[] args) {

    }
}
