/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.controller;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;
import sumdu.edu.ua.studentweb.Support.StatsCalculator;
import sumdu.edu.ua.studentweb.Support.Student;
import sumdu.edu.ua.studentweb.Support.Utils;

/**
 *
 * @author User
 */
@Controller
public class StudentController {
    List<Student> students;
    ApplicationContext factory;
    Student student;
    
    @ModelAttribute
    public void modelData(Model m){
        if(students == null) students = new LinkedList<>();
        factory = new ClassPathXmlApplicationContext("/SpringXMLConfig.xml");
        student = (Student)factory.getBean("Student");
    }
    
    @RequestMapping(value = "/")
    public String home(){
        return"home";
    }
    
    @RequestMapping("StudentAdd")
    public String addStudent(HttpServletRequest request, Model m){
        HttpSession session = request.getSession();
        if(request.getParameter("name")!= "" || request.getParameter("surname")!=""){
            Student student = (Student)factory.getBean("Student");
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setAge(request.getParameter("age"));
            student.setEmail(request.getParameter("email"));
            student.setGroup(request.getParameter("group"));
            student.setFaculty(request.getParameter("faculty"));
            students.add(student);
        }
        m.addAttribute("students", students);
        return "home";
    }
    
    @PostMapping("calculateStats")
    public ModelAndView calculateSt() throws EmailException{
        ModelAndView modelNview = new ModelAndView();
        modelNview.setViewName("statistic");
        StatsCalculator stat = StatsCalculator.getInstance();
        stat.setMeanAge(Utils.calculateMeanAge((LinkedList<Student>) students));
        stat.setMinAge(Integer.parseInt(Utils.calculateMinAge((LinkedList<Student>) students).getAge()));
        stat.setMaxAge(Integer.parseInt(Utils.calculateMaxAge((LinkedList<Student>) students).getAge()));
        stat.setSumduMails(Utils.calculateSumduMails((LinkedList<Student>) students));
        stat.setGroups(Utils.calculateGroups((LinkedList<Student>) students));
        stat.setFaculty(Utils.calculateFaculty((LinkedList<Student>) students));
        stat.setPopularMail(Utils.calculatePopularDomain((LinkedList<Student>) students));
        modelNview.addObject("stat", stat);
        return modelNview;
    }
    
    @GetMapping("filterFaculty")
    public String filterF(@RequestParam("filter") String faculty, Model m){
        List<Student> filtered = new LinkedList<>();
        for(Student st : students){
            if(st.getFaculty().equalsIgnoreCase(faculty)) filtered.add(st);
        }
        m.addAttribute("filter", faculty);
        m.addAttribute("filtered", filtered);
        return "listed";
    }
    
    @GetMapping("filterGroup")
    public String filterG(@RequestParam("filter") String group, Model m){
        List<Student> filtered = new LinkedList<>();
        for(Student st : students){
            if(st.getFaculty().equalsIgnoreCase(group)) filtered.add(st);
        }
        m.addAttribute("filter", group);
        m.addAttribute("filtered", filtered);
        return "listed";
    }
}
