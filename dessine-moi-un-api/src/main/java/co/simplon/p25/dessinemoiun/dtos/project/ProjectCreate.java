package co.simplon.p25.dessinemoiun.dtos.project;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProjectCreate {

    @NotBlank
    @Size(min = 20, max = 255)
    private String description;

    @NotNull
    @Positive
    private double price;

    @NotNull
    @Future
    private LocalDate deadline;

    @NotNull
    private Long artMediumId;

    @NotNull
    private Long artFormatId;

    @NotNull
    private Long artistId;

    public ProjectCreate() {
	//
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

    public Long getArtMediumId() {
	return artMediumId;
    }

    public void setArtMediumId(Long artMediumId) {
	this.artMediumId = artMediumId;
    }

    public Long getArtFormatId() {
	return artFormatId;
    }

    public void setArtFormatId(Long artFormatId) {
	this.artFormatId = artFormatId;
    }

    public Long getArtistId() {
	return artistId;
    }

    public void setArtistId(Long artistId) {
	this.artistId = artistId;
    }

    @Override
    public String toString() {
	return String.format(
		"ProjectCreate [description=%s, price=%s, deadline=%s, artMediumId=%s, artFormatId=%s, artistId=%s]",
		description, price, deadline, artMediumId, artFormatId,
		artistId);
    }

}
