package humanResources;

public class Organization {
    private String organisationTitle;
    private Department[] departments;

    public Organization(String title){
        organisationTitle=title;
    }

    public Organization(String title, Department[] departments){
        organisationTitle=title;
        this.departments = new Department[departments.length];
        System.arraycopy(departments,0, this.departments,0, departments.length);
    }

    public void addDepartment(Department department){
        int arraySize = departments.length;
        Department[] newDepartmentList = new Department[arraySize+1];
        System.arraycopy(departments,0,newDepartmentList,0,arraySize +1);
        newDepartmentList[arraySize]=department;
        departments = newDepartmentList;
    }

    public Department getDepartment(String name){
        Department departmentByName = null;
        for (int i = 0; i< departments.length; i++){
            if (name.equals(departments[i].getName())){
                departmentByName = departments[i];
                break;
            }
        }
        return departmentByName;
    }

    public Department[] getDepartments(){
        return departments;
    }

    public int getDepartmentCount(){
        return departments.length;
    }

    public int employeeCount(){
        int employeeCount=0;
        for (int i = 0; i< departments.length; i++) employeeCount+= departments[i].getEmployeeCount();
        return employeeCount;
    }

    public int employeesCountByPosition(String position){
        int employeeCountByPosition=0;
        for (int i = 0; i< departments.length; i++) employeeCountByPosition+= departments[i].countByPosition(position);
        return employeeCountByPosition;
    }

    public Employee highestSalaryEmployee(){
        Employee highestSalaryEmployee = departments[0].highestSalary();
        for (int i = 1; i< departments.length; i++) {
            if(highestSalaryEmployee.getSalary()<departments[i].highestSalary().getSalary()) highestSalaryEmployee=departments[i].highestSalary();
        }
        return highestSalaryEmployee;
    }

    public Department departmentByEmployee(String name, String surname){
        Department departmentByEmployee=null;
        for (int i=0;i<departments.length;i++){
            if(departments[i].hasEmployee(name,surname)) departmentByEmployee=departments[i];
        }
        return departmentByEmployee;
    }

}
