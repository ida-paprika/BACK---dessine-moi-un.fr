package co.simplon.p25.dessinemoiun.dtos.project;

import java.time.LocalDate;

public class ProjectView {

    private Long id;

    private LocalDate createdAt;

    private String description;

    private double price;

    private LocalDate deadline;

    private String artMediumLabel;

    private String artFormatLabel;

    private String userName;

    private String progressStatus;

    public ProjectView() {
	//
    }

    public ProjectView(Long id, LocalDate createdAt, String description,
	    double price, LocalDate deadline, String artMediumLabel,
	    String artFormatLabel, String userName, String progressStatus) {
	this.id = id;
	this.createdAt = createdAt;
	this.description = description;
	this.price = price;
	this.deadline = deadline;
	this.artMediumLabel = artMediumLabel;
	this.artFormatLabel = artFormatLabel;
	this.userName = userName;
	this.progressStatus = progressStatus;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public LocalDate getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
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

    public String getArtMediumLabel() {
	return artMediumLabel;
    }

    public void setArtMediumLabel(String artMediumLabel) {
	this.artMediumLabel = artMediumLabel;
    }

    public String getArtFormatLabel() {
	return artFormatLabel;
    }

    public void setArtFormatLabel(String artFormatLabel) {
	this.artFormatLabel = artFormatLabel;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getProgressStatus() {
	return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
	this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
	return String.format(
		"ProjectView [id=%s, createdAt=%s, description=%s, price=%s, deadline=%s, artMediumLabel=%s, artFormatLabel=%s, userName=%s, progressStatus=%s]",
		id, createdAt, description, price, deadline, artMediumLabel,
		artFormatLabel, userName, progressStatus);
    }

}
