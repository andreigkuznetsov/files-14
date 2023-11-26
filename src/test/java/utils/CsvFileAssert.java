package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.assertj.core.api.Assertions;

import java.io.*;
import java.util.List;

public class CsvFileAssert {

    public void assertCsvFileContainsData(byte[] fileContent) throws IOException, CsvException {
        String content = new String(fileContent);
        try (CSVReader reader = new CSVReader(new StringReader(content))) {
            List<String[]> records = reader.readAll();
            Assertions.assertThat(records.size()).isGreaterThan(0);
        }
    }

    public void assertCsvFileHasExpectedHeaders(
                                            byte[] fileContent,
                                            String[] expectedHeaders) throws IOException, CsvValidationException {
        String content = new String(fileContent);
        try (CSVReader reader = new CSVReader(new StringReader(content))) {
            String[] headers = reader.readNext();
            Assertions.assertThat(headers).isNotNull();
            Assertions.assertThat(headers.length).isEqualTo(expectedHeaders.length);

            for (int i = 0; i < headers.length; i++) {
                Assertions.assertThat(headers[i]).isEqualTo(expectedHeaders[i]);
            }
        }
    }
}
