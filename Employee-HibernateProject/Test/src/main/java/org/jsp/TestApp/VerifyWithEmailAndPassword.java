package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.*;

public class VerifyWithEmailAndPassword {

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the email id and password");
		String email=s.next();
		String password=s.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createNamedQuery("verifywithEmandPsd");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try 
		{
			Employee e=(Employee)q.getSingleResult();
			System.out.println("your account is verified and your phone number is: "+e.getPhone());
		}
		catch (NoResultException e) 
		{
			System.err.println("invalid login details please try with correct email and password");
		}
		s.close();
	}

}
