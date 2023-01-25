/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import java.util.LinkedList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;
import sumdu.edu.ua.studentweb.Support.Student;
import sumdu.edu.ua.studentweb.Support.Utils;





/**
 *
 * @author User
 */
public class StatsCalculateTest {
    static LinkedList<Student> studs= new LinkedList<>();;
    
    @BeforeAll
    public static void setUpData(){
        studs.add(new Student("Test1","Test1","18","test1@test.ua", "test", "test"));
        studs.add(new Student("Test2","Test2","28","test2@test.ua", "test", "test"));
        studs.add(new Student("Test3","Test3","19","test3@test.ua", "test1", "test1"));
        studs.add(new Student("Test4","Test4","23","test4@test.ua", "test1", "test1"));
        studs.add(new Student("Test5","Test5","15","test5@test.ua", "test", "test"));
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
        assertEquals((double)(18+28+19+23+15)/5, result);
    }
    
    @Test
    public void calculateMinAgeTest(){
        Student result = Utils.calculateMinAge(studs);
        assertEquals("15", result.getAge());
    }
    
    @Test
    public void calculateMaxAgeTest(){
        Student result = Utils.calculateMaxAge(studs);
        assertEquals("28", result.getAge());
    }
    
    @Test
    public void calculateGroupTest(){
        int result = Utils.calculateGroups(studs);
        assertEquals(2, result);
    }
}
