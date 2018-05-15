package humanResources;


public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, String surname){
        super(name,surname,DEFAULT_SALARY,JobTitlesEnum.NONE);
    }

    public PartTimeEmployee(String name,String surname, float salary, JobTitlesEnum jobTitle){
        super(name,surname,salary,jobTitle);
    }

    public float getPremium(){
        return 0;
    }

    public void setPremium(float premium){
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object object){
        if (object == this){
            return true;
        }
        if (object==null || object.getClass() != this.getClass()){
            return false;
        }
        Employee partTimeEmployee = (PartTimeEmployee)object;
        return ((this.getName().equals(partTimeEmployee.getName()))
                && (this.getSurname().equals(partTimeEmployee.getSurname()))
                && (this.getSalary()==partTimeEmployee.getSalary())
                && (this.getJobTitle().equals(partTimeEmployee.getJobTitle())));
    }

    public int hashCode(){
        return super.hashCode();
    }
}
