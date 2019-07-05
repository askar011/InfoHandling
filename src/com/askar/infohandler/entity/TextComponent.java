package com.askar.infohandler.entity;

import java.util.List;

public class TextComponent implements Component {

    private TextComponentType componentType;
    private String text;

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
        throw new UnsupportedOperationException();
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
