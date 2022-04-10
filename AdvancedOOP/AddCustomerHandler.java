/**
 * 
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

/**
 * @Murtatha Hussein
 *
 */
public class AddCustomerHandler implements HttpHandler{

	/**
	 * 
	 */
	public AddCustomerHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("Add Custotmer Handler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	      CustomerDAO customers = new CustomerDAO();

	    



	     out.write(
	      "<html>" +
	      "<head> <title>Customer</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	       "<div class=\"container\">"+
	      "<h1> Add Customer</h1>"+
	      "<form method=\"get\" action=\"/processAddCustomer\">" +
	      "<div class=\"form-group\"> "+
	      
	       
	      "<label for=\"id\">ID</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"id\" id=\"id\"> " + 
	      
"<label for=\"firstName\">First Name</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"firstName\" id=\"firstName\"> " + 

	      "<label for=\"secondName\">Second Name</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"secondName\" id=\"secondName\"> " + 

	      "<label for=\"telephoneNumber\">Telephone Number</label> " + 
	      "<input type=\"text\" class=\"form-control\" name=\"telephoneNumber\" id=\"telephoneNumber\"> " + 
	      
"<label for=\"addressID\">Address ID</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"aID\" id=\"aID\"> " + 

"<label for=\"House\">House</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"house\" id=\"house\"> " + 

"<label for=\"addressline1\">Address Line 1</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"addressline1\" id=\"addressline1\"> " + 

"<label for=\"addressline2\">Address Line 2</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"addressline2\" id=\"addressline2\"> " + 

"<label for=\"postCode\">postcode</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"postcode\" id=\"postcode\"> " +

"<label for=\"city\">city</label> " + 
"<input type=\"text\" class=\"form-control\" name=\"city\" id=\"city\"> " +

"<label for=\"country\">country</label> " + 
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
