public class Room
{
	public Room(int roomNum, int maxCapacity)
	{
		NUM = roomNum;
		MAX = maxCapacity;
		guests = new Person[maxCapacity];
		size = 0;
	}
	
	public boolean addGuest(Person guest)
	{ 
        int i = 0;
		while( i < MAX && guests[i] != null )
			i++;
		if( i < MAX ) {
			guests[i] = guest;
			size++;
			return true;
		}
		return false;
	}
	
	public boolean isFull()
	{
        return size == MAX;
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
