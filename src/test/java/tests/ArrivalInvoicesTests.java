package tests;

import models.Invoice;
import models.CommonData;
import models.OperatorInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.JsonParser;

import java.util.List;

public class ArrivalInvoicesTests {
    TestData testData = new TestData();
    private JsonParser jsonParser;

    @BeforeEach
    void setUp() {
        jsonParser = new JsonParser(testData.jsonFilePath);
    }

    private CommonData getCommonData() {
        return jsonParser.getCommonData();
    }

    @Test
    void commonDataTest() {
        Assertions.assertThat(getCommonData().getResultType()).isEqualTo(testData.resultType);
        Assertions.assertThat(getCommonData().getMessage()).isNull();
    }

    @Test
    void operatorInfoTest() {
        OperatorInfo operatorInfo = getCommonData().getOperatorInfo();

        Assertions.assertThat(operatorInfo)
                .extracting(
                        OperatorInfo::getOperatorName,
                        OperatorInfo::getOperatorDepartmentCode,
                        OperatorInfo::getTsdSerialNumber
                )
                .containsExactly(
                        testData.operatorName,
                        testData.departmentCode,
                        testData.tsdSerialNumber
                );
    }

    @Test
    void invoicesDataTest() {
        List<Invoice> invoices = getCommonData().getInvoices();

        Assertions.assertThat(invoices).hasSize(2);

        Assertions.assertThat(invoices.get(0))
                .extracting(
                        Invoice::getId,
                        Invoice::getInvoiceNum,
                        Invoice::getInvoiceState,
                        Invoice::getCityFrom,
                        Invoice::getAirportTo,
                        Invoice::getCarrierTripDate,
                        Invoice::getScanTs,
                        Invoice::getScannedParcels,
                        Invoice::getTotalParcels
                )
                .containsExactly(
                        testData.firstInvoiceId,
                        testData.firstInvoiceNum,
                        testData.openInvoiceState,
                        testData.firstInvoiceCityFrom,
                        testData.firstInvoiceAirportTo,
                        testData.firstInvoiceCarrierTripDate,
                        null,
                        testData.firstInvoiceScannedParcels,
                        testData.firstInvoiceTotalParcels
                );

        Assertions.assertThat(invoices.get(1))
                .extracting(
                        Invoice::getId,
                        Invoice::getInvoiceNum,
                        Invoice::getInvoiceState,
                        Invoice::getCityFrom,
                        Invoice::getAirportTo,
                        Invoice::getCarrierTripDate,
                        Invoice::getScanTs,
                        Invoice::getScannedParcels,
                        Invoice::getTotalParcels
                )
                .containsExactly(
                        testData.secondInvoiceId,
                        testData.secondInvoiceNum,
                        testData.openInvoiceState,
                        testData.secondInvoiceCityFrom,
                        testData.secondInvoiceAirportTo,
                        testData.secondInvoiceCarrierTripDate,
                        testData.secondInvoiceScanTs,
                        testData.secondInvoiceScannedParcels,
                        testData.secondInvoiceTotalParcels
                );
    }

    @Test
    void invalidJsonFileTest() {
        Assertions.assertThatThrownBy(() -> new JsonParser(testData.invalidJsonFilePath))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("JSON-файл не найден");
    }
}

