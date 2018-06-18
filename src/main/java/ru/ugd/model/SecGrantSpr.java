package ru.ugd.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sec_grant_spr", schema = "users", catalog = "ugddb")
public class SecGrantSpr {

    private short grantId;
    private String grantName;

    private Set<SecGrant2RoleMap> secGrant2RoleMaps = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "secGrantSpr")
    public Set<SecGrant2RoleMap> getSecGrant2RoleMaps() {
        return secGrant2RoleMaps;
    }

    public void setSecGrant2RoleMaps(Set<SecGrant2RoleMap> secGrant2RoleMaps) {
        this.secGrant2RoleMaps = secGrant2RoleMaps;
    }




    @Id
    @Column(name = "grant_id", nullable = false)
    public short getGrantId() {
        return grantId;
    }

    public void setGrantId(short grantId) {
        this.grantId = grantId;
    }

    @Basic
    @Column(name = "grant_name", nullable = true, length = 200)
    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecGrantSpr that = (SecGrantSpr) o;
        return grantId == that.grantId &&
                Objects.equals(grantName, that.grantName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grantId, grantName);
    }
}
