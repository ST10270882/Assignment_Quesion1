/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_assigmentq1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;

/**
 *
 * @author mbald
 */
public class MenuMethodsTest {
//Declaring all global Array lists and variables
    MenuMethods mm = new MenuMethods();
//    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//These 2 varibales will be used to simulate user input
    private ByteArrayOutputStream outputStream;
    private InputStream inputStream;

    ArrayList<String> studentID = new ArrayList<>();
    ArrayList<String> studentName = new ArrayList<>();
    ArrayList<String> studentAge = new ArrayList<>();
    ArrayList<String> studentEmail = new ArrayList<>();
    ArrayList<String> studentCourse = new ArrayList<>();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
//before unit testing the following details will be added to the arraylists
    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String id = "1";
        String Name = "Mikyle";
        String Age = "18";
        String Email = "mbaldav26@gmail.com";
        String Course = "BCAD";

        studentID.add(id);
        studentName.add(Name);
        studentAge.add(Age);
        studentEmail.add(Email);
        studentCourse.add(Course);

        mm.setStudentID(studentID);
        mm.setStudentName(studentName);
        mm.setStudentAge(studentAge);
        mm.setStudentEmail(studentEmail);
        mm.setStudentCourse(studentCourse);

        mm.setStudId(id);
        mm.setStudName(Name);
        mm.setStudAge(Age);
        mm.setStudEmail(Email);
        mm.setStudCourse(Course);

    }

    @AfterEach
    public void tearDown() {

    }

    //The test is seeing if "p" is an invalid character
    @Test
    public void testStudentAgeInvalidChar() {
        System.out.println("studentAgeInvalidChar");
        boolean ageIsValid = false;
        String stuAge = "p";
        MenuMethods instance = new MenuMethods();
        instance.studentAgeInvalidChar(ageIsValid, stuAge);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    //This test is checking if 15 is a valid age
    @Test
    public void testStudentAgeInvalid() {
        System.out.println("studentAgeInvalid");
        boolean ageIsValid = true;
        String stuAge = "15";
        MenuMethods instance = new MenuMethods();
        instance.studentAgeInvalid(ageIsValid, stuAge);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    //This test is checking if 18 is a valid age
    @Test
    public void testStudentAgeValid() {
        System.out.println("studentAgeInvalid");
        boolean ageIsValid = true;
        String stuAge = "18";
        MenuMethods instance = new MenuMethods();
        instance.studentAgeInvalid(ageIsValid, stuAge);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    //This test checks against the information saved in the arraylists and the ones saved to the objects variables
    @Test
    public void testSaveStudent() {

        System.out.println("SaveStudent");
        mm.saveStudent();
        assertEquals(studentID.get(0), mm.getStudId());
        assertEquals(studentName.get(0), mm.getStudName());
        assertEquals(studentAge.get(0), mm.getStudAge());
        assertEquals(studentEmail.get(0), mm.getStudEmail());
        assertEquals(studentCourse.get(0), mm.getStudCourse());

    }

    //this test will search if there is an ID in the arraylist and return true
    @Test
    public void testSearchStudent() {

        System.out.println("Search Student");

        String studentID = "1";

        inputStream = new ByteArrayInputStream(studentID.getBytes());

        System.setIn(inputStream);
//       mm.searchStudent();
        
          assertTrue(mm.getStudId().contains("1"));
//        assertEquals(studentID,mm.getStudId());

    }

     //This test will search if there is no ID in the arraylist and return false if it works
    @Test
    public void testSearchStudent_StudentNotFound() {

        System.out.println("Search Student");

        String studentID = "1";

        inputStream = new ByteArrayInputStream(studentID.getBytes());
//        mm.searchStudent();
        System.setIn(inputStream);

        assertFalse(outputStream.toString().contains("Student ID: 1"));

    }

    //This test will delete the ID "1" in the arraylist and then check if it is not there
    @Test
    public void testDeleteStudent() {
             String idToDelete = "1";
     inputStream = new ByteArrayInputStream(idToDelete.getBytes());
     System.setIn(inputStream);
     
     mm.delStu();
     
     assertTrue(mm.getStudId().contains("1"));
     

    }


    //This test will try to delete ID "1" but will return false as there is no ID 1 to delete
    @Test
    public void testDeleteStudent_StudentNotFound() {
    String idToDelete = "1";
     inputStream = new ByteArrayInputStream(idToDelete.getBytes());
     System.setIn(inputStream);
     
     mm.delStu();
     
     assertFalse(!mm.getStudId().contains("1"));

    }
}



