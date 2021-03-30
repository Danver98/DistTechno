package com.danver.serialization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

public class Serializer {

    ObjectMapper jsonMapper;
    XmlMapper xmlMapper;
    ObjectMapper yamlMapper;

    public Serializer(){
        jsonMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
        yamlMapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        yamlMapper.findAndRegisterModules();
        yamlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public String  serializeToJson(Object obj) throws IOException {
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

    
}
