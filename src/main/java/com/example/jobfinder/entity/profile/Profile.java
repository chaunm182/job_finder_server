package com.example.jobfinder.entity.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "position")
    private String position;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private List<Education> educations;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private List<Certification> certifications;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private List<Skill> skills;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private List<Prize> prizes;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    private List<Project> projects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
