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


    public void serializeToJson(Object obj, String pathToFile) throws IOException {
        jsonMapper.writeValue(new File(pathToFile),obj);
    }

    public Object deserializeFromJson(Class _class, String pathToFile) throws IOException {
        return jsonMapper.readValue(new File(pathToFile), _class);
    }

    public void serializeToXML(Object obj, String pathToFile) throws IOException {
        xmlMapper.writeValue(new File(pathToFile), obj);
    }

    public Object deserializeFromXML(Class _class, String pathToFile) throws IOException {
        return xmlMapper.readValue(new File(pathToFile), _class);
    }

    public void serializeToYAML(Object obj, String pathToFile) throws IOException {
        yamlMapper.writeValue(new File(pathToFile),obj);
    }

    public Object deserializeFromYAML(Class _class, String pathToFile) throws IOException {
        return yamlMapper.readValue(new File(pathToFile), _class);
    }

    public static void main(String [] args){
        System.out.println(new File("").getAbsolutePath());
    }
}
