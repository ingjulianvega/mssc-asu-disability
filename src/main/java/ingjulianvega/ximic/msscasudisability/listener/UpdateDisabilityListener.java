package ingjulianvega.ximic.msscasudisability.listener;

import ingjulianvega.ximic.events.UpdateDisabilityEvent;
import ingjulianvega.ximic.msscasudisability.configuration.JmsConfig;
import ingjulianvega.ximic.msscasudisability.services.DisabilityService;
import ingjulianvega.ximic.msscasudisability.web.Mappers.DisabilityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateDisabilityListener {

    private final DisabilityService disabilityService;
    private final DisabilityMapper disabilityMapper;

    @JmsListener(destination = JmsConfig.UPDATE_DISABILITY_QUEUE)
    public void listen(UpdateDisabilityEvent updateDisabilityEvent) {
        log.debug("Got UpdateDisabilityEvent " + updateDisabilityEvent.toString());
        disabilityService.create(disabilityMapper
                .updateDisabilityEventToDisability(updateDisabilityEvent));
    }
}
