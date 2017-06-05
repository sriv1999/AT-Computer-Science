package maps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ClubMap {

	HashMap<String, HashSet<Student>> clubList;

	public ClubMap() {
		clubList = new HashMap<String, HashSet<Student>>();
	}

	public void join(String clubName, Student student) {
		if (!clubList.containsKey(clubName)) {
			HashSet<Student> set = new HashSet<Student>();
			set.add(student);
			clubList.put(clubName, set);
		}

		else
			clubList.get(clubName).add(student);
	}

	public void printAll() {
		for (String str : clubList.keySet()) {
			System.out.println(str + ": ");
			for (Student stu : clubList.get(str)) {
				System.out.print(stu + "\t");
			}
			System.out.println("\n");
		}
	}

	public void printClub(String clubName) {
		System.out.println(clubName + ": " + clubList.get(clubName));
	}

	public HashSet<Student> intersection(String club1, String club2) {
		HashSet<Student> set = clubList.get(club1);
		HashSet<Student> inter = new HashSet<Student>();
		for (Student stu : clubList.get(club2)) {
			if (set.contains(stu)) {
				inter.add(stu);
			}
		}
		return inter;
	}

	public HashSet<Student> union(String club1, String club2) {
		HashSet<Student> set = clubList.get(club1);
		HashSet<Student> union = new HashSet<Student>();
		for (Student stu : clubList.get(club1)) {
			union.add(stu);
		}
		for (Student stu : clubList.get(club2)) {
			if (!union.contains(stu))
				union.add(stu);
		}
		return union;
	}
	
	public static void main(String[] args) throws IOException{
		ClubMap map = new ClubMap();
		File file = new File("H:\\Files-AT\\students.txt");
		Scanner in = new Scanner(file);
		while (in.hasNext()){
			String lastName = in.next();
			String firstName = in.next();
			int id = Integer.parseInt(in.next());
			map.join(in.next(), new Student(firstName, lastName, id));
		}
		in.close();
		map.printAll();
	}

}
