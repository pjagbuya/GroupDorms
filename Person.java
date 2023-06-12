/** The class Person represents a person
  * that has a name and nationality
  *
  * @author Paul Josef P. Agbuya
  * @author Vince Kenneth D. Rojo
  * @author Acemere F. Villena
  * @version 1.0
  */
public class Person{
  
	/**
	 * This is a constructor that initializes the name and nationality
	 * of a person, based on the given parameters.
	 * 
	 * @param name the String name of this person
	 * @param nationality the String nationality of this person
	 */
	public Person(String name, String nationality) {
		this.name = name;
		this.nationality = nationality;
	}
	

	/**
	 * This method gets the name of this person and returns it
	 * as a String
	 * 
	 * @return String representing the name of the person
	 */
	public String getName() {
		return name;
	}
	

	/**
	 * This method gets the nationality of this person
	 * 
	 * @return String representing the nationality of this person
	 */
	public String getNationality() {
		return nationality;
	}

	/**Name of this person */
	private String name;
	/**Nationality of this person */
	private String nationality;
}
