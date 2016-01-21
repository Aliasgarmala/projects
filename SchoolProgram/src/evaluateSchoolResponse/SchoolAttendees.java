package evaluateSchoolResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Question 3
 */
public class SchoolAttendees {
	public static void main (String[] args) throws IOException{
		
		BufferedReader br = null;
		InputStreamReader isr = null;
		String line = null;
		String input = null;

		String[][] attendees = new String[4096][];
		int numberOfPeople = 0;
		//should use FileReader for text data
		FileReader fr = new FileReader("q3_data.txt");
		br = new BufferedReader(fr);
		line = br.readLine();
		
		/*Parse the string data 
		 * Make a 2d String array with dimensions:
		 * #ofPeople x #ofFields
		 * Fields are indexed by:
		 * 0 - Name
		 * 1 - Occupation
		 * 2 - Tuition/Salary
		 * 3 - Subject 1
		 * 4 - Subject 2
		 * 5 - Subject 3
		 * 6 - Subject 4
		 */
		while (line!=null) {
			attendees[numberOfPeople] = new String[7];
			int fieldCount = 0;
			while(true) {
				attendees[numberOfPeople][fieldCount] = line;
				fieldCount++;
				line = br.readLine();
				if (line == null || line.trim().length() == 0) {
					fieldCount = 0;
					line = br.readLine();
					break;
				}
			}
			numberOfPeople++;
		}
		//close the resource
		br.close();
		
		
		
		//Run the program
		System.out.println ("######################################");
		System.out.println ("-------XYZ School Attendees List-------");
		System.out.println ("######################################");
		System.out.println ("Commands:");
		System.out.println ("t - list teachers");
		System.out.println ("s - list students");
		System.out.println ("j - list attendees by subject");
		System.out.println ("q - quit");
		
		while(true) {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			input = br.readLine();
			
			//list teachers
			if (input.equals("t")) {
				int numberOfTeachers = 0;
				for (int i =0; i < numberOfPeople; i ++) {
					if (attendees[i][1].equalsIgnoreCase("teacher")) {
						System.out.println("Name: " + attendees[i][0]);
						System.out.println("Occupation: " + attendees[i][1]);
						System.out.println("Salary: $" + attendees[i][2]);
						System.out.println("Subject 1: " + attendees[i][3]);
						System.out.println("Subject 2: " + attendees[i][4]);
						System.out.println("Subject 3: " + attendees[i][5]);
						System.out.println("Subject 4: " + attendees[i][6]);
						System.out.println();
						numberOfTeachers++;
					}
				}
				System.out.println("Total: " + numberOfTeachers);
				
			//list students
			} else if (input.equals("s")) {
				int numberOfStudents = 0;
				for (int i =0; i < numberOfPeople; i ++) {
					if (attendees[i][1].equalsIgnoreCase("student")) {
						System.out.println("Name: " + attendees[i][0]);
						System.out.println("Occupation: " + attendees[i][1]);
						System.out.println("Tuition: $" + attendees[i][2]);
						System.out.println("Subject 1: " + attendees[i][3]);
						System.out.println("Subject 2: " + attendees[i][4]);
						System.out.println("Subject 3: " + attendees[i][5]);
						System.out.println("Subject 4: " + attendees[i][6]);
						System.out.println();
						numberOfStudents++;
					}
					
				}
				System.out.println("Total: " + numberOfStudents);
				
			//list attendees
			} else if (input.equals("j")) {
				System.out.println("Please enter the subject name:");
				isr = new InputStreamReader(System.in);
				br = new BufferedReader(isr);
				input = br.readLine();
				int numberOfPeopleWithSubject = 0;
				for (int i = 0; i < numberOfPeople; i++) {
					if (attendees[i][3].equalsIgnoreCase(input) ||
						attendees[i][4].equalsIgnoreCase(input) ||
						attendees[i][5].equalsIgnoreCase(input) ||
						attendees[i][6].equalsIgnoreCase(input)) { 
							System.out.println("Name: " + attendees[i][0]);
							System.out.println("Occupation: " + attendees[i][1]);
							if (attendees[i][1].equals("teacher")) {
								System.out.println("Salary: $" + attendees[i][2]);
							} else if (attendees[i][1].equals("student")) {
								System.out.println("Tuition: $" + attendees[i][2]);
							}
							System.out.println("Subject 1: " + attendees[i][3]);
							System.out.println("Subject 2: " + attendees[i][4]);
							System.out.println("Subject 3: " + attendees[i][5]);
							System.out.println("Subject 4: " + attendees[i][6]);
							System.out.println();
							numberOfPeopleWithSubject++;
					}
				}
				System.out.println("Total: " + numberOfPeopleWithSubject);
			
			//quit
			} else if (input.equals("q")) {
				//free all the resources
				input = null;
				isr.close();
				br.close();
				System.out.println("Exiting...");
				System.exit(0);
			} 
		}
	}
}
