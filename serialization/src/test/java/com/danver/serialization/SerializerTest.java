package com.danver.serialization;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {

    private static Organization prepareOrganizationObject(){
        Organization org = new Organization("Tensor",new Address(1000,"Russia","Yaroslavl","Uglichskaya",44,0), LocalDate.of(1996,06,10));
        Collections.addAll(org.getPhones(), new Phone(7,"9612345678",LocalDate.now()), new Phone(7,"9612345679",LocalDate.of(2021,04,1)));
        Person Ivan =  new Person("Ivan","Ivanov",22,false, new Address(1,"Russia","Yaroslavl","Pervomayskaya",1,1), new Phone(7,"9612343322",LocalDate.of(2021,04,1)));
        Person Vasiliy = new Person("Vasiliy","Vasiliev",19,true, new Address(1,"Russia","Yaroslavl","Sovetskaya",10,12),new Phone(7,"9612342135",LocalDate.of(2021,04,1)));
        Person Dmitriy = new Person("Dmitriy","Ivanov",23,false, new Address(1,"Russia","Yaroslavl","Slepneva",64,15),new Phone(7,"9612347777",LocalDate.of(2021,04,1)));
        Collections.addAll(org.getEmployees(), Ivan,Vasiliy,Dmitriy);
        return org;
    }
    @Test
    void serializeToJSON() throws IOException {
        Serializer serializer = new Serializer();
        Organization org = prepareOrganizationObject();
        String serializedJSONString = "{\"name\":\"Tensor\",\"address\":{\"postalCode\":1000,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Uglichskaya\",\"houseNumber\":44,\"apartmentNumber\":0},\"employees\":[{\"name\":\"Ivan\",\"surname\":\"Ivanov\",\"age\":22,\"address\":{\"postalCode\":1,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Pervomayskaya\",\"houseNumber\":1,\"apartmentNumber\":1},\"phone\":{\"code\":7,\"number\":\"9612343322\",\"creationDate\":[2021,4,1]},\"married\":false},{\"name\":\"Vasiliy\",\"surname\":\"Vasiliev\",\"age\":19,\"address\":{\"postalCode\":1,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Sovetskaya\",\"houseNumber\":10,\"apartmentNumber\":12},\"phone\":{\"code\":7,\"number\":\"9612342135\",\"creationDate\":[2021,4,1]},\"married\":true},{\"name\":\"Dmitriy\",\"surname\":\"Ivanov\",\"age\":23,\"address\":{\"postalCode\":1,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Slepneva\",\"houseNumber\":64,\"apartmentNumber\":15},\"phone\":{\"code\":7,\"number\":\"9612347777\",\"creationDate\":[2021,4,1]},\"married\":false}],\"phones\":[{\"code\":7,\"number\":\"9612345678\",\"creationDate\":[2021,4,1]},{\"code\":7,\"number\":\"9612345679\",\"creationDate\":[2021,4,1]}],\"foundationDate\":[1996,6,10]}";
        assertEquals(serializedJSONString, serializer.serializeToJson(org));
    }

    @Test
    void deserializeFromJSON() throws IOException {
        String serializedJSONString = "{\"name\":\"Tensor\",\"address\":{\"postalCode\":1000,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Uglichskaya\",\"houseNumber\":44,\"apartmentNumber\":0},\"employees\":[{\"name\":\"Ivan\",\"surname\":\"Ivanov\",\"age\":22,\"address\":{\"postalCode\":1,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Pervomayskaya\",\"houseNumber\":1,\"apartmentNumber\":1},\"phone\":{\"code\":7,\"number\":\"9612343322\",\"creationDate\":[2021,4,1]},\"married\":false},{\"name\":\"Vasiliy\",\"surname\":\"Vasiliev\",\"age\":19,\"address\":{\"postalCode\":1,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Sovetskaya\",\"houseNumber\":10,\"apartmentNumber\":12},\"phone\":{\"code\":7,\"number\":\"9612342135\",\"creationDate\":[2021,4,1]},\"married\":true},{\"name\":\"Dmitriy\",\"surname\":\"Ivanov\",\"age\":23,\"address\":{\"postalCode\":1,\"country\":\"Russia\",\"city\":\"Yaroslavl\",\"street\":\"Slepneva\",\"houseNumber\":64,\"apartmentNumber\":15},\"phone\":{\"code\":7,\"number\":\"9612347777\",\"creationDate\":[2021,4,1]},\"married\":false}],\"phones\":[{\"code\":7,\"number\":\"9612345678\",\"creationDate\":[2021,4,1]},{\"code\":7,\"number\":\"9612345679\",\"creationDate\":[2021,4,1]}],\"foundationDate\":[1996,6,10]}";
        Serializer serializer = new Serializer();
        Organization org = prepareOrganizationObject();
        assertEquals(serializer.deserializeFromJson(Organization.class, serializedJSONString),org);
    }

    @Test
    void serializeToXML() throws IOException {
        String serializedXMLString = "<Organization><name>Tensor</name><address><postalCode>1000</postalCode><country>Russia</country><city>Yaroslavl</city><street>Uglichskaya</street><houseNumber>44</houseNumber><apartmentNumber>0</apartmentNumber></address><employees><employees><name>Ivan</name><surname>Ivanov</surname><age>22</age><address><postalCode>1</postalCode><country>Russia</country><city>Yaroslavl</city><street>Pervomayskaya</street><houseNumber>1</houseNumber><apartmentNumber>1</apartmentNumber></address><phone><code>7</code><number>9612343322</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phone><married>false</married></employees><employees><name>Vasiliy</name><surname>Vasiliev</surname><age>19</age><address><postalCode>1</postalCode><country>Russia</country><city>Yaroslavl</city><street>Sovetskaya</street><houseNumber>10</houseNumber><apartmentNumber>12</apartmentNumber></address><phone><code>7</code><number>9612342135</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phone><married>true</married></employees><employees><name>Dmitriy</name><surname>Ivanov</surname><age>23</age><address><postalCode>1</postalCode><country>Russia</country><city>Yaroslavl</city><street>Slepneva</street><houseNumber>64</houseNumber><apartmentNumber>15</apartmentNumber></address><phone><code>7</code><number>9612347777</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phone><married>false</married></employees></employees><phones><phones><code>7</code><number>9612345678</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phones><phones><code>7</code><number>9612345679</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phones></phones><foundationDate>1996</foundationDate><foundationDate>6</foundationDate><foundationDate>10</foundationDate></Organization>";
        Organization org = prepareOrganizationObject();
        Serializer serializer = new Serializer();
        assertEquals(serializedXMLString, serializer.serializeToXML(org));
    }

    @Test
    void deserializeFromXML() throws IOException{
        String serializedXMLString = "<Organization><name>Tensor</name><address><postalCode>1000</postalCode><country>Russia</country><city>Yaroslavl</city><street>Uglichskaya</street><houseNumber>44</houseNumber><apartmentNumber>0</apartmentNumber></address><employees><employees><name>Ivan</name><surname>Ivanov</surname><age>22</age><address><postalCode>1</postalCode><country>Russia</country><city>Yaroslavl</city><street>Pervomayskaya</street><houseNumber>1</houseNumber><apartmentNumber>1</apartmentNumber></address><phone><code>7</code><number>9612343322</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phone><married>false</married></employees><employees><name>Vasiliy</name><surname>Vasiliev</surname><age>19</age><address><postalCode>1</postalCode><country>Russia</country><city>Yaroslavl</city><street>Sovetskaya</street><houseNumber>10</houseNumber><apartmentNumber>12</apartmentNumber></address><phone><code>7</code><number>9612342135</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phone><married>true</married></employees><employees><name>Dmitriy</name><surname>Ivanov</surname><age>23</age><address><postalCode>1</postalCode><country>Russia</country><city>Yaroslavl</city><street>Slepneva</street><houseNumber>64</houseNumber><apartmentNumber>15</apartmentNumber></address><phone><code>7</code><number>9612347777</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phone><married>false</married></employees></employees><phones><phones><code>7</code><number>9612345678</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phones><phones><code>7</code><number>9612345679</number><creationDate>2021</creationDate><creationDate>4</creationDate><creationDate>1</creationDate></phones></phones><foundationDate>1996</foundationDate><foundationDate>6</foundationDate><foundationDate>10</foundationDate></Organization>";
        Organization org = prepareOrganizationObject();
        Serializer serializer = new Serializer();
        assertEquals(serializer.deserializeFromXML(Organization.class, serializedXMLString), org);
    }

    @Test
    void serializeToYAML() throws IOException {
        String serializedYAMLString = "name: \"Tensor\"\n" +
                "address:\n" +
                "  postalCode: 1000\n" +
                "  country: \"Russia\"\n" +
                "  city: \"Yaroslavl\"\n" +
                "  street: \"Uglichskaya\"\n" +
                "  houseNumber: 44\n" +
                "  apartmentNumber: 0\n" +
                "employees:\n" +
                "- name: \"Ivan\"\n" +
                "  surname: \"Ivanov\"\n" +
                "  age: 22\n" +
                "  address:\n" +
                "    postalCode: 1\n" +
                "    country: \"Russia\"\n" +
                "    city: \"Yaroslavl\"\n" +
                "    street: \"Pervomayskaya\"\n" +
                "    houseNumber: 1\n" +
                "    apartmentNumber: 1\n" +
                "  phone:\n" +
                "    code: 7\n" +
                "    number: \"9612343322\"\n" +
                "    creationDate: \"2021-04-01\"\n" +
                "  married: false\n" +
                "- name: \"Vasiliy\"\n" +
                "  surname: \"Vasiliev\"\n" +
                "  age: 19\n" +
                "  address:\n" +
                "    postalCode: 1\n" +
                "    country: \"Russia\"\n" +
                "    city: \"Yaroslavl\"\n" +
                "    street: \"Sovetskaya\"\n" +
                "    houseNumber: 10\n" +
                "    apartmentNumber: 12\n" +
                "  phone:\n" +
                "    code: 7\n" +
                "    number: \"9612342135\"\n" +
                "    creationDate: \"2021-04-01\"\n" +
                "  married: true\n" +
                "- name: \"Dmitriy\"\n" +
                "  surname: \"Ivanov\"\n" +
                "  age: 23\n" +
                "  address:\n" +
                "    postalCode: 1\n" +
                "    country: \"Russia\"\n" +
                "    city: \"Yaroslavl\"\n" +
                "    street: \"Slepneva\"\n" +
                "    houseNumber: 64\n" +
                "    apartmentNumber: 15\n" +
                "  phone:\n" +
                "    code: 7\n" +
                "    number: \"9612347777\"\n" +
                "    creationDate: \"2021-04-01\"\n" +
                "  married: false\n" +
                "phones:\n" +
                "- code: 7\n" +
                "  number: \"9612345678\"\n" +
                "  creationDate: \"2021-04-01\"\n" +
                "- code: 7\n" +
                "  number: \"9612345679\"\n" +
                "  creationDate: \"2021-04-01\"\n" +
                "foundationDate: \"1996-06-10\"\n";
        Organization org = prepareOrganizationObject();
        Serializer serializer = new Serializer();
        assertEquals(serializedYAMLString, serializer.serializeToYAML(org));
    }

    @Test
    void deserializeFromYAML() throws IOException {
        String serializedYAMLString = "name: \"Tensor\"\n" +
                "address:\n" +
                "  postalCode: 1000\n" +
                "  country: \"Russia\"\n" +
                "  city: \"Yaroslavl\"\n" +
                "  street: \"Uglichskaya\"\n" +
                "  houseNumber: 44\n" +
                "  apartmentNumber: 0\n" +
                "employees:\n" +
                "- name: \"Ivan\"\n" +
                "  surname: \"Ivanov\"\n" +
                "  age: 22\n" +
                "  address:\n" +
                "    postalCode: 1\n" +
                "    country: \"Russia\"\n" +
                "    city: \"Yaroslavl\"\n" +
                "    street: \"Pervomayskaya\"\n" +
                "    houseNumber: 1\n" +
                "    apartmentNumber: 1\n" +
                "  phone:\n" +
                "    code: 7\n" +
                "    number: \"9612343322\"\n" +
                "    creationDate: \"2021-04-01\"\n" +
                "  married: false\n" +
                "- name: \"Vasiliy\"\n" +
                "  surname: \"Vasiliev\"\n" +
                "  age: 19\n" +
                "  address:\n" +
                "    postalCode: 1\n" +
                "    country: \"Russia\"\n" +
                "    city: \"Yaroslavl\"\n" +
                "    street: \"Sovetskaya\"\n" +
                "    houseNumber: 10\n" +
                "    apartmentNumber: 12\n" +
                "  phone:\n" +
                "    code: 7\n" +
                "    number: \"9612342135\"\n" +
                "    creationDate: \"2021-04-01\"\n" +
                "  married: true\n" +
                "- name: \"Dmitriy\"\n" +
                "  surname: \"Ivanov\"\n" +
                "  age: 23\n" +
                "  address:\n" +
                "    postalCode: 1\n" +
                "    country: \"Russia\"\n" +
                "    city: \"Yaroslavl\"\n" +
                "    street: \"Slepneva\"\n" +
                "    houseNumber: 64\n" +
                "    apartmentNumber: 15\n" +
                "  phone:\n" +
                "    code: 7\n" +
                "    number: \"9612347777\"\n" +
                "    creationDate: \"2021-04-01\"\n" +
                "  married: false\n" +
                "phones:\n" +
                "- code: 7\n" +
                "  number: \"9612345678\"\n" +
                "  creationDate: \"2021-04-01\"\n" +
                "- code: 7\n" +
                "  number: \"9612345679\"\n" +
                "  creationDate: \"2021-04-01\"\n" +
                "foundationDate: \"1996-06-10\"\n";
        Organization org = prepareOrganizationObject();
        Serializer serializer = new Serializer();
        assertEquals(serializer.deserializeFromYAML(Organization.class, serializedYAMLString),org);
    }

}