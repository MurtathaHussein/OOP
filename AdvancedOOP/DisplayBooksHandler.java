import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

/**
 * 
 */

/**
 * @Murtatha Hussein
 *
 */
public class DisplayBooksHandler implements HttpHandler{

	/**
	 * 
	 */
	public DisplayBooksHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {

	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    BookDAO books = new BookDAO();
	    try{
	    ArrayList<Book> allBooks = books.getAllBooks();
	   
	    out.write(
	      "<html>" +
	      "<head> <title>Book List</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<div class=\"container\">" +
	      "<h1> List of Books!</h1>"+
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

	      for (Book b : allBooks){
	        out.write(
	      "  <tr>"       +
	      "    <td>"+ b.getBookID() + "</td>" +
	      "    <td>"+ b.getTitle() + "</td>" +
	      "    <td>"+ b.getAuthor() + "</td>" +
	      "    <td>"+ b.getYear() + "</td>" +
	      "    <td>"+ b.getEdition() + "</td>" +
	      "    <td>"+ b.getPublisher() + "</td>" +
	      "    <td>"+ b.getISBN() + "</td>" +
	      "    <td>"+ b.getCover() + "</td>" +
	      "    <td>"+ b.getCondition() + "</td>" +
	      "    <td>"+ b.getPrice() + "</td>" +
	      "    <td>"+ b.getNotes() + "</td>" +
        "    <td> <a href=\"/editbook?id=" + b.getBookID() + "\"> edit </a> </td>" +  
	      "    <td> <a href=\"/deletebook?id=" + b.getBookID() + "\"> delete </a> </td>" +  
	     
            
	      "  </tr>" 
	        );
	      }
	      out.write(
	      "</tbody>" +
	      "</table>" +
	     "<a href=\"/\">Back to Menu </a>"+
	      "</div>" +   
	             
	      "</body>" +
	      "</html>");
	     }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
	    out.close();

	  }

}
