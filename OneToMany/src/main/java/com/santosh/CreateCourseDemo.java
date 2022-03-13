package com.santosh;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		

		try {
			Integer id = 4;
			
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);
			
			Course course = new Course("History");
			Course course2 = new Course("Math");
			
			instructor.Add(course);
			instructor.Add(course2);
			
			session.save(course);
			session.save(course2);
			
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(" Exception :: " + e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

}
