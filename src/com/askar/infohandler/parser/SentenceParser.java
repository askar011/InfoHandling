package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;
import com.askar.infohandler.entity.TextComponent;
import com.askar.infohandler.entity.TextComponentType;
import com.askar.infohandler.util.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private static final String REG_EXP = "(?<=['\"\"A-Za-z0-9][\\.\\!\\?])\\s+(?=[A-Z])";
    private AbstractParser wordParser;

    public SentenceParser(){
        GeneratorId.generateParserId();
    }
    @Override
    public void setNext(AbstractParser wordParser) {
        this.wordParser = wordParser;
    }

    @Override
    public void parse(Component paragraphComposite, String text) {
        String[] split = text.split(REG_EXP);
        for (int i = 0; i < split.length; i++) {
            if (wordParser != null) {
                TextComponent textComponent = new TextComponent(TextComponentType.SENTENCE, split[i]);
                LOGGER.info(TextComponentType.SENTENCE + " " + i + " :" + split[i]);
                wordParser.parse(textComponent, split[i]);
                paragraphComposite.add(textComponent);
            }
        }
    }
}
