package com.example.ioc;

/**
 * XML Configuration
 * 
 * <bean id="MySql" class="com.example.ioc.MySqlDatabase"/>
 * <bean id="Oracle" class="com.example.ioc.OracleDatabase"/>
 * 
 * <bean id="user" class="com.example.ioc.User">
 * 		<arg ref="MySql">
 * 		<arg ref="Oracle">
 * </bean>
 * 
 * @author heseth
 *
 */

public class IoC {

	public static void main (String[] args) {
		
		//User user = new User(new MySqlDatabase()); // This is Dependency Injection
		
		// This is not possible because User is dependent on MySqlDatabase
		// Dependency Inversion helps to resolve this
		//User user1 = new User(new OracleDatabase());
		
		User user = new User(new OracleDatabase()); // This is Dependency Injection
		user.add("This is some data");
		
		// Currently programmer is injecting dependency but what happens 
		// if User class constructor is changed to accept another database
		// that will break our code. So IoC frameworks such as Spring helps to
		// inject dependency by configuring object at one place 
		//(refer the XML config above) and utilizing that 
		// at multiple places in application.
		
		//@Autowired
		//User user1;
		
		//@Autowired
		//User user2;
	}
}

class User{
	
	//MySqlDatabase database;
	Database database;
	
	
	// Traditional way
	// Problem -
	// It's very difficult to unit test it.
	// Later if someone want to change the database it can't be done
	//public User() {
	//	database = new MySqlDatabase();
	//}
	
	//Invert the control
	//public User(MySqlDatabase database) {
	//	this.database = database;
	//}
	
	//Dependency Inversion
	public User(Database database) {
		this.database = database;
	}
	
	public User(MySqlDatabase database) {
		this.database = database;
	}
	
	public void add(String data) {
		database.persist(data);
	}
}

interface Database{
	void persist(String data);
}

class MySqlDatabase implements Database{
	
	public void persist(String data) {
		System.out.println("Mysql has persisted: " + data);
	}
}

class OracleDatabase implements Database{
	
	public void persist(String data) {
		System.out.println("Oracle has persisted: " + data);
	}
}