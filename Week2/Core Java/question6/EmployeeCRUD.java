import java.util.*;

public class EmployeeCRUD{
    List<Employee>employees = new ArrayList<>();
    
    public void create(Employee employee){
        employees.add(employee);
    }

    public List<Employee>read(){
        return employees;
    }

    public void update(int id, String name, String department){
        for(Employee employee : employees){
            if(employee.getId() == id){
                employee.setName(name);
                employee.setDepartment(department);
                break;
            }
        }
    }

    public void delete(int id){
        employees.removeIf(employee -> employee.getId() == id);
    }

    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();
        // Create employees
        crud.create(new Employee(1, "Alice", "Merchant"));
        crud.create(new Employee(2, "Bob", "Sales"));
        crud.create(new Employee(3, "Charlie", "Marketing"));

        // Read employee
        System.out.println("Employees: ");
        for(Employee emp : crud.read()){
            System.out.println(emp);
        }

        // Update employee
        System.out.println("\nUpdating Employee with ID 2...");
        crud.update(2, "Bob Smith", "Finance");

        // Read employee
        System.out.println("Employees: ");
        for(Employee emp : crud.read()){
            System.out.println(emp);
        }

        // Delete employee
        System.out.println("\nDeleting Employee with ID 1...");
        crud.delete(1);
        System.out.println("Employees: ");
        for(Employee emp : crud.read()){
            System.out.println(emp);
        }
    }
}