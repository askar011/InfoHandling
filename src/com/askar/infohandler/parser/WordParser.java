package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import com.askar.infohandler.util.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(WordParser.class);
    private static final String REG_EXP = "\\w+";

    private AbstractParser lexemeParser;

    public WordParser() {
        GeneratorId.generateParserId();
    }

    @Override
    public void setNext(AbstractParser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    @Override
    public void parse(Component sentenceComposite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
            TextComponent textComponent = new TextComponent(TextComponentType.WORD, split[i]);
            LOGGER.info(TextComponentType.WORD + " " + i + " :" + split[i]);
            sentenceComposite.add(textComponent);
        }
        if (lexemeParser != null) {
            lexemeParser.parse(sentenceComposite, text);
        }
    }
}
