package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import com.askar.infohandler.util.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);
    private static final String REG_EXP = "\\n\\s";
    private AbstractParser sentenceParser;

    public ParagraphParser() {
        GeneratorId.generateParserId();
    }

    @Override
    public void setNext(AbstractParser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    @Override
    public void parse(Component composite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
            if (sentenceParser != null) {
                Component paragraphComponent = new TextComponent(TextComponentType.PARAGRAPH, split[i]);
                LOGGER.info(TextComponentType.PARAGRAPH + " " + i + " :" + split[i]);
                sentenceParser.parse(paragraphComponent, split[i]);
                composite.add(paragraphComponent);
            }
        }
    }
}
