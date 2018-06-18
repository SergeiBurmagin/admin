package ru.ugd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_auth", schema = "users", catalog = "ugddb")
@IdClass(UserAuthPK.class)
public class UserAuth {
    private Users userId;
    private String authType;
    private String login;
    private String password;
    private String role;
    private Boolean enabled;
    private String extGuid;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }




    @Id
    @Column(name = "auth_type", nullable = false, length = 30)
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 200)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "secRole2ScopeMap", nullable = true, length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "enabled", nullable = true)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "ext_guid", nullable = true, length = 500)
    public String getExtGuid() {
        return extGuid;
    }

    public void setExtGuid(String extGuid) {
        this.extGuid = extGuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuth userAuth = (UserAuth) o;
        return Objects.equals(userId, userAuth.userId) &&
                Objects.equals(authType, userAuth.authType) &&
                Objects.equals(login, userAuth.login) &&
                Objects.equals(password, userAuth.password) &&
                Objects.equals(role, userAuth.role) &&
                Objects.equals(enabled, userAuth.enabled) &&
                Objects.equals(extGuid, userAuth.extGuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, authType, login, password, role, enabled, extGuid);
    }
}
