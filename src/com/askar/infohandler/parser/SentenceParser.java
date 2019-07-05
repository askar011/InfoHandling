package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private SymbolParser symbolParser;
    private static final String REG_EXP = "[(.)(!)(?)]";

    public SentenceParser(AbstractParser symbolParser) {
        super(symbolParser);
    }

    @Override
    public void parse(Component composite, String text, String regExp, TextComponentType textComponentType) {
        super.parse(composite, text, REG_EXP, TextComponentType.SENTENCE);
    }


}
