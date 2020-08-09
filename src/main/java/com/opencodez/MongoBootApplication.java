package com.opencodez;

import com.opencodez.model.*;
import com.opencodez.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoBootApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	MapRepository mapRepository;
	
	@Autowired
	CustomRepository crepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MongoBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//User
		deleteAllUser();
		addSampleDataUser();
		listAllUser();
		findFirstUser();
		findByRegexUser();
		//Player
		deleteAllPlayer();
		addSampleDataPlayer();
		listAllPlayer();
		findFirstPlayer();
		//Room
		deleteAllRoom();
		addSampleDataRoom();
		listAllRoom();
		findFirstRoom();
		//Map
		deleteAllMap();
		addSampleDataMap();
		listAllMap();
		findFirstMap();
	}
	
	public void deleteAllUser() {
		System.out.println("Deleting all records User..");
		userRepository.deleteAll();
	}

	public void deleteAllPlayer() {
		System.out.println("Deleting all records Player..");
		playerRepository.deleteAll();
	}

	public void deleteAllRoom() {
		System.out.println("Deleting all records Room..");
		roomRepository.deleteAll();
	}

	public void deleteAllMap() {
		System.out.println("Deleting all records Room..");
		mapRepository.deleteAll();
	}
	
	public void addSampleDataUser() {
		System.out.println("Adding sample data User");
		userRepository.save(new Users("Jack Bauer", "New York", 11111d));
		userRepository.save(new Users("Harvey Spectre", "London", 22222d));
		userRepository.save(new Users("Mike Ross", "New Jersey", 333333d));
		userRepository.save(new Users("Louise Litt", "Kathmandu", 44444d));
	}

	public void addSampleDataPlayer() {
		System.out.println("Adding sample data Player");
		playerRepository.save(new Player("Jack Bauer", 13, 43));
		playerRepository.save(new Player("Harvey Spectre", 13, 43));
		playerRepository.save(new Player("Mike Ross",43, 7, true));
		playerRepository.save(new Player("Louise Litt", 13, 7));
	}

	public void addSampleDataRoom() {
		System.out.println("Adding sample data Room");
		roomRepository.save(new Room(1, 2));
		roomRepository.save(new Room(1, 13));
		Room r = new Room(5,43);
		IEvent iEvent = new Combat();
		iEvent.setupEvent("Wolfs",null);
		r.setEvent(iEvent);
		roomRepository.save(r);
		roomRepository.save(new Room(6, 13));
	}

	public void addSampleDataMap() {
		System.out.println("Adding sample data Map");
		Map m1 = new Map(20, 20);
		while(!m1.findPath(10, 10, 10, 10, 20,3,5));
		m1.makeRoomConnected();
		mapRepository.save(m1);
		mapRepository.save(new Map(20, 20));
		mapRepository.save(new Map(20, 20));
		mapRepository.save(new Map( 20, 20));
	}
	
	public void listAllUser() {
		System.out.println("Listing sample data User");
		userRepository.findAll().forEach(u -> System.out.println(u));
	}

	public void listAllPlayer() {
		System.out.println("Listing sample data Player");
		playerRepository.findAll().forEach(u -> System.out.println(u));
	}

	public void listAllRoom() {
		System.out.println("Listing sample data Room");
		roomRepository.findAll().forEach(u -> System.out.println(u));
	}

	public void listAllMap() {
		System.out.println("Listing sample data Map");
		mapRepository.findAll().forEach(u -> System.out.println(u));
	}
	
	public void findFirstUser() {
		System.out.println("Finding first by Name User");
		Users u = userRepository.findFirstByName("Louise Litt");
		System.out.println(u);
	}

	public void findFirstPlayer() {
		System.out.println("Finding first by Name Player");
		Player u = playerRepository.findFirstByName("Louise Litt");
		System.out.println(u);
	}

	public void findFirstRoom() {
		System.out.println("Finding first by Name Room");
		Room u = roomRepository.findFirstByX(1);
		System.out.println(u);
	}

	public void findFirstMap() {
		System.out.println("Finding first by Name Room");
		Map u = mapRepository.findFirstByX(20);
		System.out.println(u);
	}
	
	public void findByRegexUser() {
		System.out.println("Finding by Regex - All with address starting with ^New User");
		userRepository.findCustomByRegExAddress("^New").forEach(u -> System.out.println(u));
	}
}
