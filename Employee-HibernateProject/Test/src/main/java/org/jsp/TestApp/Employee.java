package org.jsp.TestApp;

import javax.persistence.*;

@Entity
@Table(name="employee")
@NamedQueries(value = {@NamedQuery( name ="VerifyWithIdAndPsd",query = "select e from Employee e where e.id=?1 and e.password=?2" ),
		@NamedQuery(name = "VerifyWithPhAndPsd",query = "select e from Employee e where e.phone=:ph and e.password=?1"),
		@NamedQuery(name = "verifywithEmandPsd",query = "select e from Employee e where e.email=?1 and e.password=?2"),
		@NamedQuery(name = "FetchBySal", query = "select e from Employee e where e.salary=:sl"),
		@NamedQuery(name = "FetchByDesg", query = "select e from Employee e where e.desg=?1")})
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name",length=45,nullable=false)
	private String name;
	@Column(name="desg",length=45,nullable=false)
	private String desg;
	@Column(name="salary",length=45,nullable=false)
	private int salary;
	@Column(name="phone",length=45,nullable=false,unique=true)
	private int phone;
	@Column(name="email",length=45,nullable = false)
	private String email;
	@Column(name="password",length=45,nullable=false)
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
