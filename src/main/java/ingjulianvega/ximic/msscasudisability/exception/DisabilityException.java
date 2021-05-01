package ingjulianvega.ximic.msscasudisability.exception;

import lombok.Getter;

@Getter
public class DisabilityException extends RuntimeException {

    private final String code;

    public DisabilityException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

