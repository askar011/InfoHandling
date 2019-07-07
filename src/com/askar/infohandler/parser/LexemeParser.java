package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(LexemeParser.class);
    private static final String REG_EXP = "\\s";


    private AbstractParser symbolParser;
    private TextComponent component;

    @Override
    public void setNext(AbstractParser symbolParser) {
        this.symbolParser = symbolParser;
    }

    @Override
    public void parse(Component composite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
                Component lexemeComponent = new TextComponent(TextComponentType.LEXEME, split[i]);
                LOGGER.info(TextComponentType.LEXEME + " " + i + " :" + split[i]);
//                symbolParser.parse(lexemeComponent, text);
                composite.add(lexemeComponent);
        }
    }
}
