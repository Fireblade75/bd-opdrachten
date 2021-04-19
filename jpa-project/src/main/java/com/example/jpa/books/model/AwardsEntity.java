package com.example.jpa.books.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "awards", schema = "bookstore", catalog = "")
public class AwardsEntity {
    private int awardId;
    private String name;
    private String organisation;

    @Id
    @Column(name = "award_id", nullable = false)
    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "organisation", nullable = true, length = 20)
    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwardsEntity that = (AwardsEntity) o;
        return awardId == that.awardId && Objects.equals(name, that.name) && Objects.equals(organisation, that.organisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardId, name, organisation);
    }
}
