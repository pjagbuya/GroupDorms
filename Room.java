public class Room
{
	public Room(int roomNum, int maxCapacity)
	{
              //Provide code 

	}
	
	public boolean addGuest(Person guest)
	{ 
              //Provide code 
	}
	
	public boolean isFull()
	{
              //Provide code 
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int getMaxCapacity()
	{
		return MAX;
	}

	public int getRoomNum()
	{
		return NUM;
	}
	
	public Person[] getGuests()
	{
		return guests;
	}
	
	public int getNumOccupants()
	{
		return size;
	}
	
	public void removeGuest(int index)
	{
              //Provide code 
	}
	
	private final int MAX; //max number of guests
	private final int NUM; //room number
	private Person[] guests;  //do not change to ArrayList
	private int size; //current number of guests in room
}
