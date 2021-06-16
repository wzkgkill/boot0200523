package com.student.demo.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Term {
    private Integer tid;
    private String tname;
    private Collection<Course> coursesByTid;
    private Grade gradeByGiid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "tname", nullable = true, length = 1024)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term = (Term) o;
        return Objects.equals(tid, term.tid) && Objects.equals(tname, term.tname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, tname);
    }

    @OneToMany(mappedBy = "termByTid")
    public Collection<Course> getCoursesByTid() {
        return coursesByTid;
    }

    public void setCoursesByTid(Collection<Course> coursesByTid) {
        this.coursesByTid = coursesByTid;
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
