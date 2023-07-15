package org.jsp.TestApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyByIdAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id: ");
		int id=s.nextInt();
		System.out.println("enter the password: ");
		String password=s.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createNamedQuery("VerifyWithIdAndPsd");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			Employee e=(Employee) q.getSingleResult();
			System.out.println("your account is verified");
			System.out.println("your id is: "+e.getId());
			System.out.println("salary is:"+e.getSalary());
		}
		catch (NoResultException e) 
		{
			System.err.println("invalid password or idS");
		}
		s.close();
	}

}
