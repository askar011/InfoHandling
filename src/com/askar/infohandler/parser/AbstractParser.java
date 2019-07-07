package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;

public abstract class AbstractParser {

    public abstract void setNext(AbstractParser parser);

    public abstract void parse(Component composite, String text);


}
