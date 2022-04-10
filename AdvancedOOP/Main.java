import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * Murtatha Hussein
 *
 */
public class Main {
	static final private int PORT = 8080;
	

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException,SQLException {  //for sir method
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HttpServer server = HttpServer.create(new InetSocketAddress(PORT),0);
		/*try {
			HttpServer server = HttpServer.create(new InetSocketAddress(PORT),0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		server.createContext("/", new RootHandler() ); 
		server.createContext("/books", new DisplayBooksHandler() );
		server.createContext("/addbook", new AddBookHandler());
		server.createContext("/processAddBook", new ProcessAddBookHandler());
		server.createContext("/deletebook", new DeleteHandler() ); 
    server.createContext("/editbook", new UpdateBookHandler() ); 
    server.createContext("/processUpdateBook", new ProcessUpdateBookHandler());
		
		server.createContext("/customers", new DisplayCustomersHandler() );
		server.createContext("/addcustomer", new AddCustomerHandler());
		server.createContext("/processAddCustomer", new ProcessAddCustomerHandler());
		server.createContext("/deleteCustomer", new DeleteCustomerHandler() );
    server.createContext("/processUpdateCustomer", new ProcessUpdateCustomerHandler());
		
		
		server.createContext("/users", new DisplayUsersHandler() );
		server.createContext("/adduser", new AddUserHandler());
		server.createContext("/processAddUser", new ProcessAddUserHandler());
		server.createContext("/deleteUser", new DeleteUserHandler() ); 

    
    
		server.setExecutor(null);
		server.start();
		System.out.println("The server is listening on port " + PORT);

    Scanner in = new Scanner(System.in);
    CustomerDAO customers = new CustomerDAO();
    BookDAO books = new BookDAO();
    AddressDAO addressess = new AddressDAO();
    UserDAO users = new UserDAO();
    
    String selection;
    String selectionSubOptions;
  
    do {
      System.out.println("--------------------");
      System.out.println("Book Inventory");
      System.out.println("Choose from these options");
      System.out.println("--------------------");

      System.out.println("[1]Books Options");
      System.out.println("[2]Customers Options");
      System.out.println("[3]Users Options");
      System.out.println("[99] Exit");

      System.out.println();

      selection = in.nextLine();

      switch (selection) {
          case "1":

          System.out.println("[11] Retrieve all books ");
          System.out.println("[12] Search for a book");
          System.out.println("[13] Add a new book");
          System.out.println("[14] Update book details ");
          System.out.println("[15] Delete a book from databse");
          // System.out.println("[16] Back to Main Menu");

          selectionSubOptions = in.nextLine();
          switch (selectionSubOptions) {
            case "11":
              ArrayList<Book> allBooks = books.getAllBooks();
	              try {
	            	  for (int i = 0; i < allBooks.size(); i++) {
	  	                System.out.println(allBooks.get(i));
	  	              }
	            	  
	              }catch(Exception e) {
	      			System.out.println("get all books: "+e);
	      		}
              
              System.out.println();
              break;

              case "12":
              System.out.println("\nEnter Book ID to get details  ");
              int book_ID = Integer.parseInt(in.nextLine());
              System.out.println(books.getBook(book_ID));
              System.out.println();

              break;

              case "13":

              System.out.println("Add a new Book");
              //Books Boooks = createBooks();
              //books.addBooks(Boooks);

              System.out.println("Enter ID");
              int ID = Integer.parseInt(in.nextLine());
                
              System.out.println("Enter Title");
      				String title = in.nextLine();
              
              System.out.println("Enter Author");
      				String author = in.nextLine();
              
              System.out.println("Enter Year");
      				int year = Integer.parseInt(in.nextLine());
              
              System.out.println("Enter Edition");
      				int edition = Integer.parseInt(in.nextLine());
              
              System.out.println("Enter Publisher");
      				String publisher = in.nextLine();
              
              System.out.println("Enter ISBN");
      				String isbn = in.nextLine();
              
              System.out.println("Enter Cover");
      				String cover = in.nextLine();
              
              System.out.println("Enter Condition");
      				String condition = in.nextLine();
              
              System.out.println("Enter Price");
      				int price = Integer.parseInt(in.nextLine());
              
              System.out.println("Enter Notes");
      				String notes = in.nextLine();

              Book badd = new Book(ID,title,author,year,edition,publisher,isbn,cover,condition,price,notes);
              

              try {  
	            books.addBook(badd);
                }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
                
              System.out.println();

              break;
  
            case "14":
              System.out.println("Update book details");
              System.out.println("\nEnter Book ID to update ");
              
              int uBook_ID = Integer.parseInt(in.nextLine());
              //System.out.println(books.getBooks(uBook_ID));
              //Books updatedBooks = updateBooks(books.getBooks(uBook_ID));
              //books.updateBooks(updatedBooks);

              System.out.println("Enter further details to update the new Book");
              //Books Boooks = createBooks();
              //books.addBooks(Boooks);
                
              System.out.println("Enter Title");
      				String utitle = in.nextLine();
              
              System.out.println("Enter Author");
      				String uauthor = in.nextLine();
              
              System.out.println("Enter Year");
      				int uyear = Integer.parseInt(in.nextLine());
              
              System.out.println("Enter Edition");
      				int uedition = Integer.parseInt(in.nextLine());
              
              System.out.println("Enter Publisher");
      				String upublisher = in.nextLine();
              
              System.out.println("Enter ISBN");
      				String uisbn = in.nextLine();
              
              System.out.println("Enter Cover");
      				String ucover = in.nextLine();
              
              System.out.println("Enter Condition");
      				String ucondition = in.nextLine();
              
              System.out.println("Enter Price");
      				int uprice = Integer.parseInt(in.nextLine());
              
              System.out.println("Enter Notes");
      				String unotes = in.nextLine();

              Book bupdate = new Book(uBook_ID,utitle,uauthor,uyear,uedition,upublisher,uisbn,ucover,ucondition,uprice,unotes);
              

              try {  
	            books.updateBook(bupdate);
                }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
                
              System.out.println();
              

              break;

            case "15":
              System.out.println("Delete Book");
              System.out.println("Enter ID of Book to delete");
              int dBooks_ID = Integer.parseInt(in.nextLine());
              books.deleteBook(dBooks_ID);
              
              break;

            /*
             * case"16": System.exit(0);
             */

          }

          break;

        case "2":
  
          System.out.println("[21] Retrieve all Customers ");
          System.out.println("[22] Search for a Customers");
          System.out.println("[23] Add a new Customer");
          System.out.println("[24] Update Customer ");
          System.out.println("[25] Delete a Customer from ID");

          selectionSubOptions= in.nextLine();
          switch (selectionSubOptions) {
            case "21":
	              ArrayList<Customer> allCustomers = 
	               customers.getAllCustomers();
	              for (int i = 0; i < allCustomers.size(); i++) {
	                System.out.println(allCustomers.get(i));
	              }
	              
	              
	              System.out.println("display customers");
	              break;

            case "22":
	              System.out.println("\nEnter Customer ID to get details  ");
	              int customerId = Integer.parseInt(in.nextLine());
	              System.out.println(customers.getCustomer(customerId));
	              System.out.println();
	              break;

            case "23":
              System.out.println("Add a new Customer");
	                //Books Boooks = createBooks();
	                //books.addBooks(Boooks);

	                System.out.println("Enter Customer ID");
	                int id = Integer.parseInt(in.nextLine());
	                  
	                System.out.println("Enter First Name");
	        		String firstName = in.nextLine();
	                
	                System.out.println("Enter Second Name");
	        		String secondName = in.nextLine();
	                
	                System.out.println("Enter Telephone Number");
	        		String telephoneNumber = in.nextLine();

              System.out.println("Enter Address ID");
	                int aID = Integer.parseInt(in.nextLine());
	                
	                System.out.println("Enter House");
	        		String house = in.nextLine();
	                
	                System.out.println("Enter addressline 1");
	        		String addressline1 = in.nextLine();
	                
	                System.out.println("Enter addressline 2");
	        		String addressline2 = in.nextLine();
	                
	        		System.out.println("Enter postcode");
	        		String postcode = in.nextLine();
	        		
	        		System.out.println("Enter city");
	        		String city = in.nextLine();
	                
	                System.out.println("Enter country");
	        		String country = in.nextLine();
	        		
	        		Address aaddress = new Address(aID,house,addressline1,addressline2,city,country,postcode);
	        		try {  
	        			 addressess.addAddress(aaddress);
	        			 //int last_id=addressess.fetchAddressId(); 
	        			 //System.out.println("last inserted id value for address"+  last_id);
	        			 //Address fetchAdd = addressess.getAddress(last_id);
	        			 Customer acustomer = new Customer(id,firstName,secondName,aaddress,telephoneNumber);
	        			 customers.addCustomer(acustomer);
		                  }catch(SQLException se){
		  	      System.out.println(se.getMessage());
		  	    }
	                  
	                System.out.println();
	                  
	                System.out.println();
              break;

            case "24":
              System.out.println("Update Customer details");
	              System.out.println("\nEnter Customer ID to update ");

	              int ucustomerId = Integer.parseInt(in.nextLine());
	              
	                  
	                System.out.println("Enter First Name");
	        		String ufirstName = in.nextLine();
	                
	                System.out.println("Enter Second Name");
	        		String usecondName = in.nextLine();
	                
	                System.out.println("Enter Telephone Number");
	        		String utelephoneNumber = in.nextLine();
	        		
	        		System.out.println("Enter Address ID");
	                int uaID = Integer.parseInt(in.nextLine());
	                
	                System.out.println("Enter House");
	        		String uhouse = in.nextLine();
	                
	                System.out.println("Enter addressline 1");
	        		String uaddressline1 = in.nextLine();
	                
	                System.out.println("Enter addressline 2");
	        		String uaddressline2 = in.nextLine();
	                
	        		System.out.println("Enter postcode");
	        		String upostcode = in.nextLine();
	        		
	        		System.out.println("Enter city");
	        		String ucity = in.nextLine();
	                
	                System.out.println("Enter country");
	        		String ucountry = in.nextLine();
	        		
	        		Address uaddress = new Address(uaID,uhouse,uaddressline1,uaddressline2,ucity,ucountry,upostcode);
	        		
	        		try {  
	        			 addressess.updateAddress(uaddress);
	        			 Customer ucustomer = new Customer(ucustomerId,ufirstName,usecondName,uaddress,utelephoneNumber);
	        			 customers.updateCustomer(ucustomer);
		                  }catch(SQLException se){
		  	      System.out.println(se.getMessage());
		  	    }
	                  
	                System.out.println();
              break;

            case "25":
              System.out.println("Delete Customer");
              System.out.println("Enter ID of Customer to delete");
              int dcustomers_Id = Integer.parseInt(in.nextLine());
              customers.deleteCustomer(dcustomers_Id);
              break;

          }

          break;

        case "3":
          System.out.println("[31] Retrieve all Users ");
          System.out.println("[32] Search for a Users");
          System.out.println("[33] Add a new User");
          System.out.println("[34] Update User ");
          System.out.println("[35] Delete a User from ID");

          selectionSubOptions= in.nextLine();
          switch (selectionSubOptions) {
            case "31":
              ArrayList<User> allUsers = users.getAllUsers();
		              try {
		            	  for (int i = 0; i < allUsers.size(); i++) {
		  	                System.out.println(allUsers.get(i));
		  	              }
		            	  
		              }catch(Exception e) {
		      			System.out.println("get all users: "+e);
		      		}
		              
		              System.out.println();
              break;

            case "32":
              System.out.println("\nEnter User ID to get details  ");
	              int userId = Integer.parseInt(in.nextLine());
	              System.out.println(users.getUser(userId));
	              System.out.println();
	              break;

            case "33":
              System.out.println("Add a new User");
	              
	              System.out.println("Enter ID");
  	              int id = Integer.parseInt(in.nextLine());
                    
                  System.out.println("Enter Username");
          			String username = in.nextLine();
                  
                  System.out.println("Enter Password");
          			String password = in.nextLine();
          			
    	          int user_type = 2;
          			
    	          User uadd = new User(id,username,password,user_type);
                  

                  try {  
    	            users.addUser(uadd);
                    }catch(SQLException se){
    	      System.out.println(se.getMessage());
    	    }
                    
                  System.out.println();
              break;

            case "34":
              System.out.println("Update User details");
              System.out.println("\nEnter User ID to update ");


              System.out.println("Enter User ID");
  	              int uuserId = Integer.parseInt(in.nextLine());
                    
                  System.out.println("Enter Username");
          			String uusername = in.nextLine();
                  
                  System.out.println("Enter Password");
          			String upassword = in.nextLine();
          			
    	          int uuser_type = 2;

              User uupdate = new User(uuserId,uusername,upassword,uuser_type);
              

              try {  
                users.updateUser(uupdate);
                }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
                
              System.out.println();
              
              break;

            case "35":
              System.out.println("Delete Users");
		              System.out.println("Enter ID of User to delete");
		              int duser_Id = Integer.parseInt(in.nextLine());
		              users.deleteUser(duser_Id);
              break;  
          }
          
          break;

        case "99":
          System.out.println("Exiting");
          break;
        default:
          System.out.println("Invalid Selection");
      }
    }while (!selection.equals("99"));
    System.out.println("Thank you and Goodbye !");

              
          
      }
}
