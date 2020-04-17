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

    private AddressRepository addressRepository;
    private ApartmentRepository apartmentRepository;
    private BasementRepository basementRepository;
    private GarageRepository garageRepository;
    private HouseRepository houseRepository;
    private StorageRepository storageRepository;
    private ClientRepository clientRepository;
    private RealEstateAgentRepository realEstateAgentRepository;
    private FacilityObjectRepository facilityObjectRepository;

    public RealEstateBootstrap(AddressRepository addressRepository, ApartmentRepository apartmentRepository,
                               BasementRepository basementRepository, GarageRepository garageRepository,
                               HouseRepository houseRepository, StorageRepository storageRepository,
                               ClientRepository clientRepository, RealEstateAgentRepository realEstateAgentRepository,
                               FacilityObjectRepository facilityObjectRepository) {
        this.addressRepository = addressRepository;
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
        populateAddress();
        populateClients();
        populateRealEstateAgents();
        populateFacilityObjects();
        populateApartment();
        populateHouse();
        populateBasement();
        populateGarage();
        populateStorage();

        activateAddressRelationships();
        activateAgentsFacilityObjectsRelationships();
        activateFacilityObjectsFacilitiesRelationship();
        activateClientsAgentsRelationship(0, 2);
        activateClientsApartmentsRelationship(0, 1);
        activateClientsBasementsRelationship(1, 2);
        activateClientsGaragesRelationship(2, 3);
        activateClientsHousesRelationship(0, 1);
        activateClientsStoragesRelationship(1, 2);
    }

    private void populateAddress() {
        Address commercialAgentAddress = new Address(888132, 355, "New York", "NY", "Queens");
        Address nonCommercialAgentAddress = new Address(789654, 12, "New York", "NY", "Bronx");
        Address richieAddress = new Address(369845, 514, "New York", "NY", "Brooklyn");
        Address donaldAddress = new Address(159753, 645, "New York", "NY", "Madison Ave");
        Address johnAddress = new Address(369456, 364, "New York", "NY", "Queens");
        Address apartmentAddress = new Address(100305, 255, "New York", "NY", "Manhattan");
        Address basementAddress = new Address(200645, 143, "New York", "NY", "Bronx");
        Address garageAddress = new Address(99887, 657, "New York", "NY", "Brooklyn");
        Address houseAddress = new Address(55322, 28, "New York", "NY", "Madison Ave");
        Address storageAddress = new Address(888132, 665, "New York", "NY", "Queens");

        addressRepository.save(commercialAgentAddress);
        addressRepository.save(nonCommercialAgentAddress);
        addressRepository.save(richieAddress);
        addressRepository.save(donaldAddress);
        addressRepository.save(johnAddress);
        addressRepository.save(apartmentAddress);
        addressRepository.save(basementAddress);
        addressRepository.save(garageAddress);
        addressRepository.save(houseAddress);
        addressRepository.save(storageAddress);
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
        Apartment apartment = new Apartment(5, 150, "top rated xata",
                LocalDateTime.now(), 788, 25);
        apartmentRepository.save(apartment);
    }

    private void populateHouse() {
        House house = new House(8, 300, "new home with repair for big family",
                LocalDateTime.now(), 3, true, true);
        houseRepository.save(house);
    }

    private void populateBasement() {
        Basement basement = new Basement(3, 200, "barbershop, ready business model",
                LocalDateTime.now(), true);
        basementRepository.save(basement);
    }

    private void populateGarage() {
        Garage garage = new Garage(3, 600, "vehicles repair facility",
                LocalDateTime.now(),true, true);
        garageRepository.save(garage);
    }

    private void populateStorage() {
        Storage storage = new Storage(3, 700, "huge storage for business needs",
                LocalDateTime.now(), 600, true);
        storageRepository.save(storage);
    }

    private void activateAddressRelationships() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();

        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<RealEstateAgent> agents = (List<RealEstateAgent>) realEstateAgentRepository.findAll();

        List<Apartment> apartments = (List<Apartment>) apartmentRepository.findAll();
        List<House> houses = (List<House>) houseRepository.findAll();
        List<Basement> basements = (List<Basement>) basementRepository.findAll();
        List<Garage> garages = (List<Garage>) garageRepository.findAll();
        List<Storage> storages = (List<Storage>) storageRepository.findAll();

        int pointer = 0;
        for (Client client : clients) {
            client.setAddress(addresses.get(pointer));
            pointer++;
        }
        clientRepository.saveAll(clients);
        for (RealEstateAgent agent : agents) {
            agent.setAddress(addresses.get(pointer));
            pointer++;
        }
        realEstateAgentRepository.saveAll(agents);
        for (Apartment apartment : apartments) {
            apartment.setAddress(addresses.get(pointer));
            pointer++;
        }
        apartmentRepository.saveAll(apartments);
        for (House house : houses) {
            house.setAddress(addresses.get(pointer));
            pointer++;
        }
        houseRepository.saveAll(houses);
        for (Basement basement : basements) {
            basement.setAddress(addresses.get(pointer));
            pointer++;
        }
        basementRepository.saveAll(basements);
        for (Garage garage : garages) {
            garage.setAddress(addresses.get(pointer));
            pointer++;
        }
        garageRepository.saveAll(garages);
        for (Storage storage : storages) {
            storage.setAddress(addresses.get(pointer));
            pointer++;
        }
        storageRepository.saveAll(storages);
    }

    private void activateAgentsFacilityObjectsRelationships() {
        List<FacilityObject> facilityObjects = (List<FacilityObject>) facilityObjectRepository.findAll();
        List<RealEstateAgent> agents = (List<RealEstateAgent>) realEstateAgentRepository.findAll();

        int pointer = 0;
        for (FacilityObject facility : facilityObjects) {
            if (pointer == agents.size()) {
                pointer = 0;
            }
            facility.setAgent(agents.get(pointer));
            pointer++;
        }

        facilityObjectRepository.saveAll(facilityObjects);
    }

    private void activateFacilityObjectsFacilitiesRelationship() {
        List<FacilityObject> facilityObjects = (List<FacilityObject>) facilityObjectRepository.findAll();

        List<Apartment> apartments = (List<Apartment>) apartmentRepository.findAll();
        List<House> houses = (List<House>) houseRepository.findAll();
        List<Basement> basements = (List<Basement>) basementRepository.findAll();
        List<Garage> garages = (List<Garage>) garageRepository.findAll();
        List<Storage> storages = (List<Storage>) storageRepository.findAll();

        int pointer = 0;

        for(Apartment apartment : apartments) {
            apartment.setFacilityObject(facilityObjects.get(pointer));
            pointer++;
        }
        apartmentRepository.saveAll(apartments);
        for(House house : houses) {
            house.setFacilityObject(facilityObjects.get(pointer));
            pointer++;
        }
        houseRepository.saveAll(houses);
        for(Basement basement : basements) {
            basement.setFacilityObject(facilityObjects.get(pointer));
            pointer++;
        }
        basementRepository.saveAll(basements);
        for(Garage garage : garages) {
            garage.setFacilityObject(facilityObjects.get(pointer));
            pointer++;
        }
        garageRepository.saveAll(garages);
        for(Storage storage : storages) {
            storage.setFacilityObject(facilityObjects.get(pointer));
            pointer++;
        }
        storageRepository.saveAll(storages);
    }

    private void activateClientsAgentsRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<RealEstateAgent> agents = (List<RealEstateAgent>) realEstateAgentRepository.findAll();

        for (int index = 0; index < agents.size(); index++) {
            agents.get(index).setClients(new HashSet<>(clients.subList(start,finish + index)));
        }

        realEstateAgentRepository.saveAll(agents);
    }

    private void activateClientsApartmentsRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<Apartment> apartments = (List<Apartment>) apartmentRepository.findAll();

        for (int index = 0; index < apartments.size(); index++) {
            apartments.get(index).setClients(new HashSet<>(clients.subList(start, finish + index)));
        }

        apartmentRepository.saveAll(apartments);
    }

    private void activateClientsHousesRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<House> houses = (List<House>) houseRepository.findAll();

        for (int index = 0; index < houses.size(); index++) {
            houses.get(index).setClients(new HashSet<>(clients.subList(start, finish + index)));
        }

        houseRepository.saveAll(houses);
    }

    private void activateClientsBasementsRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<Basement> basements = (List<Basement>) basementRepository.findAll();

        for (int index = 0; index < basements.size(); index++) {
            basements.get(index).setClients(new HashSet<>(clients.subList(start, finish + index)));
        }

        basementRepository.saveAll(basements);
    }

    private void activateClientsGaragesRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<Garage> garages = (List<Garage>) garageRepository.findAll();

        for (int index = 0; index < garages.size(); index++) {
            garages.get(index).setClients(new HashSet<>(clients.subList(start, finish + index)));
        }

        garageRepository.saveAll(garages);
    }

    private void activateClientsStoragesRelationship(int start, int finish) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        List<Storage> storages = (List<Storage>) storageRepository.findAll();

        for (int index = 0; index < storages.size(); index++) {
            storages.get(index).setClients(new HashSet<>(clients.subList(start, finish + index)));
        }

        storageRepository.saveAll(storages);
    }
}
