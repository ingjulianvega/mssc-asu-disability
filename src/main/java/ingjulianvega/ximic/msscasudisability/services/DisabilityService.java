package ingjulianvega.ximic.msscasudisability.services;


import ingjulianvega.ximic.msscasudisability.web.model.Disability;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityDto;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityList;

import java.util.UUID;

public interface DisabilityService {
    DisabilityList get();

    DisabilityDto getById(UUID id);

    DisabilityList getByVisitId(UUID patientId);

    void create(Disability disability);

    void updateById(UUID id, Disability disability);

    void deleteById(UUID id);


}
