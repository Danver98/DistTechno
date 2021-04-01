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

    public static void main(String [] args) throws IOException {
        Organization org = new Organization("Tensor",new Address(1000,"Russia","Yaroslavl","Uglichskaya",44,0), LocalDate.of(1996,06,10));
        Collections.addAll(org.getPhones(), new Phone(7,"9612345678",LocalDate.now()), new Phone(7,"9612345679",LocalDate.now()));
        Person Ivan =  new Person("Ivan","Ivanov",22,false, new Address(1,"Russia","Yaroslavl","Pervomayskaya",1,1), new Phone(7,"9612343322",LocalDate.now()));
        Person Vasiliy = new Person("Vasiliy","Vasiliev",19,true, new Address(1,"Russia","Yaroslavl","Sovetskaya",10,12),new Phone(7,"9612342135",LocalDate.now()));
        Person Dmitriy = new Person("Dmitriy","Ivanov",23,false, new Address(1,"Russia","Yaroslavl","Slepneva",64,15),new Phone(7,"9612347777",LocalDate.now()));
        Collections.addAll(org.getEmployees(), Ivan,Vasiliy,Dmitriy);
        System.out.println(new Serializer().serializeToXML(org));
    }
}
