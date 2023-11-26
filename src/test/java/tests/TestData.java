package tests;

public class TestData {

    public String archiveName = "archive.zip",
                pdfFileTitle = "pandect_is471.pdf",
                xlsxFileTitle = "devices.xlsx",
                scvFileTitle = "departments.csv",
                jsonFilePath = "/response.json",
                invalidJsonFilePath = "responses.json",
                resultType = "OK",
                operatorName = "Горшенин Максим Евгеньевич",
                departmentCode = "SVO",
                tsdSerialNumber = "Mnbbvxx10",
                firstInvoiceId = "52822982779",
                secondInvoiceId = "52822887621",
                firstInvoiceNum = "kznsvo45",
                secondInvoiceNum = "kznsvo723",
                openInvoiceState = "open",
                firstInvoiceCityFrom = "Казань",
                secondInvoiceCityFrom = "Казань",
                firstInvoiceAirportTo = "Шереметьево",
                secondInvoiceAirportTo = "Шереметьево",
                firstInvoiceCarrierTripDate = "2023-11-16T00:00:00",
                secondInvoiceCarrierTripDate = "2023-11-17T00:00:00",
                secondInvoiceScanTs = "2023-11-16T13:57:43";

    public Long pdfFileCompressiveSize = 909814L,
                pdfFileSize = 1026038L,
                xlsxFileCompressiveSize = 6398L,
                xlsxFileSize = 8867L,
                scvFileCompressiveSize = 239L,
                scvFileSize = 487L;

    public Integer firstInvoiceScannedParcels = 0,
                secondInvoiceScannedParcels = 0,
                firstInvoiceTotalParcels = 3,
                secondInvoiceTotalParcels = 4;
}
