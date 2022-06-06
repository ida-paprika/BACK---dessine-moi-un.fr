package co.simplon.p25.dessinemoiun.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "art_formats")
public class ArtFormat extends AbstractEntity {

    @Column(name = "label")
    private String label;

    @Column(name = "minimum_price")
    private Integer minimumPrice;

    @Column(name = "multiplier")
    private double multiplier;

    @ManyToMany(mappedBy = "artFormat")
    private List<Artist> artist;

    public ArtFormat() {
	//
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public Integer getMinimumPrice() {
	return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
	this.minimumPrice = minimumPrice;
    }

    public double getMultiplier() {
	return multiplier;
    }

    public void setMultiplier(double multiplier) {
	this.multiplier = multiplier;
    }

    public List<Artist> getArtist() {
	return artist;
    }

    public void setArtist(List<Artist> artist) {
	this.artist = artist;
    }

    @Override
    public String toString() {
	return String.format(
		"ArtFormat [label=%s, minimumPrice=%s, multiplier=%s]", label,
		minimumPrice, multiplier);
    }

}
