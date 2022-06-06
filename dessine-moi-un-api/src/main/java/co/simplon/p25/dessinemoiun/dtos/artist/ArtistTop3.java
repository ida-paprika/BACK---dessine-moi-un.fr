package co.simplon.p25.dessinemoiun.dtos.artist;

import co.simplon.p25.dessinemoiun.dtos.ArtworkView;

public class ArtistTop3 {

    private Long id;

    private String artistName;

    private ArtworkView cover;

    public ArtistTop3() {
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

    public ArtworkView getCover() {
	return cover;
    }

    public void setCover(ArtworkView cover) {
	this.cover = cover;
    }

}
