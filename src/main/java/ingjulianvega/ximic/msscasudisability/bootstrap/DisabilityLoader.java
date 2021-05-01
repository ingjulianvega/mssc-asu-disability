package ingjulianvega.ximic.msscasudisability.bootstrap;

import ingjulianvega.ximic.msscasudisability.domain.DisabilityEntity;
import ingjulianvega.ximic.msscasudisability.domain.repositories.DisabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class DisabilityLoader implements CommandLineRunner {

    private final DisabilityRepository disabilityRepository;

    @Override
    public void run(String... args) throws Exception {
        if (disabilityRepository.count() == 0) {
            loadDisabilityObjects();
        }
    }

    private void loadDisabilityObjects() {
        disabilityRepository.saveAll(Arrays.asList(
                DisabilityEntity.builder().visitId(UUID.randomUUID())
                        .disabilityTypeId(UUID.randomUUID())
                        .durationQuantity(1)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                DisabilityEntity.builder().visitId(UUID.randomUUID())
                        .disabilityTypeId(UUID.randomUUID())
                        .durationQuantity(2)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                DisabilityEntity.builder().visitId(UUID.randomUUID())
                        .disabilityTypeId(UUID.randomUUID())
                        .durationQuantity(3)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                DisabilityEntity.builder().visitId(UUID.randomUUID())
                        .disabilityTypeId(UUID.randomUUID())
                        .durationQuantity(4)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                DisabilityEntity.builder().visitId(UUID.randomUUID())
                        .disabilityTypeId(UUID.randomUUID())
                        .durationQuantity(5)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build()


        ));
    }
}