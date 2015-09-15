package com.example.test;

import org.robovm.objc.annotation.Property;
import org.robovm.pods.realm.RLMObject;

/**
 * Created by c on 9/15/15.
 */
public class TestObj extends RLMObject {
    private String name;
    private String type;

    @Property
    public String getName() {
        return name;
    }

    @Property
    public void setName(String name) {
        this.name = name;
    }

    @Property
    public String getType() {
        return type;
    }

    @Property
    public void setType(String type) {
        this.type = type;
    }
}
