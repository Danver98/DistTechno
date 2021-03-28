package com.danver.serialization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Serializer {

    ObjectMapper jsonMapper;
    XmlMapper xmlMapper;
    ObjectMapper yamlMapper;

    public Serializer(){
        jsonMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
        yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.findAndRegisterModules();
        yamlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public String  serializeToJson(Object obj, String pathToFile) throws IOException {
        return jsonMapper.writeValueAsString(obj);
    }

    public Object deserializeFromJson(Class _class, String data) throws IOException {
        return jsonMapper.readValue(data, _class);
    }

    public String serializeToXML(Object obj) throws IOException {
        return xmlMapper.writeValueAsString(obj);
    }

    public Object deserializeFromXML(Class _class, String data) throws IOException {
        return xmlMapper.readValue(data, _class);
    }

    public String serializeToYAML(Object obj) throws IOException {
        return yamlMapper.writeValueAsString(obj);
    }

    public Object deserializeFromYAML(Class _class, String data) throws IOException {
        return yamlMapper.readValue(data, _class);
    }

    public static void main(String [] args) throws IOException {
        System.out.println(new File("").getPath());
        System.out.println(new File("").getAbsolutePath());
        System.out.println(new File("").getCanonicalPath());
    }
}
