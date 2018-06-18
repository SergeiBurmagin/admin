package ru.ugd.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sec_scope_spr", schema = "users", catalog = "ugddb")
public class SecScopeSpr {
    private String scopeId;
    private String scopeName;

    //OneToMony
    private Set<SecRole2ScopeMap> secRole2ScopeMaps = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "secScopeSpr")
    public Set<SecRole2ScopeMap> getSecRole2ScopeMaps() {
        return secRole2ScopeMaps;
    }

    public void setSecRole2ScopeMaps(Set<SecRole2ScopeMap> secRole2ScopeMaps) {
        this.secRole2ScopeMaps = secRole2ScopeMaps;
    }

    //OneToMony
    private Set<SecUser2ScopeMap> secUser2ScopeMaps = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "secScopeSpr")
    public Set<SecUser2ScopeMap> getSecUser2ScopeMaps() {
        return secUser2ScopeMaps;
    }

    public void setSecUser2ScopeMaps(Set<SecUser2ScopeMap> secUser2ScopeMaps) {
        this.secUser2ScopeMaps = secUser2ScopeMaps;
    }


    @Id
    @Column(name = "scope_id", nullable = false, length = 60)
    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    @Basic
    @Column(name = "scope_name", nullable = false, length = 100)
    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecScopeSpr that = (SecScopeSpr) o;
        return Objects.equals(scopeId, that.scopeId) &&
                Objects.equals(scopeName, that.scopeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scopeId, scopeName);
    }
}
