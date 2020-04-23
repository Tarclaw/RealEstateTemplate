package com.realestate.web.example.bootstrap;

import com.realestate.web.example.domain.*;
import com.realestate.web.example.domain.enums.Status;
import com.realestate.web.example.repository.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Component
public class RealEstateBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ApartmentRepository apartmentRepository;
    private BasementRepository basementRepository;
    private GarageRepository garageRepository;
    private HouseRepository houseRepository;
    private StorageRepository storageRepository;
    private ClientRepository clientRepository;
    private RealEstateAgentRepository realEstateAgentRepository;
    private FacilityObjectRepository facilityObjectRepository;

    public RealEstateBootstrap(ApartmentRepository apartmentRepository, BasementRepository basementRepository,
                               GarageRepository garageRepository, HouseRepository houseRepository,
                               StorageRepository storageRepository, ClientRepository clientRepository,
                               RealEstateAgentRepository realEstateAgentRepository,
                               FacilityObjectRepository facilityObjectRepository) {
        this.apartmentRepository = apartmentRepository;
        this.basementRepository = basementRepository;
        this.garageRepository = garageRepository;
        this.houseRepository = houseRepository;
        this.storageRepository = storageRepository;
        this.clientRepository = clientRepository;
        this.realEstateAgentRepository = realEstateAgentRepository;
        this.facilityObjectRepository = facilityObjectRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        populateClients();
        populateRealEstateAgents();
        populateFacilityObjects();
        populateApartment();
        populateHouse();
        populateBasement();
        populateGarage();
        populateStorage();

        activateAgentsFacilityObjectsRelationships();
        List<FacilityObject> facilityObjects = (List<FacilityObject>) facilityObjectRepository.findAll();

        apartmentRepository.saveAll((Iterable<Apartment>) activateFacilityObjectsFacilitiesRelationship(
                apartmentRepository.findAll(), facilityObjects, 0));
        houseRepository.saveAll((Iterable<House>) activateFacilityObjectsFacilitiesRelationship(
                houseRepository.findAll(), facilityObjects, 1));
        basementRepository.saveAll((Iterable<Basement>) activateFacilityObjectsFacilitiesRelationship(
                basementRepository.findAll(), facilityObjects, 2));
        garageRepository.saveAll((Iterable<Garage>) activateFacilityObjectsFacilitiesRelationship(
                garageRepository.findAll(), facilityObjects, 3));
        storageRepository.saveAll((Iterable<Storage>) activateFacilityObjectsFacilitiesRelationship(
                storageRepository.findAll(), facilityObjects, 4));
        activateClientsAgentsRelationship(0, 2);
        activateClientsFacilitiesRelationship();
    }

    private void populateClients() {
        Client richie = new Client("Richie", "Rich", "dinaro_login", "babosiki_pass",
                 new Contact("r.rich@gmail.com", "r.rich", "+1-097-999-3355"),
                true, false, false, true);
        Client donald = new Client("Donald", "Donaldson", "duck_login", "kr9kr9",
                new Contact("d.donaldson@gmail.com", "d.donaldson", "+1-066-534-6842"),
                false, false, true, false);
        Client john = new Client("John", "Johnson", "johnny_login", "rieltorizlo",
                new Contact("j.johnson@gmail.com", "j.johnson", "+1-099-897-3511"),
                true, false, false, false);
        clientRepository.save(richie);
        clientRepository.save(donald);
        clientRepository.save(john);
    }

    private void populateRealEstateAgents() {
        RealEstateAgent commercialAgent = new RealEstateAgent("Marry", "Public", "marry_login",
                "123456",
                new Contact("m.public@realestate.com", "m.public", "+1-014-777-3355"),
                BigInteger.valueOf(5000L), LocalDate.now());
        RealEstateAgent nonCommercialAgent = new RealEstateAgent("Billy", "Butkiss", "billy_login", "qwerty",
                new Contact("b.billy@realestate.com", "b.billy", "+1-014-515-2288"),
                BigInteger.valueOf(4500L), LocalDate.now());
        realEstateAgentRepository.save(commercialAgent);
        realEstateAgentRepository.save(nonCommercialAgent);
    }

    private void populateFacilityObjects() {
        FacilityObject commercialObjectBasement = new FacilityObject(Status.FOR_RENT, BigInteger.valueOf(4000L),
                BigInteger.valueOf(1000000L), BigInteger.valueOf(2000L));

        FacilityObject commercialObjectGarage = new FacilityObject(Status.FOR_SALE, BigInteger.valueOf(4200L),
                BigInteger.valueOf(1500000L), BigInteger.valueOf(15000L));

        FacilityObject commercialObjectStorage = new FacilityObject(Status.FOR_SALE, BigInteger.valueOf(6000L),
                BigInteger.valueOf(2000000L), BigInteger.valueOf(20000L));

        FacilityObject nonCommercialObjectApartment = new FacilityObject(Status.FOR_RENT, BigInteger.valueOf(3000L),
                BigInteger.valueOf(700000L), BigInteger.valueOf(1500L));

        FacilityObject nonCommercialObjectHouse = new FacilityObject(Status.FOR_SALE, BigInteger.valueOf(5000L),
                BigInteger.valueOf(1200000L), BigInteger.valueOf(12000L));

        facilityObjectRepository.save(commercialObjectBasement);
        facilityObjectRepository.save(commercialObjectGarage);
        facilityObjectRepository.save(commercialObjectStorage);
        facilityObjectRepository.save(nonCommercialObjectApartment);
        facilityObjectRepository.save(nonCommercialObjectHouse);
    }

    private void populateApartment() {
        Address apartmentAddress = new Address(100305, 255, "New York", "NY", "Manhattan");
        Apartment apartment = new Apartment(5, 150, "top rated xata",
                LocalDateTime.now(), apartmentAddress,788, 25);
        apartmentAddress.setFacility(apartment);
        apartmentRepository.save(apartment);
    }

    private void populateHouse() {
        Address houseAddress = new Address(55322, 28, "New York", "NY", "Madison Ave");
        House house = new House(8, 300, "new home with repair for big family",
                LocalDateTime.now(), houseAddress, 3, true, true);
        houseAddress.setFacility(house);
        houseRepository.save(house);
    }

    private void populateBasement() {
        Address basementAddress = new Address(200645, 143, "New York", "NY", "Bronx");
        Basement basement = new Basement(3, 200, "barbershop, ready business model",
                LocalDateTime.now(), basementAddress,true);
        basementAddress.setFacility(basement);
        basementRepository.save(basement);
    }

    private void populateGarage() {
        Address garageAddress = new Address(99887, 657, "New York", "NY", "Brooklyn");
        Garage garage = new Garage(3, 600, "vehicles repair facility",
                LocalDateTime.now(), garageAddress,true, true);
        garageAddress.setFacility(garage);
        garageRepository.save(garage);
    }

    private void populateStorage() {
        Address storageAddress = new Address(888132, 665, "New York", "NY", "Queens");
        Storage storage = new Storage(3, 700, "huge storage for business needs",
                LocalDateTime.now(), storageAddress,600, true);
        storageAddress.setFacility(storage);
        storageRepository.save(storage);
    }

    private void activateAgentsFacilityObjectsRelationships() {
        List<FacilityObject> facilityObjects = (List<FacilityObject>) facilityObjectRepository.findAll();
        List<RealEstateAgent> agents = (List<RealEstateAgent>) realEstateAgentRepository.findAll();

        int pointer = 0;
        for (FacilityObject facilityObject : facilityObjects) {
            if (pointer == agents.size()) {
                pointer = 0;
            }
            facilityObject.setAgent(agents.get(pointer));
            pointer++;
        }

        facilityObjectRepository.saveAll(facilityObjects);

    }



    private Iterable<? extends Facility> activateFacilityObjectsFacilitiesRelationship(Iterable<? extends Facility> facilities,
                                                     List<FacilityObject> facilityObjects, int pointer) {
        for(Facility facility : facilities) {
            facility.setFacilityObject(facilityObjects.get(pointer));
            pointer++;
        }

        return facilities;
    }

    private void activateClientsAgentsRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<RealEstateAgent> agents = (List<RealEstateAgent>) realEstateAgentRepository.findAll();

        for (int index = 0; index < agents.size(); index++) {
            agents.get(index).setClients(new HashSet<>(clients.subList(start,finish + index)));
        }

        realEstateAgentRepository.saveAll(agents);
    }

    private void activateClientsFacilitiesRelationship() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<Apartment> apartments = (List<Apartment>) apartmentRepository.findAll();
        List<House> houses = (List<House>) houseRepository.findAll();
        List<Basement> basements = (List<Basement>) basementRepository.findAll();
        List<Garage> garages = (List<Garage>) garageRepository.findAll();
        List<Storage> storages = (List<Storage>) storageRepository.findAll();
        clientRepository. findAll();

        clients.get(0).addFacility(apartments.get(0));
        clients.get(1).addFacility(houses.get(0));
        clients.get(2).addFacility(basements.get(0));
        clients.get(0).addFacility(garages.get(0));
        clients.get(1).addFacility(storages.get(0));

        clientRepository.saveAll(clients);
    }
}
