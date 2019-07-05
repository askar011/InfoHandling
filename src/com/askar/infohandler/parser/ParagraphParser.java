package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.Composite;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private static final String REG_EXP = "\\n\\s";
    private TextComponent paragraph;

    public ParagraphParser(SentenceParser sentenceParser) {
        super(sentenceParser);
    }

    @Override
    public void parse(Component composite, String text, String regExp, TextComponentType textComponentType) {
        super.parse(composite, text, REG_EXP, TextComponentType.PARAGRAPH);
    }
}
