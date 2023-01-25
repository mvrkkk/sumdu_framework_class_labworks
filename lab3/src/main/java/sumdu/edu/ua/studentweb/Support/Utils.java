/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.Support;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;

/**
 *
 * @author User
 */
public class Utils {
    public static String calculatePopularDomain(LinkedList<Student> studs) throws EmailException{
        Map<String, Integer> mails = new HashMap<String, Integer>();
        String tempDomain = "";
        String popularDomain = "";
        int count = 0;
        for(Student st : studs){
            if(Utils.patternMatches(st.getEmail())){
                tempDomain  = Utils.getEmailDomain(st.getEmail());
                if(mails.containsKey(tempDomain)){
                    count = mails.get(tempDomain) + 1;
                }
                else{
                    count = 1;
                }
                mails.put(tempDomain, count);
            }else{
                throw new EmailException();
            }
        }
        Set<String> keys = mails.keySet();
        int max = 0;
        for(String current:keys){
            if(max<mails.get(current)){
                max = mails.get(current);
                popularDomain = current;
            }
        }
        return popularDomain;
    }
    
    public static double calculateMeanAge(LinkedList<Student> studs){
        double tempAge = 0;
        int count = 0;
        for(Student st: studs){
            int age = Integer.parseInt(st.getAge());
            if(age>0){
                tempAge+=age;
                count++;
            }
        }
        if(count == 0) return -1;
        return tempAge/count;
    }
    
    public static boolean patternMatches(String emailAddress){
        String regexPattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
    
    public static String getEmailDomain(String someEmail){
        return someEmail.substring(someEmail.indexOf("@")+1);
    }
    
    public static Student calculateMinAge(LinkedList<Student> studs){
        studs.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.parseInt(s1.getAge())- Integer.parseInt(s2.getAge());
            }
        });
        return studs.get(0);
    }
    
    public static Student calculateMaxAge(LinkedList<Student> studs){
        studs.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.parseInt(s1.getAge())- Integer.parseInt(s2.getAge());
            }
        });
        return studs.get(studs.size()-1);
    }
    
    public static int calculateSumduMails(LinkedList<Student> studs){
        int count = 0;
        for(Student st: studs){
            if(st.getEmail().contains("sumdu")) count ++;
        }
        return count;
    }
    
    public static int calculateGroups(LinkedList<Student> studs){
        Set<String> groups = new HashSet<>();
        for(Student st: studs){
            groups.add(st.getGroup());
        }
        return groups.size();
    }
    
    public static Map<String, Integer> calculateFaculty(LinkedList<Student> studs){
        Map<String, Integer> faculty = new HashMap<>();
        int students = 0;
        for(Student st : studs){
            if(faculty.containsKey(st.getFaculty())){
                students = faculty.get(st.getFaculty()) + 1;
            }else{
                students = 1;
            }
            faculty.put(st.getFaculty(), students);
        }
        return faculty;
    }
    
}
