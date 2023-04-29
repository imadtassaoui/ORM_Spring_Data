package ma.emsi.ormspringdata.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.ormspringdata.entities.*;
import ma.emsi.ormspringdata.repositories.*;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ServiceImpl implements IService{
    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    RendezVousRepository rendezVousRepository;
    ConsultationRepository consultationRepository;
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient ChercherPatientParNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin ChercherMedecinParNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public RendezVous ChercherRendezVousParId(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User ChercherUserParUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role ChercherRoleParRoleName(String rolename) {
        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public void AjouterRoleToUser(String username, String rolename) {
        User user=userRepository.findByUsername(username);
        Role role=roleRepository.findByRoleName(rolename);

        user.getRoles().add(role);
        role.getUsers().add(user);
    }
}
