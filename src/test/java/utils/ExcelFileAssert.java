package utils;

import com.codeborne.xlstest.XLS;
import org.assertj.core.api.Assertions;

public class ExcelFileAssert {

    public void assertXlsFileContainsCellValue(byte[] fileContent, String expectedCellValue,
                                                      int sheetAt, int row, int cell) {
        XLS xls = new XLS(fileContent);
        Assertions.assertThat(xls.excel.getSheetAt(sheetAt).getRow(row).getCell(cell).getStringCellValue())
                .isEqualTo(expectedCellValue);
    }

    public void assertXlsxFileHasRowCount(byte[] fileContent, int expectedRowCount) {
        XLS xls = new XLS(fileContent);
        Assertions.assertThat(xls.excel.getSheetAt(0).getPhysicalNumberOfRows()).isEqualTo(expectedRowCount);
    }
}
