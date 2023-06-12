public class Dormitory {
	
	public Dormitory(String name, int numberOfRooms) {
		this(name, numberOfRooms, 6);
	}
	
	public Dormitory(String name, int numberOfRooms, int maxRoomCapacity) {
		int i;
		
		if(	numberOfRooms > 0 &&
			maxRoomCapacity > 0 ) {
			this.name = name;
			this.numberOfRooms = numberOfRooms;
			this.maxRoomCapacity = maxRoomCapacity;
			rooms = new Room[numberOfRooms];
			
			for( i = 0; i < rooms.length; i++ )
				rooms[i] = new Room(i+1, maxRoomCapacity);
		}
		else
			System.out.println("INVALID DORMITORY SPECIFICATIONS");
	}
	
	public String getDormitoryName() {
		return name;
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	public boolean acceptGuest(int roomNum, Person guest) {
		int i;
		if(guest != null)
			for( i = 0; i < rooms.length; i++ )
				if( rooms[i].getRoomNum() == roomNum )
					return rooms[i].addGuest(guest);
		return false;	
	}
	
	public Person[] getListOfGuests(int roomNumber) {
		int i;
		for( i = 0; i < rooms.length; i++ )
			if( rooms[i].getRoomNum() == roomNumber )
				return rooms[i].getGuests();
		return null;
	}
	
	public int getMaxRoomCapacity() {
		return maxRoomCapacity;
	}
	
	/*
	public void removeGuest(Person guest) {
		int i;
		int j;
		for( i = 0; i < rooms.length; i++ ) {
			if( rooms[i].isEmpty() == false ) 
				for( j = 0; j < rooms[i].getMaxCapacity(); j++ ) 
					if( rooms[i].getGuests()[j] == guest)
						break;
			if( j < rooms[i].getMaxCapacity() ) {
				rooms[i].removeGuest(j);
				break;
			}
		}
	}
	*/
	
	/**
	
		@return room number of the first unoccupied room in the room array, -1 if all rooms are full
	*/
	/*
	public int findUnoccupiedRoom() {
		int i;
		
		i = 0;
		while( i < rooms.length && rooms[i].isEmpty() == false )
			i++;
		
		if( i < rooms.length )
			return rooms[i].getRoomNum();
		else
			return -1;
	}
	*/
	
	
	/**
	
		@return room number of the guest, -1 if guest not found
	*/
	/*
	public int findRoomOfGuest(Person guest) {
		int i;
		int j;
		Person[] guests;
		
		for( i = 0; i < rooms.length; i++ ) {
			guests = rooms[i].getGuests();
			for( j = 0; j < guests.length; j++ )
				if( guests[j] == guest )
					return rooms[i].getRoomNum();
		}
		return -1;
	}
	*/

	
	private String name; // dormitory's name
	private int numberOfRooms; // number of rooms in the dormitory
	private Room[] rooms;
	private int maxRoomCapacity; // maximum number of guests per room

}