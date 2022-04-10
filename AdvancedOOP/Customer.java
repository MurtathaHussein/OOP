/**
 * 
 */

/**
 * @Murtatha Hussein
 *
 */
public class Customer {
	int ID;
	String firstName;
	String secondName;	
	Address address;
	String telephoneNumber;
	
	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public Customer(int ID, String firstName, String secondName, Address address, String telephoneNumber) {
		super();
		this.ID = ID;
		this.firstName = firstName;
		this.secondName = secondName;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer [ID= " + ID + ", first name= " + firstName + ", second name= " + secondName  + ", address= " + address + ", telephone number= " + telephoneNumber +" ]";
	}
	
	//getter for ID
		public int getCustomerID() {
			return this.ID;
		}
		
		//setter for ID
		public void setID( int ID ) {
			this.ID = ID;
		}
		
		//getter for first name
		public String getFirstName() {
			return this.firstName;
		}
		
		//setter for firstname
		public void setFirstName( String firstName ) {
			this.firstName = firstName;
		}
		
		//getter for second name
		public String getSecondName() {
			return this.secondName;
		}
		
		//setter for second name
		public void setSecondName( String secondName ) {
			this.secondName = secondName;
		}
		
		//getter for telephone number
		public String getTelephoneNumber() {
			return this.telephoneNumber;
		}
		
		//setter for telephone number
		public void setTelephoneNumber( String telephoneNumber ) {
			this.telephoneNumber = telephoneNumber;
		}
		
		//getter for address
		public Address getAddress() {
			return this.address;
		}
		
		//setter for address
		public void setAddress( Address address ) {
			this.address = address;
		}

	

}
