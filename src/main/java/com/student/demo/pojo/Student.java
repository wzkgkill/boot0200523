package com.student.demo.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Student {
    private Integer sid;
    private String sname;
    private String sex;
    private Timestamp sbirth;

    private Collection<Coursegrade> coursegradesBySid;
    private Grade gradeByGiid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname", nullable = true, length = 1024)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 1024)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "sbirth", nullable = false)
    public Timestamp getSbirth() {
        return sbirth;
    }

    public void setSbirth(Timestamp sbirth) {
        this.sbirth = sbirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) && Objects.equals(sname, student.sname) && Objects.equals(sex, student.sex) && Objects.equals(sbirth, student.sbirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, sex, sbirth);
    }

    @OneToMany(mappedBy = "studentBySid")
    public Collection<Coursegrade> getCoursegradesBySid() {
        return coursegradesBySid;
    }

    public void setCoursegradesBySid(Collection<Coursegrade> coursegradesBySid) {
        this.coursegradesBySid = coursegradesBySid;
    }

    @ManyToOne
    @JoinColumn(name = "giid", referencedColumnName = "giid")
    public Grade getGradeByGiid() {
        return gradeByGiid;
    }

    public void setGradeByGiid(Grade gradeByGiid) {
        this.gradeByGiid = gradeByGiid;
    }
}
