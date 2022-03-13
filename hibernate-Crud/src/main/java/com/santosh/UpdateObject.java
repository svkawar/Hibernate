package com.santosh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing..........");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Student stdStudent = session.get(Student.class, 4);
			
			stdStudent.setFirstName("santosh");
			stdStudent.setLastName("Kawar");
			//session.createQuery("update Student set email=santosh.kawar@gmail.com").executeUpdate();
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='santosh.kawar@gmail.com'").executeUpdate();
			session.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {

			session.close();
			factory.close();
		}

	}

}
