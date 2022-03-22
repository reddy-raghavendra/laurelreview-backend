package com.nwmsu.laurelreview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AboutUs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AboutUsId;
    @Column
    private String AboutUsName;
    @Column
    private String AboutUsDesc;
    @Column
    private String AboutUsCoverImage;

    public Long getAboutUsId() {
        return AboutUsId;
    }

    public void setAboutUsId(Long AboutUsId) {
        this.AboutUsId = AboutUsId;
    }

    public String getAboutUsName() {
        return AboutUsName;
    }

    public void setPodcastName(String podcastName) {
        this.AboutUsName = AboutUsName;
    }

    public String getPodcastDesc() {
        return AboutUsDesc;
    }

    public void setAboutUsDesc(String AboutUsDesc) {
        this.AboutUsDesc = AboutUsDesc;
    }

    public String getAboutUsCoverImage() {
        return AboutUsCoverImage;
    }

    public void setAboutUsCoverImage(String AboutUsCoverImage) {
        this.AboutUsCoverImage = AboutUsCoverImage;
    }

}
