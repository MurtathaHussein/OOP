import java.io.OutputStream;
import java.io.OutputStreamWriter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.util.ArrayList;
import java.sql.SQLException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

/**
 * 
 */

/**
 * @Murtatha Hussein
 *
 */
public class DeleteUserHandler implements HttpHandler{

	/**
	 * 
	 */
	public DeleteUserHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("DeleteUserHandler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    // Get param from URL
	    Map <String,String> parms = Util.requestStringToMap
	    (he.getRequestURI().getQuery());

	    // print the params for debugging 
	    System.out.println(parms);

	    //get ID number
	    int ID = Integer.parseInt(parms.get("id"));

	    UserDAO users = new UserDAO();

	    

	    try{
	      // get the book details before we delete from the Database
	      User deletedUser = users.getUser(ID);
	      // actually delete from database;
	      users.deleteUser(ID);
	      

	     out.write(
	      "<html>" +
	      "<head> <title>User's List</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<h1> User Deleted</h1>"+
	      "<table class=\"table\">" +
	      "<thead>" +
	      "  <tr>" +
	      "    <th>ID</th>" +
	      "    <th>Username</th>" +
	      "    <th>Password</th>" +
	      "    <th>User Type</th>" +
	    
	      "  </tr>" +
	      "</thead>" +
	      "<tbody>");

	      
	        out.write(
	        		"  <tr>"       +
	        			      "    <td>"+ deletedUser.getUserID() + "</td>" +
	        			      "    <td>"+ deletedUser.getUsername() + "</td>" +
	        			      "    <td>"+ deletedUser.getPassword() + "</td>" +
	        			      "    <td>"+ deletedUser.getUserType() + "</td>" +
	        			      "  </tr>"  
	        );
	      
	      out.write(
	      "</tbody>" +
	      "</table>" +
	      "<a href=\"/\">Back to Menu </a>"+
	      "</body>" +
	      "</html>");
	     }catch(SQLException se){
	      System.out.println(se.getMessage());
	    }
	    out.close();

	}

}
