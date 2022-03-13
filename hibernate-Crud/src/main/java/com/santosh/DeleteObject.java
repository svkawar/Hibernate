package com.santosh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing..........");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			session.createQuery("delete from Student where id = 2").executeUpdate();
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			//List<Student> stdList = session.createQuery("from Student s where s.firstName LIKE '%Sant%'").getResultList();
			List<Student> stdList = session.createQuery("from Student").getResultList();
			for(Student stdStudent : stdList) {
				System.out.println(stdStudent);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {

			session.close();
			factory.close();
		}

	}

}
