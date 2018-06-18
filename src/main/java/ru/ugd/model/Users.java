package ru.ugd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "users", catalog = "ugddb")
public class Users {
    private String userId;
    private UserDepartments depId;
    private String family;
    private String name;
    private String patronymic;

    //OneToMany
    private Set<SecUser2RoleMap> secUser2RoleMaps = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
    public Set<SecUser2RoleMap> getSecUser2RoleMaps() {
        return secUser2RoleMaps;
    }

    public void setSecUser2RoleMaps(Set<SecUser2RoleMap> secUser2RoleMaps) {
        this.secUser2RoleMaps = secUser2RoleMaps;
    }

    private Set<UserAuth> userAuths = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userId")
    public Set<UserAuth> getUserAuths() {
        return userAuths;
    }

    public void setUserAuths(Set<UserAuth> userAuths) {
        this.userAuths = userAuths;
    }



    @Id
    @Column(name = "user_id", nullable = false, length = 40)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false)
    public UserDepartments getDepId() {
        return depId;
    }

    public void setDepId(UserDepartments depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "family", nullable = true, length = 100)
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "patronymic", nullable = true, length = 100)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userId, users.userId) &&
                Objects.equals(family, users.family) &&
                Objects.equals(name, users.name) &&
                Objects.equals(patronymic, users.patronymic) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, family, name, patronymic);
    }
}
