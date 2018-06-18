package ru.ugd.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sec_role_spr", schema = "users", catalog = "ugddb")
public class SecRoleSpr {
    private String roleId;
    private String roleName;


    //OneToMony
    private Set<SecGrant2RoleMap> secGrant2RoleMaps = new HashSet<>();
  @OneToMany(cascade = CascadeType.ALL,mappedBy = "secRoleSpr")
    public Set<SecGrant2RoleMap> getSecGrant2RoleMaps() {
        return secGrant2RoleMaps;
    }

    public void setSecGrant2RoleMaps(Set<SecGrant2RoleMap> secGrant2RoleMaps) {
        this.secGrant2RoleMaps = secGrant2RoleMaps;
    }

    //OneToMony
    private Set<SecUser2RoleMap> secUser2RoleMaps = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "secRoleSpr")
    public Set<SecUser2RoleMap> getSecUser2RoleMaps() {
        return secUser2RoleMaps;
    }

    public void setSecUser2RoleMaps(Set<SecUser2RoleMap> secUser2RoleMaps) {
        this.secUser2RoleMaps = secUser2RoleMaps;
    }


    //OneToMony
    private Set<SecRole2ScopeMap> secRole2ScopeMaps = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "secRoleSpr")
    public Set<SecRole2ScopeMap> getSecRole2ScopeMaps() {
        return secRole2ScopeMaps;
    }

    public void setSecRole2ScopeMaps(Set<SecRole2ScopeMap> secRole2ScopeMaps) {
        this.secRole2ScopeMaps = secRole2ScopeMaps;
    }





    @Id
    @Column(name = "role_id", nullable = false, length = 60)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 200)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecRoleSpr that = (SecRoleSpr) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, roleName);
    }
}
