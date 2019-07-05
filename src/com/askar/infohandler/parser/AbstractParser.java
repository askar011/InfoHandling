package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(AbstractParser.class);
    private AbstractParser next;
    private TextComponent textComponent;

    public AbstractParser(AbstractParser next) {
        this.next = next;
    }

    public AbstractParser getNext() {
        return next;
    }

    public void setNext(AbstractParser next) {
        this.next = next;
    }

    public void parse(Component composite, String text, String regExp, TextComponentType textComponentType) {

        String[] split = text.split(regExp);

        for (int i = 0; i < split.length; i++) {
            textComponent = new TextComponent(textComponentType, split[i]);
            LOGGER.info(textComponent.getComponentType() + ":" + i + " " + textComponent.struct());
            composite.add(textComponent);
        }
    }

}
