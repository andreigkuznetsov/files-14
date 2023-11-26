package models;

public class Invoice {
    private String id;
    private String invoiceNum;
    private String invoiceState;
    private String cityFrom;
    private String airportTo;
    private String carrierTripDate;
    private String scanTs;
    private Integer scannedParcels;
    private Integer totalParcels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(String invoiceState) {
        this.invoiceState = invoiceState;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public String getCarrierTripDate() {
        return carrierTripDate;
    }

    public void setCarrierTripDate(String carrierTripDate) {
        this.carrierTripDate = carrierTripDate;
    }

    public String getScanTs() {
        return scanTs;
    }

    public void setScanTs(String scanTs) {
        this.scanTs = scanTs;
    }

    public Integer getScannedParcels() {
        return scannedParcels;
    }

    public void setScannedParcels(int scannedParcels) {
        this.scannedParcels = scannedParcels;
    }

    public Integer getTotalParcels() {
        return totalParcels;
    }

    public void setTotalParcels(int totalParcels) {
        this.totalParcels = totalParcels;
    }
}

