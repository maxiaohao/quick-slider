package com.github.maxiaohao.quickslider.util;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {

    private static final ObjectMapper _objectMapper = new ObjectMapper();


    /**
     * Get json string representation of the given object.
     *
     * @param object
     * @param beautify
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String objectToJson(Object object, boolean beautify) throws JsonGenerationException,
            JsonMappingException, IOException {
        if (beautify) {
            return _objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } else {
            return _objectMapper.writeValueAsString(object);
        }
    }


    /**
     * Convert a json string into specified type(class) of object.
     *
     * @param json
     *            the json string
     * @param clazz
     *            expected class of the target object to be converted into, could be a class of single pojo/bean or
     *            collections.
     * @return the converted object representing the json string
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T jsonToObject(String json, Class<? extends T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        if (null == json || json.length() == 0) {
            return null;
        }
        return _objectMapper.readValue(json, clazz);
    }


    /**
     * Write the json string representation of the given object, to specified writer.
     *
     * @param writer
     *            the writer to which we pass the json string
     * @param object
     *            the object to convert into json and write
     * @throws JsonMappingException
     * @throws JsonGenerationException
     * @throws IOException
     */
    public static void writeAsJson(Writer writer, Object object, boolean beautify)
            throws JsonGenerationException, JsonMappingException, IOException {

        if (beautify) {
            _objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, object);
        } else {
            _objectMapper.writeValue(writer, object);
        }
    }


    public static <T> T readObject(File jsonFile, Class<? extends T> clazz) throws JsonParseException,
            JsonMappingException, IOException {
        if (null == jsonFile || !jsonFile.exists()) {
            return null;
        }
        return _objectMapper.readValue(jsonFile, clazz);
    }

}
