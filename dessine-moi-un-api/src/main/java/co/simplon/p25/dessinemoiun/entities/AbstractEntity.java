package co.simplon.p25.dessinemoiun.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    AbstractEntity() {
	//
    }

    public Long getId() {
	return id;
    }

    // DO NOT SET : auto-incremented value
    @SuppressWarnings("unused")
    private void setId(Long id) {
	this.id = id;
    }
}
