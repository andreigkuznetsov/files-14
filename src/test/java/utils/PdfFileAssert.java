package utils;

import com.codeborne.pdftest.PDF;
import org.assertj.core.api.Assertions;

public class PdfFileAssert {

    public void assertPdfFileContainsText(byte[] fileContent, String expectedText) {
        PDF pdf = new PDF(fileContent);
        Assertions.assertThat(pdf.text).contains(expectedText);
    }


    public void assertPdfFileHasPageCount(byte[] fileContent, int expectedPageCount) {
        PDF pdf = new PDF(fileContent);
        int actualPageCount = pdf.numberOfPages;
        Assertions.assertThat(actualPageCount).isEqualTo(expectedPageCount);
    }
}


