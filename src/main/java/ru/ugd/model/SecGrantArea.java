package ru.ugd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sec_grant_area", schema = "users", catalog = "ugddb")
public class SecGrantArea {
    private String grantAreaId;
    private String grantAreaName;

    @Id
    @Column(name = "grant_area_id", nullable = false, length = 100)
    public String getGrantAreaId() {
        return grantAreaId;
    }

    public void setGrantAreaId(String grantAreaId) {
        this.grantAreaId = grantAreaId;
    }

    @Basic
    @Column(name = "grant_area_name", nullable = false, length = 200)
    public String getGrantAreaName() {
        return grantAreaName;
    }

    public void setGrantAreaName(String grantAreaName) {
        this.grantAreaName = grantAreaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecGrantArea that = (SecGrantArea) o;
        return Objects.equals(grantAreaId, that.grantAreaId) &&
                Objects.equals(grantAreaName, that.grantAreaName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grantAreaId, grantAreaName);
    }
}
