package ingjulianvega.ximic.msscasudisability.services;


import ingjulianvega.ximic.msscasudisability.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasudisability.domain.DisabilityEntity;
import ingjulianvega.ximic.msscasudisability.domain.repositories.DisabilityRepository;
import ingjulianvega.ximic.msscasudisability.exception.DisabilityException;
import ingjulianvega.ximic.msscasudisability.web.Mappers.DisabilityMapper;
import ingjulianvega.ximic.msscasudisability.web.model.Disability;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityDto;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class DisabilityServiceImpl implements DisabilityService {

    private final DisabilityRepository disabilityRepository;
    private final DisabilityMapper disabilityMapper;

    @Cacheable(cacheNames = "disabilityListCache")
    @Override
    public DisabilityList get() {
        log.debug("get()...");
        return DisabilityList
                .builder()
                .disabilityDtoList(disabilityMapper.disabilityEntityListToDisabilityDtoList(disabilityRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "disabilityCache")
    @Override
    public DisabilityDto getById(UUID id) {
        log.debug("getById()...");
        return disabilityMapper.disabilityEntityToDisabilityDto(
                disabilityRepository.findById(id)
                        .orElseThrow(() -> DisabilityException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.DISABILITY_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.DISABILITY_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.DISABILITY_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.DISABILITY_NOT_FOUND_SOLUTION)
                                .build()));
    }

    @Override
    public DisabilityList getByVisitId(UUID visitId) {
        log.debug("getByVisitId()...");
        return DisabilityList
                .builder()
                .disabilityDtoList(disabilityMapper.disabilityEntityListToDisabilityDtoList(disabilityRepository.findByVisitId(visitId)))
                .build();
    }

    @Override
    public void create(Disability disability) {
        log.debug("create()...");
        disabilityMapper.disabilityEntityToDisabilityDto(
                disabilityRepository.save(
                        disabilityMapper.disabilityDtoToDisabilityEntity(
                                DisabilityDto
                                        .builder()
                                        .visitId(disability.getVisitId())
                                        .disabilityTypeId(disability.getDisabilityTypeId())
                                        .durationQuantity(disability.getDurationQuantity())
                                        .durationId(disability.getDurationId())
                                        .observations(disability.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Disability disability) {
        log.debug("updateById...");
        DisabilityEntity remissionEntity = disabilityRepository.findById(id)
                .orElseThrow(() -> DisabilityException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.DISABILITY_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.DISABILITY_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.DISABILITY_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.DISABILITY_NOT_FOUND_SOLUTION)
                        .build());

        remissionEntity.setVisitId(disability.getVisitId());
        remissionEntity.setDisabilityTypeId(disability.getDisabilityTypeId());
        remissionEntity.setDurationQuantity(disability.getDurationQuantity());
        remissionEntity.setDurationId(disability.getDurationId());
        remissionEntity.setObservations(disability.getObservations());

        disabilityRepository.save(remissionEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        disabilityRepository.deleteById(id);
    }
}
