import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Used to create a hash table that has Linked List which contain
 * CourseDBElements in them.
 * 
 * @author Allan Kangethe
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	protected int size;
	protected ArrayList<LinkedList<CourseDBElement>> table;
	private final double load = 1.5;

	public CourseDBStructure(int num) {
		int d = (int) (num / load);
		for (int k = 0; k < d; k++) {
			if ((4 * k + 3) > d) {
				if (isPrime(4 * k + 3)) {
					int size = 4 * k + 3;
					this.size = size;
					table = new ArrayList<LinkedList<CourseDBElement>>(size);
					break;
				}
			}
		}

		for (int i = 0; i < size; i++) {
			table.add(new LinkedList<CourseDBElement>());
		}
	}

	public CourseDBStructure(String s, int n) {
		size = n;
		table = new ArrayList<LinkedList<CourseDBElement>>(size);
		for (int i = 0; i < size; i++) {
			table.add(new LinkedList<CourseDBElement>());
		}
	}

	private int getIndex(String hashS) {

		int hash = Integer.parseInt(hashS);
		return hash % size;
	}

	/**
	 * Adds a CourseDBElement object to the CourseDBStructure using the hashcode of
	 * the CourseDatabaseElemen object's crn value. If the CourseDatabaseElement
	 * already exists, exit quietly
	 * 
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = getIndex(element.getHash());

		if (!(table.get(index).contains(element))) {
			table.get(index).add(element);
		}
		for (int i = 0; i < table.get(index).size(); i++) {
			if (((CourseDBElement) table.get(index).get(i)).getCRN() == element.getCRN()) {
				if (!((CourseDBElement) table.get(index).get(i)).getID().equals(element.getID())) {
					table.get(index).add(element);
					table.get(index).remove(i);
				}
			}
		}

	}

	/**
	 * Find a courseDatabaseElement based on the crn of the courseDatabaseElement If
	 * the CourseDatabaseElement is found return it If not, throw an IOException
	 * 
	 * @param crn - crn (key) whose associated courseDatabaseElement is to be
	 *            returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int index = crn % size;
		if (!(table.get(index) == null)) {
			for (int i = 0; i < table.get(index).size(); i++) {
				if (crn == ((CourseDBElement) table.get(index).get(i)).getCRN())
					return ((CourseDBElement) table.get(index).get(i));
			}
		}
		throw new IOException();

	}

	/**
	 * Shows all of the elements in the hash table
	 * 
	 * @return all - all the elements in the hash table in an arraylist
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> all = new ArrayList<String>(size);

		for (int i = 0; i < size; i++) {
			if (!(table.get(i).isEmpty())) {
				all.add(table.get(i).toString().replace("[", "").replace("]", ""));
			}
		}
		return all;
	}

	/**
	 * Gets the size of the table
	 * 
	 * @return size
	 */
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return size;
	}

	/**
	 * Checks if number is prime or not
	 * 
	 * @param k - number that is being checked to see if it is prime or not
	 * @return true if k is prime
	 * @return false if k is not prime
	 */
	private static boolean isPrime(int k) {

		for (int i = 2; i < Math.sqrt(k); i++) {
			if (k % i == 0) {
				return false;
			}
		}

		return true;

	}

}