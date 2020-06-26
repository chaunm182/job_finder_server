package com.example.jobfinder.entity.person;


import com.example.jobfinder.entity.profile.Profile;

import javax.persistence.*;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Person {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
