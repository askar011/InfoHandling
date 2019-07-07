package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import com.askar.infohandler.util.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(LexemeParser.class);
    private static final String REG_EXP = "\\s";

    public LexemeParser() {
        GeneratorId.generateParserId();
    }

    @Override
    public void setNext(AbstractParser parser) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void parse(Component sentenceComposite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
            Component lexemeComponent = new TextComponent(TextComponentType.LEXEME, split[i]);
            LOGGER.info(TextComponentType.LEXEME + " " + i + " :" + split[i]);
            sentenceComposite.add(lexemeComponent);
        }
    }
}
