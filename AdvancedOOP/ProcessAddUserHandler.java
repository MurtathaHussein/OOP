
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
public class ProcessAddUserHandler implements HttpHandler{

	/**
	 * 
	 */
	public ProcessAddUserHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("ProcessAddUserHandler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    // Get param from URL
	    Map <String,String> parms = Util.requestStringToMap
	    (he.getRequestURI().getQuery());

	    // print the params for debugging 
	    System.out.println(parms);

	    //get ID number
	  

	    UserDAO users = new UserDAO();

	    System.out.println("about to get data");

	    int ID = Integer.parseInt(parms.get("id"));
	    String username = parms.get("username");
	    String password = parms.get("password");
	    int user_type = Integer.parseInt(parms.get("user_type"));
	   
	    System.out.println("about to create user"); // Debugging message 
	    User user = new User(ID,username,password,user_type);
	    System.out.println("User to Add" + user);

	    try {  
	    	users.addUser(user); // add to database 
	      

	     out.write(
	      "<html>" +
	      "<head> <title>User Library</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<h1> User Added</h1>"+
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
	      "    <td>"+ user.getUserID() + "</td>" +
	      "    <td>"+ user.getUsername() + "</td>" +
	      "    <td>"+ user.getPassword() + "</td>" +
	      "    <td>"+ user.getUserType() + "</td>" +
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
