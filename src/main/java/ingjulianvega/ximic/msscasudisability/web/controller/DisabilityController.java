package ingjulianvega.ximic.msscasudisability.web.controller;


import ingjulianvega.ximic.msscasudisability.services.DisabilityService;
import ingjulianvega.ximic.msscasudisability.web.model.Disability;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityDto;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DisabilityController implements DisabilityI {

    private final DisabilityService disabilityService;

    @Override
    public ResponseEntity<DisabilityList> get() {
        return new ResponseEntity<>(disabilityService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DisabilityDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(disabilityService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DisabilityList> getByVisittId(UUID visitId) {
        return new ResponseEntity<>(disabilityService.getByVisitId(visitId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Disability diability) {
        disabilityService.create(diability);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Disability disability) {
        disabilityService.updateById(id, disability);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        disabilityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
