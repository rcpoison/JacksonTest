package org.afraid.poison.jacksontest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.UUID;

public class UUIDDeserializer extends JsonDeserializer<UUID> {

	@Override
	public UUID deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return UUID.fromString(jp.getText());
	}
}
