package org.jsp.TestApp;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class FetchBydesg 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter the designation to fetch the data:");
		String desg=s.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createNamedQuery("FetchByDesg");
		q.setParameter(1, desg);
		List<Employee >emp=q.getResultList();
		for (Employee employ : emp) 
		{
			System.out.println("id: "+employ.getId());
			System.out.println("Name:"+employ.getName());
			System.out.println("salary :"+employ.getSalary());
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}
		s.close();
	}
}
