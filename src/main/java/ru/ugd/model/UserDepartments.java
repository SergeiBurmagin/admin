package ru.ugd.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_departments", schema = "users", catalog = "ugddb")
public class UserDepartments {
    private short depId;
    private String departmentName;

    private Set<Users> users = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "depId")
    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Id
    @Column(name = "dep_id", nullable = false)
    public short getDepId() {
        return depId;
    }

    public void setDepId(short depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "department_name", nullable = false, length = 200)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDepartments that = (UserDepartments) o;
        return depId == that.depId &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(depId, departmentName);
    }
}
