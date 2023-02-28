/**
 * The Auto_Rickshaw class is a child class of Vehicle class and has eight attributes: engine_displacement, torque, number_of_seats,
 * fuel_tank_capacity, ground_clearance, charge_amount, booked_date, isBooked.The variables are initialized in the constructor by calling 
 * the parent constructor and setter methods for vehicle_speed and vehicle_color. The engine_displacement, torque, fuel_capacity, ground_clearance
 * are intitialized with parameter value and isBokked is set to false.The accessor methods for each viariable is made and a 
 * setter method for charge_amount and number_of_seats. There is a parameterized method book with parameters booked_date, charge_amount,
 * number_of_seats. The method sets the booked_date, charge_amount and number_of_seats if isBokked is false.Then a display method is created
 * to call display method of parent class and display the variables if isBooked is true.
 * 
 * @ Kritika Baidawar
 * 
 * 5/15/2022
 */

//declaring a child class Auto_Rickshaw
public class Auto_Rickshaw extends Vehicle
{
    /* declaring attributes of Auto_Rickshaw class
     * All variables are kept private
     * These are instance variable (Scope reaches within class)
    */
    private int engine_displacement;
    private String torque;
    private int number_of_seats;
    private int fuel_tank_capacity; 
    private String ground_clearance; 
    private int charge_amount;
    private String booked_date;
    private boolean isBooked;
    
    /*Parameterized constructor for Vehicle class
     * Accepts vehicle id, vehicle name, vehicle color and vehicle weight
     * Accepts engine displacement, torque, tank fuel capacity and ground clearance
     * The parameters are formal parameters
    */
    
    public Auto_Rickshaw(int vehicle_id,String vehicle_name,String vehicle_color,String vehicle_weight,String vehicle_speed,int engine_displacement,String torque,int fuel_tank_capacity,String ground_clearance)
    {
        super(vehicle_id,vehicle_name,vehicle_color,vehicle_weight);    //calling parent class(vehicle) constructor
        super.setVehicle_Speed(vehicle_speed);   //calling parent class setter method for vehicle speed
        super.setVehicle_Color(vehicle_color);   //calling parent class setter method for vehicle color
        
        this.engine_displacement=engine_displacement; 
        this.torque=torque; 
        this.fuel_tank_capacity=fuel_tank_capacity;  
        this.ground_clearance=ground_clearance; 
        this.isBooked=false;     //setting value of the private variable isBooked to false
    }
    
    //accessor methods of Auto_Rickshaw class
    
    //getter of engine_displacement attribute
    public int getEngine_Displacement()
    {
        return this.engine_displacement;
    }
    
    //getter of torque attribute
    public String getTorque()
    {
        return this.torque;
    }
    
    //getter of number_of_seats attribute
    public int getNumber_of_Seats()
    {
        return this.number_of_seats;
    }
    
    //getter of fuel_tank_capacity attribute
    public int getFuel_Tank_Capacity()
    {
        return this.fuel_tank_capacity;
    }
    
    //getter of ground_clearance attribute
    public String getGround_Clearance()
    {
        return this.ground_clearance;
    }
    
    //getter of charge_amount attribute
    public int getCharge_Amount()
    {
        return this.charge_amount;
    }
    
    //getter of booked_date attribute
    public String getBooked_Date()
    {
        return this.booked_date;
    }
    
    //getter of isBooked attribute
    public boolean getIsBooked()
    {
        return this.isBooked;
    }
    
    //setter of charge_amount attribute
    public void setCharge_Amount(int charge_amount)
    {
        this.charge_amount=charge_amount;
    }
    
    //setter of number_of_seats attribute
    public void setNumber_of_Seats(int number_of_seats)
    {
        this.number_of_seats=number_of_seats;
    }
    
    //method to book an auto rickshaw
    public void book(String booked_date, int charge_amount, int number_of_seats)
    {
        /*using if...else condition
         * Checking if the auto rickshaw is booked or not
         */
        if(this.isBooked==false) // if the auto rickshaw is not booked
        {
            this.booked_date=booked_date; //the value of the variable booked_date is changed to the given value
            this.setCharge_Amount(charge_amount);//calling mutator method for variable charge_amount
            this.setNumber_of_Seats(number_of_seats);//calling mutator method for variable number_of_seats
            this.isBooked=true;  //status of auto rickshaw is changed to booked
            System.out.println("Vehilcle ID "+super.getVehicle_ID()+" has been booked on "+this.booked_date);
        }
        else
        {
            System.out.println("Vehicle is booked: "+this.isBooked); //Booked status of auto_rickshaw is displayed
            System.out.println("The auto rickshaw has already been booked");
        }
    }
    
    //method to display details of the Auto rickshaw
    public void display() //same method name as parent class(vehicle)
    {
        super.display(); //calling parent class display method
        
        /*using if condition
         * Checking if the auto rickshaw is booked
         */
        if(this.isBooked==true)
        {
            //'this' refers to the instance variables
            System.out.println("Engine Displacement: "+this.engine_displacement);
            System.out.println("Torque: "+this.torque);
            System.out.println("Fuel Tank Capacity: "+this.fuel_tank_capacity);
            System.out.println("Ground Clearance: "+this.ground_clearance);
            System.out.println("Booked Date: "+this.booked_date);
        
            /*using if...else condition
             * Checking if the charge amount is null
             */
            if(this.charge_amount==0)
                {
                    System.out.println("Charge Amount: unknown (Empty!!!)");
                }
            else //displaying charge amount if not null
                {
                    System.out.println("Charge Amount: "+this.charge_amount);
                }
        
            /*using if...else condition
             * Checking if the number of seats is null
             */
            if(this.number_of_seats==0)
                {
                    System.out.println("Number of Seats: unknown (Empty!!!)");
                }
                else //displaying the number of seats if not null
                {
                    System.out.println("Number of Seats: "+this.number_of_seats);
                }
        }
    }
}