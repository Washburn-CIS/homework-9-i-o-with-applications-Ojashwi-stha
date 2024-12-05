import java.util.Scanner;

public class GradeBook {
    private static Student[] students;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // TODO: initialize students from contents of grades.txt file
        Scanner fileInput = new Scanner(new File("grades.txt"));
        int numStudents = Integer.parseInt(fileInput.nextLine());
        students = new Student[numStudents];
        while(fileInput.hasNext())
        {
            for(int i = 0; i < numStudents; i++)
            {
                String[] temp = fileInput.nextLine().split(",");
                students[i] = new Student();
                students[i].setFirstName(temp[0]);
                students[i].setLastName(temp[1]);
                students[i].setGrade(Double.parseDouble(temp[2]));
            }
        }
        System.out.println("Welcome to the CM111 Grade Book App!");

        while(true) {
            System.out.println("\nPlease make a selection:\n");
            System.out.println("1) List Class Grades");
            System.out.println("2) Update Grade");
            System.out.println("3) Exit");
            System.out.print("\nPlease choose an option: ");
            String choice = input.nextLine();
            System.out.println();
            switch(choice) {
                case "1": 
                    for(Student student: students) {
                        System.out.printf("%s, %s: %f%n", student.getFirstName(), 
                                                        student.getLastName(), 
                                                        student.getGrade());
                    }
                    break;
                case "2":
                    System.out.println("Enter First Name: ");
                    String fname = input.nextLine();
                    System.out.println("Enter Last Name: ");
                    String lname = input.nextLine();
                    
                    for(Student student: students) {
                        if(student.getFirstName().equals(fname) &&
                           student.getLastName().equals(lname)) {
                           System.out.println("Enter Grade: ");
                           student.setGrade(Double.parseDouble(input.nextLine()));
                           System.out.println("Grade updated");
                           break;
                        }
                    }
                    System.out.println("Student not found");
                    break;
                case "3":
                    // Challenge: write code to save the grades to grades.txt
                    PrintWriter fout = new PrintWriter(new File("grades.txt"));
                    fout.println(students.length);
                    for(int i = 0; i < students.length; i++){
                       fout.printf("%s,%s,%.2f%n",students[i].getFirstName(),
                                                  students[i].getLastName(),
                                                  students[i].getGrade());
                    }
                    fout.close();
                    System.out.println("Grades saved!");
                    continue;
                    System.out.println("Goodbye!");
                    return;

            }
        }
    }
}
