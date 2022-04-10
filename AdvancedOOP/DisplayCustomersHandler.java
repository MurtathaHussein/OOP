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
public class DisplayCustomersHandler implements HttpHandler{

	/**
	 * 
	 */
	public DisplayCustomersHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {

	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    CustomerDAO customers = new CustomerDAO();
	    try{
	    ArrayList<Customer> allcustomers = customers.getAllCustomers();
	   
	    out.write(
	      "<html>" +
	      "<head> <title>Customer List</title> "+
	         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
	      "</head>" +
	      "<body>" +
	      "<div class=\"container\">" +
	      "<h1> List of Customers!</h1>"+
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

	      for (Customer c : allcustomers){
	        out.write(
	      "  <tr>"       +
	      "    <td>"+ c.getCustomerID() + "</td>" +
	      "    <td>"+ c.getFirstName() + "</td>" +
	      "    <td>"+ c.getSecondName() + "</td>" +
	      "    <td>"+ c.getTelephoneNumber() + "</td>" +
	      "    <td>"+ c.getAddress().id + "</td>" +
	      "    <td>"+ c.getAddress().house + "</td>" +
	      "    <td>"+ c.getAddress().addressline1 + "</td>" +
	      "    <td>"+ c.getAddress().addressline2 + "</td>" +
	      "    <td>"+ c.getAddress().postCode + "</td>" +
	      "    <td>"+ c.getAddress().city + "</td>" +
	      "    <td>"+ c.getAddress().country + "</td>" +
        "    <td> <a href=\"/editCustomer?id=" + c.getCustomerID() + "\"> edit </a> </td>" +  
	      "    <td> <a href=\"/deleteCustomer?id=" + c.getCustomerID() + "\"> delete </a> </td>" +  
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
