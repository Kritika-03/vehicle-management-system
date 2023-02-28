/**
 * The Vehicle class is created with attributes vehicle_id,vehicle_name,vehicle_weight, vehicle_color and vehicle_speed.The variables are
 * initialized in the constructor except vehicle_speed with the parameter values. The accessor methods for each viariable is made and a 
 * setter method for vehicle_color and vehicle_speed. Then a display method is created to print  vehicle_id,vehicle_name,vehicle_weight, 
 * vehicle_color and vehicle_speed.
 * 
 * @ Kritika Baidawar
 * 
 * 5/15/2022
 */

//declaring a parent class Vehicle
public class Vehicle
{
    /* declaring attributes of Vehicle class
     * All variables are kept private
     * These are instance variable (Scope reaches within class)
    */
    private int vehicle_id;
    private String vehicle_name;
    private String vehicle_weight;
    private String vehicle_color;
    private String vehicle_speed;
    
    /*Parameterized constructor for Vehicle class
     * Accepts vehicle id, vehicle name, vehicle color and vehicle weight
     * The parameters are formal parameters
    */
    public Vehicle(int vehicle_id,String vehicle_name,String vehicle_color,String vehicle_weight)
    {
        this.vehicle_id=vehicle_id;     //setting value of the private variable vehicle_id with the given value
        this.vehicle_name=vehicle_name; //setting value of the private variable vehicle_name with the given value
        this.vehicle_color=vehicle_color;   //setting value of the private variable vehicle_color with the given value
        this.vehicle_weight=vehicle_weight; //setting value of the private variable vehicle_weight with the given value
    }
    
    //Accessor(Getter) methods for each attributes
    
    //getter method for vehicle_id attribute
    public int getVehicle_ID()
    {
        return this.vehicle_id;
    }
    
    //getter method for vehicle_name attribute
    public String getVehicle_Name()
    {
        return this.vehicle_name;
    }
    
    //getter method for vehicle_weight attribute
    public String getVehicle_Weight()
    {
        return this.vehicle_weight;
    }
    
    //getter method for vehicle_color attribute
    public String getVehicle_Color()
    {
        return this.vehicle_color;
    }
    
    //getter method for vehicle_speed attribute
    public String getVehicle_Speed()
    {
        return this.vehicle_speed;
    }
    
    //setter(mutator) method for vehicle_speed attribute
    public void setVehicle_Speed(String vehicle_speed)
    {
        this.vehicle_speed=vehicle_speed;
    }
    
    //setter(mutator) method for vehicle_color attribute
    public void setVehicle_Color(String vehicle_color)
    {
        this.vehicle_color=vehicle_color;
    }
    
    //method to display details of the vehicle
    public void display()
    {
       System.out.println("Vehicle ID: "+this.vehicle_id);
       System.out.println("Vehicle Name: "+this.vehicle_name);
       System.out.println("Vehicle Color: "+this.vehicle_color);
       System.out.println("Vehicle Speed: "+this.vehicle_speed);
       
        /*using if...else condition
         * Checking if the vehicle weight variable is null or not
         */
       if(this.vehicle_weight.length()==0)
       {
           System.out.println("Vehicle Weight: unknown (Empty!!!)");
       } //prints empty if the variable is empty
       else
       {
         System.out.println("Vehicle Weight: "+this.vehicle_weight);  
       }//otherwise prints the stored value
       
    }
    
}