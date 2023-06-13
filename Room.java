/** The class Room represents a room
  * that is built within a dorm
  *
  * @author Paul Josef P. Agbuya
  * @author Vince Kenneth D. Rojo
  * @author Acemere F. Villena
  * @version 1.0
  */
public class Room
{
	/**
	 * This is a constructor that initializes the room number and capacity
	 * of this room based on the given parameters. 
	 * 
	 * @param roomNum the number that this room is labeled as
	 * @param maxCapacity the capacity of this Room
	 */
	public Room(int roomNum, int maxCapacity)
	{
		NUM = roomNum;
		MAX = maxCapacity;
		guests = new Person[maxCapacity];
		size = 0;
	}
	
	/**
	 * This method returns true if the guest is successfully added, otherwise
	 * it returns false. It also returns false if the guest is null.
	 * 
	 * @param guest is a Person that is trying to be added to a room
	 * @return true if the guest is added successfully added to the room, otherwise
	 *         return false
	 */
	public boolean addGuest(Person guest)
	{ 
        int i = 0;

		if(guest == null){
			return false;
		}

		while( i < MAX && guests[i] != null )
			i++;
		if( i < MAX ) {
			guests[i] = guest;
			size++;
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if the Room capacity has already been reached
	 * by its current size of people inside
	 * 
	 * @return true if the Room is full, otherwise false
	 */
	public boolean isFull()
	{
        return size == MAX;
	}
	

	/**
	 * This method checks if the room is currently Empty
	 * 
	 * @return true if the rooms if empty or the size is 0, false otherwise
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	

	/**
	 * This method gets the max capacity of this room
	 * 
	 * @return the positive integer representing the max capacity of the room
	 */
	public int getMaxCapacity()
	{
		return MAX;
	}


	/**
	 * This method get the room number that this room is assigned as
	 * 
	 * @return the room number of this room
	 */
	public int getRoomNum()
	{
		return NUM;
	}
	

	/**
	 * This method returns an array of Persons that represents
	 * guests currently present in a room
	 * 
	 * @return array of guests occupying the room
	 */
	public Person[] getGuests()
	{
		return guests;
	}
	
	/**
	 * This method returns the number of guests occupying the room
	 * 
	 * @return the current number of guests in a room
	 */
	public int getNumOccupants()
	{
		return size;
	}
	

	/**
	 * This method rmeoves a guest based on the given parameter as index
	 * of an array in the list of guests. It first checks if the given index is
	 * negative or over the maximum capacity, it would return if these conditions
	 * are true.
	 * 
	 * @param index the number representing the index in the array of guests
	 */
	public void removeGuest(int index)
	{
		if(index < 0 || index >= MAX){
			return;
		}

		if( guests[index] != null ) {
			guests[index] = null;
			size--;
		}
	}
	
	private final int MAX; //max number of guests
	private final int NUM; //room number
	private Person[] guests;  //do not change to ArrayList
	private int size; //current number of guests in room
}
