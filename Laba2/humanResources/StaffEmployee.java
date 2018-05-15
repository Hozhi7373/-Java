package humanResources;

public class StaffEmployee extends Employee implements BusinessTraveller {
    private float paymentSize;
    private TravelNode head;
    private TravelNode tail;
    private int listSize;

    public static final int DEFAULT_PAYMENT=0;
    public static final int DEFAULT_LIST_SIZE=0;

    public StaffEmployee(String name, String surname){
        this(name,surname,JobTitlesEnum.NONE,DEFAULT_SALARY,DEFAULT_PAYMENT);
    }

    public StaffEmployee(String name, String surname, JobTitlesEnum jobTitle, float salary, float paymentSize){
        super(name,surname,salary,jobTitle);
        this.paymentSize=DEFAULT_SALARY;
        head=null;
        tail=null;
        listSize=DEFAULT_LIST_SIZE;
    }

    public StaffEmployee(String name, String surname, JobTitlesEnum jobTitle, float salary, BusinessTravel[] travelsArray){
        super(name,surname,salary,jobTitle);
        this.paymentSize=DEFAULT_SALARY;
        listSize=DEFAULT_LIST_SIZE;
        TravelNode node= new TravelNode();
        head.nextTravel=node;
        for(int i=0;i<travelsArray.length;i++){
            node.nextTravel = new TravelNode();
            node.travel=travelsArray[i];
            node=node.nextTravel;
            listSize++;
        }
        tail.nextTravel=node;
        node.nextTravel=head;
    }

    public void setDescription(BusinessTravel businessTravel){
        paymentSize=businessTravel.getPayment();
    }

    public BusinessTravel[] getBusinessTravels(){
        TravelNode node=head.nextTravel;
        BusinessTravel[] businessTravels=new BusinessTravel[listSize];
        for(int i=0;i<listSize;i++){
            businessTravels[i]=node.travel;
            node=node.nextTravel;
        }
        return businessTravels;
    }

    public void setPremium(float paymentSize){
        this.paymentSize=paymentSize;
    }

    public float getPremium(){
        return paymentSize;
    }
    //todo то же что в employee - поправил
    public String toString(){
        StringBuilder toString = new StringBuilder();
        if (super.getSurname().equals(null)){
            toString.append("<");
            toString.append(super.getSurname());
            toString.append(">");
        }
        if (super.getName().equals(null)){
            toString.append("<");
            toString.append(super.getName());
            toString.append(">");
        }
        if (super.getJobTitle().equals(JobTitlesEnum.NONE)) {
            toString.append("<");
            toString.append(super.getJobTitle());
            toString.append(">,");
        }
        if (paymentSize!=0) {
            toString.append("<");
            toString.append(super.getSalary());
            toString.append(">p.");
            toString.append("<");
            toString.append(paymentSize);
            toString.append(">p.");
        } else if (super.getSalary()!=0) {
            toString.append("<");
            toString.append(super.getSalary());
            toString.append(">p.");
        }
        TravelNode node=head.nextTravel;
        for(int i=0;i<listSize;i++){
            toString.append("<");
            if (node.travel.getCity().equals(null)){
                toString.append("<");
                toString.append(node.travel.getCity());
                toString.append(">");
            }
            if (node.travel.getPayment()!=0){
                toString.append("<");
                toString.append(node.travel.getPayment());
                toString.append(">р.");
            }
            if (node.travel.getDescription().equals(null)) {
                toString.append("<");
                toString.append(node.travel.getDescription());
                toString.append(">,");
            }
            if (node.travel.getDaysCount()!=0) {
                toString.append("<");
                toString.append(node.travel.getDaysCount());
                toString.append(">");
            }
        }
        return toString.toString();
    }

    public boolean equals(Object object){
        if (object == this){
            return true;
        }
        if (object==null || object.getClass() != this.getClass()){
            return false;
        }
        StaffEmployee employee = (StaffEmployee)object;
        return ((super.getName().equals(employee.getName()))
                && (super.getSurname().equals(employee.getSurname()))
                && (super.getSalary()==employee.getSalary())
                && (super.getJobTitle().equals(employee.getJobTitle()))
                && (this.getPremium()==employee.getPremium()))
                && (this.getBusinessTravels().equals(employee.getBusinessTravels()));
    }

    public int hashCode(){
        return super.hashCode()^Float.hashCode(paymentSize);
    }

    private class TravelNode{
        private BusinessTravel travel;
        private TravelNode nextTravel;

        public TravelNode(){
            travel=null;
            nextTravel=null;
        }
    }
}
