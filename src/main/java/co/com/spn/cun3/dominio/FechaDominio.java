package co.com.spn.cun3.dominio;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FechaDominio {
    private final Instant instanteFecha;

    public FechaDominio(Instant instanteFecha) {
        this.instanteFecha = instanteFecha;
    }

    public FechaDominio(String fecha) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
        LocalDateTime localDateTime = LocalDateTime.parse(fecha, dateTimeFormatter);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        this.instanteFecha = zonedDateTime.toInstant();
    }

    public Instant toInstant() {
        return this.instanteFecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a")
                .withZone(ZoneId.systemDefault());
        return formatter.format(this.instanteFecha);
    }
}
