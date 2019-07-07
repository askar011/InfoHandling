package com.askar.infohandler.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private static final Logger LOGGER = LogManager.getLogger(Composite.class);
    private List<TextComponent> componentList = new ArrayList<>();

    @Override
    public void add(Component component) {
        componentList.add((TextComponent) component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }

    @Override
    public List<TextComponent> getComponentList() {
        return componentList;
    }

    @Override
    public String struct() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < componentList.size(); i++) {
            stringBuilder.append(componentList.get(i).getText());
        }
        return stringBuilder.toString();
    }
}
