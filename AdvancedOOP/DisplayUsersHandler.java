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
public class DisplayUsersHandler implements HttpHandler{

	/**
	 * 
	 */
	public DisplayUsersHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {

	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    UserDAO users = new UserDAO();
	    try{
	    ArrayList<User> allusers = users.getAllUsers();
	   
	    out.write(
	      "<html>" +
	      "<head> <title>User List</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<div class=\"container\">" +
	      "<h1> List of Users!</h1>"+
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

	      for (User u : allusers){
	        out.write(
	      "  <tr>"       +
	      "    <td>"+ u.getUserID() + "</td>" +
	      "    <td>"+ u.getUsername() + "</td>" +
	      "    <td>"+ u.getPassword() + "</td>" +
	      "    <td>"+ u.getUserType() + "</td>" +
        "    <td> <a href=\"/editUser?id=" + u.getUserID() + "\"> edit</a> </td>" +  
	      "    <td> <a href=\"/deleteUser?id=" + u.getUserID() + "\"> delete </a> </td>" +  
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
