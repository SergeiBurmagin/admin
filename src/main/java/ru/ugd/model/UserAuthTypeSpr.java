package ru.ugd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_auth_type_spr", schema = "users", catalog = "ugddb")
public class UserAuthTypeSpr {
    private String authType;
    private String authName;


    @Id
    @Column(name = "auth_type", nullable = false, length = 30)
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }


    @Column(name = "auth_name", nullable = false, length = 200)
    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthTypeSpr that = (UserAuthTypeSpr) o;
        return Objects.equals(authType, that.authType) &&
                Objects.equals(authName, that.authName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(authType, authName);
    }
}
