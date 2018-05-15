package humanResources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class Project {
    private String name;
    private EmployeeNode head;
    private EmployeeNode tail;
    private int listSize;

    private static final int DEFAULT_LIST_SIZE = 0;

    public Project(String name){
        this.name=name;
        head = new EmployeeNode();
        listSize = DEFAULT_LIST_SIZE;
    }

    public Project(String name, Employee[] employees){
        this.name=name;
        head = new EmployeeNode();
        listSize = DEFAULT_LIST_SIZE;
        EmployeeNode node= new EmployeeNode();
        head.nextEmployee=node;
        for(int i=0;i<employees.length;i++){
            node.nextEmployee = new EmployeeNode();
            node.employee=employees[i];
            node=node.nextEmployee;
            listSize++;
        }
        tail.nextEmployee=node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        EmployeeNode node= tail.nextEmployee;
        node.nextEmployee= new EmployeeNode();
        node=node.nextEmployee;
        tail.nextEmployee=node;
    }

    public Employee getEmployee(String name, String surname){
        EmployeeNode node;
        node=head.nextEmployee;
        for (int i=0;i<listSize;i++){
            if (node.employee.getSurname().equals(surname)&&node.employee.getName().equals(name)) return node.employee;
            node=node.nextEmployee;
        }
        return null;
    }

    public void removeEmployee(String name, String surname){
        EmployeeNode currentNode;
        EmployeeNode nextNode;
        currentNode=head.nextEmployee;
        for (int i=0;i<listSize;i++){
            nextNode=currentNode.nextEmployee;
            if (nextNode.employee.getSurname().equals(surname)&&nextNode.employee.getName().equals(name)){
                currentNode.nextEmployee=nextNode.nextEmployee;
                break;
            }
        }
    }

    public void removeEmployee(Employee employee){
        EmployeeNode currentNode;
        EmployeeNode nextNode;
        currentNode=head.nextEmployee;
        for (int i=0;i<listSize;i++){
            nextNode=currentNode.nextEmployee;
            if (nextNode.employee.equals(employee)){
                currentNode.nextEmployee=nextNode.nextEmployee;
                break;
            }
        }
    }

    public int getEmployeesCount(){
        return listSize;
    }

    public Employee[] getEmployees(){
        EmployeeNode node=head.nextEmployee;
        Employee[] employees = new Employee[listSize];
        for(int i=0;i<listSize;i++){
            employees[i]=node.employee;
            node=node.nextEmployee;
        }
        return employees;
    }

    private class EmployeeNode{
        private Employee employee;
        private EmployeeNode nextEmployee;

        public EmployeeNode(){
            employee=null;
            nextEmployee=null;
        }
    }
}
