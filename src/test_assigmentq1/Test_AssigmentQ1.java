/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test_assigmentq1;

import java.util.Scanner;

/**
 *
 * @author mbald
 */
public class Test_AssigmentQ1 {
    
    //Declaring Global objects and variables
    final static Scanner sc = new Scanner(System.in);
    final static MenuMethods stu = new MenuMethods();
    private static String idToSearch;
    
    //Main will only call one method(Intro)
    public static void main(String[] args) {
        intro();
    }

    //User can enter 1 to carry on with the programme and any other key to exit the programme
    public static void intro() {
        String menuChoice;
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        menuChoice = sc.next();
        if (!menuChoice.equals("1")) {
            System.exit(0);
        } else {
            mainMenu();
        }
    }

    public static void mainMenu() {
        
        //menuChoice variable declared to store what the user choice is
        String menuChoice;

        System.out.println("Please select one of the following menu items:\n"
                + "(1) Capture a new student.\n"
                + "(2) Search for a new student\n"
                + "(3) Delete a student.\n"
                + "(4) Print student report.\n"
                + "(5) Edit Student.\n"
                + "(6) Exit Application.\n");

        menuChoice = sc.next();

        //User choice is stored in menuChoice and depending on the choice it will call the appropriate method
        switch (menuChoice) {
            case "1":
                stu.enterDetails();
                break;
            case "2":
                stu.searchStudent();
                break;
            case "3":
                stu.deleteStudent();
                break;
            case "4":
                stu.studentReport();
                break;
            case "5":
                stu.editStudent();
                break;
            case "6":
                stu.exitStudentApplication();
                return;
            default:
                throw new AssertionError();
        }
    }
}
