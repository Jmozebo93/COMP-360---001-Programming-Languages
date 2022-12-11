/**
 * 
 */
package GreenCo;
import java.awt.BorderLayout;
import java.util.Date;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;






/**
 * @author jordanmozebo
 * 
 * 
 *  This class implements the graphic user interface where the agent will interact to enter the client informations
 * The class contains a flight number field, a name field where the agent will enter the name and select the seat number based on the flight.
 * In addition to that, there are radio buttons that correspond to the type of flight the client want to reserve.
 * There are also drop down button to select the arrival and the departure date.
 * The drop down buttons for the arrival and departure date are set up in a dd/mm/yyyy format but will be displayed in mm/dd/yyyy after the execution.
 * Make sure you click on the "Accept term and Conditions" button before running the code or it will not run.
 * In addition to that, there is a reset button in case the clients want to return their tickets.
 * Make sure to select the seat number based on the flight number. For examaple if you choose flight GH100, you need to choose seat for GH100.
 * 
 *
 */
public  class GreenAirlineTicketSystem implements ActionListener {
	TicketPurchase purchase; //A variable of type MariottReservation
	public JFrame GreenAirlineFrame; //The frame that will contains all the buttons and fields
	public JTextField name; //The text field where the name of the client will be entered
	public JTextField resField; //The result field where all the client informations will be displayed
	public JLabel nameLabel; //The first name label it is displayed beside the first name text field
	public JLabel re; //The result label
	public JLabel flightNum; //flight number
	public JLabel Arrival; //The arrival date
	public JLabel Departure; //The departure date
	public JLabel gh_seatNum; //The seat number for greenH airplane
	public JLabel gf_seatNum; //The seat number for greenF airplane
	public JPanel controlPanel; //The control panel store and organize all the components
	public JTextArea result; //Area where all the information will be displayed
	public JButton submit, reset; //The button submit the agent will click on after entering all the client informations
	public JComboBox day,month,year; //JComboBox is used to display the drop down list of day, month, and year for the arrival date
	public JComboBox day1,month1,year1; //JComboBox is used to display the drop down list of day, month, and year for the departure date
	public JComboBox gh; //JComboBox is used to display the drop down list of seat for flight Green 100
	public JComboBox gf; //JComboBox is used to display the drop down list of seat for flight Green 400
	GreenH gH; //An object class GreenH for flight Green 100
	GreenF gF; //An object class GreenF for flight Green 400
	String seatN; //A variable that stores the seat in airplane Green 100 (GH100)
	String seatNF; //A variable that stores the seat in flight Green 400 (GF400)
	public JRadioButton greenH_airplane,greenF_airplane; //The radio button where the agent will select whether the client want a stand room, a luxury room or a junior room.
	public JCheckBox termsAndConditions; //The check box where to click on before clicking on the submit button.
	
	public String [] dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
			"17","18","19","20","21","22","23","24","25","26","27",
			"28","29","30","31"}; //An array of string numeric that represents the days
	
	public String [] months = {"01", "02", "03", "04", "05","06", "07",
			"08", "09", "10","11","12"}; //An array of string numeric that represents the months
	
	public String [] years = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
			"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"}; //An array of string numeric that represents the years.
	
	public String [] greenH = {"1A","2A","3A","4A","5A","6A","7A","1B","2B","3B","4B","5B","6B","7B","1C","2C","3C","4C","5C","6C","7C"}; //An array string alphanumeric that represents the seat on the flight Green 100 (GH100).
	
	public String [] greenF = {"1A","2A","3A","4A","5A","6A","7A","8A","9A","10A","11A","12A","13A","14A","15A","16A",
			"17A","18A","19A","20A","1B","2B","3B","4B","5B","6B","7B","8B","9B","10B","11B","12B","13B","14B","15B",
			"16B","17B","18B","19B","20B","1C","2C","3C","4C","5C","6C","7C","8C","9C","10C","11C","12C","13C","14C","15C",
			"16C","17C","18C","19C","20C"}; //An array of string alphanumeric that represents the seat on the flight Green 400 (GF400).
	
	//Constructor that implements the layout of the graphic user interface.
	public GreenAirlineTicketSystem() {
		gH = new GreenH();
		gF = new GreenF();
		// TODO Auto-generated constructor stub
		GreenAirlineFrame = new JFrame("Welcome to Green Airline Company!");
		GreenAirlineFrame.setBounds(300,90,900,300);
		GreenAirlineFrame.setResizable(true);
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		
		
		nameLabel = new JLabel("Name");
		nameLabel.setSize(100, 20);
		nameLabel.setLocation(100, 150);
		controlPanel.add(nameLabel);
		
		
		name = new JTextField(100);
		name.setSize(100, 20);
		name.setLocation(200, 150);
		controlPanel.add(name);
		
		
		submit = new JButton("Submit");
		submit.setSize(100,20);
		submit.setLocation(150,500);
		submit.addActionListener(this);
		controlPanel.add(submit);
		
		reset = new JButton("reset");
		reset.setSize(100,20);
		reset.setLocation(270,500);
		reset.addActionListener(this);
		controlPanel.add(reset);
		
		result = new JTextArea();
		result.setSize(300,400);
		result.setLocation(500,100);
		result.setLineWrap(true);
		result.setEditable(false);
		controlPanel.add(result);
		
		re = new JLabel("");
		re.setSize(500,25);
		re.setLocation(100,550);
		controlPanel.add(re);
		
		resField = new JTextField();
		resField.setSize(200,75);
		resField.setLocation(580,175);
		controlPanel.add(resField);
		
		termsAndConditions = new JCheckBox("Accept Terms And Condidtions.");
		termsAndConditions.setSize(250,20);
		termsAndConditions.setLocation(150,450);
		controlPanel.add(termsAndConditions);
		
		
		flightNum = new JLabel("Flight Number");
		flightNum.setSize(100,20);
		flightNum.setLocation(100,200);
		
		
		Departure = new JLabel("Departure");
		Departure.setSize(100,20);
		Departure.setLocation(100,250);
		controlPanel.add(Departure);
		
		Arrival = new JLabel("Arrival");
		Arrival.setSize(100,20);
		Arrival.setLocation(100, 300);
		controlPanel.add(Arrival);
		
		greenH_airplane = new JRadioButton("GH100");
		greenH_airplane.setSelected(false);
		greenH_airplane.setSize(75,20);
		greenH_airplane.setLocation(200,200);
		greenF_airplane = new JRadioButton("GF400");
		greenF_airplane.setSelected(false);
		greenF_airplane.setSize(80,20);
		greenF_airplane.setLocation(275,200);	
		controlPanel.add(flightNum);
		controlPanel.add(greenH_airplane);
		controlPanel.add(greenF_airplane);
		
		
		
		gh_seatNum = new JLabel("Seats GH100");
		gh_seatNum.setSize(100,20);
		gh_seatNum.setLocation(100,350);
		controlPanel.add(gh_seatNum);
		
		gf_seatNum = new JLabel("Seats GF400");
		gf_seatNum.setSize(100,20);
		gf_seatNum.setLocation(100,400);
		controlPanel.add(gf_seatNum);
		
		gh = new JComboBox(greenH);
		gh.setSize(50,20);
		gh.setLocation(200, 350);
		gf = new JComboBox(greenF);
		gf.setSize(50,20);
		gf.setLocation(200, 400);
		controlPanel.add(gh);
		controlPanel.add(gf);
		
		day = new JComboBox(dates);
		day.setSize(50,20);
		day.setLocation(200,250);
		month = new JComboBox(months);
		month.setSize(60,20);
		month.setLocation(250,250);
		year = new JComboBox(years);
		year.setSize(60,20);
		year.setLocation(320,250);
		controlPanel.add(day);
		controlPanel.add(month);
		controlPanel.add(year);
		
		day1 = new JComboBox(dates);
		day1.setSize(50,20);
		day1.setLocation(200,300);
		month1 = new JComboBox(months);
		month1.setSize(60,20);
		month1.setLocation(250,300);
		year1 = new JComboBox(years);
		year1.setSize(60,20);
		year1.setLocation(320,300);
		controlPanel.add(day1);
		controlPanel.add(month1);
		controlPanel.add(year1);
		
		

		
		GreenAirlineFrame.add(controlPanel);
		GreenAirlineFrame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreenAirlineTicketSystem tkt = new GreenAirlineTicketSystem(); //A variable of type GreenAirlineTicketSystem.

	}
	
	int i = 0; //A counter that keeps track of the number of seat in the flight Green 100
	int j = 0; //A counter that keeps track of the number of seat in the flight Green 400
	
	
	@Override
	//This method is invoked every time a component such as a button is pressed
	//In this case this method is invoked whenever the button submit is pressed
	public void actionPerformed(ActionEvent e) {
		
		    //Verify if the submit button is pressed
			if(e.getSource() == submit) {
				 //Verify if the terms and condition and the button for the Green 100 (GH100) are isSelected
			     //Make sure the number of seats  do not exceed 21
				if(termsAndConditions.isSelected() && greenH_airplane.isSelected() && i <= gH.getNumSeat()){
					
					String PassengerName = name.getText();
					
					
					int d = Integer.parseInt((String)day.getSelectedItem());
					int m = Integer.parseInt((String)month.getSelectedItem());
					int y = Integer.parseInt((String)year.getSelectedItem());
					
					int d1 = Integer.parseInt((String)day1.getSelectedItem());
					int m1 = Integer.parseInt((String)month1.getSelectedItem());
					int y1 = Integer.parseInt((String)year1.getSelectedItem());
					
					Date arrival = new Date(y1, m1, d1);
					Date departure = new Date(y, m, d);
					
					long arrivaldateInMs = arrival.getTime();
					long departuredateInMs = departure.getTime();
					
					long timeDiff = 0;
					String arr = (String)month1.getSelectedItem()
					+"/" + (String)day1.getSelectedItem()
					+ "/" + (String)year1.getSelectedItem();
					
					String dep = (String)month.getSelectedItem()
					+"/" + (String)day.getSelectedItem()
					+ "/" + (String)year.getSelectedItem();
					
					seatN = (String)gh.getSelectedItem();
					if(gh.getSelectedItem() != null) {
						gh.removeItem(seatN);
						
					}
					
					
					gH.setSeatNumber(seatN);
					
					if(departuredateInMs < arrivaldateInMs) {
						
						
						
						purchase = new TicketPurchase(PassengerName, dep, arr, gH);
						String res = purchase.toString();
						
						result.setText(res);
						result.setEditable(false);
						re.setText("Registration successful!");
						
					}
					i++;
					
					
				}
				
				
				//Verify if the terms and condition and the button for the Green 400 (GF400) are isSelected
			    //Make sure the number of seats  do not exceed 60
                if(termsAndConditions.isSelected() && greenF_airplane.isSelected() && j <= gF.getNumSeat()){
					
					String PassengerName = name.getText();
					
					
					int d = Integer.parseInt((String)day.getSelectedItem());
					int m = Integer.parseInt((String)month.getSelectedItem());
					int y = Integer.parseInt((String)year.getSelectedItem());
					
					int d1 = Integer.parseInt((String)day1.getSelectedItem());
					int m1 = Integer.parseInt((String)month1.getSelectedItem());
					int y1 = Integer.parseInt((String)year1.getSelectedItem());
					
					Date arrival = new Date(y1, m1, d1);
					Date departure = new Date(y, m, d);
					
					long arrivaldateInMs = arrival.getTime();
					long departuredateInMs = departure.getTime();
					
					long timeDiff = 0;
					String arr = (String)month1.getSelectedItem()
					+"/" + (String)day1.getSelectedItem()
					+ "/" + (String)year1.getSelectedItem();
					
					String dep = (String)month.getSelectedItem()
					+"/" + (String)day.getSelectedItem()
					+ "/" + (String)year.getSelectedItem();
					
					 seatNF = (String)gf.getSelectedItem();
					 
					 if(gf.getSelectedItem() != null) {
							gf.removeItem(seatNF);
							
						}
					
					
					
					gF.setSeatNum(seatNF);
					
					if(departuredateInMs < arrivaldateInMs) {
						
						
						
						purchase = new TicketPurchase(PassengerName, dep, arr, gF);
						String res = purchase.toString1();
						
						result.setText(res);
						result.setEditable(false);
						re.setText("Registration successful!");
						
					}
					j++;
					
					
				}
               
			}
			
			//If a passenger on the flight Green 100 (GH100) wants to return a ticket purchased
			//Press the reset button.
			if (e.getSource()== reset) {
				if(greenH_airplane.isSelected() && i <= gH.getNumSeat()) {
					String def = "";
					String def1 = "Ticket successfully returned";
					name.setText(def);
					result.setText(def1);
					re.setText(def);
					day.setSelectedIndex(0);
					month.setSelectedIndex(0);
					year.setSelectedIndex(0);
					day1.setSelectedIndex(0);
					month1.setSelectedIndex(0);
					year1.setSelectedIndex(0);
					gh.setSelectedIndex(0);
					for(int p = 0; p < greenH.length;p++ ) {
						if(seatN == greenH[p]) {
							gh.insertItemAt(seatN, p);
							
						}
					}
					
					
					
					i--;
					
					
				}
				
			}
			
			//If a passenger on the flight Green 400 (GF400) wants to return a ticket purchased
			//Press the reset button.
			if(e.getSource() == reset)  {
				if(greenF_airplane.isSelected() && j <= gF.getNumSeat()) {
					String def = "";
					String def1 = "Ticket successfully returned";
					name.setText(def);
					result.setText(def1);
					re.setText(def);
					day.setSelectedIndex(0);
					month.setSelectedIndex(0);
					year.setSelectedIndex(0);
					day1.setSelectedIndex(0);
					month1.setSelectedIndex(0);
					year1.setSelectedIndex(0);
					gf.setSelectedIndex(0);
					for(int n = 0; n < greenF.length;n++ ) {
						if(seatNF == greenF[n]) {
							gf.insertItemAt(seatNF, n);
							
						}
					}
					
					
					j--;
					
					
				}
				
			}
			
			//If you have exceeded the number of seats in flight Green 400 (GF400)
			//Press reset to have all the seats in flight Green 400 (GF400) available.
			if(e.getSource() == reset)  {
				if(greenF_airplane.isSelected() && j > gF.getNumSeat()) {
					String def = "";
					String def1 = "";
					name.setText(def);
					result.setText(def1);
					re.setText(def);
					day.setSelectedIndex(0);
					month.setSelectedIndex(0);
					year.setSelectedIndex(0);
					day1.setSelectedIndex(0);
					month1.setSelectedIndex(0);
					year1.setSelectedIndex(0);
					for(int m = 0; m < greenF.length;m++ ) {
						gf.addItem(greenF[m]);
					}
					gf.setSelectedIndex(0);
					
					j = 0;
					
					
				}
				
			}
			
			//If you have exceeded the number of seats in flight Green 100 (GH100)
			//Press reset to have all the seats in flight Green 100 (GH100) available.
			if (e.getSource()== reset) {
				if(greenH_airplane.isSelected() && i > gH.getNumSeat()) {
					String def = "";
					String def1 = "";
					name.setText(def);
					result.setText(def1);
					re.setText(def);
					day.setSelectedIndex(0);
					month.setSelectedIndex(0);
					year.setSelectedIndex(0);
					day1.setSelectedIndex(0);
					month1.setSelectedIndex(0);
					year1.setSelectedIndex(0);
					for(int l = 0; l < greenH.length;l++ ) {
						gh.addItem(greenH[l]);
					}
					gh.setSelectedIndex(0);
					
					i = 0;
					
					
				}
				
			}
			
			
		//Exception handling in case the number of seats in flight Green 100 (GH100) is exceeded
		try {
			if(i > gH.getNumSeat()) throw new IllegalStateException();
		}
		catch(IllegalStateException e1) {
			result.setText("The airplane is full!");
			re.setText("Please try another flight");
		}
		
		//Exception handling in case the number of seats in flight Green 400 (GF400) is exceeded.
		try {
			if(j > gF.getNumSeat()) throw new IllegalStateException();
		}
		catch(IllegalStateException e1) {
			result.setText("The airplane is full!");
			re.setText("Please try another flight");
		}
		
		
					
				
			
		
	}

}
