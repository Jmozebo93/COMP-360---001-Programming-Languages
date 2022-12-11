/**
 * 
 */
package GreenCo;


/**
 * @author jordanmozebo
 * An object class that implements the purchase of a ticket for both flight
 * A flight ticket includes the name of the passenger, the type of flight, the departure and arrival date.
 * 
 *
 */
public class TicketPurchase {
	private String name;
	private GreenH greenH;
	private GreenF greenF;
	private String departureDate;
	private String arrivalDate;
	
	
	//Constructor to initialize the ticket purchase when the passenger board the flight Green 100
	public TicketPurchase(String n, String dpDate, String arrDate, GreenH gH) {
		this.name = n;
		this.departureDate = dpDate;
		this.arrivalDate = arrDate;
		this.greenH = gH;
	}
	
	//Constructor to initialize the ticket purchase when the passenger board the flight Green 400
	public TicketPurchase(String n, String dpDate, String arrDate, GreenF gF) {
		this.name = n;
		this.departureDate = dpDate;
		this.arrivalDate = arrDate;
		this.greenF = gF;
		
		
	}
	
	////Constructor with predefined values.
    public TicketPurchase() {
		name = "none";
		departureDate = "none";
		arrivalDate = "none";
		
	}
	
    //Set the name of the passenger
	public void setName(String n) {
		this.name = n;
	}
	
	//Set the departure date
	public void setDepartureDate(String dpD) {
		this.departureDate = dpD;
	}
	
	//Set the arrival date
	public void setArrivalDate(String arrD) {
		this.arrivalDate = arrD;
	}

	//Set the flight Green 100
	public void setGreenH(GreenH greenyH) {
		this.greenH = greenyH;
	}
	
	//Set the flight Green 400
	public void setGreenF(GreenF greenyF) {
		this.greenF = greenyF;
		
	}
	
	//Get the name of the passenger
	public String getName(String n) {
		return name;
	}
	
	//Get the departure date
	public String getDepartureDate() {
		return this.departureDate;
	}
	
	//Get the arrival date
	public String getArrivalDate() {
		return this.arrivalDate;
	}
	
	
	
	@Override
	//Method that returns the informations regarding the ticket purchase for flight Green 100.
	public String toString() {
		String res = "";
		
		res = "Name:"+"\n"+name+"\n"+"Departure date:"+"\n"+departureDate+"\n"+"Arrival date:"+"\n"+arrivalDate+"\n";
		
		res += greenH.toString();
		
		return res;
	}
	
	//Method that returns the informations regarding the ticket purchase for flight Green 400.
	public String toString1(){
		String res = "";
		
		res = "Name:"+"\n"+name+"\n"+"Departure date:"+"\n"+departureDate+"\n"+"Arrival date:"+"\n"+arrivalDate+"\n";
		
		res += greenF.toString();
		
		return res;
		
	}

}
