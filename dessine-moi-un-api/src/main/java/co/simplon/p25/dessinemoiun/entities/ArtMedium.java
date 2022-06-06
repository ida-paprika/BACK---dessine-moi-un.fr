package co.simplon.p25.dessinemoiun.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "art_mediums")
public class ArtMedium extends AbstractEntity {

    @Column(name = "label")
    private String label;

    @Column(name = "minimum_price")
    private Integer minimumPrice;

    public ArtMedium() {
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

    @Override
    public String toString() {
	return String.format("ArtMedium [label=%s, minimumPrice=%s]", label,
		minimumPrice);
    }

}
