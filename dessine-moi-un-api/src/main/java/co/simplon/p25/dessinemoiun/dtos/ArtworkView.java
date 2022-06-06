package co.simplon.p25.dessinemoiun.dtos;

public class ArtworkView {

    private String fileName;

    private Boolean cover;

    public ArtworkView() {
	//
    }

    public ArtworkView(String fileName, Boolean cover) {
	this.fileName = fileName;
	this.cover = cover;
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

}
