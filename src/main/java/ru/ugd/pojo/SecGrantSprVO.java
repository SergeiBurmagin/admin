package ru.ugd.pojo;

public class SecGrantSprVO {

    private short grantId;
    private String grantName;

    public short getGrantId() {
        return grantId;
    }

    public SecGrantSprVO() {
    }

    public SecGrantSprVO(short grantId) {
        this.grantId = grantId;
    }

    public SecGrantSprVO(String grantName) {
        this.grantName = grantName;
    }

    public SecGrantSprVO(short grantId, String grantName) {
        this.grantId = grantId;
        this.grantName = grantName;
    }

    public void setGrantId(short grantId) {
        this.grantId = grantId;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }
}
