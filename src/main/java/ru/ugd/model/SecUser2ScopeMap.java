package ru.ugd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sec_user_2_scope_map", schema = "users", catalog = "ugddb")

public class SecUser2ScopeMap implements Serializable{

    //MonyToOne
    private Users users;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecUser2ScopeMap)) return false;
        SecUser2ScopeMap that = (SecUser2ScopeMap) o;
        return Objects.equals(users, that.users) &&
                Objects.equals(secScopeSpr, that.secScopeSpr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(users, secScopeSpr);
    }
}
