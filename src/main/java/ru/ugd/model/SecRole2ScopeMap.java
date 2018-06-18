package ru.ugd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sec_role_2_scope_map", schema = "users", catalog = "ugddb")

public class SecRole2ScopeMap implements Serializable{


    //MonyToOne
    private SecScopeSpr secScopeSpr;

    @Id
    @ManyToOne
    @JoinColumn(name = "scope_id", nullable = false)
    public SecScopeSpr getSecScopeSpr() {
        return secScopeSpr;
    }

    public void setSecScopeSpr(SecScopeSpr secScopeSpr) {
        this.secScopeSpr = secScopeSpr;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecRole2ScopeMap)) return false;
        SecRole2ScopeMap that = (SecRole2ScopeMap) o;
        return Objects.equals(secScopeSpr, that.secScopeSpr) &&
                Objects.equals(secRoleSpr, that.secRoleSpr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(secScopeSpr, secRoleSpr);
    }
}
