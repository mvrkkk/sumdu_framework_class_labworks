/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import java.util.LinkedList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;
import sumdu.edu.ua.studentweb.model.Student;
import sumdu.edu.ua.studentweb.Support.Utils;





/**
 *
 * @author User
 */
public class StatsCalculateTest {
    static LinkedList<Student> studs;
    static {
         studs = new LinkedList<>();
        studs.add(new Student("Test1","Test1","10","test1@test.ua", "test", "test"));
        studs.add(new Student("Test2","Test2","30","test2@test.ua", "test", "test"));
        studs.add(new Student("Test3","Test3","20","test3@test.ua", "test1", "test1"));
        studs.add(new Student("Test4","Test4","15","test4@test.ua", "test1", "test1"));
        studs.add(new Student("Test5","Test5","25","test5@test.ua", "test", "test"));
    }
   

    @Test
    public void patternMatchesTest(){
        String email = "username@domain.com";
        assertTrue(Utils.patternMatches(email));
    }
    
    @Test
    public void getEmailDomainTest(){
        String result = Utils.getEmailDomain("test@gmail.com");
        assertEquals(result, "gmail.com");
    }
    
    @Test
    public void whenExceptionThrown_thenExpectationSatisfied()throws EmailException{
        studs.add(new Student("Exception", "Exception", "-1", "email", "test", "test"));
        Assertions.assertThrows(EmailException.class, ()->{
            Utils.calculatePopularDomain(studs);
        });
        studs.remove(5);
    }
    
    @Test
    public void calculateMeanAgeTest(){ 
        double result = Utils.calculateMeanAge(studs);
        assertEquals(20.0, result);
    }
    
    @Test
    public void calculateMinAgeTest(){
        Student result = Utils.calculateMinAge(studs);
        assertEquals("10", result.getAge());
    }
    
    @Test
    public void calculateMaxAgeTest(){
        Student result = Utils.calculateMaxAge(studs);
        assertEquals("30", result.getAge());
    }
    
    @Test
    public void calculateGroupTest(){
        int result = Utils.calculateGroups(studs);
        assertEquals(2, result);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
