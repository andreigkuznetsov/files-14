package tests;

import org.junit.jupiter.api.Test;
import utils.*;

public class ReadFromArchiveTests {

    private final ClassLoader classLoader = ReadFromArchiveTests.class.getClassLoader();
    private final ArchiveFileAssert archiveFileAssert = new ArchiveFileAssert(classLoader);
    private final PdfFileAssert pdfFileAssert = new PdfFileAssert();
    private final ExcelFileAssert excelFileAssert = new ExcelFileAssert();
    private final CsvFileAssert csvFileAssert = new CsvFileAssert();
    private final FileExtractor fileExtractor = new FileExtractor();
    TestData testData = new TestData();

    @Test
    void pdfFileInZipShouldHaveCorrectDataTest() throws Exception {
        byte[] pdfFileContent = fileExtractor.extractFileFromZip(testData.archiveName, testData.pdfFileTitle);
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.pdfFileTitle,
                testData.pdfFileCompressiveSize,
                testData.pdfFileSize);
        pdfFileAssert.assertPdfFileContainsText(pdfFileContent, testData.pdfDocumentText);
        pdfFileAssert.assertPdfFileHasPageCount(pdfFileContent, testData.pdfDocumentPagesQty);
    }

    @Test
    void xlsxFileInZipShouldHaveCorrectDataTest() throws Exception {
        byte[] xlsFileContent = fileExtractor.extractFileFromZip(testData.archiveName, testData.xlsxFileTitle);
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
    void scvFileInZipShouldHaveCorrectDataTest() throws Exception {
        byte[] csvFileContent = fileExtractor.extractFileFromZip(testData.archiveName, testData.scvFileTitle);
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.scvFileTitle,
                testData.scvFileCompressiveSize,
                testData.scvFileSize);
        csvFileAssert.assertCsvFileContainsData(csvFileContent);
        csvFileAssert.assertCsvFileHasExpectedHeaders(csvFileContent, testData.csvHeadersTitles);
    }
}



