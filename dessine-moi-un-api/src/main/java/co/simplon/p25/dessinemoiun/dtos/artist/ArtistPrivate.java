package co.simplon.p25.dessinemoiun.dtos.artist;

public class ArtistPrivate {

    private String artistName;

    private String instagramUrl;

    public ArtistPrivate() {
	//
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

    @Override
    public String toString() {
	return String.format("ArtistPrivate [artistName=%s, instagramUrl=%s]",
		artistName, instagramUrl);
    }

}
