public class Room
{
	public Room(int roomNum, int maxCapacity)
	{
		NUM = roomNum;
		MAX = maxCapacity;
		guests = new Person[maxCapacity];
	}
	
	public boolean addGuest(Person guest)
	{ 
        int i = 0;
		while( i < MAX && guests[i] != NULL )
			i++;
		if( i < MAX ) {
			guests[i] = guest;
			size++
			return true;
		}
		return false;
	}
	
	public boolean isFull()
	{
        return size == NUM;
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
		if( guests[index] != NULL ) {	
			guests[index] = NULL;
			size--;
		}
	}
	
	private final int MAX; //max number of guests
	private final int NUM; //room number
	private Person[] guests;  //do not change to ArrayList
	private int size; //current number of guests in room
}
