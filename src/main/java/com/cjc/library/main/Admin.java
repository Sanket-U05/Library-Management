package com.cjc.library.main;

import java.util.Scanner;

import com.cjc.library.service.LibraryService;
import com.cjc.library.service.LibraryServiceIMPL;

public class Admin {
	public static void main(String[] args) {
		
	Scanner sc	=new Scanner(System.in);
	LibraryService ls=new LibraryServiceIMPL();
	
	boolean flag=true;
	
	while(flag)
	{
		System.out.println("welcome to Library..:");
		System.out.println("Enter 1 to Register New Student:");
		System.out.println("Enter 2 to Add New Book:");
		System.out.println("Enter 3 to Assign Book to Student:");
		System.out.println("Enter 4 to Update Student:");
		System.out.println("Enter 5 to Delete Student:");
		System.out.println("Enter 6 to Delete Book:");
		System.out.println("Enter 7 to Get All Student:");
		System.out.println("Enter 8 to Get All Students By Division:");
		System.out.println("Enter 9 to Exit from Application:");
		System.out.println("***********_________***************__________********");
		
		int ch =sc.nextInt();
		
		switch(ch) {
		
		case 1:
			ls.registerNewStudent();
			break;
		case 2:
			ls.addNewBook();
			break;
		case 3:
			ls.assignBookToStudent();
			break;
		case 4:
			ls.updateStudentDetails();
			break;
		case 5:
			ls.deleteStudent();
			break;
		case 6:
			ls.deleteBook();
			break;
		case 7:
			ls.getAllStudent();
			break;
		case 8:
			ls.getAllStuByDivision();
			break;
		case 9:
			flag=false;
			break;
		default:
			break;
				
		}
	}
	}
}
