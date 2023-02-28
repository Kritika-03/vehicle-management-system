
/**
 * The TransportGUI class creates a GUI in the constructor and uses the classes: Vehicle, Auto_Rickshaw, and Electric_Scooter.
 * The class implements the ActionListener interface and provides functions for the buttons in the GUI.
 * It overrides the actionPerformed method of the ActionListener interface.
 * The program also checks for exception and handles them.
 * The GUI will add Auto Rickshaw, and Electric Scooter, book AutoRickshaw, purchase Electric Scooter, sell Electric Scooter
 * and display the information of each vehicle, clear the forms in the GUI when required.
 * While event handling code is being carried out, the program checks for invalid inputs and displays suitable dialog boxes. 
 *
 * @author Kritika Baidawar
 * @version 08/02/2022
 */

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//creating the gui in the constructor
//implementing the actionlistener interface for event handling in the gui
public class TransportGUI implements ActionListener
{
    /*The GUI has three frames. All three framess follow a certain colour code that is declared and initialized. 
     * The main frame has a weclome message and three button options for opening Auto Rickshaw, Electric Scooter or closing the program.
     * The main frames contains JLabel for displaying the welcome messages and buttons to navigate to the next frame or exit.
     * The Auto Rickshaw frame has JPanel to separate the frame into navigation bar, Adding form, and Booking form.
     * The Electric Scooter frame has JPanel to separate the frame into navigation bar, adding form, purchasing form, and sell form.
     * The values are input using JTextFields, JComboBox, JButtons; and are stored in a single ArrayList. 
     */
    
    //declaring the components used in making the GUI
    public Color darkBlue,midBlue,lightBlue; //the custom colors used in the GUI
    public JFrame mainFrame, autoFrame, elecFrame;// the different frames that will display the menu, auto rickhaw and electric scooter forms
    public JPanel autoBar,autoAdd, autoBook,elecBar,elecAdd,elecPurchase,elecSell; //Panels used to seection the frames in the GUI
    public JLabel mainTitle,subTitle,autoTitle1,autoTitle2,a1,a2,a3,a4,a5,a6,a7,a8,a9,ab1,ab2,ab3,ab4,elecTitle1,elecTitle2,elecTitle3,ea1,ea2,ea3,ea4,ea5,ea6,ep1,ep2,ep3,ep4,ep5,ep6,es1,es2;
    /*Labels for displayed title and texts
     * a(no)- for JLabels indicating labels for textfields in add autorickshaw form
     * ab(no)- for JLabels indicating labels for textfields in book autorickshaw form
     * ea(no)-for JLabels indicating labels for textfields in add electric scooter form
     * ep(no)-for JLabels indicating labels for textfields in purchase electric scooter form
     * es(no)-for JLabels indicating labels for textfields in sell electric scooter form
     */
    public JButton mainBtn1,mainBtn2,mainBtn3,autoBackBtn,autoDisplayBtn,autoClearBtn,autoAddBtn,autoBookBtn,elecBackBtn,elecDisplayBtn,elecClearBtn,elecAddBtn,elecPurchaseBtn,elecSellBtn;
    public JTextField at1,at2,at3,at4,at5,at6,at7,at8,at9,abt1,abt2,abt3,eat1,eat2,eat3,eat4,eat5,eat6,ept1,ept2,ept3,ept4,ept5,ept6,est1,est2;
    /*Textfields for user input
     * at(no)- for JTextFields indicating textfields in add autorickshaw form
     * abt(no)- for JTextFields indicating textfields in book autorickshaw form
     * eat(no)-for JTextFields indicating textfields in add electric scooter form
     * ept(no)-for JTextFields indicating textfields in purchase electric scooter form
     * est(no)-for JTextfields indicating textfields in sell electric scooter form
     */
    public JComboBox <String> aday,amonth,ayear;
    
    public ArrayList <Vehicle> vehicleList=new ArrayList<Vehicle>();
    /*Creating the main frame that is displayed when the GUI is opened.
       It will have a title and buttons for the vehicles and exit.
       Clicking on the buttons will call the respective jframes and close the main frame.*/
       
    public TransportGUI()
    {
        darkBlue=new Color(0,55,72);
        midBlue=new Color(77,215,250);
        lightBlue=new Color(145,228,251);
        
        //The arrays needed to construct the date combobox
        String day[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String year[]={"2022","2023","2024","2025"};
        
        mainFrame=new JFrame("Transport Services");//initializing the main menu frame
        mainFrame.getContentPane().setBackground(darkBlue);//setting the backgrounds color of the main menu frame
        
        mainTitle=new JLabel("Welcome",JLabel.CENTER);//Initializing the main menu title at the center of the line
        mainTitle.setFont(new Font("SansSerif",Font.BOLD,48));//setting the font style of the main menu title
        mainTitle.setForeground(Color.WHITE);//setting font color
        mainTitle.setBounds(0,40,500,80);//setting the position and size of the label
        
        subTitle=new JLabel("Choose your transport service",JLabel.CENTER);//Initializing the main menu subtitle at the center of the line
        subTitle.setFont(new Font("SansSerif",Font.PLAIN,30));//setting the font style of the main menu title
        subTitle.setForeground(midBlue);//setting font color
        subTitle.setBounds(25,120,450,50);//setting the position and size of the label
        
        mainBtn1=new JButton("Auto Rickshaw");//Initializing the main menu button for displaying Auto Rickshaw 
        mainBtn1.setFont(new Font("SansSerif",Font.PLAIN,24));//setting the font style of the main menu button
        mainBtn1.setForeground(darkBlue);//setting font color
        mainBtn1.setBackground(lightBlue);//setting button color
        mainBtn1.setBounds(100,220,300,50);//setting the position and size of the main menu button
        
        mainBtn2=new JButton("Electric Scooter");//Initializing the main menu button for displaying Electric Scooter
        mainBtn2.setFont(new Font("SansSerif",Font.PLAIN,24));
        mainBtn2.setForeground(darkBlue);
        mainBtn2.setBackground(lightBlue);
        mainBtn2.setBounds(100,295,300,50);
        
        mainBtn3=new JButton("Exit");//Initializing the main menu button for exiting the program
        mainBtn3.setFont(new Font("SansSerif",Font.PLAIN,24));
        mainBtn3.setForeground(darkBlue);
        mainBtn3.setBackground(lightBlue);
        mainBtn3.setBounds(100,370,300,50);
        
        //adding the components created to the main menu frame
        mainFrame.add(mainTitle);
        mainFrame.add(subTitle);
        mainFrame.add(mainBtn1);
        mainFrame.add(mainBtn2);
        mainFrame.add(mainBtn3);
        
        //setting the size, layout and visibility of the mainmenu frame.
        mainFrame.setLayout(null);
        mainFrame.setSize(500,520);
        mainFrame.setVisible(true);
        //the program will close completely when the (x) is clicked
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //adding the actionlistener method to the buttons in the mainmenu frame
        mainBtn1.addActionListener(this);
        mainBtn2.addActionListener(this);
        mainBtn3.addActionListener(this);
        
        
        /* Creating the frame that is displayed when the AutoRickshaw button is clicked.
         *It will contain the form to add and book auto rickshaw separately with a menu to 
         *display, clear, or go back to main frame.
        */
        autoFrame=new JFrame("Auto Rickshaw");
        
        //creating the navigation bar(JPanel) of the auto rickshaw frame and setting its properties(position,size,bgcolor,layout)
        autoBar=new JPanel();
        autoBar.setBounds(0,0,150,500);
        autoBar.setBackground(Color.WHITE);
        autoBar.setLayout(null);
        
        //creating the add form(JPanel) of the auto rickshaw frame and setting its properties(position,size,bgcolor,layout)
        autoAdd=new JPanel();
        autoAdd.setBounds(150,0,350,500);
        autoAdd.setBackground(darkBlue);
        autoAdd.setLayout(null);
        
        //creating the book form(JPanel) of the auto rickshaw frame and setting its properties(position,size,bgcolor,layout)
        autoBook=new JPanel();
        autoBook.setBounds(500,0,350,500);
        autoBook.setBackground(midBlue);
        autoBook.setLayout(null);
        
        //creating the back button of the autoBar JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        autoBackBtn=new JButton("Back");
        autoBackBtn.setFont(new Font("SansSerif",Font.PLAIN,18));
        autoBackBtn.setForeground(darkBlue);
        autoBackBtn.setBackground(Color.WHITE);
        autoBackBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));//setting border to 1 px and white
        autoBackBtn.setBounds(0,0,150,50);
        
        //creating the display button of the autoBar JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        autoDisplayBtn=new JButton("Display");
        autoDisplayBtn.setFont(new Font("SansSerif",Font.PLAIN,18));
        autoDisplayBtn.setForeground(darkBlue);
        autoDisplayBtn.setBackground(Color.WHITE);
        autoDisplayBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        autoDisplayBtn.setBounds(0,350,150,50);
        
        //creating the clear button of the autoBar JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        autoClearBtn=new JButton("Clear");
        autoClearBtn.setFont(new Font("SansSerif",Font.PLAIN,18));
        autoClearBtn.setForeground(darkBlue);
        autoClearBtn.setBackground(Color.WHITE);
        autoClearBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        autoClearBtn.setBounds(0,400,150,50);
        
        //creating the add button of the autoAdd JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        autoAddBtn=new JButton("Add");
        autoAddBtn.setFont(new Font("SansSerif",Font.PLAIN,24));
        autoAddBtn.setForeground(Color.WHITE);
        autoAddBtn.setBackground(darkBlue);
        autoAddBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        autoAddBtn.setBounds(103,400,150,50);
        
        //creating the book button of the autoBook JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        autoBookBtn=new JButton("Book");
        autoBookBtn.setFont(new Font("SansSerif",Font.PLAIN,24));
        autoBookBtn.setForeground(darkBlue);
        autoBookBtn.setBackground(midBlue);
        autoBookBtn.setBorder(BorderFactory.createLineBorder(darkBlue,1));
        autoBookBtn.setBounds(115,400,150,50);
        
        //Title for the Add form in Auto Rickshaw
        autoTitle1=new JLabel("Add Auto Rickshaw",JLabel.CENTER);
        autoTitle1.setFont(new Font("SansSerif",Font.BOLD,24));
        autoTitle1.setForeground(Color.WHITE);
        autoTitle1.setBounds(0,0,350,50);
        
        //Title for the Book form in Auto Rickshaw
        autoTitle2=new JLabel("Book Auto Rickshaw",JLabel.CENTER);
        autoTitle2.setFont(new Font("SansSerif",Font.BOLD,24));
        autoTitle2.setForeground(darkBlue);
        autoTitle2.setBounds(0,0,350,50);
        
        //Creating JLabels for the textfields in auto rickshaw add form and setting the font,colors,position and size
        //Vehicle ID Label
        a1=new JLabel("Vehicle ID");
        a1.setFont(new Font("SansSerif",Font.PLAIN,14));
        a1.setForeground(Color.WHITE);
        a1.setBounds(28,80,135,25);
        
        //Vehicle Name Label
        a2=new JLabel("Vehicle Name");
        a2.setFont(new Font("SansSerif",Font.PLAIN,14));
        a2.setForeground(Color.WHITE);
        a2.setBounds(28,110,135,25);
        
        //Vehicle Weight Label
        a3=new JLabel("Vehicle Weight");
        a3.setFont(new Font("SansSerif",Font.PLAIN,14));
        a3.setForeground(Color.WHITE);
        a3.setBounds(28,140,135,25);
        
        //Vehicle Color Label
        a4=new JLabel("Vehicle Color");
        a4.setFont(new Font("SansSerif",Font.PLAIN,14));
        a4.setForeground(Color.WHITE);
        a4.setBounds(28,170,135,25);
        
        //Vehicle Speed Label
        a5=new JLabel("Vehicle Speed");
        a5.setFont(new Font("SansSerif",Font.PLAIN,14));
        a5.setForeground(Color.WHITE);
        a5.setBounds(28,200,135,25);
        
        //Engine Displacement Label
        a6=new JLabel("Engine Displacement");
        a6.setFont(new Font("SansSerif",Font.PLAIN,14));
        a6.setForeground(Color.WHITE);
        a6.setBounds(28,230,135,25);
        
        //Torque Label
        a7=new JLabel("Torque");
        a7.setFont(new Font("SansSerif",Font.PLAIN,14));
        a7.setForeground(Color.WHITE);
        a7.setBounds(28,260,135,25);
        
        //Fuel Tank Capacity Label
        a8=new JLabel("Fuel Tank Capacity");
        a8.setFont(new Font("SansSerif",Font.PLAIN,14));
        a8.setForeground(Color.WHITE);
        a8.setBounds(28,290,135,25);
        
        //Ground Clearance Label
        a9=new JLabel("Ground Clearance");
        a9.setFont(new Font("SansSerif",Font.PLAIN,14));
        a9.setForeground(Color.WHITE);
        a9.setBounds(28,320,135,25);
        
        //Creating JTextfields entering information in auto rickshaw add form and setting the font,position and size
        //Vehicle ID JTextField
        at1=new JTextField();
        at1.setFont(new Font("SansSerif",Font.PLAIN,14));
        at1.setBounds(173,80,150,25);
        
        //Vehicle Name JTextField
        at2=new JTextField();
        at2.setFont(new Font("SansSerif",Font.PLAIN,14));
        at2.setBounds(173,110,150,25);
        
        //Vehicle Weight JTextField
        at3=new JTextField();
        at3.setFont(new Font("SansSerif",Font.PLAIN,14));
        at3.setBounds(173,140,150,25);
        
        //Vehicle Color JTextField
        at4=new JTextField();
        at4.setFont(new Font("SansSerif",Font.PLAIN,14));
        at4.setBounds(173,170,150,25);
        
        //Vehicle Speed JTextField
        at5=new JTextField();
        at5.setFont(new Font("SansSerif",Font.PLAIN,14));
        at5.setBounds(173,200,150,25);
        
        //Engine Displacement JTextField
        at6=new JTextField();
        at6.setFont(new Font("SansSerif",Font.PLAIN,14));
        at6.setBounds(173,230,150,25);
        
        //Torque JTextField
        at7=new JTextField();
        at7.setFont(new Font("SansSerif",Font.PLAIN,14));
        at7.setBounds(173,260,150,25);
    
        //Fuel Tank Capacity JTextField
        at8=new JTextField();
        at8.setFont(new Font("SansSerif",Font.PLAIN,14));
        at8.setBounds(173,290,150,25);
        
        //Ground Clearance JTextField
        at9=new JTextField();
        at9.setFont(new Font("SansSerif",Font.PLAIN,14));
        at9.setBounds(173,320,150,25);
        
        //Creating JLabels for the textfields in auto rickshaw book form and setting the font,colors,position and size
        //Vehicle ID Label
        ab1=new JLabel("Vehicle ID");
        ab1.setFont(new Font("SansSerif",Font.PLAIN,14));
        ab1.setForeground(darkBlue);
        ab1.setBounds(28,80,135,25);
        
        //Charged Amount Label
        ab2=new JLabel("Charged Amount");
        ab2.setFont(new Font("SansSerif",Font.PLAIN,14));
        ab2.setForeground(darkBlue);
        ab2.setBounds(28,110,135,25);
        
        //Number of Seats Label
        ab3=new JLabel("Number of Seats");
        ab3.setFont(new Font("SansSerif",Font.PLAIN,14));
        ab3.setForeground(darkBlue);
        ab3.setBounds(28,140,135,25);
        
        //Booked Date Label
        ab4=new JLabel("Booked Date");
        ab4.setFont(new Font("SansSerif",Font.PLAIN,14));
        ab4.setForeground(darkBlue);
        ab4.setBounds(28,170,135,25);
        
        //Creating JTextfields entering information in auto rickshaw book form and setting the font,position and size
        //Vehicle ID JTextField
        abt1=new JTextField();
        abt1.setFont(new Font("SansSerif",Font.PLAIN,14));
        abt1.setBounds(173,80,150,25);
        
        //Charged Amount JTextField
        abt2=new JTextField();
        abt2.setFont(new Font("SansSerif",Font.PLAIN,14));
        abt2.setBounds(173,110,150,25);
        
        //Number of Seats JTextField
        abt3=new JTextField();
        abt3.setFont(new Font("SansSerif",Font.PLAIN,14));
        abt3.setBounds(173,140,150,25);
        
        //Creating JComboBoxes for selecting Booked Date
        //JComboBox for selecting day number and setting the font, position and size of the combobox
        aday=new JComboBox<String>(day);
        aday.setFont(new Font("SansSerif",Font.PLAIN,14));
        aday.setBounds(63,200,80,30);
        
        //JComboBox for selecting month number and setting the font, position and size of the combobox
        amonth=new JComboBox<String>(month);
        amonth.setFont(new Font("SansSerif",Font.PLAIN,14));
        amonth.setBounds(152,200,80,30);
        
        //JComboBox for selecting year and setting the font, position and size of the combobox
        ayear=new JComboBox<String>(year);
        ayear.setFont(new Font("SansSerif",Font.PLAIN,14));
        ayear.setBounds(242,200,80,30);
        
        //adding the actionlistener method to the buttons in the autorickshaw frame
        autoBackBtn.addActionListener(this);
        autoDisplayBtn.addActionListener(this);
        autoClearBtn.addActionListener(this);
        autoAddBtn.addActionListener(this);
        autoBookBtn.addActionListener(this);
        
        //adding the back,display and clear (navigation) buttons to the navigation bar panel
        autoBar.add(autoBackBtn);
        autoBar.add(autoDisplayBtn);
        autoBar.add(autoClearBtn);
        
        //adding the JLabels and TextFields for the add form and the add button in the add form panel
        autoAdd.add(autoTitle1);
        autoAdd.add(a1);
        autoAdd.add(a2);
        autoAdd.add(a3);
        autoAdd.add(a4);
        autoAdd.add(a5);
        autoAdd.add(a6);
        autoAdd.add(a7);
        autoAdd.add(a8);
        autoAdd.add(a9);
        autoAdd.add(at1);
        autoAdd.add(at2);
        autoAdd.add(at3);
        autoAdd.add(at4);
        autoAdd.add(at5);
        autoAdd.add(at6);
        autoAdd.add(at7);
        autoAdd.add(at8);
        autoAdd.add(at9);
        autoAdd.add(autoAddBtn);
        
        //adding the JLabels and TextFields for the book form and the book button in the book form panel
        autoBook.add(autoTitle2);
        autoBook.add(ab1);
        autoBook.add(ab2);
        autoBook.add(ab3);
        autoBook.add(ab4);
        autoBook.add(abt1);
        autoBook.add(abt2);
        autoBook.add(abt3);
        autoBook.add(aday);
        autoBook.add(amonth);
        autoBook.add(ayear);
        autoBook.add(autoBookBtn);
        
        //adding the JPanels in the auto rickshaw frame
        autoFrame.add(autoBar);
        autoFrame.add(autoAdd);
        autoFrame.add(autoBook);
        
        //setting the size, layout and visibility of the auto rickshaw frame.
        autoFrame.setLayout(null);
        autoFrame.setSize(865,520);
        autoFrame.setVisible(false);
        //the program will close completely when the (x) is clicked
        autoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        /* Creating the frame that is displayed when the Electric Scooter button is clicked from the main menu frame.
         *It will contain the form to add,purchase,and sell electric scooter separately with a menu to 
         *display, clear, or go back to main frame.
        */
        elecFrame=new JFrame("Electric Scooter");
    
        //creating the navigation bar(JPanel) of the electric scooter frame and setting its properties(position,size,bgcolor,layout)
        elecBar=new JPanel();
        elecBar.setBounds(0,0,150,620);
        elecBar.setBackground(Color.WHITE);
        elecBar.setLayout(null);
        
        //creating the add form(JPanel) of the electric scooter frame and setting its properties(position,size,bgcolor,layout)
        elecAdd=new JPanel();
        elecAdd.setBounds(150,0,675,210);
        elecAdd.setBackground(darkBlue);
        elecAdd.setLayout(null);
        
        //creating the purchase form(JPanel) of the electric scooter frame and setting its properties(position,size,bgcolor,layout)
        elecPurchase=new JPanel();
        elecPurchase.setBounds(150,210,675,210);
        elecPurchase.setBackground(midBlue);
        elecPurchase.setLayout(null);
        
        //creating the sell form(JPanel) of the electric scooter frame and setting its properties(position,size,bgcolor,layout)
        elecSell=new JPanel();
        elecSell.setBounds(150,420,675,200);
        elecSell.setBackground(lightBlue);
        elecSell.setLayout(null);
        
        //creating the back button of the elecBar JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        elecBackBtn=new JButton("Back");
        elecBackBtn.setFont(new Font("SansSerif",Font.PLAIN,18));
        elecBackBtn.setForeground(darkBlue);
        elecBackBtn.setBackground(Color.WHITE);
        elecBackBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        elecBackBtn.setBounds(0,0,150,50);
        
        //creating the display button of the elecBar JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        elecDisplayBtn=new JButton("Display");
        elecDisplayBtn.setFont(new Font("SansSerif",Font.PLAIN,18));
        elecDisplayBtn.setForeground(darkBlue);
        elecDisplayBtn.setBackground(Color.WHITE);
        elecDisplayBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        elecDisplayBtn.setBounds(0,450,150,50);
        
        //creating the clear button of the elecBar JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        elecClearBtn=new JButton("Clear");
        elecClearBtn.setFont(new Font("SansSerif",Font.PLAIN,18));
        elecClearBtn.setForeground(darkBlue);
        elecClearBtn.setBackground(Color.WHITE);
        elecClearBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        elecClearBtn.setBounds(0,500,150,50);
        
        //creating the add button of the elecAdd JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        elecAddBtn=new JButton("Add");
        elecAddBtn.setFont(new Font("SansSerif",Font.PLAIN,20));
        elecAddBtn.setForeground(Color.WHITE);
        elecAddBtn.setBackground(darkBlue);
        elecAddBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
        elecAddBtn.setBounds(493,145,150,40);
        
        //creating the purchase button of the elecPurchase JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        elecPurchaseBtn=new JButton("Purchase");
        elecPurchaseBtn.setFont(new Font("SansSerif",Font.PLAIN,20));
        elecPurchaseBtn.setForeground(darkBlue);
        elecPurchaseBtn.setBackground(midBlue);
        elecPurchaseBtn.setBorder(BorderFactory.createLineBorder(darkBlue,1));
        elecPurchaseBtn.setBounds(493,145,150,40);
        
        //creating the sell button of the elecSell JPanel and setting its properties(position,size,bgcolor,layout,font,border)
        elecSellBtn=new JButton("Sell");
        elecSellBtn.setFont(new Font("SansSerif",Font.PLAIN,20));
        elecSellBtn.setForeground(darkBlue);
        elecSellBtn.setBackground(lightBlue);
        elecSellBtn.setBorder(BorderFactory.createLineBorder(darkBlue,1));
        elecSellBtn.setBounds(493,78,150,40);
        
        //Title for the Add form in Electric Scooter
        elecTitle1=new JLabel("Add Electric Scooter",JLabel.CENTER);
        elecTitle1.setFont(new Font("SansSerif",Font.BOLD,24));
        elecTitle1.setForeground(Color.WHITE);
        elecTitle1.setBounds(0,0,665,50);
        
        //Title for the Purchase form in Electric Scooter
        elecTitle2=new JLabel("Purchase Electric Scooter",JLabel.CENTER);
        elecTitle2.setFont(new Font("SansSerif",Font.BOLD,24));
        elecTitle2.setForeground(darkBlue);
        elecTitle2.setBounds(0,0,665,50);
        
        //Title for the Sell form in Electric Scooter
        elecTitle3=new JLabel("Sell Electric Scooter",JLabel.CENTER);
        elecTitle3.setFont(new Font("SansSerif",Font.BOLD,24));
        elecTitle3.setForeground(darkBlue);
        elecTitle3.setBounds(0,0,665,50);
        
        //Creating JLabels for the textfields in electric scooter add form and setting the font,colors,position and size
        //Vehicle ID Label
        ea1=new JLabel("Vehicle ID");
        ea1.setFont(new Font("SansSerif",Font.PLAIN,14));
        ea1.setForeground(Color.WHITE);
        ea1.setBounds(23,70,135,25);
        
        //Vehicle Name Label
        ea2=new JLabel("Vehicle Name");
        ea2.setFont(new Font("SansSerif",Font.PLAIN,14));
        ea2.setForeground(Color.WHITE);
        ea2.setBounds(23,100,135,25);
        
        //Vehicle Weight Label
        ea3=new JLabel("Vehicle Weight");
        ea3.setFont(new Font("SansSerif",Font.PLAIN,14));
        ea3.setForeground(Color.WHITE);
        ea3.setBounds(23,130,135,25);
        
        //Vehicle Color Label
        ea4=new JLabel("Vehicle Color");
        ea4.setFont(new Font("SansSerif",Font.PLAIN,14));
        ea4.setForeground(Color.WHITE);
        ea4.setBounds(23,160,135,25);
        
        //Vehicle Speed Label
        ea5=new JLabel("Vehicle Speed");
        ea5.setFont(new Font("SansSerif",Font.PLAIN,14));
        ea5.setForeground(Color.WHITE);
        ea5.setBounds(348,70,135,25);
        
        //Battery Capacity Label
        ea6=new JLabel("Battery Capacity");
        ea6.setFont(new Font("SansSerif",Font.PLAIN,14));
        ea6.setForeground(Color.WHITE);
        ea6.setBounds(348,100,135,25);
        
        //Creating JTextfields for entering information in electric scooter add form and setting the font,position and size
        //Vehicle ID JTextField
        eat1=new JTextField();
        eat1.setFont(new Font("SansSerif",Font.PLAIN,14));
        eat1.setBounds(168,70,150,25);
        
        //Vehicle Name JTextField
        eat2=new JTextField();
        eat2.setFont(new Font("SansSerif",Font.PLAIN,14));
        eat2.setBounds(168,100,150,25);
        
        //Vehicle Weight JTextField
        eat3=new JTextField();
        eat3.setFont(new Font("SansSerif",Font.PLAIN,14));
        eat3.setBounds(168,130,150,25);
        
        //Vehicle Color JTextField
        eat4=new JTextField();
        eat4.setFont(new Font("SansSerif",Font.PLAIN,14));
        eat4.setBounds(168,160,150,25);
        
        //Vehicle Speed JTextField
        eat5=new JTextField();
        eat5.setFont(new Font("SansSerif",Font.PLAIN,14));
        eat5.setBounds(493,70,150,25);
        
        //Battery Capacity JTextField
        eat6=new JTextField();
        eat6.setFont(new Font("SansSerif",Font.PLAIN,14));
        eat6.setBounds(493,100,150,25);
        
        //Creating JLabels for the textfields in electric scooter purchase form and setting the font,colors,position and size
        //Vehicle ID Label
        ep1=new JLabel("Vehicle ID");
        ep1.setFont(new Font("SansSerif",Font.PLAIN,14));
        ep1.setForeground(darkBlue);
        ep1.setBounds(23,70,135,25);
        
        //Vehicle Brand Label
        ep2=new JLabel("Vehicle Brand");
        ep2.setFont(new Font("SansSerif",Font.PLAIN,14));
        ep2.setForeground(darkBlue);
        ep2.setBounds(23,100,135,25);
        
        //Price Label
        ep3=new JLabel("Vehicle Price");
        ep3.setFont(new Font("SansSerif",Font.PLAIN,14));
        ep3.setForeground(darkBlue);
        ep3.setBounds(23,130,135,25);
        
        //Charging Time Label
        ep4=new JLabel("Charging Time");
        ep4.setFont(new Font("SansSerif",Font.PLAIN,14));
        ep4.setForeground(darkBlue);
        ep4.setBounds(23,160,135,25);
        
        //Mileage Label
        ep5=new JLabel("Vehicle Mileage");
        ep5.setFont(new Font("SansSerif",Font.PLAIN,14));
        ep5.setForeground(darkBlue);
        ep5.setBounds(348,70,135,25);
        
        //Range Label
        ep6=new JLabel("Vehicle Range");
        ep6.setFont(new Font("SansSerif",Font.PLAIN,14));
        ep6.setForeground(darkBlue);
        ep6.setBounds(348,100,135,25);
        
        //Creating JTextfields for entering information in electric scooter purchase form and setting the font,position and size
        //Vehicle ID JTextField
        ept1=new JTextField();
        ept1.setFont(new Font("SansSerif",Font.PLAIN,14));
        ept1.setBounds(168,70,150,25);
        
        //Vehicle Brand JTextField
        ept2=new JTextField();
        ept2.setFont(new Font("SansSerif",Font.PLAIN,14));
        ept2.setBounds(168,100,150,25);
        
        //Vehicle Price JTextField
        ept3=new JTextField();
        ept3.setFont(new Font("SansSerif",Font.PLAIN,14));
        ept3.setBounds(168,130,150,25);
        
        //Vehicle Charging Time JTextField
        ept4=new JTextField();
        ept4.setFont(new Font("SansSerif",Font.PLAIN,14));
        ept4.setBounds(168,160,150,25);
        
        //Vehicle Mileage JTextField
        ept5=new JTextField();
        ept5.setFont(new Font("SansSerif",Font.PLAIN,14));
        ept5.setBounds(493,70,150,25);
        
        //Vehicle Range JTextField
        ept6=new JTextField();
        ept6.setFont(new Font("SansSerif",Font.PLAIN,14));
        ept6.setBounds(493,100,150,25);
        
        //Creating JLabels for the textfields in electric scooter sell form and setting the font,colors,position and size
        //Vehicle ID Label
        es1=new JLabel("Vehicle ID");
        es1.setFont(new Font("SansSerif",Font.PLAIN,14));
        es1.setForeground(darkBlue);
        es1.setBounds(23,70,135,25);
        
        //Vehicle Price Label
        es2=new JLabel("Price");
        es2.setFont(new Font("SansSerif",Font.PLAIN,14));
        es2.setForeground(darkBlue);
        es2.setBounds(23,100,135,25);
        
        //Creating JTextfields for entering information in electric scooter sell form and setting the font,position and size
        //Vehicle ID JTextField
        est1=new JTextField();
        est1.setFont(new Font("SansSerif",Font.PLAIN,14));
        est1.setBounds(168,70,150,25);
        
        //Vehicle Price JTextField
        est2=new JTextField();
        est2.setFont(new Font("SansSerif",Font.PLAIN,14));
        est2.setBounds(168,100,150,25);
        
        //adding the navigation buttons in the electric scooter navigation panel
        elecBar.add(elecBackBtn);
        elecBar.add(elecDisplayBtn);
        elecBar.add(elecClearBtn);
        
        //adding the JLabels and TextFields for the add form and the add button in the add form panel
        elecAdd.add(elecTitle1);
        elecAdd.add(ea1);
        elecAdd.add(ea2);
        elecAdd.add(ea3);
        elecAdd.add(ea4);
        elecAdd.add(ea5);
        elecAdd.add(ea6);
        elecAdd.add(eat1);
        elecAdd.add(eat2);
        elecAdd.add(eat3);
        elecAdd.add(eat4);
        elecAdd.add(eat5);
        elecAdd.add(eat6);
        elecAdd.add(elecAddBtn);
        
        //adding the JLabels and TextFields for the puchase form and the purchase button in the book purchase panel
        elecPurchase.add(elecTitle2);
        elecPurchase.add(ep1);
        elecPurchase.add(ep2);
        elecPurchase.add(ep3);
        elecPurchase.add(ep4);
        elecPurchase.add(ep5);
        elecPurchase.add(ep6);
        elecPurchase.add(ept1);
        elecPurchase.add(ept2);
        elecPurchase.add(ept3);
        elecPurchase.add(ept4);
        elecPurchase.add(ept5);
        elecPurchase.add(ept6);
        elecPurchase.add(elecPurchaseBtn);
        
        //adding the JLabels and TextFields for the sell form and the sell button in the sell form panel
        elecSell.add(elecTitle3);
        elecSell.add(es1);
        elecSell.add(es2);
        elecSell.add(est1);
        elecSell.add(est2);
        elecSell.add(elecSellBtn);
        
        //adding the JPanels in the electric scooter frame
        elecFrame.add(elecBar);
        elecFrame.add(elecAdd);
        elecFrame.add(elecPurchase);
        elecFrame.add(elecSell);
        
        //adding the actionlistener method to the buttons in the electric scooter frame
        elecBackBtn.addActionListener(this);
        elecDisplayBtn.addActionListener(this);
        elecClearBtn.addActionListener(this);
        elecAddBtn.addActionListener(this);
        elecPurchaseBtn.addActionListener(this);
        elecSellBtn.addActionListener(this);
        
        //setting the size, layout and visibility of the electric scooter frame.
        elecFrame.setLayout(null);
        elecFrame.setSize(840,620);
        elecFrame.setVisible(false);
        //the program will close completely when the (x) is clicked
        elecFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //The frames will be positioned in the middle of the screen
        mainFrame.setLocationRelativeTo(null);
        autoFrame.setLocationRelativeTo(null);
        elecFrame.setLocationRelativeTo(null);
    }
    /*Creating a separate method for clearing the textfields in auto rickshaw frame because there are multiple scenarios where the 
     * fields have to be emptied
     * using the setText() method to set the string values to empty
     * using setSelectedIndex() method to reset the ComboBoxes to the first values
     */
    public void autoClear()
    {
        at1.setText("");
        at2.setText("");
        at3.setText("");
        at4.setText("");
        at5.setText("");
        at6.setText("");
        at7.setText("");
        at8.setText("");
        at9.setText("");
        abt1.setText("");
        abt2.setText("");
        abt3.setText("");
        aday.setSelectedIndex(0);
        amonth.setSelectedIndex(0);
        ayear.setSelectedIndex(0);
    }
    /*Creating a separate method for clearing the textfields in electric scooter frame because there are multiple scenarios where the 
     * fields have to be emptied*/
    public void elecClear()
    {
        eat1.setText("");
        eat2.setText("");
        eat3.setText("");
        eat4.setText("");
        eat5.setText("");
        eat6.setText("");
        ept1.setText("");
        ept2.setText("");
        ept3.setText("");
        ept4.setText("");
        ept5.setText("");
        ept6.setText("");
        est1.setText("");
        est2.setText("");
    }
    /*Since the TransportGUI class implements the ActionListener interface, the abstract method in ActionListener interface needs to
     * be overidden
     * This method overrides the abstract method actionPerformed in ActionListener interface
     * The parameter passed is an ActionEvent a
     * The method defines what needs to be done when the buttons in the GUI are clicked
     */
    public void actionPerformed(ActionEvent a)
    {
        /*
         * when the source of the event is JButton mainBtn1, the autoFrame JFrame becomes visible and mainFrame JFrame is not visible
         * the instance method autoClear() is called to clear any previous input in autoFrame.
         */
        if (a.getSource()==mainBtn1)
        {
            mainFrame.setVisible(false);
            autoFrame.setVisible(true);
            autoClear();
        }
        /*
         * when the source of the event is JButton mainBtn2, the elecFrame JFrame becomes visible and mainFrame JFrame is not visible
         * the instance method elecClear() is called to clear any previous input in elecFrame.
         */
        else if (a.getSource()==mainBtn2)
        {
            mainFrame.setVisible(false);
            elecFrame.setVisible(true);
            elecClear();
        }
        //the program is shutdown completely when the JButton mainBtn3 is clicked 
        else if (a.getSource()==mainBtn3)
        {
            System.exit(0);
        }
        //if autoBackBtn or elecBackBtn is the source of the action event autoFrame and elecFrame are not visible and the mainFrame is set to visible
        else if (a.getSource()==autoBackBtn || a.getSource()==elecBackBtn )
        {
            autoFrame.setVisible(false);
            elecFrame.setVisible(false);
            mainFrame.setVisible(true);
        }
        //when the autoDisplayBtn JButton is clicked the autorickshaw objects stored in the arrayList vehicleList are identified and the display method is  called
        else if(a.getSource()==autoDisplayBtn)
        {
            int count=0;// to count the number of records displayed
            for (Vehicle obj:vehicleList) //iterating ArrayList vehicleList of Vehicle class using for-each loop
            {
                if (obj instanceof Auto_Rickshaw==true) //identifies whether the object is an object of Auto_Rickshaw class
                {
                    obj.display(); //display method of Auto_Rickshaw class is called
                    System.out.println();
                    count+=1;
                }
            }
            //displays the number of auto rickshaws displayed
            JOptionPane.showMessageDialog(autoFrame,"There are "+count+" auto rickshaw(s) recorded.");
        }
        //when the autoClearBtn is clicked the autoClear instance method is called
        else if (a.getSource()==autoClearBtn)
        {
            autoClear();
        }
        //when the elecClearBtn is clicked the elecClear instance method is called
        else if(a.getSource()==elecClearBtn) 
        {
            elecClear();
        }
        /*when the autoAddBtn is clicked, the inputs are checked for validity and then and object of Auto Rickshaw is created and added 
        to the arraylist vehicleList*/
        else if (a.getSource()==autoAddBtn)
        {
            try//exception handling (try-catch pair) the code inside try can generate exceptions
            {
                //checking for empty textfields and displaying an error message if any of the fields are empty
                if (at1.getText().trim().isEmpty()==true||at2.getText().trim().isEmpty()==true||at3.getText().trim().isEmpty()==true||at4.getText().trim().isEmpty()==true||at5.getText().trim().isEmpty()==true||at6.getText().trim().isEmpty()==true||at7.getText().trim().isEmpty()==true||at8.getText().trim().isEmpty()==true||at9.getText().trim().isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(autoFrame,"Please fill all the spaces before adding the vehicle.","Empty Fields",JOptionPane.ERROR_MESSAGE);          
                }
                else
                {
                    boolean canAdd = true;
                    boolean inList = true;
                    //boolean values to check validity of user input
                    //acquiring the user input using the getText() method
                    int vehicle_id = Integer.parseInt(at1.getText());//converting the default String data type to int data type
                    String vehicle_name =at2.getText();
                    String vehicle_weight =at3.getText();
                    String vehicle_color =at4.getText();
                    String vehicle_speed =at5.getText();
                    int engine_displacement = Integer.parseInt(at6.getText());
                    String torque =at7.getText();
                    int fuel_tank_capacity = Integer.parseInt(at8.getText());
                    String ground_clearance =at9.getText();
                    //NumberFormatException can be generated when converting string values to int values
                    if (vehicleList.size()==0) //if there are no objects in the arraylist, a new object can be added directly
                    {
                        canAdd=true;
                        inList=false;
                    }
                    else
                    {   //if there are objects in the list then iterate through the list for duplicate values
                        for (Vehicle obj: vehicleList)
                        {
                            if (obj.getVehicle_ID()==vehicle_id)//using getVehicleID() and comparing it to the vehicle_id input by user for equality
                            {
                                if (obj instanceof Auto_Rickshaw ==true )/*checking if the object is an instance of Auto_Rickshaw class. 
                                                                        Allows same VehicleID for electric Scooter but not Auto_Rickshaw*/
                                {
                                    JOptionPane.showMessageDialog(autoFrame,"The Vehicle ID already exists. Please enter a new Vehicle information.","Duplicate Values",JOptionPane.ERROR_MESSAGE);
                                    canAdd=false;//error message for duplicate values
                                }
                            }
                            else //if there are no identical values of vehicle ID then the object is not in the vehicleList arraylist
                            {
                                inList=false;
                            }
                        } 
                    }
                    if (canAdd==true && inList==false) //Checking the boolean values to add new object
                    {
                        Auto_Rickshaw objAuto=new Auto_Rickshaw(vehicle_id,vehicle_name,vehicle_weight,vehicle_color,vehicle_speed,engine_displacement,torque,fuel_tank_capacity,ground_clearance);
                        vehicleList.add(objAuto); //creating new Auto_Rickshaw object using parameterized constructor and passing parameters from user input and adding the object to the arrayList
                        autoClear();//clearing fields are successful addition of auto rickshaw
                        JOptionPane.showMessageDialog(autoFrame,"Vehicle ID: "+vehicle_id+" with vehicle name: "+vehicle_name+" has been added. It is available for booking.");
                        //sucessfull addition message box
                    }
                }
            }
            /*exception handing - catch block
             * there is a possible NumberFormatException in the try-block
             */
            catch(NumberFormatException e) //handling the exception, display an error dialog box
            {
                JOptionPane.showMessageDialog(autoFrame,"You've entered an invalid input. Make sure the values of Vehicle ID, Engine Displacement, and Fuel Tank Capacity are numerical.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e)//catch block hierarchy, most specific to general. A second general catch block to catch any other possible exceptions
            {
                JOptionPane.showMessageDialog(autoFrame,"The data you've entered are invalid. Please re-enter the data correctly.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
        }
        /*when the autoBookBtn is clicked, the inputs are checked for validity, double booking, invalid booking and 
         * and then the object is downcasted to Auto_Rickshaw class and the book() method of Auto_Rickshaw class is called
         */
        else if (a.getSource()==autoBookBtn)
        {
            try 
            {
                if (abt1.getText().trim().isEmpty()==true||abt2.getText().trim().isEmpty()==true||abt3.getText().trim().isEmpty()==true)
                {//empty fields check and corresponding error dialog box
                    JOptionPane.showMessageDialog(autoFrame,"Please fill all the spaces before adding the vehicle.","Invalid Input",JOptionPane.ERROR_MESSAGE);          
                }
                else
                {
                    boolean inList= true;
                    boolean canBook=true;
                    //initializing variables to store user input using getText() method
                    int vehicle_id = Integer.parseInt(abt1.getText());
                    int charge_amount = Integer.parseInt(abt2.getText());
                    int number_of_seats = Integer.parseInt(abt3.getText());
                    //converting combobox values to string 
                    String booked_date= aday.getSelectedItem()+" "+amonth.getSelectedItem()+" "+ayear.getSelectedItem();
                    if (vehicleList.size()==0)//if there are no vehicles in the arrayList, booking cannot be done- corresponding error message)
                    {
                        JOptionPane.showMessageDialog(autoFrame,"There are no Auto Rickshaws to be booked. Add an auto rickshaw before booking it.","Empty List",JOptionPane.ERROR_MESSAGE);          
                    }
                    else //if there are objects in the list then iterate through the list for identical vehicle ID
                    {
                        for (Vehicle obj: vehicleList)
                        {
                            if (obj.getVehicle_ID()==vehicle_id)
                            {
                                if (obj instanceof Vehicle==true && obj instanceof Auto_Rickshaw==true)//checking if it an object of Vehicle(superclass) and Auto_Rickshaw(subclass) class
                                {
                                    Auto_Rickshaw vobj=(Auto_Rickshaw) obj;//downcasting object to Auto_Rickshaw class
                                    if (vobj.getIsBooked()==false)//using the getIsBooked() getter method of Auto Rickshaw class and checking if the vehicle is already booked
                                    {
                                        //if not booked then calling the book() instnace method of Auto_Rickshaw class and displaying appropriate dialog box
                                        vobj.book(booked_date,charge_amount,number_of_seats);
                                        autoClear();
                                        canBook=false;
                                        JOptionPane.showMessageDialog(autoFrame,"Vehicle ID: "+vehicle_id+" has been booked on"+booked_date);
                                    }
                                    else//if the vehicle is already booked, display a dialog box for double booking
                                    {
                                        JOptionPane.showMessageDialog(autoFrame,"The Vehicle has already been booked on "+vobj.getBooked_Date()+". Please choose another vehicle.");  
                                        canBook=false;
                                    }
                                }
                            }
                            else //if the vehicleID doesnt match, it is not in the list
                            {
                                inList=false;
                            }
                        }
                        if(inList==false && canBook==true)//if the vehicle is not in the list but can be booked, display an error message 
                        {
                            JOptionPane.showMessageDialog(autoFrame,"The Vehicle ID does not exist. Please choose an available vehicle."); 
                        }
                    }
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(autoFrame,"You've entered an invalid input. Make sure the data entered are numerical.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(autoFrame,"The data you've entered are invalid. Please re-enter the data correctly.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
        }
        //when the elecDisplayBtn JButton is clicked the electric scooter objects stored in the arrayList vehicleList are identified and the display method is  called
        else if(a.getSource()==elecDisplayBtn)
        {
            int count=0;
            for (Vehicle obj:vehicleList)
            {
                if (obj instanceof Electric_Scooter==true)
                {
                    obj.display();
                    System.out.println();
                    count+=1;
                }
            }
            JOptionPane.showMessageDialog(elecFrame,"There are "+count+" electric scooter(s) recorded.");
        }
        /*when the elecAddBtn is clicked, the inputs are checked for validity and then and object of Electric Scooter is created and added 
        to the arraylist vehicleList*/
        else if (a.getSource()==elecAddBtn)
        {
            try
            {
                if (eat1.getText().trim().isEmpty()==true||eat2.getText().trim().isEmpty()==true||eat3.getText().trim().isEmpty()==true||eat4.getText().trim().isEmpty()==true||eat5.getText().trim().isEmpty()==true||eat6.getText().trim().isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(elecFrame,"Please fill all the spaces before adding the vehicle.","Invalid Input",JOptionPane.ERROR_MESSAGE);          
                }
                else
                {
                    boolean canAdd = true;
                    boolean inList= true;
                    int vehicle_id = Integer.parseInt(eat1.getText());
                    String vehicle_name =eat2.getText();
                    String vehicle_weight =eat3.getText();
                    String vehicle_color =eat4.getText();
                    String vehicle_speed =eat5.getText();
                    int battery_capacity = Integer.parseInt(eat6.getText());
                    
                    if (vehicleList.size()==0)
                    {
                        canAdd=true;
                        inList=false;
                    }
                    else
                    {
                        for (Vehicle obj: vehicleList)
                        {
                            if (obj.getVehicle_ID()==vehicle_id)
                            {
                                if (obj instanceof Electric_Scooter ==true)
                                {
                                    JOptionPane.showMessageDialog(elecFrame,"The Vehicle ID already exists. Please enter a new Vehicle information.","Duplicate Values",JOptionPane.ERROR_MESSAGE);  
                                    canAdd=false;
                                }
                            }     
                            else 
                            {
                                inList=false;
                            }
                        } 
                    }
                    if (canAdd==true && inList==false)
                    {
                        Electric_Scooter objElec=new Electric_Scooter(vehicle_id,vehicle_name,vehicle_weight,vehicle_color,vehicle_speed,battery_capacity);
                        vehicleList.add(objElec);
                        elecClear();
                        JOptionPane.showMessageDialog(elecFrame,"Vehicle ID: "+vehicle_id+" has been added to the catalog. It is available for purchase.");
                    }
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(elecFrame,"You've entered an invalid input. Make sure the values are numerical.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(elecFrame,"The data you've entered are invalid. Please re-enter the data correctly.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }            
        }
        /*when the elecPurchaseBtn is clicked, the inputs are checked for validity, double purcahsing, invalid purchase and 
         *then the object is downcasted to Elecctric_Scooter class and the purchase() method of Electric_Scooter class is called
         */
        else if (a.getSource()==elecPurchaseBtn)
        {
          try
            {
                if (ept1.getText().trim().isEmpty()==true||ept2.getText().trim().isEmpty()==true||ept3.getText().trim().isEmpty()==true||ept4.getText().trim().isEmpty()==true||ept5.getText().trim().isEmpty()==true||ept6.getText().trim().isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(elecFrame,"Please fill all the spaces before adding the vehicle.","Invalid Input",JOptionPane.ERROR_MESSAGE);          
                }
                else
                {
                    boolean inList= true;
                    boolean canPurchase=true;
                    int vehicle_id = Integer.parseInt(ept1.getText());
                    String brand =ept2.getText();
                    int price =Integer.parseInt(ept3.getText());
                    String charging_time =ept4.getText();
                    String mileage =ept5.getText();
                    int range=Integer.parseInt(ept6.getText());
                    if (vehicleList.size()==0)
                    {
                        JOptionPane.showMessageDialog(elecFrame,"There are no Electric Scooters to be purchased. Add an electric scooter before purchasing it.","Empty List",JOptionPane.ERROR_MESSAGE);          
                    }
                    else
                    {
                        for (Vehicle obj: vehicleList)
                        {
                            if (obj.getVehicle_ID()==vehicle_id)
                            {
                                if (obj instanceof Vehicle==true && obj instanceof Electric_Scooter==true)
                                {
                                    Electric_Scooter vobj=(Electric_Scooter) obj;
                                    if (vobj.getHasPurchased()==false)
                                    {
                                        vobj.purchase(brand,price,charging_time,mileage,range);
                                        canPurchase=false;
                                        elecClear();
                                        JOptionPane.showMessageDialog(elecFrame,"Vehicle ID: "+vehicle_id+" has been purchased.");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(elecFrame,"The Vehicle has already been purchased before. Please choose another vehicle.");  
                                        canPurchase=false;
                                    }
                                }
                            }
                            else
                            {
                                inList=false;
                            }
                        }
                        if(inList==false && canPurchase==true)
                        {
                            JOptionPane.showMessageDialog(elecFrame,"The Vehicle ID does not exist. Please choose an available vehicle."); 
                        }
                    }
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(autoFrame,"You've entered an invalid input. Make sure the data entered are numerical.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(autoFrame,"The data you've entered are invalid. Please re-enter the data correctly.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }  
        }
        /*when the elecSellBtn is clicked, the inputs are checked for validity, double selling, invalid selling and 
         *then the object is downcasted to Electric_Scooter class and sell() method of Electric_Scooter class is called
         */
        else if (a.getSource()==elecSellBtn)
        {
            try
            {
                if (est1.getText().trim().isEmpty()==true||est2.getText().trim().isEmpty()==true)
                {
                    JOptionPane.showMessageDialog(elecFrame,"Please fill all the spaces before adding the vehicle.","Invalid Input",JOptionPane.ERROR_MESSAGE);          
                }
                else
                {
                    boolean inList= true;
                    boolean canSell=true;
                    int vehicle_id = Integer.parseInt(est1.getText());
                    int price=Integer.parseInt(est2.getText()); 
                    if (vehicleList.size()==0)
                    {
                        JOptionPane.showMessageDialog(elecFrame,"There are no Electric Scooters to be sold. Add an electric scooter before selling it.","Empty List",JOptionPane.ERROR_MESSAGE);          
                    }
                    else
                    {
                        for (Vehicle obj: vehicleList)
                        {
                            if (obj.getVehicle_ID()==vehicle_id)
                            {
                                if (obj instanceof Vehicle==true && obj instanceof Electric_Scooter==true)
                                {
                                    Electric_Scooter vobj=(Electric_Scooter) obj;
                                    if(vobj.getHasSold()==false && vobj.getHasPurchased()==true)//the vehicle should be purchased but not sold
                                    {
                                        vobj.sell(price);
                                        elecClear();
                                        canSell=false;
                                        JOptionPane.showMessageDialog(elecFrame,"Vehicle ID: "+vehicle_id+" has been sold for "+price);
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(elecFrame,"The Vehicle has already been sold before or has not been purchased. Please choose another vehicle.");  
                                        canSell=false;
                                    }
                                }
                            }
                            else
                            {
                                inList=false;
                            }
                        }
                        if(inList==false && canSell==true)
                        {
                            JOptionPane.showMessageDialog(elecFrame,"The Vehicle ID does not exist. Please choose an available vehicle."); 
                        }
                    }
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(elecFrame,"You've entered an invalid input. Make sure the data entered are numerical.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(elecFrame,"The data you've entered are invalid. Please re-enter the data correctly.","Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
        } 
    }
    //calling the constructor in the main method of the TrabsportGUI class
    public static void main(String args[])
    {
        new TransportGUI();
    } 
    }
