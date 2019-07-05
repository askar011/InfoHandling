package com.askar.infohandler.entity;

import java.util.List;

public interface Component {

    String struct();

    void add(Component component);

    void remove(Component component);

    List<Component> getComponentList();

}
