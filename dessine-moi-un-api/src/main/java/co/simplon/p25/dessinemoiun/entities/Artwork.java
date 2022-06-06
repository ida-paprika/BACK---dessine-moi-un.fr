package co.simplon.p25.dessinemoiun.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artworks")
public class Artwork extends AbstractEntity {

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "cover")
    private Boolean cover;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Artwork() {
	//
    }

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

    public Boolean getCover() {
	return cover;
    }

    public void setCover(Boolean cover) {
	this.cover = cover;
    }

    public Artist getArtist() {
	return artist;
    }

    public void setArtist(Artist artist) {
	this.artist = artist;
    }

    public Artwork(String fileName, Boolean cover, Artist artist) {
	this.fileName = fileName;
	this.cover = cover;
	this.artist = artist;
    }

    @Override
    public String toString() {
	return String.format("Artwork [fileName=%s, cover=%s, artist=%s]",
		fileName, cover, artist.toString());
    }

}
