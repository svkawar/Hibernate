package com.santosh;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		

		try {
			Instructor instructor = new Instructor("santosh", "Kawar", "santosh.kawar@gmail.com");

			InstructorDetail instructorDetails = new InstructorDetail("www.youtube.com", "TT");

			instructor.setInstructorDetail(instructorDetails);
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
