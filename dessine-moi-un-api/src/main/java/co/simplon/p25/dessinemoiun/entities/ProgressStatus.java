package co.simplon.p25.dessinemoiun.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "progress_status")
public class ProgressStatus extends AbstractEntity {

    @Column(name = "status")
    private String status;

    public ProgressStatus() {
	//
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return String.format("ProgressStatus [status=%s]", status);
    }

}
