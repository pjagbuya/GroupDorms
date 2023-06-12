import java.util.*;

public class DormDriver
{
    public void display(Room room)
	{
		/* display all the guests in the room */
		int i;
		Person[] guests;
		System.out.println(
			"Guests in Room No. " + room.getRoomNum());
		
		
		guests = room.getGuests();
		for( i = 0; i < room.getMaxCapacity; i++ )
			System.out.println(
				(i+1) + ".) " + guests[i].getName() + ", " + guests[i].getNationality());
	}
	
	public void displayDorms(Dormitory[] dorms)
	{
		int i;
		int j;
		int numberOfNotFullRooms = 0;
		Room room;
		
		
		for (i = 0; i < dorms.length; i++)
		{
			/* display the name of the dorm, the total
			   number of rooms, and the number of rooms
			   that are not full yet */
			
			for( j = 0; j < dorms[i].getNumberOfRooms(); j++ )
				if( dorms[i].getRoom(j+1).isFull == FALSE )
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
				if( dorms[i].getRoom(j+1).isEmpty() == FALSE )
					display(dorms[i].getRoom(j+1));
				else
					System.out.println(
						"Room No. " + (j+1) +" is Empty");
		}
	}
	
	
	public static void main(String[] args)
	{
		Dormitory[] dorms = new Dormitory[2];
		DormDriver dormdriver = new DormDriver();
		
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
		
		
		/* Provide your code to call displayDorms() in
		   class DormDriver. */
 		   

		/* Provide code to transfer Ray to STC Dorm, and
			he wants to be assigned to a currently unoccupied
			room. */
		System.out.println("\n\nTransfering Ray");
	
		
		
		/* Provide code to transfer Michael to the same room 
		   as Miguel */
		System.out.println("\n\nTransfering Michael");   
		
	
		

		/* Provide your code to call displayDorms() in
		   class DormDriver. */


		   
		guests = null;
		dorms = null;
		System.gc();
	}
}
