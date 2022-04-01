/**
 * CourseDBElement
 * @author Allan Kangethe
 *
 */
public class CourseDBElement implements Comparable<CourseDBElement>
{
	private String ID, room, instructor;
	private int CRN, credits;
	
	public CourseDBElement()
	{
		this(null,0,0,null,null);
	}
	public CourseDBElement(int CRN)
	{
		this.CRN=CRN;
	}
	public CourseDBElement(String ID, int CRN, int credits, String room, String instructor)
	{
		this.ID=ID;
		this.CRN=CRN;
		this.credits=credits;
		this.room=room;
		this.instructor=instructor;
	}
	/**
	 * Gets CRN as a string
	 * @return crn as a string
	 */
	public String getHash() {
		return "" + CRN;
	}
	/**
	 * Gets course ID
	 * @return ID - course ID
	 */
	public String getID() {
		return ID;
	}
	/**
	 * Sets the course ID
	 * @param ID - course ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * Gets the CRN of the class
	 * @return CRN - Class CRN
	 */
	public int getCRN() {
		return CRN;
	}
	/**
	 * Sets the CRN of the class
	 * @param CRN - Class CRN
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;
	}
	/**
	 * Gets the credits of the class
	 * @return credits - Class credits
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * Sets the credits of the class
	 * @param credits - Class credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	/**
	 * Gets the room number of the class
	 * @return room - Class room number
	 */
	public String getRoomNum() {
		return room;
	}
	/**
	 * Sets the room number of the class
	 * @param room - Class room number
	 */
	public void setRoomNum(String room) {
		this.room = room;
	}
	/**
	 * Gets the name of the instructor
	 * @return instructor - Instructor name
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * Sets the name of instructor
	 * @param instructor - Instructor name
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Override
	public int compareTo(CourseDBElement o) {
		return 0;
	}
	/**
	 * Puts all of the values of element into a string
	 * @return str - a string with all values of the element
	 */
	@Override
	public String toString() {
		String str = "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + instructor
				+ " Room:" + room;
		return str;
	}
	
}