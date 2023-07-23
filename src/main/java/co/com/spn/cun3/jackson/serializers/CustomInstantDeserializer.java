package co.com.spn.cun3.jackson.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CustomInstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        if (jsonParser.getText().endsWith("Z")) {
            return Instant.parse(jsonParser.getText());
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
            LocalDateTime localDateTime = LocalDateTime.parse(jsonParser.getText(), dateTimeFormatter);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
            return zonedDateTime.toInstant();
        }
    }
}
