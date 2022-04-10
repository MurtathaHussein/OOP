import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

/**
 * 
 */

/**
 * @Murtatha Hussein
 *
 */
public class AddAddressHandler implements HttpHandler{

	/**
	 * 
	 */
	public AddAddressHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("Add Address Handler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	      //BookDAO books = new BookDAO();

	    



	     out.write(
	      "<html>" +
	      "<head> <title>Address</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	       "<div class=\"container\">"+
	      "<h1> Add Address</h1>"+
	      "<form method=\"get\" action=\"/processAddAddress\">" +
	      "<div class=\"form-group\"> "+
	      
	       
	      "<label for=\"house\">House</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"house\" id=\"house\"> " + 

	      "<label for=\"addressline1\">Address Line 1</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"addressline1\" id=\"addressline1\"> " + 

	      "<label for=\"addressline2\">Address Line 2</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"addressline2\" id=\"addressline2\"> " + 
	      
"<label for=\"postcode\">Post Code</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"postcode\" id=\"postcode\"> " +

"<label for=\"city\">City</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"city\" id=\"city\"> " +

"<label for=\"country\">Country</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"country\" id=\"country\"> " + 

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
