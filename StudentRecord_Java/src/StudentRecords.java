import java.io.*;
import java.util.Scanner;

public class StudentRecords {
    public static void main(String[] args) throws IOException {
        //Import txt file
        File classList = new File("classList.txt");
        Scanner input = new Scanner(System.in);
        int choice = 0;
        //Repeat displaying the options
        do {
            Scanner infile = new Scanner(classList);
            System.out.println("\n" +
                    "Please enter your choice:\n"
                    + "1.\tTo display a specific student's record.\n"
                    + "2.\tTo calculate the final exam average.\n"
                    + "3.\tTo find a student with the highest score on the final exam.\n"
                    + "4.\tTo find the number of student records having score greater than or equal to 90.\n"
                    + "5.\tTo copy the students' record to another file\n"
                    + "6.\tTo terminate the program.");
            //Read the integer from user's input
            choice = input.nextInt();
            input.nextLine();

            //Call the method based on the choice
            switch (choice) {
                case 1:
                    //Read the name from user's input
                    System.out.println("Please enter the student's name:");
                    String studentName = input.nextLine();
                    //Search for the name in txt file and get the record
                    displayRecord(studentName, infile);
                    break;
                case 2:
                    //Search for the scores in txt file and calculate the average
                    findAverage(infile);
                    break;
                case 3:
                    //Search for the highest score
                    findHighest(infile);
                    break;
                case 4:
                    //Search for 90+ scores
                    find90Plus(infile);
                    break;
                case 5:
                    //Read name for the new file from user's input
                    System.out.println("Please enter the file name:");
                    String fileName = input.nextLine();
                    fileName += ".txt";
                    //Copy and paste
                    copyFile(fileName, infile);
                    break;
                case 6:
                default:
                    //End
                    System.exit(0);
            }
        } while (choice >=1 && choice < 6);
        input.close();
    }

    public static void displayRecord(String sname, Scanner sc) {
        boolean exist = false;
        //Skip the header line
        String line = sc.nextLine();
        //Repeat reading the record until the student name is found
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            int index = line.indexOf(":");
            if (index > 0) {
                //Get student id
                int ID = Integer.parseInt(line.substring(0, index));
                line = line.substring(index + 1);
                index = line.indexOf(":");
                if (index > 0) {
                    //Get student name
                    String student = line.substring(0, index);
                    //Display the record if matched
                    if (student.equalsIgnoreCase(sname)) {
                        exist = true;
                        //Get the score
                        double score = Double.parseDouble(line.substring(index + 1));
                        System.out.println("Student record found. Here is the information:");
                        System.out.println("Student ID: " + ID);
                        System.out.println("Student Name: " + sname);
                        System.out.println("Final Score: " + score);
                    }
                }
            }
        }
        //Display error if not found
        if (!exist) {
            System.out.println("No matching record found");
        }
    }

    public static void findAverage(Scanner sc) {
        double total = 0, avg = 0;
        int count = 0;
        //Skip the header line
        String line = sc.nextLine();
        //Read every record in the file
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            int index = line.indexOf(":");
            if (index > 0) {
                line = line.substring(index + 1);
                index = line.indexOf(":");
                if (index > 0) {
                    //Sum up all the scores and increase the count
                    total += Double.parseDouble(line.substring(index + 1));
                    count++;
                }
            }
        }
        //Calculate the average score if records exist
        if (count>0) {
            avg = total / count;
            System.out.println("The final exam average is " + avg);
        } else {
            System.out.println("No record found");
        }
    }

    public static void findHighest(Scanner sc) {
        int highID = 0;
        String highName = null;
        double highScore = 0;
        //Skip the header line
        String line = sc.nextLine();
        //Read every record in the file
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            int index = line.indexOf(":");
            if (index > 0) {
                int curID = Integer.parseInt(line.substring(0, index));
                line = line.substring(index + 1);
                index = line.indexOf(":");
                if (index > 0) {
                    String curName = line.substring(0, index);
                    //Get the score and compare with the current highest score
                    double curScore = Double.parseDouble(line.substring(index + 1));
                    if (curScore > highScore){
                        highID = curID;
                        highScore = curScore;
                        highName = curName;
                    }
                }
            }
        }
        //Display the result
        System.out.println("Student with the highest score on the final exam:\n");
        System.out.println("Student ID: " + highID);
        System.out.println("Student Name: " + highName);
        System.out.println("Highest Score: " + highScore);
    }

    public static void find90Plus(Scanner sc) {
        int count = 0;
        //Skip the header line
        String line = sc.nextLine();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            int index = line.indexOf(":");
            if (index > 0) {
                line = line.substring(index + 1);
                index = line.indexOf(":");
                if (index > 0) {
                    //Get the score and compare with 90, if it is greater than 90 then increase count
                    double curScore = Double.parseDouble(line.substring(index + 1));
                    if (curScore >= 90) {
                        count++;
                    }
                }
            }
        }
        //Display the count
        System.out.println(count);
    }

    public static void copyFile(String fname, Scanner sc) throws FileNotFoundException {
        //Create a new file with the name entered by the user
        PrintWriter pw = new PrintWriter(new File(fname));
        int count = 0;
        //Copy the header line and paste to the new file
        String line = sc.nextLine();
        pw.println(line);
        while (sc.hasNextLine()){
            //Copy and paste, count the number of records
            line = sc.nextLine();
            pw.println(line);
            count++;
        }
        //Display how many records have been copied after finished
        System.out.println(count+" records successfully copied to "+fname);
        pw.close();
    }
}
