class Human{
    private int age = 11;
    private String name = "swana";

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public void setAge(int a){
        age=a;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Encapsulation
{
    public static void main(String args[]){
        Human obj = new Human();
        System.out.println("Name: " + obj.getName());
        System.out.println("Age: " + obj.getAge());
        // Setting new values
        System.out.println("\nSetting new values...");
        obj.setName("Alice");
        obj.setAge(25);

        System.out.println("Name: " + obj.getName());
        System.out.println("Age: " + obj.getAge());
    }
}