package com.askar.infohandler.operation;

import com.askar.infohandler.entity.Composite;

public interface Sorter {

    void sortParagraphBySentenceCount(Composite composite);

    String sortSentenceByWords(String text);

    String sortSentencesByWordAmount(String text);

}
