package ma.emsi.ormspringdata.repositories;

import ma.emsi.ormspringdata.entities.Medecin;
import ma.emsi.ormspringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
