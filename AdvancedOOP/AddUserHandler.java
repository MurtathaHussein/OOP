import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class AddUserHandler implements HttpHandler{

	public AddUserHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("Add User Handler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	      //BookDAO books = new BookDAO();

	    



	     out.write(
	      "<html>" +
	      "<head> <title>User List</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	       "<div class=\"container\">"+
	      "<h1> Add User</h1>"+
	      "<form method=\"get\" action=\"/processAddUser\">" +
	      "<div class=\"form-group\"> "+
	      
	       
	      "<label for=\"username\">Username</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"username\" id=\"username\"> " + 

	      "<label for=\"password\">Password</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"password\" id=\"password\"> " + 

	      "<label for=\"user type\">User Type</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"user_type\" id=\"user_type\"> " + 

	      "<button type=\"submit\" class=\"btn btn-primary\">Submit</button> " + 
	      "</div>" + 
	      "</form>" +
	      "<a href=\"/\">Back to List </a>"+
	      "</div>" +
	      "</body>" +
	      "</html>");
	   
	    out.close();

	}

}
