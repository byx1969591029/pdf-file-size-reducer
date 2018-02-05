package com.example.pdfreducer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PdfFileSizeReducerTest {
    @Test
    public void testReducingPdf() throws Exception {
        String inputFilePath = "/tmp/sample1.pdf";
        String outputFilePath = "/tmp/sample1-comp.pdf";

        PdfFileSizeReducer pdfReducer = new PdfFileSizeReducer(new FileInputStream(inputFilePath));

        if (pdfReducer.getNumberOfPages() > 100) {
            System.out.println("Your input pdf file has page more than 100!");
        } else {
            pdfReducer.setResizeExceptSizeUnder(1024, 768);
            pdfReducer.reduce(new FileOutputStream(outputFilePath), 0.5f, 0.5f);
        }
    }
}