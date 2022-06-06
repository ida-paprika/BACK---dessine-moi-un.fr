package co.simplon.p25.dessinemoiun.dtos.project;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ProjectUpdate {

    private Long id;

    @NotBlank
    @Positive
    private Integer price;

    public ProjectUpdate() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getPrice() {
	return price;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

    @Override
    public String toString() {
	return String.format("ProjectUpdate [id=%s, price=%s]", id, price);
    }

}
