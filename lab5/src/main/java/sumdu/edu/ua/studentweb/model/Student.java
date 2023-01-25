/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.model;

import sumdu.edu.ua.studentweb.Support.Document;

import javax.persistence.*;

/**
 *
 * @author User
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_surname")
    private String surname;
    @Column(name = "age")
    private String age;
    @Column(name = "email")
    private String email;
    @Column(name = "student_group")
    private String group;
    @Column(name = "faculty")
    private String faculty;
    @Transient
    private Document doc;
    
    public Student(String name, String surname, String age, String email, String group, String faculty){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.group = group;
        this.faculty = faculty;
    }
    
    public Student(){}
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age = age;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getGroup(){
        return group;
    }
    public void setGroup(String group){
        this.group = group;
    }
    public String getFaculty(){
        return faculty;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document id) {
        this.doc = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
