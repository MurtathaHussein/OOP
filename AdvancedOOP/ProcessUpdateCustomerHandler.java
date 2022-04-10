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
public class ProcessUpdateCustomerHandler implements HttpHandler{

	/**
	 * 
	 */
	public ProcessUpdateCustomerHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void handle(HttpExchange he) throws IOException {
		   
	    System.out.println("ProcessUpdateCustomerHandler Called");
	    he.sendResponseHeaders(200,0);
	    BufferedWriter out = new BufferedWriter(  
	        new OutputStreamWriter(he.getResponseBody() ));
	    
	    // Get param from URL
	    Map <String,String> parms = Util.requestStringToMap
	    (he.getRequestURI().getQuery());

	    // print the params for debugging 
	    System.out.println(parms);

	    //get ID number
	  

	    CustomerDAO customers = new CustomerDAO();
      AddressDAO addressess = new AddressDAO();

	    System.out.println("about to get data");

	    int id = Integer.parseInt(parms.get("id"));
	    String firstName = parms.get("firstName");
	    String secondName = parms.get("secondName");
	    String telephoneNumber = parms.get("telephoneNumber");
	    String aID = parms.get("aID");
	    int aIDvalue = Integer.parseInt(aID);
	    String house = parms.get("house");
	    String addressline1 = parms.get("addressline1");
	    String addressline2 = parms.get("addressline2");
	    String postcode = parms.get("postcode");
	    String city = parms.get("city");
	    String country = parms.get("country");
	    
	    
	    Address aaddress = new Address(aIDvalue,house,addressline1,addressline2,city,country,postcode);
	    try {
	    	addressess.addAddress(aaddress);
	    	Customer acustomer = new Customer(id,firstName,secondName,aaddress,telephoneNumber);
	    	
	    	System.out.println("about to create customer"); // Debugging message 
		    System.out.println("Customer to Add" + acustomer);
		    
	    	
			customers.addCustomer(acustomer);// add to database 
			
			out.write(
				      "<html>" +
				      "<head> <title>Customer</title> "+
				         "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">" +
				      "</head>" +
				      "<body>" +
				      "<h1> Customer Updated</h1>"+
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
				      "    <td>"+ acustomer.getCustomerID() + "</td>" +
				      "    <td>"+ acustomer.getFirstName() + "</td>" +
				      "    <td>"+ acustomer.getSecondName() + "</td>" +
				      "    <td>"+ acustomer.getTelephoneNumber() + "</td>" +
				      "    <td>"+ acustomer.getAddress().id + "</td>" +
				      "    <td>"+ acustomer.getAddress().house + "</td>" +
				      "    <td>"+ acustomer.getAddress().addressline1 + "</td>" +
				      "    <td>"+ acustomer.getAddress().addressline2 + "</td>" +
				      "    <td>"+ acustomer.getAddress().postCode + "</td>" +
				      "    <td>"+ acustomer.getAddress().city + "</td>" +
				      "    <td>"+ acustomer.getAddress().country + "</td>" +
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
