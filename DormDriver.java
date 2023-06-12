import java.util.*;

/*
	javac DormDriver.java && javac Room.java && javac Person.java && javac Dormitory.java
*/

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
	/* display all the guests in the given room */
    public void display(Room room)
	{
		int i;
		int j;
		Person[] guests;
		guests = room.getGuests();
		System.out.println(
			"Guests in Room No. " + room.getRoomNum());
		
		/* displays guests' information, in the order in which they appear in the guests[] array, and numbers them */
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
	
	
	
	/* displays information about each dormitory */
	public void displayDorms(Dormitory[] dorms)
	{
		int i;
		int j;
		int numberOfNotFullRooms;
		
		System.out.println();
		
		/* runs once through the array of dormitories */
		for (i = 0; i < dorms.length; i++)
		{
			
			/* counts no. of rooms that are not full */
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

			/* displays each room's guest list, unless room is empty, in which case it displays a message saying the room is empty */
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
		DormDriver dormDriver = new DormDriver();
		int i;
		int j;
		Person[] listOfGuests;
		
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
		
		
		/* runs once through the guests ArrayList */
		/* sorts Filipinos into LS Dorm, filling up the 1st room before filling in the next one*/
		/* sorts Non-Filipinos into STC Dorm, separating them into different rooms */
		for( i = 0; i < guests.size(); i++ ) {
			if( guests.get(i).getNationality().equalsIgnoreCase("Filipino") ) {
				j = 1; // here, j represents room number, not an index
				while( j <= dorms[0].getRooms()[0].getMaxCapacity() &&
					dorms[0].acceptGuest( j, guests.get(i) ) == false )
					j++;
				}
			else {
				j = 1; // here, j represents room number, not an index
				while( j <= dorms[1].getNumberOfRooms() )
					if( dorms[1].getRooms()[j-1].isEmpty() &&
						dorms[1].acceptGuest(j, guests.get(i)) )
						break;
					else
						j++;
			}
		}
		
		
		
		dormDriver.displayDorms(dorms);
 		
		
		
		System.out.println("\n\nTransfering Ray");
		
		/* finds 1st guest named "Ray" in LS Dorm and deletes him */
		for( i = 0; i < dorms[0].getNumberOfRooms(); i++ ) {
			listOfGuests = dorms[0].getListOfGuests(i+1);
			for( j = 0; j < dorms[0].getRooms()[i].getMaxCapacity(); j++ )
				if( listOfGuests[j] != null &&
					listOfGuests[j].getName().equalsIgnoreCase("Ray") ) {
					dorms[0].getRooms()[i].removeGuest(j);
					break;
				}
			if( j < dorms[0].getRooms()[i].getMaxCapacity() )
				break;
		}
		/* adds Ray to 1st empty room in STC Dorm */
		i = 0;
		while( i < dorms[1].getNumberOfRooms() &&
			dorms[1].getRooms()[i].isEmpty() == false )
			i++;
		dorms[1].acceptGuest( i+1, guests.get(3) );
		
		
		
		
		System.out.println("\n\nTransfering Michael");
		
		/* finds 1st guest named "Michael" in STC Dorm and deletes him */
		for( i = 0; i < dorms[1].getNumberOfRooms(); i++ ) {
			listOfGuests = dorms[1].getListOfGuests(i+1);
			for( j = 0; j < dorms[1].getRooms()[i].getMaxCapacity(); j++ )
				if( listOfGuests[j] != null &&
					listOfGuests[j].getName().equalsIgnoreCase("Michael") ) {
					dorms[1].getRooms()[i].removeGuest(j);
					break;
				}
			if( j < dorms[1].getRooms()[i].getMaxCapacity() )
				break;
		}
		/* adds Michael to 1st room in LS Dorm with a "Miguel" */
		for( i = 0; i < dorms[0].getNumberOfRooms(); i++ ) {
			listOfGuests = dorms[0].getListOfGuests(i+1);
			for( j = 0; j < dorms[0].getRooms()[i].getMaxCapacity(); j++ )
				if( listOfGuests[j] != null &&
					listOfGuests[j].getName().equalsIgnoreCase("Miguel") )
					break;
			if( j < dorms[0].getRooms()[i].getMaxCapacity() )
				break;
		}
		dorms[0].acceptGuest( i+1, guests.get(5) );
		
		
		
		dormDriver.displayDorms(dorms);
		
		   
		guests = null;
		dorms = null;
		System.gc();
	}
}
