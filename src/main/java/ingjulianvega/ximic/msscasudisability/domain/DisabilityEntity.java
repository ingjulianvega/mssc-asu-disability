package ingjulianvega.ximic.msscasudisability.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class DisabilityEntity extends BaseEntity {

    private UUID visitId;
    private UUID disabilityTypeId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;
}
