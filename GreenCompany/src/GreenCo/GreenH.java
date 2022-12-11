/**
 * 
 */
package GreenCo;

/**
 * @author jordanmozebo
 * 
 * An object class that represents a flight
 * A flight has a number of seats, seat numbers such as "1C" or "2A'
 * A departure time as well as an arrival time
 * It also has a destination, meaning, the city from which the plane departs and a city where the flight arrives at
 * In this case, the flight departs from Greensboro at 6:00 AM  and arrives at Newark at 7:30 AM.
 *
 */
public class GreenH extends TicketPurchase {
	public int numSeat;
	public String seatNumber;
	public String flightNum;
	public String departureCity;
	public String arrivalCity;
	public String departureTime;
	public String arrivalTime;
	
	//Constructor to initialize the Green 100 flight
	public GreenH(int Numseat, String Seatnum, String flightNumber, String DepCity, String ArrCity, String depTime, String arrTime) {
		
		this.numSeat = Numseat;
		this.seatNumber = Seatnum;
		this.flightNum = flightNumber;
		this.departureCity = DepCity;
		this.arrivalCity = ArrCity;
		this.departureTime = depTime;
		this.arrivalTime = arrTime;
	}
	
	//Constructor with predefined values since the number of seats, the flight number, the destination as well as the time are already known.
    public GreenH() {
		numSeat = 21;
		seatNumber = "none";
		flightNum = "GH100";
		departureCity = "Greensboro";
		arrivalCity = "Newark";
		departureTime = "6:00 AM";
		arrivalTime = "7:30 AM";
		
	}
	
    //Set the number of seats
	public void setNumSeats(int numSeats) {
		this.numSeat = numSeats;
	}
	
	//Set the seat number
	public void setSeatNumber(String sn) {
		this.seatNumber = sn;
	}
	
	//Set the flight number
	public void setFlightNum(String fNumber) {
		this.flightNum = fNumber;
	}
	
	//Set the city from which the flight departs
	public void setDepartureCity(String DepCity) {
		this.departureCity = DepCity;
	}
	
	//Set the departure time
	public void setDepartureTime(String depTime) {
		this.departureTime = depTime;
	}
	
	//Set the city where the plane lands
	public void setArrivalCity(String ArrCity) {
		this.arrivalCity = ArrCity;
	}
	
	//Set the arrival time
	public void setArrivalTime(String arrTime) {
		this.arrivalTime = arrTime;
	}
	
	//Get the number of seats
	public int getNumSeat() {
		return numSeat;
	}
	
	//Get the seat number
	public String getSeatNumber() {
		return seatNumber;
	}
	
	//Get the flight number
	public String getFlightNum() {
		return flightNum;
	}
	
	//Get the city from which the flight departs
	public String getDepartureCity() {
		return departureCity;
	}
	
	//Get the departure time
	public String getDepartureTime() {
		return departureTime;
	}
	
	//Get the city where the flight arrives at
	public String getArrivalCity() {
		return arrivalCity;
	}
	
	//Get the arrival time
	public String getArrivalTime() {
		return arrivalTime;
	}
	
	//Method that returns the informations regarding the flight
	public String toString() {
		String result = " ";
		
		result = "The seat number:"+"\n"+seatNumber+"\n"+"The flight number:"+"\n"+flightNum+"\n"+"Departs from:"+"\n"+departureCity+"\n"+departureTime+"\n"+"Arrives at:"+"\n"+arrivalCity+"\n"+arrivalTime+"\n";
		
		return result;
		
	}

}
