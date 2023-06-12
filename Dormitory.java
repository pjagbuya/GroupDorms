/** The class Dormitory represents a dorm
  * that is built in a particular building
  *
  * @author Paul Josef P. Agbuya
  * @author Vince Kenneth D. Rojo
  * @author Acemere F. Villena
  * @version 1.0
  */
public class Dormitory {
	

	/**
	 * This is a constructor that makes a Dormitory and initializes
	 * the name and number of its rooms based on the parameters. 
	 * The capacity of a room is by default set to 6
	 * @param name
	 * @param numberOfRooms
	 */
	public Dormitory(String name, int numberOfRooms) {
		this(name, numberOfRooms, 6);
	}
	

	/**
	 * This is a constructor that makes a Dormitory and initializes its
	 * name, number of its rooms, and max room capacity based on the parameters
	 * given. Checks if the parameters given are not null or zero first before 
	 * setting the attributes, otherwise it will print and Invalid Message
	 * 
	 * @param name the name of the Dormitory
	 * @param numberOfRooms the number of rooms that exist in a dorm
	 * @param maxRoomCapacity the max capacity of a room in a dorm
	 */
	public Dormitory(String name, int numberOfRooms, int maxRoomCapacity) {
		int i;
		
		if(	name != null &&
			name.length() > 0 &&
			numberOfRooms > 0 &&
			maxRoomCapacity > 0 )
		{
			this.name = name;
			this.numberOfRooms = numberOfRooms;
			rooms = new Room[numberOfRooms];
			for( i = 0; i < rooms.length; i++ )
				rooms[i] = new Room(i+1, maxRoomCapacity);
		}
		else
			System.out.println("INVALID DORMITORY SPECIFICATIONS");
	}
	

	/**
	 * This method returns the String representation of this Dormitory's name
	 * 
	 * @return String of the Dormitory's name
	 */
	public String getDormitoryName() {
		return name;
	}
	
	/**
	 * This method returns the number of rooms in the Dormitory
	 * 
	 * @return nuumber of room in the Dormitory
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	/**
	 * This method gets the array of rooms that exists within
	 * the Dormitory
	 * 
	 * @return the array representing the rooms that exist within the Dormitory
	 */
	public Room[] getRooms() {
		return rooms;
	}
	

	/**
	 * This method checks if the Dormitory can accept more guest depending
	 * if one of the rooms selected by room number has capacity to add the
	 * guest
	 * 
	 * @param roomNum the room number of a room
	 * @param guest the person that is requesting to be in a room
	 * @return true if the guest is successfully added in the room, false otherwise
	 */
	public boolean acceptGuest(int roomNum, Person guest) {
		if(	guest != null &&
			roomNum >= 1 &&
			roomNum <= numberOfRooms )
			return rooms[roomNum-1].addGuest(guest);
		return false;	
	}
	
	/**
	 * This method gets the list of guest in a room based on the parameter's
	 * given room numbers. If the room number does not exist, this method would
	 * return null
	 * 
	 * @param roomNumber the room number of this room
	 * @return the array of Person representing the guests in a room
	 */
	public Person[] getListOfGuests(int roomNumber) {
		if( roomNumber >= 1 && roomNumber <= numberOfRooms )
				return rooms[roomNumber-1].getGuests();
		return null;
	}
	

	
	private String name; // dormitory's name
	private int numberOfRooms; // number of rooms in the dormitory
	private Room[] rooms;
}