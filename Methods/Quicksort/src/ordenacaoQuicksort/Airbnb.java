package ordenacaoQuicksort;

public class Airbnb {
	
// Declara��o de vavi�veis do Tipo String
	
	private String roomID;
	private String hostID;
	private String roomtype;
	private String country;
	private String city;
	private String Bairro;
	private String review;
	private String overallSatisfaction;
	private String accommodates;
	private String bedrooms;
	private String price;
	private String propertyType;
	
// M�todo construtor
	
	public Airbnb(String roomID, String hostID, String roomtype, String country, String city, String bairro,
			String review, String overallSatisfaction, String accommodates, String bedrooms, String price,
			String propertyType) {
		this.roomID = roomID;
		this.hostID = hostID;
		this.roomtype = roomtype;
		this.country = country;
		this.city = city;
		Bairro = bairro;
		this.review = review;
		this.overallSatisfaction = overallSatisfaction;
		this.accommodates = accommodates;
		this.bedrooms = bedrooms;
		this.price = price;
		this.propertyType = propertyType;
	} // end construtor
	
// M�todos Gets e Sets 
	
	public String getRoomID() {
		return roomID;
	} // end getRoomID()
	
	public void setRoomID (String roomID) {
		this.roomID = roomID;
	} // end setRoomID

	public String getHostID() {
		return hostID;
	} // end getHostID
	
	public void setHostID (String hostID) {
		this.hostID = hostID;
	} // end setHostID
	
	public String getRoomtype () {
		return roomtype;
	} // end getRoomtype
	
	public void setRoomtype (String roomtype) {
		this.roomtype = roomtype;
	} // end setRoomtype
	
	public String getCountry() {
		return country;
	} // end getCountry()
	
	public void setCountry (String country) {
		this.country = country;
	} // end setCountry
	
	public String getCity () {
		return city;
	} // end getCity
	
	public void setCity (String city) {
		this.city = city;
	} // end setCity
	
	public String getBairro () {
		return Bairro;
	} // end getBairro
	
	public void setBairro (String bairro) {
		Bairro = bairro;
	} // end setBairro
	
	public String getReview () {
		return review;
	} // end getReview
	
	public void setReview (String review) {
		this.review = review;
	} // end setReview
	
	public String getOverallSatisfaction () {
		return overallSatisfaction;
	} // end getOverallSatisfaction
	
	public void setOverallSatisfaction (String overallSatisfaction) {
		this.overallSatisfaction = overallSatisfaction;
	} // end setOverallSatisfaction
	
	public String getAccommodates () {
		return accommodates;
	} // end getAccommodates
	
	public void setAccommodates (String accommodates) {
		this.accommodates = accommodates;
	} // end setAccommodates
	
	public String getBedrooms() {
		return bedrooms;
	} // end  getBedrooms
	
	public void setBedrooms (String bedrooms) {
		this.bedrooms = bedrooms;
	} // setBedrooms
	
	public String getPrice() {
		return price;
	} // end getPrice
	
	public void setPrice (String price) {
		this.price = price;
	} // end setPrice
	
	public String getPropertyType () {
		return propertyType;
	} // end getPropertyType
	
	public void setPropertyType (String propertyType) {
		this.propertyType = propertyType;
	} // end setPropertyType
} // end class Airbnb