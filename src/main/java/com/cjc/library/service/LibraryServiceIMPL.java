package com.cjc.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.cjc.library.config.Hibernatecon;
import com.cjc.library.model.Book;
import com.cjc.library.model.Student;

public class LibraryServiceIMPL implements LibraryService {
	Scanner sc= new Scanner(System.in);
	Student stu=new Student();
	Book bk= new Book();
	
	public void registerNewStudent() 
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		
		System.out.println("welcome to library management");
		stu=new Student();
		
		System.out.println("Enter Student id to Register:");
		int sid	=sc.nextInt();
		Student s = session.get(Student.class, sid);
		if(s==null)
		{
			stu.setId(sid);
		
		System.out.println("Enter Student Name:");
		String sname=sc.next()+sc.nextLine();
		stu.setSname(sname);
		
		System.out.println("Enter Student Division:");
		String sdiv = sc.next();
		stu.setSdiv(sdiv);
		System.out.println("Enter Student Address:");
		stu.setSadd(sc.next());
		
		System.out.println("Enter Student Mobile Number:");
		stu.setMobile_no(sc.nextLong());
		
		System.out.println("Enter Student Adhar Number");
		stu.setAdharno(sc.nextLong());
		
		
		session.save(stu);
		
		session.beginTransaction().commit();
	
		System.out.println("Student registered successfully....");
		}
		else {
			System.out.println("Student is Already Registred....");
			
		}
		
	}
	
	public void addNewBook()
	{
		
		Session session = Hibernatecon.getSessionFactory().openSession();
		System.out.println("welcome to library management:");
		bk=new Book();
		
		System.out.println("Enter Book id:");
		int i = sc.nextInt();
		Book b = session.get(Book.class, i);
		if(b==null)
		{
			bk.setBid(i);
		
		System.out.println("Enter Book Name:");
		bk.setBname(sc.next()+sc.nextLine());
		
		System.out.println("Enter Book Author Name: ");
		bk.setBauthor(sc.next()+sc.nextLine());
		
		System.out.println("Enter Book price:");
		bk.setPrice(sc.nextDouble());
		
	
		session.save(bk);
		session.beginTransaction().commit();
		
		System.out.println("Book add successfully......");
		}
		else {
			System.out.println("Book is already registered....");
		}
	}

	public void assignBookToStudent()
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		System.out.println("Enter Book id for assign to student:");
		int id2 = sc.nextInt();
		if(id2!=0)
		{
			
		Book bkb=session.get(Book.class, id2);
		System.out.println(bkb);
		
		
		bkb.getBid();
		bkb.getBname();
		bkb.getBauthor();
		bkb.getPrice();
	
		
		
		System.out.println("Enter Student id for assign book:");
		int id = sc.nextInt();
		if(id!=0)
		{
		Student st=session.get(Student.class, id);
		st.getId();
		st.getSname();
		st.getSdiv();
		st.getSadd();
		st.getMobile_no();
		st.getAdharno();
		
		List<Book> lst=new ArrayList();
		lst.add(bkb);
		
		st.setBook(lst);
		
		session.saveOrUpdate(st);
		session.beginTransaction().commit();
		
		System.out.println("Book assign to Student successfully......");
		
		}
	
		else {
			System.out.println("Did not find the book id you enter:"+id2);
		}
		}
		}
	
	public void updateStudentDetails()
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		System.out.println("Eneter student id to update details:");
		int id = sc.nextInt();
		Student std = session.get(Student.class, id);
		
		if(std!=null)
		{
			System.out.println("Enetr 1 to update Student ID: ");
			System.out.println("Enetr 2 to update Student Name: ");
			System.out.println("Enter 3 to update Student Division");
			System.out.println("Enetr 4 to update Student Address: ");
			System.out.println("Enetr 5 to update Student Mobile Number: ");
			System.out.println("Enetr 6 to update Student Adhar Number: ");
			int n = sc.nextInt();
			switch(n)
			{
			case 1:
				System.out.println("Enter Student Id:");
				int id1 = sc.nextInt();
				std.setId(id1);
				break;
			case 2:
				System.out.println("Enter Student name:");
				String na=sc.next()+sc.nextLine();
				std.setSname(na);
				break;
			case 3:
				System.out.println("Enter Student division: ");
				String d = sc.next();
				std.setSdiv(d);
				break;
			case 4:
				System.out.println("Enter Student Address: ");
				String a = sc.next();
				std.setSadd(a);
				break;
			case 5:
				System.out.println("Enter Student Mobile number:");
				long ad = sc.nextLong();
				std.setMobile_no(n);
				break;
			case 6 : 
				System.out.println("Enter Student Adhar number:");
				long a1 = sc.nextLong();
				std.setAdharno(a1);
				break;
			default:
				System.out.println("Please enter correct number....");
				break;
			}
			System.out.println("Update Student Details successfully.....");
			
			session.beginTransaction().commit();
		}
		else {
			System.out.println("Did not find your details of that id:"+id);
		}
	}
	public void deleteStudent()
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		System.out.println("Enter Student ID to delete student :");
		int ids = sc.nextInt();
		Student stu = session.get(Student.class, ids);
		if(stu!=null)
		{
		Transaction tx = session.beginTransaction();
		Query query = session.createNamedQuery("deletebyid");
		query.setParameter(1, ids);
		query.executeUpdate();
		tx.commit();
		
		System.out.println(ids+" "+"id student is deleted.....");
		}
		else {
			System.out.println("Did not find the Student of that id:"+ids);
		}
	}
	public void deleteBook() 
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		System.out.println("Enter Book ID to delete book :");
		int id1 = sc.nextInt();
		Book stud = session.get(Book.class, id1);
		if(stud!=null)
		{
		Transaction tx = session.beginTransaction();
		Query query = session.createNamedQuery("deletebybookid");
		query.setParameter(1, id1);
		query.executeUpdate();
		tx.commit();
		System.out.println(id1+" "+"id book is deleted.....");
		}
		else {
			System.out.println("Did not find the Book of that id:"+id1);
		}
		
	}
	public void getAllStudent()
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		Query query = session.createNamedQuery("getbystudent");
		List <Student> list = query.getResultList();
		System.out.println("Student information:");
		for(Student student:list)
		{
			
			System.out.println(student);
		}
	}
	public void getAllStuByDivision()
	{
		Session session = Hibernatecon.getSessionFactory().openSession();
		System.out.println("Enter Student division to see details :");
		String d = sc.next();
			
		if(d!=null)
		{
		
		Query query = session.createNamedQuery("getstudentbydivision");
		query.setParameter("di", d);
		List <Student>lst = query.getResultList();
		System.out.println("student information:");
		for(Student student:lst)
		{
			System.out.println(student);
		}
		}
		else {
			System.out.println("did not find the division:"+d);
		}
		
	}
}
