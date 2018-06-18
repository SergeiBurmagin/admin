package ru.ugd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_type_spr", schema = "users", catalog = "ugddb")
public class UserTypeSpr {
    private String userType;
    private String typeName;

    @Id
    @Column(name = "user_type", nullable = false, length = 2)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "type_name", nullable = false, length = 100)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTypeSpr that = (UserTypeSpr) o;
        return Objects.equals(userType, that.userType) &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userType, typeName);
    }
}
