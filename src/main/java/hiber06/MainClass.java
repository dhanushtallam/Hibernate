package hiber06;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		
		EntityManagerFactory e = Persistence.createEntityManagerFactory("tuesday");
		EntityManager m = e.createEntityManager();
		EntityTransaction t = m.getTransaction();
 --------------------inserting the values-----------------------
		Student s1 = new Student();
		s1.setAge(21);
		s1.setStudentName("umesh");
		
		Student s2 = new Student();
		s2.setAge(20);
		s2.setStudentName("raju");
		
		Student s3 = new Student();
		s3.setAge(22);
		s3.setStudentName("sanju");
		
		Student s4 = new Student();
		s4.setAge(23);
		s4.setStudentName("pooja");
		
		Trainer t1 = new Trainer();
		t1.setSubject("Core Java");
		t1.setTrainerName("shanker sir");
		t1.setSt(Arrays.asList(s1,s2,s3,s4));
		
		t.begin();
		m.persist(t1);
		t.commit();
		
------------------fetching the student class---------------------		
		Student s = m.find(Student.class, "allen");
		System.out.println(s);
		
---------------fetching the trainer class------------------------
		Trainer t1 = m.find(Trainer.class, "shanker sir");
		System.out.println(t1);
		
---------------Updating Student class---------------------------
		Student s = m.find(Student.class, "pooja");
		s.setAge(19);
		t.begin();
		m.merge(s);
		t.commit();
		
---------------updating trainer class--------------------------
		Trainer t1 = m.find(Trainer.class,"shanker sir");
		t1.setSubject("JAVA");
		t.begin();
		m.merge(t1);
		t.commit();
		
--------------remove trainer class-------------------------
		Trainer t1 = m.find(Trainer.class,"shanker sir");
		t.begin();
		m.remove(t1);
		t.commit();
		
//------------remove student class------------------
		Trainer t1 = m.find(Trainer.class,"kiran sir");
		 List<Student> s1 = t1.getSt();
		 Iterator<Student> i = s1.iterator();
		 while(i.hasNext())
		 {
			 Student st = i.next();
			 if(st.getStudentName().equals("king"))
			 {
				 i.remove();
			 }
		 }
		 t1.setSt(s1);
		 t.begin();
		 m.merge(t1);
		 t.commit();
		
		Student s = m.find(Student.class,"king");
		t.begin();
		m.remove(s);
		t.commit();
		
		
		
	}

}
