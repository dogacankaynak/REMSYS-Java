import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Auto Generated Java Class.
 */
public class RealEstate {

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	public boolean isForRent() {
		return forRent;
	}

	public void setForRent(boolean forRent) {
		this.forRent = forRent;
	}

	public String getPhoto() {
		return photo;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setMeter(int meter) {
		this.meter = meter;
	}

	public int getMeter() {
		return meter;
	}

	public String getId() {
		return id;
	}
	
	public String getDate() {
		return this.id.split("-")[0];
		
	}

	public void setId(String id) {
		this.id = id;
	}

	String id;
	String title;
	String city;
	String town;
	String district;
	double price;
	String type; // house - workplace
	String capacity;
	boolean furnished;
	boolean forSale;
	boolean forRent;
	String photo;
	int meter;
	String period;

	public RealEstate(String title, String city, String town, String district, double price, String type,
			String capacity, boolean furnished, boolean forSale, boolean forRent, String photo, String id, int meter,
			String period) throws FileNotFoundException, IOException {
		
		
		this.id = id;
		this.title = title;
		this.city = city;
		this.town = town;
		this.district = district;
		this.price = price;
		this.type = type;
		this.capacity = capacity;
		this.furnished = furnished;
		this.forSale = forSale;
		this.forRent = forRent;
		this.meter = meter;
		this.period = period;
		this.photo = photo;

	}

	public String toString() {
		if (isFurnished() && isForSale())
			return "<html><pre>Title : " + title + "\n" + "For : Sale" + "\n" + "City : " + city + "\n" + "Town: " + town + "\n"
					+ "District: " + district + "\n" + "Price: " + price + "\n" + "Type: " + type + "\n" + "Furnished"
					+ "\n" + "Number Of Room: " + capacity + "\n" + "Meter: " + meter + "\n" + "Added Date: " + getDate() +" </pre></html>";
		else if (isFurnished() && isForRent())
			return "<html><pre>Title : " + title + "\n" + "For : Rent" + "\n" + "City : " + city + "\n" + "Town: " + town + "\n"
					+ "District: " + district + "\n" + "Price: " + price + "\n" + "Type: " + type + "\n" + "Furnished"
					+ "\n" + "Number Of Room: " + capacity + "\n" + "Meter: " + meter + "\n" + "Added Date: " + getDate() + "</pre></html>";

		else if (isForSale())
			return "<html><pre>Title : " + title + "\n" + "For : Sale" + "\n" + "City : " + city + "\n" + "Town: " + town + "\n"
					+ "District: " + district + "\n" + "Price: " + price + "\n" + "Type: " + type + "\n"
					+ "Without Furnisher" + "\n" + "Number Of Room: " + capacity + "\n" + "Meter: " + meter + "\n" + "Added Date: " + getDate() +"</pre></html>";
		else
			return "<html><pre>Title : " + title + "\n" + "For  : Rent" + "\n" + "City : " + city + "\n" + "Town: " + town
					+ "\n" + "District: " + district + "\n" + "Price: " + price + "\n" + "Type: " + type + "\n"
					+ "Without Furnisher" + "\n" + "Number Of Room: " + capacity + "\n" + "Meter: " + meter + "\n" + "Added Date: " + getDate() +"</pre></html>";
	}

	// TOSTRING YAZ

}
