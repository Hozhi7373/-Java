package humanResources;

public class Department {
    private String name;
    private Employee[] employees;
    private int employeesCount;

    public static final int DEFAULT_EMPLOYEES_COUNT = 0;
    public static final int STARTING_ARRAY_COUNT = 8;

    public Department(String name, Employee[] newEmployees){
        this.name = name;
        this.employeesCount=newEmployees.length;
        employees=new Employee[employeesCount];
        System.arraycopy(newEmployees,0,employees,0,newEmployees.length);
    }

    public Department(String name){
        this(name,STARTING_ARRAY_COUNT, DEFAULT_EMPLOYEES_COUNT);
    }

    public Department(String name, int arraySize, int employeesCount){
        employees = new Employee[arraySize];
        this.name=name;
        this.employeesCount=employeesCount;
    }

    public String getName(){
        return name;
    }

    public void add(Employee employee) {
        if (employeesCount >= employees.length) {
            Employee[] newEmployees=new Employee[2*employees.length];
            System.arraycopy(employees,0,newEmployees,0,employees.length);
            employees = newEmployees;
        }
        employees[employeesCount] = employee;
        employeesCount++;
    }

    public int getEmployeeCount(){
        return employeesCount;
    }

    public boolean remove(String name, String surname){
        Employee[] newEmployees = new Employee[employees.length];
        boolean employeeDeleted = false;
        for (int i=0;i<this.employeesCount;i++){
            if (name.equals(employees[i].getName()) && (surname.equals(employees[i].getSurname()))) {
                System.arraycopy(employees,0,newEmployees,0,i);
                System.arraycopy(employees,i+1,newEmployees,i,newEmployees.length-i);
                employeeDeleted = true;
            }
        }
        employees=newEmployees;
        return employeeDeleted;
    }

    public Employee[] getEmployees() {
        Employee[] Employees = new Employee[employeesCount];
        System.arraycopy(employees,0,Employees,0,employeesCount);
        return Employees;
    }

    public Employee[] employeesByPosition(String position) {
        Employee[] employeesByPosition;
        employeesByPosition = new Employee[countByPosition(position)];
        int employeesCount=0;
        for (int i = 0; i< employeesByPosition.length; i++){
            if (position.equals(employees[i].getJobTitle())) {
                employeesByPosition[employeesCount] = employees[i];
                employeesCount++;
            }
        }
        return employeesByPosition;
    }

    public int countByPosition(String position) {
        int countByPosition=0;
        for (int i=0;i<employeesCount;i++){
            if (position.equals(employees[i].getJobTitle())) countByPosition++;
        }
        return countByPosition;
    }

    public Employee[] getSortedArray() {
        Employee[] sortedArray = getEmployees();
        Employee swapBuf;
        for (int i=0;i<employees.length;i++){
            for (int j=0;j<employees.length;j++){
                if(sortedArray[j].getSalary()< sortedArray[i].getSalary()){
                    swapBuf= sortedArray[i];
                    sortedArray[i]= sortedArray[j];
                    sortedArray[j]=swapBuf;
                }
            }
        }
        return sortedArray;
    }

    public Employee highestSalary(){
        Employee highestSalary  = employees[0];
        for (int i=1;i<employees.length;i++) if(employees[i].getSalary()>highestSalary.getSalary()) highestSalary=employees[i];
        return highestSalary;
    }

    public boolean hasEmployee(String name, String surname){
        for (int i=0;i<employeesCount;i++){
            if (name.equals(employees[i].getName()) && surname.equals(employees[i].getSurname())){
                return true;
            }
        }
        return false;
    }
}
