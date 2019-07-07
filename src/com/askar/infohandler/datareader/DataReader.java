package com.askar.infohandler.datareader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);
    private BufferedReader br;
    private StringBuilder stringBuilder;
    private static final String FILEPATH = "data/input.txt";

    public String readText(String filePath) {
        if (filePath == null) {
            filePath = FILEPATH;
        }
        stringBuilder = new StringBuilder();
        String tmp;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }
        try {
            while ((tmp = br.readLine()) != null) {
                stringBuilder.append(tmp);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            LOGGER.error(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return stringBuilder.toString();
    }
}
