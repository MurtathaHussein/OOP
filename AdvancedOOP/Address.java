/**
 * 
 */

/**
 * @Murtatha Hussein
 *
 */
public class Address {
	int id;
	String house;
	String addressline1;
	String addressline2;
	String city;
	String country;
	String postCode;
	
	/**
	 * 
	 */
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	//constructor
	public Address(int id,String house, String addressline1, String addressline2, String city, String country, String postCode) {
		super();
		this.id = id;
		this.house = house;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Address [house= " + house + ", addressline1= " + addressline1 + ", addressline2= " + addressline2  + ", country= " + country + ", postCode= " + postCode +" ]";
	}
	
		//getter for id
		public int getAddressID() {
			return this.id;
		}
		
		//setter for id
		public void setAddressID( int id ) {
			this.id = id;
		}
		
		//getter for house
		public String getHouse() {
			return this.house;
		}
		
		//setter for house
		public void setHouse( String house ) {
			this.house = house;
		}
		
		//getter for address line 1
		public String getAddressLine1() {
			return this.addressline1;
		}
		
		//setter for address line 1
		public void setAddressLine1( String addressline1 ) {
			this.addressline1 = addressline1;
		}
		
		//getter for address line 2
		public String getAddressLine2() {
			return this.addressline2;
		}
		
		//setter for address line 2
		public void setAddressLine2( String addressline2 ) {
			this.addressline2 = addressline2;
		}
		
		//getter for country
		public String getCity() {
			return this.city;
		}
		
		//setter for country
		public void setCity( String city ) {
			this.city = city;
		}
		
		//getter for country
		public String getCountry() {
			return this.country;
		}
		
		//setter for country
		public void setCountry( String country ) {
			this.country = country;
		}
		
		//getter for postcode
		public String getPostCode() {
			return this.postCode;
		}
		
		//setter for postcode
		public void setPostCode( String postCode ) {
			this.postCode = postCode;
		}
		
		

}
