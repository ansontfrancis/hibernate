package org.jsp.TestApp;
import java.util.Scanner;
import javax.persistence.*;
public class VerifyWithPhoneAndPassword 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter phone number and password: ");
		int phone=s.nextInt();
		String password=s.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createNamedQuery("VerifyWithPhAndPsd");
		q.setParameter("ph",phone);
		q.setParameter(1, password);
		try {
			Employee e=(Employee)q.getSingleResult();
			System.out.println("your acoount is verified: and your email is "+e.getEmail());
		}
		catch (NoResultException e) 
		{
			System.err.println("invalid phone or password");
		}
		s.close();
		}

}
