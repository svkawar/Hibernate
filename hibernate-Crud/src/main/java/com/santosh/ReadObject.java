package com.santosh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing..........");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {

			Student tempStudent = new Student("Sant2", "Kawa2", "svk@gmail.com");
			System.out.println("Begin..........");
			session.beginTransaction();
			System.out.println("save..........");
			session.save(tempStudent);
			System.out.println("commit..........");
			session.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {

			session.close();
			factory.close();
		}

	}

}
