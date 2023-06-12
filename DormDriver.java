import java.util.*;


/** The class DormDriver simulates building
  * dorms and people entering dorms and their
  * rooms
  
  * @author Paul Josef P. Agbuya
  * @author Vince Kenneth D. Rojo
  * @author Acemere F. Villena
  * @version 1.0
  */
public class DormDriver
{
    public void display(Room room)
	{
		/* display all the guests in the room */
		int i;
		int j;
		Person[] guests;
		guests = room.getGuests();
		System.out.println(
			"Guests in Room No. " + room.getRoomNum());
		
		i = 0;
		j = 1;
		while( j <= room.getNumOccupants() && i < room.getMaxCapacity() ) {
			if( guests[i] != null ) {
				System.out.println(
				j + ".) " + guests[i].getName() + ", " + guests[i].getNationality());
				j++;
			}
			i++;
		}
	}
	
	public void displayDorms(Dormitory[] dorms)
	{
		int i;
		int j;
		int numberOfNotFullRooms;
		
		System.out.println();
		
		for (i = 0; i < dorms.length; i++)
		{
			/* display the name of the dorm, the total
			   number of rooms, and the number of rooms
			   that are not full yet */
			numberOfNotFullRooms = 0;
			for( j = 0; j < dorms[i].getNumberOfRooms(); j++ )
				if( dorms[i].getRooms()[j].isFull() == false )
					numberOfNotFullRooms++;
	
			System.out.println(
				dorms[i].getDormitoryName() +
				"\nNumber of Rooms: " +
				dorms[i].getNumberOfRooms() +
				"\nNumber of Rooms Not Full: " +
				numberOfNotFullRooms);

			/* 
			   Display all the names and nationalities
			   of the guests in each room. Part of the 
			   solution is to call the method display() 
			   in DormDriver. Provide your code */

			for( j = 0; j < dorms[i].getNumberOfRooms(); j++ )
				if( dorms[i].getRooms()[j].isEmpty() == false )
					display( dorms[i].getRooms()[j] );
				else
					System.out.println(
						"Room No. " + dorms[i].getRooms()[j].getRoomNum() + " is Empty");
						
			System.out.println();
		}
	}
	
	
	public static void main(String[] args)
	{
		Dormitory[] dorms = new Dormitory[2];
		DormDriver dormDriver = new DormDriver(); // NEW LINE
		int i; // NEW LINE
		int j; // NEW LINE
		//int roomNum; // NEW LINE
		//Person[] guests; // NEW LINE
		
		dorms[0] = new Dormitory("LS Dorm", 3);
		dorms[1] = new Dormitory("STC Dorm", 5, 4);

		ArrayList<Person> guests = new ArrayList<Person>();
		guests.add(new Person("Andrew", "Filipino"));
		guests.add(new Person("Miguel", "Filipino"));
		guests.add(new Person("Henry", "American"));
		guests.add(new Person("Ray", "Filipino"));
		guests.add(new Person("Bernie", "Filipino"));
		guests.add(new Person("Michael", "Singaporean"));
		guests.add(new Person("Victor", "Filipino"));
		guests.add(new Person("Dennis", "Filipino"));
		guests.add(new Person("Jaime", "Filipino"));
		
		/* Have all Filipinos be in the same room, as
		   long as they fit.  Following first come, first
		   served, those who do not fit will be assigned 
		   to the next room. Use the first dormitory for 
		   the Filipinos.  For the other nationalities, 
		   they will be assigned to the second dormitory in
		   separate rooms. Provide your code.
		*/
		
		for( i = 0; i < guests.size(); i++ ) {
			if( guests.get(i).getNationality().equalsIgnoreCase("Filipino") ) {
				j = 1;
				while( j <= dorms[1].getRooms()[0].getGuests().length &&
					dorms[0].acceptGuest( j, guests.get(i) ) == false)
					j++;
				}
			else {
				j = 1;
				while( j <= dorms[1].getRooms()[0].getGuests().length &&
					dorms[1].acceptGuest( j, guests.get(i) ) == false)
					j++;
			}
		}
		
		
		
		/* Provide your code to call displayDorms() in
		   class DormDriver. */
		dormDriver.displayDorms(dorms);
 		   




		/* Provide code to transfer Ray to STC Dorm, and
			he wants to be assigned to a currently unoccupied
			room. */
		System.out.println("\n\nTransfering Ray");
		for( i = 0; i < dorms[0].getRooms().length; i++ ) {
			for( j = 0; j < dorms[0].getRooms()[i].getGuests().length; j++ )
				if( dorms[0].getRooms()[i].getGuests()[j] != null &&
					dorms[0].getRooms()[i].getGuests()[j].getName().equalsIgnoreCase("Ray") ) {
					dorms[0].getRooms()[i].removeGuest(j);
					break;
				}
			if( j < dorms[0].getRooms()[i].getGuests().length )
				break;
		}
	
		i = 0;
		while( dorms[1].getRooms()[i].isEmpty() == false )
			i++;
		if( i < dorms[1].getRooms().length )
			dorms[1].acceptGuest( dorms[1].getRooms()[i].getRoomNum(), guests.get(3) );
	
	
		/* Provide code to transfer Michael to the same room 
		   as Miguel */
		System.out.println("\n\nTransfering Michael");   
		for( i = 0; i < dorms[1].getRooms().length; i++ ) {
			for( j = 0; j < dorms[1].getRooms()[i].getGuests().length; j++ )
				if( dorms[1].getRooms()[i].getGuests()[j] != null &&
					dorms[1].getRooms()[i].getGuests()[j].getName().equalsIgnoreCase("Michael") ) {
					dorms[1].getRooms()[i].removeGuest(j);
					break;
				}
			if( j < dorms[1].getRooms()[i].getGuests().length )
				break;
		}
		
		for( i = 0; i < dorms[0].getRooms().length; i++ ) {
			for( j = 0; j < dorms[0].getRooms()[i].getGuests().length; j++ )
				if( dorms[0].getRooms()[i].getGuests()[j] != null &&
					dorms[0].getRooms()[i].getGuests()[j].getName().equalsIgnoreCase("Miguel") )
					break;
			if( j < dorms[0].getRooms()[i].getGuests().length )
				break;
			i++;
		}
		dorms[0].acceptGuest( dorms[0].getRooms()[i].getRoomNum(), guests.get(5) );
	
		

		/* Provide your code to call displayDorms() in
		   class DormDriver. */
		dormDriver.displayDorms(dorms);

		   
		guests = null;
		dorms = null;
		System.gc();
	}
}
