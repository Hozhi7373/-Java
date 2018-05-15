package humanResources;

public abstract class Employee {
    private String name;
    private String surname;
    private JobTitlesEnum jobTitle;
    private float salary;

    public static final int DEFAULT_SALARY=0;

    protected Employee(String name,String surname){
        this(name,surname,DEFAULT_SALARY,JobTitlesEnum.NONE);
    }

    protected Employee(String name,String surname, float salary, JobTitlesEnum jobTitle){
        this.name=name;
        this.surname=surname;
        this.jobTitle=jobTitle;
        this.salary=salary;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public JobTitlesEnum getJobTitle(){
        return jobTitle;
    }

    public float getSalary(){
        return salary;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setSurname(String surname){
        this.surname=surname;
    }

    public void setSalary(float salary){
        this.salary=salary;
    }

    public void setJobTitle(JobTitlesEnum jobTitle){
        this.jobTitle = jobTitle;
    }

    abstract void setPremium(float premium);

    abstract float getPremium();
    //todo стрингбилдер
    public String toString(){
        StringBuilder toString = new StringBuilder();
        if (surname.equals(null)){
            toString.append("<");
            toString.append(surname);
            toString.append(">");
        }
        if (name.equals(null)){
            toString.append("<");
            toString.append(name);
            toString.append(">");
        }
        if (jobTitle.equals(JobTitlesEnum.NONE)) {
            toString.append("<");
            toString.append(jobTitle);
            toString.append(">,");
        }
        if (salary!=0) {
            toString.append("<");
            toString.append(salary);
            toString.append(">p.");
        }
        return toString.toString();
    }

    //todo проверка типа, проверка на не null и только затем сравнивать поля - готово
    public boolean equals(Object object){
        if (object == this){
            return true;
        }
        if (object==null || object.getClass() != this.getClass()){
            return false;
        }
        Employee employee = (Employee)object;
        return ((this.getName().equals(employee.getName()))
                && (this.getSurname().equals(employee.getSurname()))
                && (this.getSalary()==employee.getSalary())
                && (this.getJobTitle().equals(employee.getJobTitle())));
    }

    public int hashCode(){
        return name.hashCode()^surname.hashCode()^jobTitle.hashCode()^Float.hashCode(salary);
    }
}
