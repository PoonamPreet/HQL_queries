package com.practice.com.practice;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class App 
{
	public static void main( String[] args )
	{
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);

		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

		SessionFactory sessionFactory=config.buildSessionFactory(reg);

		Session session =sessionFactory.openSession();

		session.beginTransaction();

		Random r =new Random();//Java's own class randomly generates the values

		/*for(int i=1;i<=50;i++)
		{
			Student s =new Student();
			s.setId(i);
			s.setName("Name"+i);
			s.setMarks(r.nextInt(100));
			session.save(s);
		}*/
		int marks1=60;
		//		Query q=session.createQuery("from Student");//should use class name not table here

		//		Query q=session.createQuery("from Student where marks > 50");
		//		Query q=session.createQuery("from Student where id=49");//for fetching single row 
//		Query q=session.createQuery("select id,name,marks from Student where marks > 50");
		//Query q=session.createQuery("select sum(marks) from Student s where s.marks>"+marks1);
		Query q=session.createQuery("select sum(marks) from Student s where s.marks> :marks1");
		q.setParameter("marks1", marks1);
		Long marks=(Long)q.uniqueResult();
		
		//List<Object[]> std1=(List<Object[]>)q.list();
		//for(Object[] std:std1)
		
		System.out.println(marks);
		//System.out.println(std[0]+ ":"+std[1]+ ":"+std[2]);
		
		//		Student std=(Student)q.uniqueResult();
		//	System.out.println(std);
		/*		List<Student> students=q.list();
		for(Student s:students)
		{

			System.out.println(s);
		}	*/	
		session.getTransaction().commit();
	}
}
