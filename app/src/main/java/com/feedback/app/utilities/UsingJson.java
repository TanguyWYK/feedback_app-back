package com.feedback.app.utilities;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class UsingJson {

    private final HashMap<String, String> json;

    public UsingJson(Object myObject) throws InvocationTargetException, IllegalAccessException {
        json = new HashMap<>();
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(myObject.getClass());
        for (PropertyDescriptor propertyDescriptor: propertyDescriptors
             ) {
            Method getter = propertyDescriptor.getReadMethod();
            String propertyName = propertyDescriptor.getName();
            if(!propertyName.equals("class") && getter.invoke(myObject)!= null){
                json.put(propertyName, getter.invoke(myObject).toString());
            }
        }
    }

    @Override
    public String toString() {
        var parts = new ArrayList<String>();
        for (String key : json.keySet()
        ) {
            parts.add("\""+key +"\""+ ":\"" + json.get(key) + "\"");
        }
        String response = String.join(",", parts);
        return "{" + response + "}";
    }
}
