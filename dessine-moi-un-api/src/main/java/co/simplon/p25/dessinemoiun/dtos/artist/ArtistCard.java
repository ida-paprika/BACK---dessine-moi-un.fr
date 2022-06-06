package co.simplon.p25.dessinemoiun.dtos.artist;

public class ArtistCard {

    private Long id;

    private String artistName;

    private String artwork;

    public ArtistCard() {
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

    public String getArtwork() {
	return artwork;
    }

    public void setArtwork(String artwork) {
	this.artwork = artwork;
    }

    @Override
    public String toString() {
	return String.format("ArtistCard [id=%s, artistName=%s, artwork=%s]",
		id, artistName, artwork);
    }

}
