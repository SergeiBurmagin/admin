package ru.ugd.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserAuthPK implements Serializable {
    private String userId;
    private String authType;

    @Column(name = "user_id", nullable = false, length = 40)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "auth_type", nullable = false, length = 30)
    @Id
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthPK that = (UserAuthPK) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(authType, that.authType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, authType);
    }
}
