package enums;

import lombok.Getter;

public enum CssConstants {
    DATA_TS("data-ts");

    @Getter
    private final String value;

    CssConstants(String value) {
        this.value = value;
    }
}
