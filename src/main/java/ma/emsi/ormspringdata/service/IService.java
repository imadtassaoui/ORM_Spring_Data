package ma.emsi.ormspringdata.service;

import ma.emsi.ormspringdata.entities.*;

public interface IService {
    Patient savePatient (Patient patient);
    Medecin saveMedecin (Medecin medecin);
    RendezVous saveRendezVous (RendezVous rendezVous);
    Consultation saveConsultation (Consultation consultation);
    Patient ChercherPatientParNom(String nom);
    Medecin ChercherMedecinParNom(String nom);
    RendezVous ChercherRendezVousParId(Long id);
    User saveUser (User user);
    Role saveRole (Role role);
    User ChercherUserParUsername (String username);
    Role ChercherRoleParRoleName (String rolename);
    void AjouterRoleToUser (String username, String rolename);
}
