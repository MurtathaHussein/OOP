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
public class BookDAO {

	/**
	 * 
	 */
	public BookDAO() {
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
	
	
	public ArrayList<Book> getAllBooks() throws SQLException {
		System.out.println("Retrieving all books ...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM books;";
		ArrayList<Book> books = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			//System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query); // Execute SQL query and record response to string
			while (result.next()) {

				int id = result.getInt("ID");
				String title = result.getString("Title");
				String author = result.getString("Author");
				int year = result.getInt("Year");
				int edition = result.getInt("Edition");
				String publisher = result.getString("Publisher");
				String isbn = result.getString("ISBN");
				String cover = result.getString("Cover");
				String condition = result.getString("Condition");
				int price = result.getInt("price");
				String notes = result.getString("Notes");
				
				books.add(new Book(id,title,author,year,edition,publisher,isbn,cover,condition,price,notes));
			}
		} catch(Exception e) {
			System.out.println("get all books: "+e);
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
		return books;
	}
	
	
	public Book getBook(int ID) throws SQLException {

		Book bookResult = null;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;

		String query = "SELECT * FROM books WHERE ID =" + ID + ";";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
		//	System.out.println("DBQuery: " + query);
			// execute SQL query
			result = statement.executeQuery(query);

			while (result.next()) {


				int id = result.getInt("ID");
				String title = result.getString("Title");
				String author = result.getString("Author");
				int year = result.getInt("Year");
				int edition = result.getInt("Edition");
				String publisher = result.getString("Publisher");
				String isbn1 = result.getString("ISBN");
				String cover = result.getString("Cover");
				String condition = result.getString("Condition");
				int price = result.getInt("price");
				String notes = result.getString("Notes");
				
				bookResult = new Book(id,title,author,year,edition,publisher,isbn1,cover,condition,price,notes);

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
		return bookResult;
	}
	
	
	public Boolean deleteBook(int book_id) throws SQLException {
		System.out.println("Deleting book");
		Connection dbConnection = null;
		Statement statement = null;
		int result = 0;
		String query = "DELETE FROM books WHERE ID = " + book_id + ";";
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
	
	public Boolean updateBook(Book book) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "UPDATE books " + "SET ID = '" + book.getBookID() + "'," + "Title = '"
				+ book.getTitle() + "'," + "Author= '" + book.getAuthor() + "'," + "Year= " + book.getYear() + ", edition=" + book.getEdition() 
				+ ", publisher=" + book.getPublisher() + ", isbn=" + book.getISBN() + ", cover=" + book.getCover() + ", condition=" + book.getCondition() 
				+ ", price=" + book.getPrice() + ", notes=" + book.getNotes() + " WHERE ID = " + book.getBookID()
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
	
	
	
	public boolean addBook(Book book) throws SQLException{
		Connection dbConnection = null;
		Statement statement = null;
		System.out.println("addBook Called");
		String update = "INSERT INTO books (ID, Title, Author, Year, Edition, Publisher, ISBN, Cover, Condition, Price, Notes ) VALUES ("+book.getBookID()+",'"+ book.getTitle()+"','"+book.getAuthor()+"',"+book.getYear()+","+book.getEdition() +","+book.getPublisher() +","+book.getISBN() +","+book.getCover() +","+book.getCondition() +","+book.getPrice() +","+book.getNotes() + ");";
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
