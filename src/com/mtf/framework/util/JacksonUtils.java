package com.mtf.framework.util;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JacksonUtils {
	public static String objectToJson(Object obj){
		String json = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			StringWriter sw = new StringWriter();
			JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(sw);
			objectMapper.writeValue(jsonGenerator, obj);
			jsonGenerator.close();
			json = sw.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return json;
	}

	public static <T> T jsonToObject(String json, Class<T> clazz){
		return jsonToObject(json, clazz, null);
	}
	
	public static <T> T jsonToObject(String json, Class<T> clazz, String dateFormat){
		T t = null;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			if(dateFormat != null){
				mapper.setDateFormat(new SimpleDateFormat(dateFormat));
			}
			
			t = mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return t;
	}
	
	public static <T> List<T> jsonArrayToList(String jsonArr, Class<T> clazz) {
		return jsonArrayToList(jsonArr, clazz, null);
	}
	
	public static <T> List<T> jsonArrayToList(String jsonArr, Class<T> clazz, String dateFormat) {
		List<T> list = null;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			if(dateFormat != null){
				mapper.setDateFormat(new SimpleDateFormat(dateFormat));
			}
			JavaType javaType = getCollectionType(mapper, ArrayList.class, clazz); 
			list = mapper.readValue(jsonArr, javaType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return list;
	}
	
	private static JavaType getCollectionType(ObjectMapper mapper, Class<?> collectionClass, Class<?>... elementClasses) {   
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	}
}
