package com.askar.infohandler.parser;

import com.askar.infohandler.entity.Component;

public class TextParser extends AbstractParser {

    private WordParser wordParser;
    private LexemeParser lexemeParser;
    private SentenceParser sentenceParser;
    private ParagraphParser paragraphParser;

    private Component textComposite;

    public TextParser() {
        this.lexemeParser = new LexemeParser();
        this.wordParser = new WordParser();
        this.sentenceParser = new SentenceParser();
        this.paragraphParser = new ParagraphParser();

        paragraphParser.setNext(sentenceParser);
        sentenceParser.setNext(wordParser);
        wordParser.setNext(lexemeParser);
    }

    @Override
    public void setNext(AbstractParser parser) {
        throw new UnsupportedOperationException();
    }

    public Component getTextComposite() {
        return textComposite;
    }

    @Override
    public void parse(Component composite, String text) {
        if (paragraphParser != null) {
            paragraphParser.parse(composite, text);
        }
        this.textComposite = composite;
    }


}
