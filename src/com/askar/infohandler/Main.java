package com.askar.infohandler;

import com.askar.infohandler.datareader.DataReader;
import com.askar.infohandler.entity.Composite;
import com.askar.infohandler.parser.*;

public class Main {


    public static void main(String[] args) {
        DataReader reader = new DataReader();
        Composite composite = new Composite();
        AbstractParser paragraphParser = new ParagraphParser();
        AbstractParser sentenceParser = new SentenceParser();
        AbstractParser wordParser = new WordParser();
        AbstractParser lexemeParser = new LexemeParser();
        AbstractParser symbolPaser = new SymbolParser();

        paragraphParser.setNext(sentenceParser);
        sentenceParser.setNext(wordParser);
        wordParser.setNext(lexemeParser);
//        lexemeParser.setNext(symbolPaser);
        symbolPaser.setNext(null);

        paragraphParser.parse(composite, reader.readText(null));

    }
}
