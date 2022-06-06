package co.simplon.p25.dessinemoiun.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist extends AbstractEntity {

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "available")
    private Boolean available;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "artists_art_mediums", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "art_medium_id"))
    private List<ArtMedium> artMedium;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "artists_art_formats", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "art_format_id"))
    private List<ArtFormat> artFormat;

    public Artist() {
	//
    }

    public Artist(String artistName, Boolean available, Profile profile) {
	this.artistName = artistName;
	this.available = available;
	this.profile = profile;
    }

    public String getArtistName() {
	return artistName;
    }

    public void setArtistName(String artistName) {
	this.artistName = artistName;
    }

    public String getInstagramUrl() {
	return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
	this.instagramUrl = instagramUrl;
    }

    public Boolean getAvailable() {
	return available;
    }

    public void setAvailable(Boolean available) {
	this.available = available;
    }

    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
    }

    public List<ArtMedium> getArtMedium() {
	return artMedium;
    }

    public void setArtMedium(List<ArtMedium> artMedium) {
	this.artMedium = artMedium;
    }

    public List<ArtFormat> getArtFormat() {
	return artFormat;
    }

    public void setArtFormat(List<ArtFormat> artFormat) {
	this.artFormat = artFormat;
    }

    @Override
    public String toString() {
	return String.format(
		"Artist [artistName=%s, instagramUrl=%s, available=%s, profile=%s]",
		artistName, instagramUrl, available, profile);
    }

}
