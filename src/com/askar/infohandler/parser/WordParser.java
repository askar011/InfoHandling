package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(WordParser.class);
    private static final String REG_EXP = "(\\w+)|(\\s)";

    private AbstractParser lexemeParser;
    private TextComponent component;

    @Override
    public void setNext(AbstractParser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    @Override
    public void parse(Component composite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
            if (lexemeParser != null) {
                Component wordComponent = new TextComponent(TextComponentType.WORD, split[i]);
                LOGGER.info(TextComponentType.WORD + " " + i + " :" + split[i]);
                lexemeParser.parse(wordComponent, split[i]);
                composite.add(wordComponent);
            }
        }
    }
}
