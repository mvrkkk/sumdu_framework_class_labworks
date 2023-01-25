package sumdu.edu.ua.studentweb.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sumdu.edu.ua.studentweb.model.Student;

import javax.transaction.Transactional;
import java.util.List;

@Repository("StudentDAO")
public class StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    public void addStudent(Student a){
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e){
            session = sessionFactory.openSession();
        }
        session.save(a);
    }

    @Transactional
    public List<Student> getStudents(){
        Session session = sessionFactory.getCurrentSession();
        List<Student> stud = session.createQuery("FROM Student").list();
        return stud;
    }
}
