package com.santosh;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBiDirDeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		

		try {
			
			Instructor instructor = new Instructor("pallavi", "Kawar", "pallavi.kawar@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("www.yahoo.com", "Reading");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(" Exception :: " + e.getMessage());
		} finally {
			session.close();
			factory.close();
		}
	}

}
