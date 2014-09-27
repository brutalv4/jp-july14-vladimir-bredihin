package com.kademika.day10.shop.objectz;


import com.kademika.day10.shop.util.Staticz;

public class TestData {

	public static Car[] createCars() {

		Car[] cars = new Car[50];
		int i = 0;
        int idx = 0;

		SportCar sc = new SportCar();
		sc.setManufacturer("Nissan");
		sc.setModelName("GTR");
		sc.setBodyType(BodyType.COUPE);
		sc.setModelYear(2012);
		sc.setExteriorColor(Color.WHITE);
		sc.setInteriorColor(Color.BLACK);
		sc.setHorsePowerAmount(545);
		sc.setWheelDrive(4);
		sc.setPrice(140000);
        idx = Staticz.getCharIndexAtAlphabet(sc.getManufacturer());
        sc.setCatNum(idx + "_" + i);
		cars[i++] = sc;


		
		sc = new SportCar();
		sc.setManufacturer("Ford");
		sc.setModelName("Mustang");
		sc.setBodyType(BodyType.COUPE);
		sc.setModelYear(2010);
		sc.setExteriorColor(Color.WHITE);
		sc.setInteriorColor(Color.BLACK);
		sc.setHorsePowerAmount(450);
		sc.setWheelDrive(2);
		sc.setPrice(70000);
        idx = Staticz.getCharIndexAtAlphabet(sc.getManufacturer());
        sc.setCatNum(idx + "_" + i);
		cars[i++] = sc;
		
		sc = new SportCar();
		sc.setManufacturer("Nissan");
		sc.setModelName("GTR Black Edition");
		sc.setBodyType(BodyType.COUPE);
		sc.setModelYear(2014);
		sc.setExteriorColor(Color.BLACK);
		sc.setInteriorColor(Color.BLACK);
		sc.setHorsePowerAmount(545);
		sc.setWheelDrive(4);
		sc.setPrice(145000);
        idx = Staticz.getCharIndexAtAlphabet(sc.getManufacturer());
        sc.setCatNum(idx + "_" + i);
		cars[i++] = sc;

		SUV s = new SUV();
		s.setManufacturer("Wolksvagen");
		s.setModelName("Touareg");
		s.setBodyType(BodyType.SUV);
		s.setModelYear(2014);
		s.setExteriorColor(Color.BLUE);
		s.setInteriorColor(Color.WHITE);
		s.setHorsePowerAmount(333);
		s.setWheelDrive(4);
		s.setPrice(60000);
        idx = Staticz.getCharIndexAtAlphabet(s.getManufacturer());
        s.setCatNum(idx + "_" + i);
		cars[i++] = s;
		
		s = new SUV();
		s.setManufacturer("Wolksvagen");
		s.setModelName("Touareg");
		s.setBodyType(BodyType.SUV);
		s.setModelYear(2013);
		s.setExteriorColor(Color.BLUE);
		s.setInteriorColor(Color.WHITE);
		s.setHorsePowerAmount(333);
		s.setWheelDrive(4);
		s.setPrice(55000);
        idx = Staticz.getCharIndexAtAlphabet(s.getManufacturer());
        s.setCatNum(idx + "_" + i);
		cars[i++] = s;

		Car c = new Car();
		c.setManufacturer("Skoda");
		c.setModelName("Octavia RS");
		c.setBodyType(BodyType.SEDAN);
		c.setModelYear(2012);
		c.setExteriorColor(Color.GREEN);
		c.setInteriorColor(Color.WHITE);
		c.setHorsePowerAmount(179);
		c.setWheelDrive(2);
		c.setPrice(28500);
        idx = Staticz.getCharIndexAtAlphabet(c.getManufacturer());
        c.setCatNum(idx + "_" + i);
		cars[i++] = c;
		
		c = new Car();
		c.setManufacturer("Skoda");
		c.setModelName("Octavia");
		c.setBodyType(BodyType.SEDAN);
		c.setModelYear(2013);
		c.setExteriorColor(Color.GREEN);
		c.setInteriorColor(Color.WHITE);
		c.setHorsePowerAmount(149);
		c.setWheelDrive(2);
		c.setPrice(27000);
        idx = Staticz.getCharIndexAtAlphabet(c.getManufacturer());
        c.setCatNum(idx + "_" + i);
		cars[i++] = c;
		
		c = new Car();
		c.setManufacturer("Skoda");
		c.setModelName("Octavia");
		c.setBodyType(BodyType.SEDAN);
		c.setModelYear(2014);
		c.setExteriorColor(Color.GREEN);
		c.setInteriorColor(Color.WHITE);
		c.setHorsePowerAmount(149);
		c.setWheelDrive(2);
		c.setPrice(26200);
        idx = Staticz.getCharIndexAtAlphabet(c.getManufacturer());
        c.setCatNum(idx + "_" + i);
		cars[i++] = c;

		return cars;
	}

	public static Customer[] createCustomers() {

		Customer[] customers = new Customer[15];
		int i = 0;
		
		Customer c = new Customer();
		c.setFullName("Michaels, Steve");
		c.setBirthDate("20.06.1976");
		c.setCategory(CustomerCategory.B);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Campbell, John");
		c.setBirthDate("10.09.1968");
		c.setCategory(CustomerCategory.A);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Fox, Vince");
		c.setBirthDate("27.01.1984");
		c.setCategory(CustomerCategory.C);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Jones, Frank");
		c.setBirthDate("24.06.1971");
		c.setCategory(CustomerCategory.A);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Miller, Mike");
		c.setBirthDate("17.09.1969");
		c.setCategory(CustomerCategory.A);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Robinson Jr., Terence");
		c.setBirthDate("17.04.1978");
		c.setCategory(CustomerCategory.C);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Fink, Julie");
		c.setBirthDate("24.02.1986");
		c.setCategory(CustomerCategory.D);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Davis, Ricky");
		c.setBirthDate("16.07.1979");
		c.setCategory(CustomerCategory.D);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Jackson, Clifford");
		c.setBirthDate("11.12.1974");
		c.setCategory(CustomerCategory.D);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Meeks, Jodie");
		c.setBirthDate("29.11.1978");
		c.setCategory(CustomerCategory.D);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Porter, Michael");
		c.setBirthDate("08.08.1973");
		c.setCategory(CustomerCategory.A);
		customers[i++] = c;
		
		c = new Customer();
		c.setFullName("Doe, Jack");
		c.setBirthDate("13.07.1981");
		c.setCategory(CustomerCategory.A);
		customers[i++] = c;
		
		return customers;
	}

	public static Transaction[] createTransactions() {
		
		Transaction[] result = new Transaction[100];
		int i = 0;
		
		Transaction t = new Transaction();
		t.setDate("2013/12/02");
		t.setBuyingItem("2010 Ford Mustang");
		t.setCustomer("Frank Jones");
		t.setPrice(45000);
		t.setQuantity(2);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/02");
		t.setBuyingItem("2011 Chevrolet Corvete");
		t.setCustomer("Mike Miller");
		t.setPrice(60000);
		t.setQuantity(3);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/03");
		t.setBuyingItem("2010 Crysler 300S");
		t.setCustomer("Terence Robinson");
		t.setPrice(35000);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/04");
		t.setBuyingItem("2009 Crysler Crossfire");
		t.setCustomer("Julie Fink");
		t.setPrice(42000);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/05");
		t.setBuyingItem("2010 Nissan 350Z");
		t.setCustomer("Ricky Davis");
		t.setPrice(35000);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/06");
		t.setBuyingItem("1995 Toyota Supra");
		t.setCustomer("Clifford Jackson");
		t.setPrice(24000);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/07");
		t.setBuyingItem("2005 Mazda RX-7");
		t.setCustomer("Jodie Meeks");
		t.setPrice(27500);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/08");
		t.setBuyingItem("2002 Nissan Skyline R34 V-Spec II");
		t.setCustomer("Michael Porter");
		t.setPrice(36500);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/09");
		t.setBuyingItem("2006 Honda CRV");
		t.setCustomer("Michael Porter");
		t.setPrice(39000);
		t.setQuantity(2);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/10");
		t.setBuyingItem("2008 Kia Sportage");
		t.setCustomer("Jack Doe");
		t.setPrice(33000);
		t.setQuantity(1);
		result[i++] = t;
		
		t = new Transaction();
		t.setDate("2013/12/10");
		t.setBuyingItem("2008 Hyundai Elantra");
		t.setCustomer("Jack Doe");
		t.setPrice(24000);
		t.setQuantity(2);
		result[i++] = t;

		return result;
	}
}
