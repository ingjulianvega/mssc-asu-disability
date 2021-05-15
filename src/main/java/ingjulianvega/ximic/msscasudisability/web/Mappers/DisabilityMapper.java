package ingjulianvega.ximic.msscasudisability.web.Mappers;


import ingjulianvega.ximic.events.UpdateDisabilityEvent;
import ingjulianvega.ximic.msscasudisability.domain.DisabilityEntity;
import ingjulianvega.ximic.msscasudisability.web.model.Disability;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface DisabilityMapper {
    DisabilityDto disabilityEntityToDisabilityDto(DisabilityEntity remissionEntity);

    DisabilityEntity disabilityDtoToDisabilityEntity(DisabilityDto remissionDto);

    ArrayList<DisabilityDto> disabilityEntityListToDisabilityDtoList(List<DisabilityEntity> remissionEntityList);

    Disability updateDisabilityEventToDisability(UpdateDisabilityEvent updateDisabilityEvent);
}
