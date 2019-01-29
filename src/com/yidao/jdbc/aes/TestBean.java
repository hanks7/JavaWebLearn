package com.yidao.jdbc.aes;

public class TestBean {
    String UDI_DI;
    String UDI_EXPIDATE;
    String UDI_MANUDATE;
    String UDI_LOT;
    String UDI_SN;

    public String getUDI_DI() {
        return UDI_DI;
    }

    public void setUDI_DI(String UDI_DI) {
        this.UDI_DI = UDI_DI;
    }

    public String getUDI_EXPIDATE() {
        return UDI_EXPIDATE;
    }

    public void setUDI_EXPIDATE(String UDI_EXPIDATE) {
        this.UDI_EXPIDATE = UDI_EXPIDATE;
    }

    public String getUDI_MANUDATE() {
        return UDI_MANUDATE;
    }

    public void setUDI_MANUDATE(String UDI_MANUDATE) {
        this.UDI_MANUDATE = UDI_MANUDATE;
    }

    public String getUDI_LOT() {
        return UDI_LOT;
    }

    public void setUDI_LOT(String UDI_LOT) {
        this.UDI_LOT = UDI_LOT;
    }

    public String getUDI_SN() {
        return UDI_SN;
    }

    public void setUDI_SN(String UDI_SN) {
        this.UDI_SN = UDI_SN;
    }

    @Override
    public String toString() {
        return "{" +
                "UDI_DI:'" + UDI_DI + '\'' +
                ", UDI_EXPIDATE:'" + UDI_EXPIDATE + '\'' +
                ", UDI_MANUDATE:'" + UDI_MANUDATE + '\'' +
                ", UDI_LOT:'" + UDI_LOT + '\'' +
                ", UDI_SN:'" + UDI_SN + '\'' +
                '}';
    }
}
