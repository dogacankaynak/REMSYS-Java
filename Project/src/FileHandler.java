import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

public class FileHandler {
	public static final String LOGINFILE = "Login.hay";
	public static final String ESTATESFILE = "Estates.hay";
	public static String userId = "";

	public static boolean checkAccount(String username, String password) throws FileNotFoundException {

		File f = new File(LOGINFILE);
		Scanner sc = new Scanner(f);

		while (sc.hasNextLine()) {
			String a = "";
			String b = "";
			String c = "";
			String line = sc.nextLine();
			Scanner sc2 = new Scanner(line);
			sc2.useDelimiter("<>");
			int count = 0;
			while (sc2.hasNext()) {
				if (count == 0)
					a = sc2.next();
				if (count == 1)
					b = sc2.next();
				if (count == 2)
					c = sc2.next();
				count++;

			}
			if (a.equals(username) && b.equals(password)) {
				userId = c;
				return true;
			}

		}
		return false;
	}

	public static int checkUser() {
		if (userId.equals("admin"))
			return 0;
		else if (userId.equals("agency"))
			return 1;
		return 2;
	}

	public static boolean userNameCheck(String username) throws FileNotFoundException {

		File f = new File(LOGINFILE);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String userName = line.substring(0, line.indexOf('<'));
			if (userName.equals(username))
				return true;
		}
		return false;

	}
	// USERNAME CHECK YAZ FARKI B OLMICAK

	/*
	 * public static ArrayList<RealEstate> readEstatesFromFile() throws
	 * FileNotFoundException{
	 * 
	 * ArrayList<RealEstate> estateList = new ArrayList<RealEstate>();
	 * 
	 * File f = new File(ESTATESFILE); Scanner sc = new Scanner(f);
	 * 
	 * while(sc.hasNextLine()){ int id = -1; String period = ""; int meter = -1;
	 * String title=""; String city=""; String town=""; String district="";
	 * double price = -1; String type=""; //house - workplace String
	 * capacity=""; boolean furnished=false; boolean forSale=false; boolean
	 * forRent=false; String photo="";
	 * 
	 * String line = sc.nextLine();//sat�r� par�alama Scanner sc2 = new
	 * Scanner(line); sc2.useDelimiter("<>"); int count=0; while(sc2.hasNext()){
	 * if(count==0) title=sc.next(); else if(count ==1) city=sc.next(); else
	 * if(count ==2) town=sc.next(); else if(count ==3) district=sc.next(); else
	 * if(count ==4) price=Double.parseDouble(sc.next()); else if(count ==5)
	 * type=sc.next(); else if(count ==6) capacity=sc.next(); else if(count ==7)
	 * furnished=Boolean.parseBoolean(sc.next()); else if(count ==8)
	 * forSale=Boolean.parseBoolean(sc.next()); else if(count ==9)
	 * forRent=Boolean.parseBoolean(sc.next()); else if(count ==10)
	 * photo=sc.next(); else if(count ==11) id = Integer.parseInt(sc.next());
	 * else if(count ==12) meter = Integer.parseInt(sc.next()); else if(count
	 * ==13) period = sc.next(); count++; }
	 * 
	 * RealEstate r = new RealEstate( title, city, town, district, price,
	 * type,capacity, furnished, forSale, forRent,photo ,id ,meter ,period);
	 * estateList.add(r);
	 * 
	 * } return estateList; }
	 */

	public static void writeUserToFile(String username, String password, String type)
			throws FileNotFoundException, IOException {

		File f = new File(LOGINFILE);
		if (!f.exists()) {
			FileNotFoundException nas = new FileNotFoundException();
			throw nas;
		}
		PrintWriter pw = new PrintWriter(new FileWriter(f, true));
		pw.println(username + "<>" + password + "<>" + type);

		pw.close();

	}

	public static void writeEstateToFile(RealEstate r) throws FileNotFoundException, IOException {
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		String id_with_time = year + ":" + month + ":" + day;
		String id = "";
		File f = new File(ESTATESFILE);
		if (!f.exists()) {
			FileNotFoundException nas = new FileNotFoundException();
			throw nas;
		}
		if (readEstateFromFile().size() == 0){
			id = id_with_time + "-0";
		}
		if (readEstateFromFile().size() > 0)
			id = id_with_time + "-" + getMaxId();

		PrintWriter pw = new PrintWriter(new FileWriter(f, true));
		pw.println(r.getTitle() + "<>" + r.getCity() + "<>" + r.getTown() + "<>" + r.getDistrict() + "<>" + r.getPrice()
				+ "<>" + r.getType() + "<>" + r.getCapacity() + "<>" + r.isFurnished() + "<>" + r.isForSale() + "<>"
				+ r.isForRent() + "<>" + r.getPhoto() + "<>" + r.getId() + "<>" + r.getMeter() + "<>" + r.getPeriod());

		pw.close();

	}

	public static void reWriteEstateToFile(ArrayList<RealEstate> realEstate) throws IOException {
		File f = new File(ESTATESFILE);
		if (!f.exists()) {
			FileNotFoundException nas = new FileNotFoundException();
			throw nas;
		}
		PrintWriter pw = new PrintWriter(new FileWriter(f, false));
		for (int i = 0; i < realEstate.size(); i++) {
			RealEstate r = realEstate.get(i);
			pw.println(r.getTitle() + "<>" + r.getCity() + "<>" + r.getTown() + "<>" + r.getDistrict() + "<>"
					+ r.getPrice() + "<>" + r.getType() + "<>" + r.getCapacity() + "<>" + r.isFurnished() + "<>"
					+ r.isForSale() + "<>" + r.isForRent() + "<>" + r.getPhoto() + "<>" + r.getId() + "<>"
					+ r.getMeter() + "<>" + r.getPeriod());

		}

		pw.close();

	}

	public static ArrayList<RealEstate> readEstateFromFile() throws FileNotFoundException, IOException {

		File r = new File(ESTATESFILE);
		Scanner fileScan = new Scanner(r);
		ArrayList<RealEstate> temp = new ArrayList<RealEstate>();
		if (!r.exists()) {
			FileNotFoundException nas = new FileNotFoundException();
			throw nas;
		}

		String id = null;
		String period = "";
		int meter = -1;
		String title = "";
		String city = "";
		String town = "";
		String district = "";
		double price = -1;
		String type = ""; // house - workplace
		String capacity = "";
		boolean furnished = false;
		boolean forSale = false;
		boolean forRent = false;
		String photo = "";
		while (fileScan.hasNextLine()) {

			String line = fileScan.nextLine();
			Scanner sc2 = new Scanner(line);
			sc2.useDelimiter("<>");
			int count = 0;
			while (sc2.hasNext()) {
				if (count == 0)
					title = sc2.next();
				if (count == 1)
					city = sc2.next();
				if (count == 2)
					town = sc2.next();
				if (count == 3)
					district = sc2.next();
				if (count == 4)
					price = Double.parseDouble(sc2.next());
				if (count == 5)
					type = sc2.next();
				if (count == 6)
					capacity = sc2.next();
				if (count == 7)
					furnished = Boolean.parseBoolean(sc2.next());
				if (count == 8)
					forSale = Boolean.parseBoolean(sc2.next());
				if (count == 9)
					forRent = Boolean.parseBoolean(sc2.next());
				if (count == 10)
					photo = sc2.next();
				if (count == 11)
					id = sc2.next();
				if (count == 12)
					meter = Integer.parseInt(sc2.next());
				if (count == 13)
					period = sc2.next();
				count++;

			}
			temp.add(new RealEstate(title, city, town, district, price, type, capacity, furnished, forSale, forRent,
					photo, id, meter, period));
		}

		return temp;

	}

	public static ArrayList<RealEstate> randomEstate() throws FileNotFoundException, IOException {
		ArrayList<RealEstate> result = new ArrayList<RealEstate>();

		for (int i = 0; i < 8; i++) {
			int random = (int) (Math.random() * readEstateFromFile().size());
			result.add(readEstateFromFile().get(random));
		}
		return result;
	}

	
	public static ArrayList<RealEstate> search(String city, String town, String district, double priceMin,
			double priceMax, String type, String capacity, int furnished, int isForSale, int isForRent, double meterMin, double meterMax)
			throws IOException {
		System.out.println("burda");
		ArrayList<RealEstate> all = readEstateFromFile();
		System.out.println(all.size());
		ArrayList<RealEstate> searchResult = new ArrayList<RealEstate>();
		for (RealEstate r : all) {
			//searching for filters
			if ((r.getCity().equalsIgnoreCase(city) || city.equalsIgnoreCase("") || city.equalsIgnoreCase("City"))
					&& (r.getTown().equalsIgnoreCase(town) || town.equalsIgnoreCase("Town")
							|| town.equalsIgnoreCase(""))
					&& (r.getDistrict().equalsIgnoreCase(district) || district.equalsIgnoreCase("District")
							|| district.equalsIgnoreCase(""))
					&& (r.getType().equalsIgnoreCase(type) || type.equals("") || type.equalsIgnoreCase("Type"))
					&& ((r.isForSale() == true && isForSale == 1) || (r.isForSale() == false && isForSale == 0)
							|| isForSale == 1)
					&& ((r.isForRent() == true && isForRent == 1) || (r.isForRent() == false && isForRent == 0)
							|| isForRent == 1)
					&& (r.getPrice() >= priceMin || priceMin == 0)
					&& (r.getPrice() <= priceMax || priceMax == 100000000)
					&& (r.getCapacity().equals(capacity) || capacity.equals("") || capacity.equals("Number Of Room"))
					&& (r.getMeter() >= meterMin || meterMin == 0)
					&& (r.getMeter() <= meterMax || meterMax == 1000000000000000.0)
					
//					&& ((r.isFurnished() == true && furnished == 1) || (r.isFurnished() == false && furnished == 0)
//							|| furnished == 1)
					
			) {
				searchResult.add(r);
			}else{
				System.out.println(isForRent + " " + isForSale);

			}
		}

		return searchResult;
	}

	public static void removeEstateFromArray(String id) throws FileNotFoundException, IOException {
		ArrayList<RealEstate> temp = readEstateFromFile();

		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getId() == id) {
				temp.remove(i);
			}
		}
		reWriteEstateToFile(temp);
	}


	public static int getMaxId() throws FileNotFoundException, IOException {
		ArrayList<RealEstate> realEstates = readEstateFromFile();
		int maxId = 0;
		for (int i = 0; i < realEstates.size(); i++) {
			int current_id = Integer.parseInt(realEstates.get(i).id.split("-")[1]);
			if (maxId < current_id) {
				maxId = current_id;
			}
		}

		return maxId;
	}

	public static ArrayList<RealEstate> searchByKeyWord(String keyword) throws FileNotFoundException, IOException {
		ArrayList<RealEstate> temp = new ArrayList<RealEstate>();
		for (int i = 0; i < readEstateFromFile().size(); i++) {
			if (readEstateFromFile().get(i).getCity().toLowerCase().equals(keyword)
					|| readEstateFromFile().get(i).getTown().toLowerCase().contains(keyword)
					|| readEstateFromFile().get(i).getDistrict().toLowerCase().contains(keyword))
				temp.add(readEstateFromFile().get(i));

		}

		return temp;

	}

}
