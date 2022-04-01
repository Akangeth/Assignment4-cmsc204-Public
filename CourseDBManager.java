import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Let user read courses from a file
 * @author Allan Kangethe
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure structure;

	public CourseDBManager() {
		structure = new CourseDBStructure(100);
	}

	/**
	 * Adds a course (CourseDBElement) with the given information to
	 * CourseDBStructure.
	 * 
	 * @param id         course id
	 * @param crn        course crn
	 * @param credits    number of credits
	 * @param roomNum    course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(element);
	}

	/**
	 * finds CourseDBElement based on the crn key
	 * 
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		int index = crn % structure.size;
		if (!(structure.table.get(index) == null)) {
			for (int i = 0; i < structure.table.get(index).size(); i++) {
				if (crn == structure.table.get(index).get(i).getCRN())
					return structure.table.get(index).get(i);
			}
		}
		return null;

	}

	/**
	 * Reads the information of courses from a test file and adds them to the
	 * CourseDBStructure data structure
	 * 
	 * @param input input file
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc;

		try {
			sc = new Scanner(input);
			while (sc.hasNextLine()) {
				String str = sc.nextLine();
				String[] lineSplit = str.split("\\s+");
				String course = lineSplit[0];
				int crn = Integer.parseInt(lineSplit[1]);
				int credits = Integer.parseInt(lineSplit[2]);
				String roomNum = lineSplit[3];
				String instructor = lineSplit[4];
				add(course, crn, credits, roomNum, instructor);
				lineSplit = null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @return an array list of string representation of each course in the data
	 *         structure separated by a new line.
	 * 
	 */
	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		return structure.showAll();
	}

}
