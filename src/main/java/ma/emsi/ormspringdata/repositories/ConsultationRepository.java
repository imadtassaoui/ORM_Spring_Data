package ma.emsi.ormspringdata.repositories;

import ma.emsi.ormspringdata.entities.Consultation;
import ma.emsi.ormspringdata.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
