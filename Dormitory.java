public class Dormitory {
	
	public Dormitory(String name, String numberOfRooms) {
		this(name, numberOfRooms, 6);
	}
	
	public Dormitory(String name, String numberOfRooms, int maxRoomCapacity) {
		int i;
		
		if( numberOfRooms >= 0 && maxRoomCapacity >= 0 ) {
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
	
	public boolean acceptGuest(int roomNum; Person guest) {
		int i;
		if(guest != NULL)
			for( i = 0; i < rooms.length; i++ )
				if( rooms[i].getRoomNum() == roomNum )
					return rooms[i].addGuest(guest);
		return false;	
	}
	
	public Person[] getListOfGuests(int roomNumber) {
		for( i = 0; i < rooms.length; i++ )
			if( rooms[i].getRoomNum() == roomNum )
				return rooms[i].addGuest(guest);
	}
	
	public Room getRoom(int index) {
		return rooms[index];
	}

	
	private String name; // dormitory's name
	private int numberOfRooms; // number of rooms in the dormitory
	private Room[] rooms;
	private int maxRoomCapacity; // maximum number of guests per room

}