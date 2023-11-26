package tests;

import org.junit.jupiter.api.Test;
import utils.archiveFileAssert;

public class ReadFromArchiveTests {

    private final ClassLoader classLoader = ReadFromArchiveTests.class.getClassLoader();
    private final archiveFileAssert archiveFileAssert = new archiveFileAssert(classLoader);
    TestData testData = new TestData();

    @Test
    void pdfFileInZipShouldHaveCorrectNameAndSizeTest() throws Exception {
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.pdfFileTitle,
                testData.pdfFileCompressiveSize,
                testData.pdfFileSize);
    }

    @Test
    void xlsxFileInZipShouldHaveCorrectNameAndSizeTest() throws Exception {
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.xlsxFileTitle,
                testData.xlsxFileCompressiveSize,
                testData.xlsxFileSize);
    }

    @Test
    void scvFileInZipShouldHaveCorrectNameAndSizeTest() throws Exception {
        archiveFileAssert.assertFileInZip(
                testData.archiveName,
                testData.scvFileTitle,
                testData.scvFileCompressiveSize,
                testData.scvFileSize);
    }
}



