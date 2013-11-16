/**
 * 
 */
package de.app.pd.entity.pv;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pd
 * 
 */
@Entity
@Table(name = "tagesertraege")
public class Tagesertrag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String wochentag;

	@Column
	private Date datum;

	@Column
	private Double erzeugerStrom;

	@Column
	private Double durchschnittsTemperatur;

	public String getWochentag() {
		return this.wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Double getErzeugerStrom() {
		return this.erzeugerStrom;
	}

	public void setErzeugerStrom(Double erzeugerStrom) {
		this.erzeugerStrom = erzeugerStrom;
	}

	public Double getDurchschnittsTemperatur() {
		return this.durchschnittsTemperatur;
	}

	public void setDurchschnittsTemperatur(Double durchschnittsTemperatur) {
		this.durchschnittsTemperatur = durchschnittsTemperatur;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
