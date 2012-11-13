package org.afraid.poison.jacksontest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class Test {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		JaxbAnnotationIntrospector jaxbAnnotationIntrospector=new JaxbAnnotationIntrospector(mapper.getTypeFactory());
		JacksonAnnotationIntrospector jacksonAnnotationIntrospector=new JacksonAnnotationIntrospector();
		mapper.setAnnotationIntrospector(AnnotationIntrospector.pair(jacksonAnnotationIntrospector, jaxbAnnotationIntrospector));

		TestEntity testEntity=new TestEntity();
		testEntity.setUuids(Arrays.asList(UUID.randomUUID(), UUID.randomUUID()));

		String json=mapper.writeValueAsString(testEntity);
		System.err.println(json);
		
		TestEntity unmarshalledTestEntity=mapper.readValue(json, TestEntity.class);
	}
}
