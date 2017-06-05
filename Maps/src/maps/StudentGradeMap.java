package maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentGradeMap {
	static Scanner in = new Scanner(System.in);
	/**
	 * Prints the options menu and returns the letter that the user types does
	 * not check for invalid selection
	 * 
	 * @return the next token on the input stream
	 */
	public static void printMenuAndGetChoice() {
		System.out.println("A) Print Grades");
		System.out.println("B) Modify Grades");
		System.out.println("C) Add Grades");
		System.out.println("D) Remove Grades");
	}

	/**
	 * Prints the students and grades
	 * 
	 * @param gradeMap
	 *            the map to print
	 */
	public static void printGrades(Map<String, String> gradeMap) {
		System.out.println("List of Students and Grades");
		System.out.println();
		for (String e : gradeMap.keySet()){
			System.out.println(e + ": " + gradeMap.get(e));
		}
		System.out.println();
	}

	/**
	 * Modifies an entry based on user input. Prints an error if an invalid
	 * student is modified
	 * 
	 * @param gradeMap
	 *            the map to modify
	 */
	public static void modifyStudent(Map<String, String> gradeMap) {
		System.out.println("Enter student to modify: ");
		String student = in.nextLine();
		if (!gradeMap.containsKey(student))
			System.out.println("Student not found");
		else{
		System.out.println("Enter new grade: ");
		String grade = in.nextLine();
		gradeMap.put(student, grade);
		System.out.println("Student grade modified");
		}
	}

	/**
	 * Removes a student from the map based on user input
	 * 
	 * @param gradeMap
	 *            the map to remove the student from
	 */
	public static void removeStudent(Map<String, String> gradeMap) {
		System.out.println("Enter student to remove: ");
		String student = in.nextLine();
		if (!gradeMap.containsKey(student))
			System.out.println("Student not found");
		else{
		gradeMap.remove(student);
		System.out.println("Student removed");
		}
	}

	/**
	 * Adds a student based on user input. Prints an error if a student is added
	 * that already exists in the map.
	 * 
	 * @param gradeMap
	 *            the map to add the student to
	 */
	public static void addStudent(Map<String, String> gradeMap) {
		System.out.println("Enter student to add: ");
		String student = in.nextLine();
		System.out.println("Enter student grade: ");
		String grade = in.nextLine();
		if (gradeMap.containsKey(student))
			System.out.println("Student duplicate");
		else{
		gradeMap.put(student, grade);
		System.out.println("Student added");
		}
	}

	public static void main(String[] args) {
		Map <String, String> one = new TreeMap<String, String> ();
		boolean quit = false;
		while (!quit){
			printMenuAndGetChoice();
			System.out.println();
			System.out.println("Enter choice: ");
			String choice = in.nextLine();
			if (choice.equalsIgnoreCase("A"))
				printGrades(one);
			else if (choice.equalsIgnoreCase("B"))
				modifyStudent(one);
			else if (choice.equalsIgnoreCase("C"))
				addStudent(one);
			if (choice.equalsIgnoreCase("D"))
				removeStudent(one);
			System.out.println("Would you like to quit?");
			String result = in.nextLine();
			if (result.equalsIgnoreCase("Y"))
				quit = true;
		}

	}

}
