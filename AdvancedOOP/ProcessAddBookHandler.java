import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.Map;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

/**
 * 
 */

/**
 * @Murtatha Hussein
 *
 */
public class ProcessAddBookHandler implements HttpHandler{

	/**
	 * 
	 */
	public ProcessAddBookHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("Process Add Book Handler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    // Get param from URL
	    Map <String,String> parms = Util.requestStringToMap
	    (he.getRequestURI().getQuery());

	    // print the params for debugging 
	    System.out.println(parms);

	    //get ID number
	  

	    BookDAO books = new BookDAO();

	    System.out.println("about to get data");

	    int ID = Integer.parseInt(parms.get("id"));
	    String title = parms.get("title");
	    String author = parms.get("author");
	    int year = Integer.parseInt(parms.get("year"));
	    int edition = Integer.parseInt(parms.get("edition"));
	    String publisher = parms.get("publisher");
	    String isbn = parms.get("isbn");
	    String cover = parms.get("cover");
	    String condition = parms.get("condition");
	    int price = Integer.parseInt(parms.get("price"));
	    String notes = parms.get("notes");
	   
	    System.out.println("about to create book"); // Debugging message 
	    Book book = new Book(ID,title,author,year,edition,publisher,isbn,cover,condition,price,notes);
	    System.out.println("Book to Add" + book);

	    try {  
	    books.addBook(book); // add to database 
	      

	     out.write(
	      "<html>" +
	      "<head> <title>Book Library</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<h1> Book Added</h1>"+
	      "<table class=\"table\">" +
	      "<thead>" +
	      "  <tr>" +
	      "    <th>ID</th>" +
	      "    <th>Title</th>" +
	      "    <th>Author</th>" +
	      "    <th>Year</th>" +
	      "    <th>Edition</th>" +
	      "    <th>Publisher</th>" +
	      "    <th>ISBN</th>" +
	      "    <th>Cover</th>" +
	      "    <th>Condition</th>" +
	      "    <th>Price</th>" +
	      "    <th>Notes</th>" +
	    
	      "  </tr>" +
	      "</thead>" +
	      "<tbody>");

	      
	        out.write(
	      "  <tr>"       +
	      "    <td>"+ book.getBookID() + "</td>" +
	      "    <td>"+ book.getTitle() + "</td>" +
	      "    <td>"+ book.getAuthor() + "</td>" +
	      "    <td>"+ book.getYear() + "</td>" +
	      "    <td>"+ book.getEdition() + "</td>" +
	      "    <td>"+ book.getPublisher() + "</td>" +
	      "    <td>"+ book.getISBN() + "</td>" +
	      "    <td>"+ book.getCover() + "</td>" +
	      "    <td>"+ book.getCondition() + "</td>" +
	      "    <td>"+ book.getPrice() + "</td>" +
	      "    <td>"+ book.getNotes() + "</td>" +
	      "  </tr>" 
	        );
	   
	      out.write(
	      "</tbody>" +
	      "</table>" +
	      "<a href=\"/\">Back to List </a>"+
	      "</body>" +
	      "</html>");
	   }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
	  
	    out.close();

	}

}
