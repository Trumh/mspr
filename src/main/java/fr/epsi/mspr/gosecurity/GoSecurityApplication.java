package fr.epsi.mspr.gosecurity;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import fr.epsi.mspr.gosecurity.dao.FirebaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GoSecurityApplication implements CommandLineRunner {

	@Autowired
	private FirebaseDao dao;

	public static void main(String[] args) {
		SpringApplication.run(GoSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Execution en cours -----");

		List<QueryDocumentSnapshot> documents = dao.findAll();
	    for (QueryDocumentSnapshot document : documents) {
            System.out.println("User: " + document.getId());
            System.out.println("Firstname: " + document.getString("firstname"));
            System.out.println("Lastname: " + document.getString("lastname"));
        }
	}
}

	public static void main(String[] args) {

	}