package org.jsp.TestApp;
import java.util.Scanner;
import javax.persistence.*;

public class FetchBySal 
{
	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the sal to print the details: ");
		int salary=s.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createNamedQuery("FetchBySal");
		q.setParameter("sl", salary);
		try {
			Employee e=(Employee)q.getSingleResult();
			System.out.println("id: "+e.getId());
			System.out.println("name: "+e.getName());
			System.out.println("email id is: "+e.getEmail());
			System.out.println("salary is:"+e.getSalary());
			}
			catch(NoResultException |IllegalArgumentException e)
		{
				System.err.println("Invalid salalry entered");
		}
		s.close();
	}

}
