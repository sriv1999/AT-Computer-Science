package maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentGradeMap2{
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
	public static void printGrades(Map<Student, String> gradeMap) {
		System.out.println("List of Students and Grades");
		System.out.println();
		for (Student e : gradeMap.keySet()) {
			System.out.println(e + " - " + gradeMap.get(e));
		}
		System.out.println();
	}

	/**
	 * Modifies an entry based on user input. Prints an error if an invalid
	 * student is modified
	 * 
	 * @param gradeMap
	 *            the map to modify
	 * @param idToStudentMap
	 *            the map to associate student id with a student
	 */
	public static void modifyStudent(Map<Student, String> gradeMap, Map<Integer, Student> idToStudentMap) {
		System.out.println("Enter student id to modify: ");
		int studentID = Integer.parseInt(in.nextLine());
		if (!idToStudentMap.containsKey(studentID))
			System.out.println("Student not found");
		else {
			Student temp = idToStudentMap.get(studentID);
			System.out.println("Enter new grade: ");
			String grade = in.nextLine();
			gradeMap.put(temp, grade);
			System.out.println("Student grade modified");
		}
	}

	/**
	 * Removes a student from the map based on user input
	 * 
	 * @param gradeMap
	 *            the map to remove the student from
	 * @param idToStudentMap
	 *            the map to associate student id with a student
	 */
	public static void removeStudent(Map<Student, String> gradeMap, Map<Integer, Student> idToStudentMap) {
		System.out.println("Enter student id to remove: ");
		int studentID = Integer.parseInt(in.nextLine());
		if (!idToStudentMap.containsKey(studentID))
			System.out.println("Student not found");
		else {
			Student temp = idToStudentMap.get(studentID);
			gradeMap.remove(temp);
			System.out.println("Student removed");
		}
	}

	/**
	 * Adds a student based on user input. Prints an error if a student is added
	 * that already exists in the map.
	 * 
	 * @param idToGradeMap
	 *            the map to add the student to
	 * @param idToStudentMap
	 *            the map to associate student id with a student
	 */
	public static void addStudent(Map<Student, String> gradeMap, Map<Integer, Student> idToStudentMap) {
		System.out.println("Enter student first name: ");
		String studentFirst = in.nextLine();
		System.out.println("Enter student last name: ");
		String studentLast = in.nextLine();
		System.out.println("Enter student id: ");
		int studentID = Integer.parseInt(in.nextLine());

		Student temp = new Student(studentFirst, studentLast, studentID);
		if (idToStudentMap.containsKey(studentID))
			System.out.println("Student duplicate");
		else {
			System.out.println("Enter grade: ");
			String grade = in.nextLine();
			idToStudentMap.put(studentID, temp);
			gradeMap.put(temp, grade);
			System.out.println("Student added");
		}
	}
	
	public static void main(String[] args) {
		Map <Student, String> one = new TreeMap<Student, String> ();
		Map <Integer, Student> two = new TreeMap<Integer, Student> ();
		boolean quit = false;
		while (!quit){
			printMenuAndGetChoice();
			System.out.println();
			System.out.println("Enter choice: ");
			String choice = in.nextLine();
			if (choice.equalsIgnoreCase("A"))
				printGrades(one);
			else if (choice.equalsIgnoreCase("B"))
				modifyStudent(one, two);
			else if (choice.equalsIgnoreCase("C"))
				addStudent(one, two);
			if (choice.equalsIgnoreCase("D"))
				removeStudent(one, two);
			System.out.println("Would you like to quit?");
			String result = in.nextLine();
			if (result.equalsIgnoreCase("Y"))
				quit = true;
		}

	}
}