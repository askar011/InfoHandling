package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private LexemeParser lexemeParser;
    private static final String REG_EXP = "\\w+";

    public WordParser(AbstractParser lexemeParser) {
        super(lexemeParser);
    }

    @Override
    public void parse(Component composite, String text, String regExp, TextComponentType textComponentType) {
        super.parse(composite, text, REG_EXP, TextComponentType.WORD);
    }
}
