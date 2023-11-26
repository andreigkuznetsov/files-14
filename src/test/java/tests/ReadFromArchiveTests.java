package tests;

import org.junit.jupiter.api.Test;
import utils.*;

public class ReadFromArchiveTests {

    private final ClassLoader classLoader = ReadFromArchiveTests.class.getClassLoader();
    private final ArchiveFileAssert archiveFileAssert = new ArchiveFileAssert(classLoader);
    private final PdfFileAssert pdfFileAssert = new PdfFileAssert();
    private final ExcelFileAssert excelFileAssert = new ExcelFileAssert();
    private final CsvFileAssert csvFileAssert = new CsvFileAssert();
    TestData testData = new TestData();

    @Test
    void pdfFileInZipShouldHaveCorrectNameAndSizeTest() throws Exception {
        byte[] pdfFileContent = FileExtractor.extractFileFromZip(testData.archiveName, testData.pdfFileTitle);
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.pdfFileTitle,
                testData.pdfFileCompressiveSize,
                testData.pdfFileSize);
        pdfFileAssert.assertPdfFileContainsText(pdfFileContent, testData.pdfDocumentText);
        pdfFileAssert.assertPdfFileHasPageCount(pdfFileContent, testData.pdfDocumentPagesQty);
    }

    @Test
    void xlsxFileInZipShouldHaveCorrectNameAndSizeTest() throws Exception {
        byte[] xlsFileContent = FileExtractor.extractFileFromZip(testData.archiveName, testData.xlsxFileTitle);
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.xlsxFileTitle,
                testData.xlsxFileCompressiveSize,
                testData.xlsxFileSize);
        excelFileAssert.assertXlsxFileHasRowCount(xlsFileContent, testData.xlsRowsQty);
        excelFileAssert.assertXlsFileContainsCellValue(xlsFileContent,
                testData.xlsCellValue, testData.xlsSheetWithData, testData.xlsRowWithData, testData.xlsCellWithData);
    }

    @Test
    void scvFileInZipShouldHaveCorrectNameAndSizeTest() throws Exception {
        byte[] csvFileContent = FileExtractor.extractFileFromZip(testData.archiveName, testData.scvFileTitle);
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.scvFileTitle,
                testData.scvFileCompressiveSize,
                testData.scvFileSize);
        csvFileAssert.assertCsvFileContainsData(csvFileContent);
        csvFileAssert.assertCsvFileHasExpectedHeaders(csvFileContent, testData.csvHeadersTitles);
    }
}



