/**
 * 
 */
package GreenCo;

/**
 * @author jordanmozebo
 * 
 * 
 * An object class that represents a flight
 * A flight has a number of seats, seat numbers such as "1C" or "2A'
 * A departure time as well as an arrival time
 * It also has a destination, meaning, the city from which the plane departs and a city where the flight arrives at
 * In this case, the flight departs from Greensboro at 4:00 PM  and arrives at Seattle at 11:00 PM.
 *
 */
public class GreenF {
	public int numSeat;
	public String seatNum;
	public String flightNum;
	public String departureCity;
	public String departureTime;
	public String arrivalCity;
	public String arrivalTime;
	
	//Constructor with predefined values since the number of seats, the flight number, the destination as well as the time are already known.
	public GreenF() {
		numSeat = 60;
		seatNum = "none";
		flightNum = "GF400";
		departureCity = "Greensboro";
		departureTime = "4:00 PM";
		arrivalCity = "Seattle";
		arrivalTime = "11:30 PM";
	}
	
	//Constructor to initialize the Green 400 flight
	public GreenF(int numberSeat, String seatNumber, String flightNumber, String depCity, String arrCity, String depTime, String arrTime) {
		numSeat = numberSeat;
		seatNum = seatNumber;
		flightNum = flightNumber;
		departureCity = depCity;
		departureTime = depTime;
		arrivalCity = arrCity;
		arrivalTime = arrTime;
	}
	
	//Set the number of seats
	public void setNumSeat(int nSeat) {
		numSeat = nSeat;
	}
	
	//Set the seat number
	public void setSeatNum(String sNum) {
		seatNum = sNum;
	}
	
	//Set the flight number
	public void setFlightNum(String fNumber) {
		flightNum = fNumber;
	}
	
	//Set the city from which the flight departs
	public void setDepartureCity(String dCity) {
		departureCity = dCity;
	}
	
	//Set the departure time
	public void setDepartureTime(String dTime) {
		departureTime = dTime;
	}
	
	//Set the city where the plane lands
	public void setArrivalCity(String aCity) {
		arrivalCity = aCity;
	}
	
	//Set the arrival time
	public void setArrivalTime(String aTime) {
		arrivalTime = aTime;
	}
	
	//Get the number of seats
	public int getNumSeat() {
		return numSeat;
	}
	
	//Get the seat number
	public String getSeatNum() {
		return seatNum;
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
		
		result = "The seat number:"+"\n"+seatNum+"\n"+"The flight number:"+"\n"+flightNum+"\n"+"Depats from:"+"\n"+departureCity+"\n"+departureTime+"\n"+"Arrives at:"+"\n"+arrivalCity+"\n"+arrivalTime+"\n";
		
		return result;
	}

}
