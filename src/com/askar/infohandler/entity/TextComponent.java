package com.askar.infohandler.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextComponent implements Component {

    private TextComponentType componentType;
    private String text;
    private List<Component> list = new ArrayList<>();

    public TextComponent(TextComponentType textComponentType, String text) {
        this.componentType = textComponentType;
        this.text = text;
    }

    public TextComponentType getComponentType() {
        return componentType;
    }


    @Override
    public String struct() {
        return text;
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    public String getText() {
        return text;
    }

    public List<Component> getList() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getComponentList() {
        throw new UnsupportedOperationException();
    }
}
