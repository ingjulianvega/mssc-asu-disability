package ingjulianvega.ximic.msscasudisability.domain.repositories;

import ingjulianvega.ximic.msscasudisability.domain.DisabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface DisabilityRepository extends JpaRepository<DisabilityEntity, UUID>, JpaSpecificationExecutor<DisabilityEntity> {
    List<DisabilityEntity> findByVisitId(UUID visitId);
}
