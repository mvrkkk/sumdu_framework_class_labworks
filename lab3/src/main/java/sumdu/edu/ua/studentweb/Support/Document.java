/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.studentweb.Support;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 *
 * @author User
 */
public class Document {
    private int id;
    private static int nextid = 0;
    List<Subject> scores;
    
    public Document( String sub1,  String sub2,  String sub3){
        this.id = nextid++;
        this.scores = new LinkedList<>();
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\Users\\User\\Documents\\NetBeansProjects\\StudentWeb\\src\\main\\resources\\SpringXMLConfig.xml"));
        Subject subj1 = (Subject)factory.getBean("Subject");
        subj1.setName(sub1);
        subj1.setScore((int)(100*Math.random()));
        if(subj1.getScore()>=60) subj1.setPass(true);
        Subject subj2 = (Subject)factory.getBean("Subject");
        subj2.setName(sub2);
        subj2.setScore((int)(100*Math.random()));
        if(subj2.getScore()>=60) subj2.setPass(true);
        Subject subj3 = (Subject)factory.getBean("Subject");
        subj3.setName(sub3);
        subj3.setScore((int)(100*Math.random()));
        if(subj3.getScore()>=60) subj3.setPass(true);
        scores.add(subj1);
        scores.add(subj2);
        scores.add(subj3);
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Subject sub:scores){
            out+=sub.isPass()+" "+sub.getName()+":"+sub.getScore()+";";
        }
        return out;
    }
    
}
