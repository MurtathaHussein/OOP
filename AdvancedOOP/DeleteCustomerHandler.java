import java.io.OutputStream;
import java.io.OutputStreamWriter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.util.ArrayList;
import java.sql.SQLException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;


public class DeleteCustomerHandler implements HttpHandler{

	public DeleteCustomerHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("DeleteCustomerHandler Called");
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

	    CustomerDAO customers = new CustomerDAO();

	    

	    try{
	      // get the book details before we delete from the Database
	      Customer deletedCustomer = customers.getCustomer(ID);
	      // actually delete from database;
	      customers.deleteCustomer(ID);
	      

	     out.write(
	      "<html>" +
	      "<head> <title>Customer's List</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<h1> Customer Deleted</h1>"+
	      "<table class=\"table\">" +
	      "<thead>" +
	      "  <tr>" +
	      "    <th>ID</th>" +
	      "    <th>First Name</th>" +
	      "    <th>Second Name</th>" +
	      "    <th>Telephone Number</th>" +
		"    <th>Address ID</th>" +
		"    <th>House</th>" +
		"    <th>Address Line 1</th>" +
		"    <th>Address Line 2</th>" +
		"    <th>Postcode</th>" +
		"    <th>City</th>" +
		"    <th>Country</th>" +
	      
	      "  </tr>" +
	      "</thead>" +
	      "<tbody>");

	      
	        out.write(
	        		"  <tr>"       +
	        			      "    <td>"+ deletedCustomer.getCustomerID() + "</td>" +
	        			      "    <td>"+ deletedCustomer.getFirstName() + "</td>" +
	        			      "    <td>"+ deletedCustomer.getSecondName() + "</td>" +
	        			      "    <td>"+ deletedCustomer.getTelephoneNumber() + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().id + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().house + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().addressline1 + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().addressline2 + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().postCode + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().city + "</td>" +
	        			      "    <td>"+ deletedCustomer.getAddress().country + "</td>" +
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
