//1 - oops
public class Car {
    private String company_name;
    private String model_name;
    private String model_year;
    private String model_mileage;

    public Car(String com,String mod,String year,String mil){
        this.company_name=com;
        this.model_name=mod;
        this.model_year=year;
        this.model_mileage=mil;
    }

    public void setCompany(String name){
        this.company_name=name;
    }

    public void setModel(String name){
        this.model_name=name;
    }
    public void setYear(String name){
        this.model_year=name;
    }
    public String getMileage(){
        return this.model_mileage;
    }
    public String getCompany(){
        return this.company_name;
    }

    public String getModel(){
        return this.model_name;
    }
    public String getYear(){
        return this.model_year;
    } 

    public static void main(String[] args){
        Car car1=new Car("Suzuki", "Alto", "2020", "24kmpl");
        Car car2=new Car("Kia","Sonet","2021","16kmpl");
        System.out.println("Car1 :"+car1.getCompany()+" of model "+car1.getModel()+" "+ car1.getYear() + " gives mileage of"+car1.getMileage());
        System.out.println("Car2 :"+car2.getCompany()+" of model "+car2.getModel()+" "+ car2.getYear() + " gives mileage of"+car2.getMileage());
        car2.setCompany("Hyundai");
        car2.setModel("Alcazar");
        car2.setYear("2023");
        System.out.println("After using setter");
         System.out.println("Car2 :"+car2.getCompany()+" of model "+car2.getModel()+" "+ car1.getYear() + "gives mileage of"+car1.getMileage());
    }
}

