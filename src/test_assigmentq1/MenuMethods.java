/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_assigmentq1;

//imports

import java.util.ArrayList;
import java.util.Scanner;
import static test_assigmentq1.Test_AssigmentQ1.intro;


public class MenuMethods {
    //Declaring all global objects,getters,setters,arraylists and variables
    
    int deleteIndex;

    public ArrayList<String> getStudentID() {
        return studentID;
    }

    public void setStudentID(ArrayList<String> studentID) {
        this.studentID = studentID;
    }

    public ArrayList<String> getStudentName() {
        return studentName;
    }

    public void setStudentName(ArrayList<String> studentName) {
        this.studentName = studentName;
    }

    public ArrayList<String> getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(ArrayList<String> studentAge) {
        this.studentAge = studentAge;
    }

    public ArrayList<String> getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(ArrayList<String> studentEmail) {
        this.studentEmail = studentEmail;
    }

    public ArrayList<String> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(ArrayList<String> studentCourse) {
        this.studentCourse = studentCourse;
    }

    ArrayList<String> studentID = new ArrayList<>();
    ArrayList<String> studentName = new ArrayList<>();
    ArrayList<String> studentAge = new ArrayList<>();
    ArrayList<String> studentEmail = new ArrayList<>();
    ArrayList<String> studentCourse = new ArrayList<>();

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudAge() {
        return studAge;
    }

    public void setStudAge(String studAge) {
        this.studAge = studAge;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getStudCourse() {
        return studCourse;
    }

    public void setStudCourse(String studCourse) {
        this.studCourse = studCourse;
    }

    private String studId;
    private String studName;
    private String studAge;
    private String studEmail;
    private String studCourse;

    int age = 0;

    //Will check if the age that the user has entered has a charcter that isnt an integer
    public void studentAgeInvalidChar(boolean ageIsValid, String stuAge) {
        try {
            age = Integer.parseInt(stuAge);

            ageIsValid = true;

        } catch (NumberFormatException e) {
            System.out.println("Invalid input, Please enter an integer value.");
        }
    }
    //will check if the age of the student is 16 years or higher and if not will re prompt the user to enter an age
    public void studentAgeInvalid(boolean ageIsValid, String stuAge) {
        Scanner sc = new Scanner(System.in);
        while (!ageIsValid) {
            System.out.println("Please enter student age:");
            stuAge = sc.nextLine();
            try {
                int age = Integer.parseInt(stuAge);

                if (age >= 16) {

                    ageIsValid = true;
                    studentAge.add(stuAge);

                } else {
                    System.out.println("Invalid age, The age of the student must be higher than 16.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input, Please enter an integer value.");
            }

        }
    }
    
    //This method is used to store the students details entered by the user and saves them to the appropriate array lists
    public void enterDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter student ID:");
        String stuId = sc.nextLine();
        studentID.add(stuId);
        setStudId(stuId);

        System.out.println("Please enter the student name \"(ex: M.Baldav)\"");
        String stuName = sc.nextLine();
        studentName.add(stuName);
        setStudName(stuName);

        boolean ageIsValid = false;
        String stuAge = "";
        studentAgeInvalid(ageIsValid, stuAge);
        if (ageIsValid) {
            setStudAge(stuAge);
        }

        System.out.println("Please enter student email:");
        String stuEmail = sc.nextLine();
        studentEmail.add(stuEmail);
        setStudEmail(stuEmail);

        System.out.println("please enter student course \"(ex:BCAD)\"");
        String stuCourse = sc.nextLine();
        studentCourse.add(stuCourse);
        setStudCourse(stuCourse);

        System.out.println("__________________________________________________");
        System.out.println("Student details have been successfully saved.");
        System.out.println("__________________________________________________");
        System.out.println(studentID.get(0));
        intro();

    }
    //this method is used or unit testing purposes
    public void saveStudent() {
        studentID.add(getStudId());
        studentName.add(getStudName());
        studentAge.add(getStudAge());
        studentEmail.add(getStudEmail());
        studentCourse.add(getStudCourse());
    }

    //The user will enter the ID of the student to see their details and if the student was not found the appropriate message will appear
    public void searchStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student ID to search: ");

        String idToSearch = sc.nextLine();
        boolean idFound = studentID.contains(idToSearch);
        int studentIndex = studentID.indexOf(idToSearch);

        if (idFound == true) {
            System.out.println("Student ID: " + studentID.get(studentIndex));
            System.out.println("Student Name: " + studentName.get(studentIndex));
            System.out.println("Student Age: " + studentAge.get(studentIndex));
            System.out.println("Student Email: " + studentEmail.get(studentIndex));
            System.out.println("Student Course: " + studentCourse.get(studentIndex));

            intro();

        } else {
            System.out.println("Student with Student Id: " + idToSearch + " was not found!");
            intro();
        }

    }
    
   
    //User will enter the Student's ID they want to delete there will be a layer of confirmation before actually deleting the students Details
    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        String idToDelete;
        String choice;
        System.out.println("Enter the student id to delete: ");
        idToDelete = sc.nextLine();
        System.out.println("Are you sure you want to delete student " + idToDelete + "? Yes \"(y)\" to delete.");
        choice = sc.nextLine();

        deleteIndex = studentID.indexOf(idToDelete);
        boolean idFound = studentID.contains(idToDelete);

        if (choice.equals("y")) {
            if (idFound == true) {
                System.out.println("Student ID: " + studentID.remove(deleteIndex));
                System.out.println("Student Name: " + studentName.remove(deleteIndex));
                System.out.println("Student Age: " + studentAge.remove(deleteIndex));
                System.out.println("Student Email: " + studentEmail.remove(deleteIndex));
                System.out.println("Student Course: " + studentCourse.remove(deleteIndex));
                System.out.println("Student with Student Id: " + idToDelete + " WAS deleted!");
                intro();

            } else {
                System.out.println("Thank you for using the programme");
                intro();
            }

        }
    }
    
    //this method is for unit testing purposes 
    public void delStu(){
        studentID.remove(deleteIndex);
        studentName.remove(deleteIndex);
        studentAge.remove(deleteIndex);
        studentEmail.remove(deleteIndex);
        studentCourse.remove(deleteIndex);
        
    }
     
    //This method will iterate through a for loop and print out every student saved to the array lists
    public void studentReport() {

        if (studentID.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        
        for (int i = 0; i < studentID.size(); i++) {
            System.out.println("Student " + (i + 1) + "\n"
                    + "-------------------------------------");
            System.out.println("Student ID: " + studentID.get(i));
            System.out.println("Student Name: " + studentName.get(i));
            System.out.println("Student Age: " + studentAge.get(i));
            System.out.println("Student Email: " + studentEmail.get(i));
            System.out.println("Student Course: " + studentCourse.get(i));
            System.out.println();
        }
        intro();

    }
//this method allows the user to edit the students details by entering the student's ID and there after choosing what detail to modify
    public void editStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student ID to edit: ");
        String idToEdit = sc.nextLine();

        if (studentID.contains(idToEdit)) {
            int stuIndex = studentID.indexOf(idToEdit);

            System.out.println("Current Student Information:");
            System.out.println("Student ID: " + studentID.get(stuIndex));
            System.out.println("Student Name: " + studentName.get(stuIndex));
            System.out.println("Student Age: " + studentAge.get(stuIndex));
            System.out.println("Student Email: " + studentEmail.get(stuIndex));
            System.out.println("Student Course: " + studentCourse.get(stuIndex));
            System.out.println("------------------------------------------------");

            System.out.println("Select a field to edit:");
            System.out.println("1. Student Name");
            System.out.println("2. Student Age");
            System.out.println("3. Student Email");
            System.out.println("4. Student Course");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the new information:");
            String newInfo = sc.nextLine();

            switch (choice) {
                case 1:
                    studentName.set(stuIndex, newInfo);
                    break;
                case 2:
                    studentAge.set(stuIndex, newInfo);
                    break;
                case 3:
                    studentEmail.set(stuIndex, newInfo);
                    break;
                case 4:
                    studentCourse.set(stuIndex, newInfo);
                    break;
                default:
                    System.out.println("No changes were made.");
                    break;
            }

            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student with Student Id: " + idToEdit + " was not found!");
        }

        intro();
    }
//this method exits the programme
    public void exitStudentApplication() {
        System.exit(0);
    }
}
