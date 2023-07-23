package co.com.spn.cun3.dominio;

import java.util.Objects;

public class StringNullable {

    private final String value;

    public StringNullable(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Objects.requireNonNullElse(this.value, "N/A");
    }
}
