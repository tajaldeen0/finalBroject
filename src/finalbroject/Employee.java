package finalbroject;

public class Employee extends User {

    public Employee(String ID, String name, String password, String status) {
        super(ID, name, password, status);
    }

    @Override
    public String getType() {
        return "Employee";
    }
}
