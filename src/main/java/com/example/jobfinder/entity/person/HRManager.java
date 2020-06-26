package com.example.jobfinder.entity.person;

import com.example.jobfinder.entity.company.Company;

import javax.persistence.*;

@Entity
@Table(name = "hr_manager")
@PrimaryKeyJoinColumn(name = "id")
public class HRManager extends Person {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
