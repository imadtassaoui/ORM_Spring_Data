package ma.emsi.ormspringdata;

import ma.emsi.ormspringdata.entities.*;
import ma.emsi.ormspringdata.repositories.ConsultationRepository;
import ma.emsi.ormspringdata.repositories.MedecinRepository;
import ma.emsi.ormspringdata.repositories.PatientRepository;
import ma.emsi.ormspringdata.repositories.RendezVousRepository;
import ma.emsi.ormspringdata.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class OrmSpringDataApplication {
    @Autowired
    private PatientRepository patient;
    public static void main(String[] args) {
        SpringApplication.run(OrmSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IService service){
        return args -> {
            Stream.of("Amine","Hamid","Ahlam","Douaa")
                    .forEach(nom -> {
                        Patient p = new Patient();
                        p.setNom(nom);
                        p.setDateNaissance(new Date());
                        p.setMalade(Math.random()>0.5 ? true : false);
                        p.setScore(387);
                        service.savePatient(p);
                    });

            Stream.of("Ahmed","Aya","Imane","Imad")
                    .forEach(nom -> {
                        Medecin m = new Medecin();
                        m.setNom(nom);
                        m.setEmail(nom + "@gmail.com");
                        m.setSpecialite(Math.random()>0.5 ? "Dentiste" : "Orthophoniste");
                        service.saveMedecin(m);
                    });

            Stream.of("user1","user2")
                    .forEach(username -> {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword("pass");
                        service.saveUser(user);
                    });

            Stream.of("role1","role2")
                    .forEach(rolename -> {
                        Role role = new Role();
                        role.setRoleName(rolename);
                        service.saveRole(role);
                    });

            Patient patient = service.ChercherPatientParNom("Douaa");
            Medecin medecin = service.ChercherMedecinParNom("Aya");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRdv(Math.random()>0.5 ? StatusRdv.PENDING : StatusRdv.CANCELED);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            service.saveRendezVous(rendezVous);

            RendezVous rendezVous1 = service.ChercherRendezVousParId(1L);

            Consultation consultation = new Consultation();
            consultation.setDate(new Date());
            consultation.setRapport("This is a rapport");
            consultation.setRendezVous(rendezVous1);
            service.saveConsultation(consultation);

            service.AjouterRoleToUser("user1","role2");
            service.AjouterRoleToUser("user2","role1");
        };
    }
}
