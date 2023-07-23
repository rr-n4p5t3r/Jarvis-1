package co.com.spn.cun3.jackson.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CustomInstantDeserializerNoHoursOrdenador extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        if (jsonParser.getText().endsWith("Z")) {
            return Instant.parse(jsonParser.getText());
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDateTime = LocalDate.parse(jsonParser.getText(), dateTimeFormatter);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime = localDateTime.atStartOfDay(zoneId);
            return zonedDateTime.toInstant();
        }
    }
}
