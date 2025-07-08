public class Singleton{
    private static Singleton instance;
    // Private constructor to prevent instantiation
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return  instance;
    }

    public void message(){
        System.out.println("Singleton instance method called");
    }

    public static void main(String[] args){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        singleton1.message();
        // Check if both instances are the same
        if(singleton1 == singleton2){
            System.out.println("Both instances are the same.");
        } else {
            System.out.println("Instances are different.");
        }
        
    }
}