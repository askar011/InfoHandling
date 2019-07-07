package com.askar.infohandler;

import com.askar.infohandler.datareader.DataReader;
import com.askar.infohandler.entity.Composite;
import com.askar.infohandler.operation.SorterImpl;
import com.askar.infohandler.parser.*;

public class Main {


    public static void main(String[] args) {
        SorterImpl sorter = new SorterImpl();
        DataReader reader = new DataReader();
        Composite composite = new Composite();

        AbstractParser paragraphParser = new ParagraphParser();
        AbstractParser sentenceParser = new SentenceParser();
        AbstractParser wordParser = new WordParser();
        AbstractParser lexemeParser = new LexemeParser();

        paragraphParser.setNext(sentenceParser);
        sentenceParser.setNext(wordParser);
        wordParser.setNext(lexemeParser);

        paragraphParser.parse(composite, reader.readText(null));

        sorter.sortParagraphBySentenceCount(composite);
        sorter.sortSentenceByWords(reader.readText(null));
        sorter.sortSentencesByWordAmount(reader.readText(null));

    }
}
