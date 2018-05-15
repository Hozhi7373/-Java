package humanResources;

public final class BusinessTravel {
    private String city;
    private int daysCount;
    private float payment;
    private String description;

    public static final int DEFAULT_COUNT=0;

    public BusinessTravel(){
        this(null,DEFAULT_COUNT,DEFAULT_COUNT,null);
    }

    public BusinessTravel(String city, int daysCount, float payment, String description){
        this.city=city;
        this.daysCount=daysCount;
        this.payment=payment;
        this.description=description;
    }

    public String getCity() {
        return city;
    }

    public int getDaysCount(){
        return daysCount;
    }

    public float getPayment(){
        return payment;
    }

    public String getDescription(){
        return description;
    }
    //todo тоже что в employee
    public String toString(){
        String toString="";
        if (city!=null) toString+="<"+city+">";
        if (daysCount!=0) toString+="<"+daysCount+">";
        if (payment!=0) toString+="<"+payment+">.";
        if (description!=null) toString+="<"+description+">";

        return toString;
    }

    public boolean equals(Object object){
        return ((this.getCity()==((BusinessTravel)object).getCity())
                && (this.getDaysCount()==((BusinessTravel)object).getDaysCount())
                && (this.getDescription()==((BusinessTravel)object).getDescription()))
                && (this.getPayment()==((BusinessTravel)object).getPayment());
    }

    public int hashCode(){
        return city.hashCode()^daysCount^(int)payment^description.hashCode();
    }
}
