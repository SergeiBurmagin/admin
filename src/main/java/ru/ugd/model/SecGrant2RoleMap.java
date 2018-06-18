package ru.ugd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sec_grant_2_role_map", schema = "users", catalog = "ugddb")

public class SecGrant2RoleMap implements Serializable{

    //MonyToOne
    private SecRoleSpr secRoleSpr;
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    public SecRoleSpr getSecRoleSpr() {
        return secRoleSpr;
    }

    public void setSecRoleSpr(SecRoleSpr secRoleSpr) {
        this.secRoleSpr = secRoleSpr;
    }

    private SecGrantSpr secGrantSpr;
    @Id
    @ManyToOne
    @JoinColumn(name = "grant_id", nullable = false)
    public SecGrantSpr getSecGrantSpr() {
        return secGrantSpr;
    }

    public void setSecGrantSpr(SecGrantSpr secGrantSpr) {
        this.secGrantSpr = secGrantSpr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecGrant2RoleMap)) return false;
        SecGrant2RoleMap that = (SecGrant2RoleMap) o;
        return Objects.equals(secRoleSpr, that.secRoleSpr) &&
                Objects.equals(secGrantSpr, that.secGrantSpr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(secRoleSpr, secGrantSpr);
    }
}
