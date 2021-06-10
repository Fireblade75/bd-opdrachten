package com.example.java.collections;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import java.beans.XMLEncoder;
import java.util.LinkedList;
import java.util.List;

public class VariantTest {

    public static List<? super Number> processNumbers(List<? extends Number> values) {
        List<? super  Number> result = new LinkedList<>();

        for(var value: values) {
            result.add(value.floatValue() * 3.5f);
        }

        return result;
    }

    public static void main(String[] args) {
        var res = processNumbers(List.of(4, 6, 9, 1));

//        XmlWriter xmlWriter = new
//        for(Object k : res) {
//
//        }
    }
}
