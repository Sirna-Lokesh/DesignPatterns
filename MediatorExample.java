import java.util.ArrayList;
import java.util.List;

public class MediatorExample {
    public static void main(String[] args) {
        Mediator mediator=new ConcreteMediator();
        Employee sravan=new JuniorEmployee(mediator,"sravan");
        Employee raj=new SeniorEmployee(mediator, "Raj");
        Employee sai=new Unknown(mediator, "sai");

        mediator.register(sravan);
        mediator.register(raj);
        mediator.register(sai);

        sravan.sendMessage("Hi to everyone in the office");
        raj.sendMessage("Hi everyone");
        sai.sendMessage("who are you?");
    }
}

interface Mediator{
    public void register(Employee emp);
    public void sendMessage(Employee emp, String msg);
}

class ConcreteMediator implements Mediator{
    private List<Employee> empList=new ArrayList<>();
    @Override
    public void register(Employee emp) {
      empList.add(emp);
    }

    @Override
    public void sendMessage(Employee emp, String msg) {
         System.out.println(emp.name+" says : "+msg);
    }
    public void displayRegisteredEmployees(){
        System.out.println("Registered employees are: ");
        for(Employee e: empList){
            System.out.println(e.name);
        }
    }
    
}

abstract class Employee{
    Mediator mediator;
    public String name;
    public Employee(Mediator mediator){
        this.mediator=mediator;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void sendMessage(String msg){
        mediator.sendMessage(this, msg);
    }
    public abstract String employeeType();
    
}

class JuniorEmployee extends Employee{
    public JuniorEmployee(Mediator mediator, String name){
        super(mediator);
        this.name=name;
    }

    @Override
    public String employeeType() {
        return this.name;
    }
    
}

class SeniorEmployee extends Employee{
    public SeniorEmployee(Mediator mediator, String name){
        super(mediator);
        this.name=name;
    }

    @Override
    public String employeeType() {
        return this.name;
    }
    
}


class Unknown extends Employee{
    public Unknown(Mediator mediator, String name){
        super(mediator);
        this.name=name;
    }

    @Override
    public String employeeType() {
        return this.name;
    }
    
}


