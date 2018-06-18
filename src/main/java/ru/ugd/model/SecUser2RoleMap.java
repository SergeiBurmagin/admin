package ru.ugd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sec_user_2_role_map", schema = "users", catalog = "ugddb")

public class SecUser2RoleMap  implements Serializable  {



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
        if (!(o instanceof SecUser2RoleMap)) return false;
        SecUser2RoleMap that = (SecUser2RoleMap) o;
        return Objects.equals(users, that.users) &&
                Objects.equals(secRoleSpr, that.secRoleSpr) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(users, secRoleSpr, id);
    }

    private String id;


}
