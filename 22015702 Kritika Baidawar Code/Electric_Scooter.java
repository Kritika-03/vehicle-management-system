/**
 * The Electric_Scooter class is a child class of Vehicle class and has eight attributes: range, battery_capacity, price, charging_time,
 * brand, mileage, hasPurchased, hasSold.The variables are initialized in the constructor by calling the parent constructor and setter 
 * methods for vehicle_speed and vehicle_color. The battery_capacity is intitialized with parameter value and the other variables are set to
 * default.The accessor methods for each viariable is made and a setter method for brand variable. There is a parameterized method purchase 
 * with parameters brand, price, charging_time, mileage, range. It sets the variable value with the parameters if hasPurchased is false and sets hasPurchased
 * to true.There is a parameterized method sell with parameter price. If hasSold is false, the variable are set to default and hasSold is set to true.
 * Then a display method is created to call the display method of parent class and display the variables if hasPurchased is true.
 * 
 * @ Kritika Baidawar
 * 
 * 5/15/2022
 */

//declaring child class Electric_Scooter
public class Electric_Scooter extends Vehicle
{
    /* declaring attributes of Electric_Scooter class
     * All variables are kept private
     * These are instance variable (Scope reaches within class)
    */
    private int range;
    private int battery_capacity;
    private int price;
    private String charging_time;
    private String brand;
    private String mileage;
    private boolean hasPurchased;
    private boolean hasSold;
    
    /*Parameterized constructor for Vehicle class
     * Accepts vehicle id, vehicle name, vehicle color and vehicle weight
     * Accepts battery capacity
     * The parameters are formal parameters
    */
    public Electric_Scooter(int vehicle_id, String vehicle_name, String vehicle_color, String vehicle_weight, String vehicle_speed, int battery_capacity)
    {
        super(vehicle_id, vehicle_name,vehicle_color, vehicle_weight);  //calling parent class(vehicle) constructor
        super.setVehicle_Speed(vehicle_speed);  //calling parent class setter method for vehicle speed
        super.setVehicle_Color(vehicle_color);  //calling parent class setter method for vehicle color
        
        this.battery_capacity=battery_capacity;
        this.range=0;   //initializing integer variable to 0
        this.price=0;
        this.brand="";  //initializing string variable to null
        this.mileage="";
        this.charging_time="";
        this.hasPurchased=false; //initializing boolean variable to false
        this.hasSold=false;
    }
    
    //accessor of attributes of electric scooter class
    
    //getter of range attribute
    public int getRange()
    {
        return this.range;
    }
    
    //getter method for battery_capacity attribute
    public int getBattery_Capacity()
    {
        return this.battery_capacity;
    }
    
    //getter method for price attribute
    public int getPrice()
    {
        return this.price;
    }
    
    //getter method for charging_time attribute
    public String getCharging_Time()
    {
        return this.charging_time;
    }
    
    //getter method for brand attribute
    public String getBrand()
    {
        return this.brand;
    }
    
    //getter method for mileage attribute
    public String getMileage()
    {
        return this.mileage;
    }
    
    //getter method for hasPurchased attribute
    public boolean getHasPurchased()
    {
        return this.hasPurchased;
    }
    
    //getter method for hasSold attribute
    public boolean getHasSold()
    {
        return this.hasSold;
    }
    
    //setter for brand attribute
    public void setBrand(String brand)
    {
        /*using if...else condition
         * Checking if the electric scooter has been purchased or not
         */
        if(this.hasPurchased==false) 
        {
            this.brand=brand; //setting brand name with given value
        }
        else
        {
            System.out.println("This electric scooter has already been purchased, so the brand cannot be changed.");
        }
    }
    
    //Method to purchase an electric scooter
    public void purchase(String brand, int price, String charging_time,String mileage, int range)
    {
        /*using if...else condition
         * Checking if the electric scooter is purchased or not
         */
        if(this.hasPurchased==false)
        {
            this.setBrand(brand); // calling setter method of variable brand
            this.price=price;
            this.charging_time=charging_time;
            this.mileage=mileage;
            this.range=range;
            this.hasPurchased=true; //changing the status to purchased
        }
    }
    
    //Method to sell an electric scooter
    public void sell(int price)
    {
        /*using if...else condition
         * Checking if the electric scooter is sold or not
         */
        if(this.hasSold==false)
        {
            this.price=price;
            this.charging_time="";
            this.mileage="";
            this.battery_capacity=0;
            this.range=0;
            this.hasSold=true; //changing the status to sold
            this.hasPurchased=false;
        }
        else
        {
            System.out.println("This electric scooter has already been sold.");
        }
    }
    
    //method to display details of the electric scooter
    public void display()   //same method name as parent class(vehicle)
    {
        super.display();    //calling parent class display method
        
        /*using if condition
         * Checking if the electric scooter has been purchased
         */
        if(this.hasPurchased==true)
        {
            System.out.println("Brand: "+this.brand);
            System.out.println("Battery Capacity: "+this.battery_capacity);
            System.out.println("Mileage: "+this.mileage);
            System.out.println("Range: "+this.range);
            System.out.println("Recharge Time: "+this.charging_time);
        }
    }
}