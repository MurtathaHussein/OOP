import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @Murtatha Hussein 
 *
 */
public class CustomerDAO {

	/**
	 * 
	 */
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		try {
			String dbURL = "jdbc:sqlite:books-5.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return dbConnection;
	}
	
	
	public ArrayList<Customer> getAllCustomers() throws SQLException {
		System.out.println("Retrieving all customers ...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM customer;";
		ArrayList<Customer> customers = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			//System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query); // Execute SQL query and record response to string
			while (result.next()) {

				int id = result.getInt("ID");
				String firstName = result.getString("firstName");
				String secondName = result.getString("secondName");
				String telephoneNumber = result.getString("telephoneNumber");
				int address_id = result.getInt("address_id");
				Address address = new Address();
				AddressDAO addressess = new AddressDAO(); 
				address = addressess.getAddress(address_id);
				
				
				customers.add(new Customer(id,firstName,secondName,address,telephoneNumber));
			}
		} catch(Exception e) {
			System.out.println("get all customers: "+e);
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return customers;
	}
	
	// this function will retrive customer by ID from the database 
	public Customer getCustomer(int ID) throws SQLException {

		Customer customerResult = null;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM customer WHERE ID =" + ID + ";";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
		//	System.out.println("DBQuery: " + query);
			// execute SQL query
			result = statement.executeQuery(query);

			while (result.next()) {


				int id = result.getInt("ID");
				String firstName = result.getString("firstName");
				String secondName = result.getString("secondName");
				String telephoneNumber = result.getString("telephoneNumber");
				int address_id = result.getInt("address_id");
				Address address = new Address();
				AddressDAO addressess = new AddressDAO(); 
				address = addressess.getAddress(address_id); 
				
				customerResult = new Customer(id,firstName,secondName,address,telephoneNumber);
				
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return customerResult;
	}
	
	// this function will delete customer from database by ID
	public Boolean deleteCustomer(int cust_id) throws SQLException {
		System.out.println("Deleting user");
		Connection dbConnection = null;
		Statement statement = null;
		int result = 0;
		String query = "DELETE FROM customer WHERE ID = " + cust_id + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			result = statement.executeUpdate(query);
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	// this is upadte customer function
	public Boolean updateCustomer(Customer customer) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "UPDATE customer " + "SET firstName = '"
				+ customer.getFirstName() + "'," + "secondName= '" + customer.getSecondName() + "'," + "telephoneNumber= " + customer.getTelephoneNumber() + " WHERE ID = " + customer.getCustomerID()
				+ ";";
		System.out.println("Query about to be Called: " + query);
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			//System.out.println(query);
			// execute SQL update
			statement.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return true;
	}
	
	
	// add customer to the database function
	public boolean addCustomer(Customer customer) throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		System.out.println("addCustomer Called");
    //String update = "INSERT INTO customer (ID, firstName, secondName, telephoneNumber) VALUES ("+customer.getCustomerID()+",'"+ customer.getFirstName()+"','"+customer.getSecondName()+"',"+customer.getTelephoneNumber()+ ");";
		String update = "INSERT INTO customer (ID, firstName, secondName, telephoneNumber, address_id) VALUES ('" + customer.getCustomerID()+"','"+ customer.getFirstName()+"','"+customer.getSecondName()+"','"+customer.getTelephoneNumber()+ "','" + customer.getAddress().id + "'" + ");";  
		System.out.println("Query about to be Called: " + update);
		boolean ok = false;
			try {
					dbConnection = getDBConnection();
					statement = dbConnection.createStatement();
					System.out.println(update);
		// execute SQL query
					statement.executeUpdate(update);
					ok = true;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					if (statement != null) {
						statement.close();
					}
					if (dbConnection != null) {
						dbConnection.close();
					}
					
				}
			return ok;
	}

	

}
