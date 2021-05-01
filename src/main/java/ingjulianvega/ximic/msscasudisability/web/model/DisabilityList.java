package ingjulianvega.ximic.msscasudisability.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisabilityList implements Serializable {

    static final long serialVersionUID = 3299660768817965510L;

    public ArrayList<DisabilityDto> disabilityDtoList;
}
