import entities.*;
import jakarta.persistence.*;

import java.math.*;
import java.util.*;

public class Main {

/* Companies:
    •	Has an id - BigInteger
    •	Has a name - String
    •	Has a one to many relations with Planes
Planes:
    •	Has an id – BigInteger
	•	Has a fuel_type – String
	•	Has a model – String
	•	Has a price – BigDecimal(19,2)
	•	Has a type – String
	•	Has an airline – String
	•	Has a passenger_capacity – int
	•	Has a company_id – BigInteger
	•	Has a many-to-one relationship with Companies */

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vehicle-jpa");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Company> companies = registerCompanies();
        companies.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Company> registerCompanies() {
        Company companyA = establishCompany("AeroJet Corp");
        Company companyB = establishCompany("AeroGlide Transport");
        Company companyC = establishCompany("CloudStream Aviation");
        Company companyD = establishCompany("Altitude Express");
        Company companyE = establishCompany("Zenith Transport");
        return new ArrayList<>(List.of(companyA, companyB, companyC, companyD, companyE));
    }

    public static Company establishCompany (String companyName) {
        Company company = new Company();
        company.setName(companyName);
        List<Plane> planesList = registerAircraft(company);
        company.setPlanes(planesList);
        return company;
    }

    public static List<Plane> registerAircraft (Company company) {
        List<Plane> planesList = new ArrayList<>();
        switch (company.getName()) {
            case "AeroJet Corp" -> {
                Plane planeA = new Plane();
                planeA.setFuelType("Jet A-1");
                planeA.setModel("Airbus A350");
                planeA.setPrice(new BigDecimal("317000000.00"));
                planeA.setType("passenger");
                planeA.setAirline("AeroJet");
                planeA.setPassengerCapacity(350);
                planeA.setCompany(company);

                Plane planeB = new Plane();
                planeB.setFuelType("Jet A-1");
                planeB.setModel("Lockheed L-100 Hercules");
                planeB.setPrice(new BigDecimal("45000000.00"));
                planeB.setType("cargo");
                planeB.setAirline("AeroJet");
                planeB.setPassengerCapacity(0);
                planeB.setCompany(company);

                Plane planeC = new Plane();
                planeC.setFuelType("Jet A-1");
                planeC.setModel("Antonov An-124");
                planeC.setPrice(new BigDecimal("95000000.00"));
                planeC.setType("cargo");
                planeC.setAirline("AeroJet");
                planeC.setPassengerCapacity(0);
                planeC.setCompany(company);
                planesList = List.of(planeA, planeB, planeC);
            }
            case "AeroGlide Transport" -> {
                Plane planeA = new Plane();
                planeA.setFuelType("Jet A-1");
                planeA.setModel("Airbus A320neo");
                planeA.setPrice(new BigDecimal("110000000.00"));
                planeA.setType("passenger");
                planeA.setAirline("AeroGlide");
                planeA.setPassengerCapacity(190);
                planeA.setCompany(company);

                Plane planeB = new Plane();
                planeB.setFuelType("Jet A-1");
                planeB.setModel("Embraer E190");
                planeB.setPrice(new BigDecimal("60000000.00"));
                planeB.setType("passenger");
                planeB.setAirline("AeroGlide");
                planeB.setPassengerCapacity(100);
                planeB.setCompany(company);

                Plane planeC = new Plane();
                planeC.setFuelType("Jet A-1");
                planeC.setModel("Bombardier CRJ900");
                planeC.setPrice(new BigDecimal("48000000.00"));
                planeC.setType("passenger");
                planeC.setAirline("AeroGlide");
                planeC.setPassengerCapacity(90);
                planeC.setCompany(company);
                planesList = List.of(planeA, planeB, planeC);
            }
            case "CloudStream Aviation" -> {
                Plane planeA = new Plane();
                planeA.setFuelType("Jet A-1");
                planeA.setModel("Airbus A321XLR");
                planeA.setPrice(new BigDecimal("142000000.00"));
                planeA.setType("passenger");
                planeA.setAirline("CloudStream");
                planeA.setPassengerCapacity(244);
                planeA.setCompany(company);

                Plane planeB = new Plane();
                planeB.setFuelType("Jet A-1");
                planeB.setModel("Comac C919");
                planeB.setPrice(new BigDecimal("72000000.00"));
                planeB.setType("passenger");
                planeB.setAirline("CloudStream");
                planeB.setPassengerCapacity(158);
                planeB.setCompany(company);

                Plane planeC = new Plane();
                planeC.setFuelType("Jet A-1");
                planeC.setModel("Cessna 208 Caravan");
                planeC.setPrice(new BigDecimal("2700000.00"));
                planeC.setType("passenger");
                planeC.setAirline("CloudStream");
                planeC.setPassengerCapacity(12);
                planeC.setCompany(company);
                planesList = List.of(planeA, planeB, planeC);
            }
            case "Altitude Express" -> {
                Plane planeA = new Plane();
                planeA.setFuelType("Jet A-1");
                planeA.setModel("Boeing 737 MAX");
                planeA.setPrice(new BigDecimal("98500000.00"));
                planeA.setType("passenger");
                planeA.setAirline("AltitudeX");
                planeA.setPassengerCapacity(180);
                planeA.setCompany(company);

                Plane planeB = new Plane();
                planeB.setFuelType("Jet A-1");
                planeB.setModel("Boeing 787 Dreamliner");
                planeB.setPrice(new BigDecimal("248000000.00"));
                planeB.setType("passenger");
                planeB.setAirline("AltitudeX");
                planeB.setPassengerCapacity(296);
                planeB.setCompany(company);

                Plane planeC = new Plane();
                planeC.setFuelType("Jet A-1");
                planeC.setModel("ATR 72");
                planeC.setPrice(new BigDecimal("26000000.00"));
                planeC.setType("passenger");
                planeC.setAirline("AltitudeX");
                planeC.setPassengerCapacity(78);
                planeC.setCompany(company);
                planesList = List.of(planeA, planeB, planeC);
            }
            case "Zenith Transport" -> {
                Plane planeA = new Plane();
                planeA.setFuelType("Jet A-1");
                planeA.setModel("Boeing 747");
                planeA.setPrice(new BigDecimal("150000000.00"));
                planeA.setType("cargo");
                planeA.setAirline("Zenith Cargo");
                planeA.setPassengerCapacity(0);
                planeA.setCompany(company);

                Plane planeB = new Plane();
                planeB.setFuelType("Jet A-1");
                planeB.setModel("McDonnell Douglas MD-11");
                planeB.setPrice(new BigDecimal("120000000.00"));
                planeB.setType("cargo");
                planeB.setAirline("Zenith Cargo");
                planeB.setPassengerCapacity(0);
                planeB.setCompany(company);

                Plane planeC = new Plane();
                planeC.setFuelType("Jet A-1");
                planeC.setModel("Boeing 767 Freighter");
                planeC.setPrice(new BigDecimal("185000000.00"));
                planeC.setType("cargo");
                planeC.setAirline("Zenith Cargo");
                planeC.setPassengerCapacity(0);
                planeC.setCompany(company);
                planesList = List.of(planeA, planeB, planeC);
            }
        }
        return planesList;
    }
}