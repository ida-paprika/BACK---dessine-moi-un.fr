package co.simplon.p25.dessinemoiun.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project extends AbstractEntity {

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "deadline")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "art_medium_id")
    private ArtMedium artMedium;

    @ManyToOne
    @JoinColumn(name = "art_format_id")
    private ArtFormat artFormat;

    @ManyToOne
    @JoinColumn(name = "progress_status_id")
    private ProgressStatus progressStatus;

    public Project() {
	//
    }

    public LocalDateTime getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public LocalDate getDeadline() {
	return deadline;
    }

    public void setDeadline(LocalDate deadline) {
	this.deadline = deadline;
    }

    public Artist getArtist() {
	return artist;
    }

    public void setArtist(Artist artist) {
	this.artist = artist;
    }

    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
    }

    public ArtMedium getArtMedium() {
	return artMedium;
    }

    public void setArtMedium(ArtMedium artMedium) {
	this.artMedium = artMedium;
    }

    public ArtFormat getArtFormat() {
	return artFormat;
    }

    public void setArtFormat(ArtFormat artFormat) {
	this.artFormat = artFormat;
    }

    public ProgressStatus getProgressStatus() {
	return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
	this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
	return String.format(
		"Project [createdAt=%s, description=%s, price=%s, deadline=%s, artist=%s, profile=%s, artMedium=%s, artFormat=%s, progressStatus=%s]",
		createdAt, description, price, deadline, artist, profile,
		artMedium, artFormat, progressStatus);
    }

}
