import java.util.ArrayDeque;
import java.util.Deque;

public class Memento {
    public static void main(String[] args) {
        Caretaker caretaker=new Caretaker();
        Employee sravan=new Employee(605,"Sravan","9490328458","Intern");
        
        EmpSave savedcopy=sravan.saveToMemento();
        caretaker.addMemento(savedcopy);
        System.out.println("Initial Values:" + sravan);

        sravan.setEmpPhoneNo("9490328456");
        savedcopy=sravan.saveToMemento();
        caretaker.addMemento(savedcopy);
        System.out.println("Values after updation:" + sravan);

        savedcopy=caretaker.getMemento();
        sravan.undoFromMemento(savedcopy);
        savedcopy=caretaker.getMemento();
        sravan.undoFromMemento(savedcopy);
        System.out.println("Values after undo operation:" + sravan);
        
    }
}

class Employee{ //Originator
    private int empId;
    private String empName;
    private String empPhoneNo;
    private String empDesignation;
    public Employee(int empId, String empName, String empPhoneNo, String empDesignation) {
        this.empId = empId;
        this.empName = empName;
        this.empPhoneNo = empPhoneNo;
        this.empDesignation = empDesignation;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpPhoneNo() {
        return empPhoneNo;
    }
    public void setEmpPhoneNo(String empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }
    public String getEmpDesignation() {
        return empDesignation;
    }
    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public EmpSave saveToMemento() {
        EmpSave empSave=new EmpSave(this.empId, this.empName, this.empPhoneNo, this.empDesignation );
        return empSave;
    }
    public  void undoFromMemento(EmpSave memento)
    {
        this.empId = memento.getEmpId();
        this.empName = memento.getEmpName();
        this.empPhoneNo = memento.getEmpPhoneNo();
        this.empDesignation = memento.getEmpDesignation();
    }
    @Override
    public String toString() {
        return "Employee [empDesignation=" + empDesignation + ", empId=" + empId + ", empName=" + empName
                + ", empPhoneNo=" + empPhoneNo + "]";
    }
    
    
}

class EmpSave{
    private int empId;
    private String empName;
    private String empPhoneNo;
    private String empDesignation;
    public EmpSave(int empId, String empName, String empPhoneNo, String empDesignation) {
        this.empId = empId;
        this.empName = empName;
        this.empPhoneNo = empPhoneNo;
        this.empDesignation = empDesignation;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpPhoneNo() {
        return empPhoneNo;
    }
    public void setEmpPhoneNo(String empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }
    public String getEmpDesignation() {
        return empDesignation;
    }
    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }
    @Override
    public String toString() {
        return "EmpSave [empDesignation=" + empDesignation + ", empId=" + empId + ", empName=" + empName
                + ", empPhoneNo=" + empPhoneNo + "]";
    }
    
    
}

class Caretaker {
    private Deque<EmpSave> mementos = new ArrayDeque<>();
    public EmpSave getMemento()
    {
        EmpSave empSave= mementos.pop();
        return empSave;
    }
    public void addMemento(EmpSave memento)
    {
        mementos.push(memento);
    }
}