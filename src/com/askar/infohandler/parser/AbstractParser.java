package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(AbstractParser.class);

    private TextComponent textComponent;

    public abstract void setNext(AbstractParser parser);

    public abstract void parse(Component composite, String text);


}
