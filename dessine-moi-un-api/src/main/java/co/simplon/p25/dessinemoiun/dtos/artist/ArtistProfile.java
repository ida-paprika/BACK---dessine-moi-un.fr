package co.simplon.p25.dessinemoiun.dtos.artist;

import java.util.List;

import co.simplon.p25.dessinemoiun.dtos.ArtFormatView;
import co.simplon.p25.dessinemoiun.dtos.ArtMediumView;
import co.simplon.p25.dessinemoiun.dtos.ArtworkView;

public class ArtistProfile {

    private Long id;

    private String artistName;

    private String instagramUrl;

    private List<ArtMediumView> artMedium;

    private List<ArtFormatView> artFormat;

    private List<ArtworkView> artwork;

    public ArtistProfile(Long id, String artistName, String instagramUrl) {
	this.id = id;
	this.artistName = artistName;
	this.instagramUrl = instagramUrl;
    }

    public ArtistProfile() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public List<ArtMediumView> getArtMedium() {
	return artMedium;
    }

    public void setArtMedium(List<ArtMediumView> artMedium) {
	this.artMedium = artMedium;
    }

    public List<ArtFormatView> getArtFormat() {
	return artFormat;
    }

    public void setArtFormat(List<ArtFormatView> artFormat) {
	this.artFormat = artFormat;
    }

    public List<ArtworkView> getArtwork() {
	return artwork;
    }

    public void setArtwork(List<ArtworkView> artwork) {
	this.artwork = artwork;
    }

}
