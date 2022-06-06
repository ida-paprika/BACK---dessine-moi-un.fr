package co.simplon.p25.dessinemoiun.dtos;

public class GetMediumFormat {

    private Long mediumId;
    private Long formatId;

    public GetMediumFormat() {
	//
    }

    public Long getMediumId() {
	return mediumId;
    }

    public void setMediumId(Long mediumId) {
	this.mediumId = mediumId;
    }

    public Long getFormatId() {
	return formatId;
    }

    public void setFormatId(Long formatId) {
	this.formatId = formatId;
    }

}
