package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SymbolParser.class);
    private static final String REG_EXP = "";


    private AbstractParser nextParser;
    private TextComponent component;

    @Override
    public void setNext(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public void parse(Component composite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
            Component lexemeComponent = new TextComponent(TextComponentType.SYMBOL, split[i]);
            LOGGER.info(TextComponentType.SYMBOL + " " + i + " :" + split[i]);
            composite.add(lexemeComponent);
        }
    }
}
