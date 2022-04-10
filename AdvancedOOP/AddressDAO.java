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
public class AddressDAO {

	/**
	 * 
	 */
	public AddressDAO() {
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
	
	
	public ArrayList<Address> getAllAddress() throws SQLException {
		System.out.println("Retrieving all addresses...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM customer_address;";
		ArrayList<Address> address = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			//System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query); // Execute SQL query and record response to string
			while (result.next()) {

				int id = result.getInt("ID");
				String house = result.getString("house");
				String addressline1 = result.getString("addressline1");
				String addressline2 = result.getString("addressline2");
				String city = result.getString("city");
				String country = result.getString("country");
				String postcode = result.getString("postcode");
				
				
				address.add(new Address(id,house,addressline1,addressline2,city,country,postcode));
			}
		} catch(Exception e) {
			System.out.println("get all address: "+e);
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
		return address;
	}
	
	// getting address customer address by ID from database 
	public Address getAddress(int ID) throws SQLException {

		Address addressResult = null;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
// query below to select all by ID
		String query = "SELECT * FROM customer_address WHERE ID =" + ID + ";";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
		//	System.out.println("DBQuery: " + query);
			// execute SQL query
			result = statement.executeQuery(query);

			while (result.next()) {


				int id = result.getInt("ID");
				String house = result.getString("house");
				String addressline1 = result.getString("addressline1");
				String addressline2 = result.getString("addressline2");
				String city = result.getString("city");
				String country = result.getString("country");
				String postcode = result.getString("postcode");
				
				addressResult = new Address(id,house,addressline1,addressline2,city,country,postcode);
				
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
		return addressResult;
	}
	
	// deleting address from table customer_address 
	public Boolean deleteAddress(int address_id) throws SQLException {
		System.out.println("Deleting address");
		Connection dbConnection = null;
		Statement statement = null;
		int result = 0;
		String query = "DELETE FROM customer_address WHERE ID = " + address_id + ";";
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
	// this will update address from database
	public Boolean updateAddress(Address address) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "UPDATE customer_address " + "SET house = '"
				+ address.getHouse() + "'," + "addressline1= '" + address.getAddressLine1() + "'," + "addressline2= '" + address.getAddressLine2() + "'," + "postcode= '" + address.getPostCode() + "'," + "city= '" + address.getCity() + "'," + "country= '" + address.getCountry() + "' WHERE ID = " + address.getAddressID()
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
	
	
	// this function will add address using address class to the database 
	public boolean addAddress(Address address) throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		System.out.println("addAddress Called");
		String update = "INSERT INTO customer_address (ID,house, addressline1, addressline2, postcode, city, country) VALUES ('"+ address.getAddressID()+ "','" + address.getHouse() + "','"+ address.getAddressLine1() + "','"+address.getAddressLine2()+"','"+address.getPostCode()+ "','"+address.getCity()+ "','"+address.getCountry()+ "'" +");";
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

  public int fetchAddressId() throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		System.out.println("Fetch Address id called");
		String update = "select last_insert_id() as address_id from customer_address";
		int last_id = 0;
		boolean ok = false;
			try {
					dbConnection = getDBConnection();
					statement = dbConnection.createStatement();
					System.out.println(update);
		// execute SQL query
					statement.executeUpdate(update);
					ok = true;
					
					ResultSet rs = statement.executeQuery(update);
					String lastidstr = rs.getString("address_id");
					System.out.println("Query about to be Called: " + lastidstr);
					last_id = Integer.parseInt(lastidstr);
					
					
					
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
			return last_id;
	}
  
	

}
