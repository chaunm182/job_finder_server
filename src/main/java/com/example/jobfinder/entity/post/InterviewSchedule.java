package com.example.jobfinder.entity.post;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interview_schedule")
public class InterviewSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "interview_at")
    private Date interviewAt;

    @OneToOne(targetEntity = RecruitmentDetail.class)
    @JoinColumn(name = "recruitment_detail_id")
    private RecruitmentDetail recruitmentDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getInterviewAt() {
        return interviewAt;
    }

    public void setInterviewAt(Date interviewAt) {
        this.interviewAt = interviewAt;
    }

    public RecruitmentDetail getRecruitmentDetail() {
        return recruitmentDetail;
    }

    public void setRecruitmentDetail(RecruitmentDetail recruitmentDetail) {
        this.recruitmentDetail = recruitmentDetail;
    }
}
