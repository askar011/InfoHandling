package com.askar.infohandler.entity;

import com.askar.infohandler.datareader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite implements Component {

    private static final Logger LOGGER = LogManager.getLogger(Composite.class);
    private List<Component> componentList = new ArrayList<>();

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }

    @Override
    public List<Component> getComponentList() {
        return Collections.unmodifiableList(componentList);
    }

    @Override
    public String struct() {
        StringBuilder s = new StringBuilder();
        for (Component component : componentList){
            s.append(component.struct());

        }

        return s.toString();
    }
}
