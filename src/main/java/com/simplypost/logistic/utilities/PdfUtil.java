package com.simplypost.logistic.utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PdfUtil {

    public static String getPdfData(String fileName) {
        String projectDir = System.getProperty("user.dir");
        String directory = projectDir + "/downloadFiles/" + fileName +".pdf";

        String[] lines = null;
        String pdfText = "";

        try (PDDocument document = PDDocument.load(new File(directory))) {
            document.getClass();

            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);

                // split by whitespace
                lines = pdfFileInText.split("\\r?\\n");
                pdfText = Arrays.toString(lines);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfText;
    }

}
