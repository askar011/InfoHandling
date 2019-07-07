package com.askar.infohandler.operation;

import com.askar.infohandler.entity.Composite;
import com.askar.infohandler.entity.TextComponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SorterImpl implements Sorter {
    private static final String SENTENCE_REGEXP = "(?<=['\"\"A-Za-z0-9][\\.\\!\\?])\\s+(?=[A-Z])";
    private static final String WORD_REGEXP = "\\w+";
    private static final String SPLITSENTENCE = "[\\s.,]";
    private static final String PARAPGRAPH_REGEXP = "\\n\\s";

    @Override
    public void sortParagraphBySentenceCount(Composite composite) {
        List<TextComponent> components = composite.getComponentList();
        Collections.sort(components, Comparator.comparingInt(o -> o.getList().size()));
    }

    @Override
    public String sortSentenceByWords(String text) {
        StringBuilder builder = new StringBuilder();
        String[] split = text.split(SENTENCE_REGEXP);
        for (int i = 0; i < split.length; i++) {
            String[] temp = split[i].split(SPLITSENTENCE);
            Arrays.stream(temp).sorted(Comparator.comparingInt(String::length)).forEach(e -> builder.append(e).append(" "));
            builder.append("\n");
        }

        return builder.toString();
    }


    @Override
    public String sortSentencesByWordAmount(String text) {
        StringBuilder builder = new StringBuilder();
        String[] split = text.split(PARAPGRAPH_REGEXP);
        for (int i = 0; i < split.length; i++) {
            String[] temp = split[i].split(SENTENCE_REGEXP);
            Arrays.stream(temp).sorted(Comparator.comparingInt(this::wordAmount)).forEach(builder::append);
            builder.append("\n");
        }
        return builder.toString();
    }

    private int wordAmount(String text) {
        String[] wordAmount = text.split(WORD_REGEXP);
        return wordAmount.length;
    }


}
