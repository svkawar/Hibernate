package com.santosh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing..........");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {

			Student tempStudent = new Student("Sdsfjn", "Kaw", "svk4@gmail.com");
			System.out.println("Begin..........");
			session.beginTransaction();
			System.out.println("save..........");
			session.save(tempStudent);
			System.out.println("commit..........");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> stdList = session.createQuery("from Student").getResultList();
			for(Student stdStudent : stdList ) {
				System.out.println("Student " + stdStudent);
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {

			session.close();
			factory.close();
		}

	}

}
