package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gridfield database table.
 * 
 */
@Entity
@Table(name="gridfield")
@NamedQuery(name="Gridfield.findAll", query="SELECT g FROM Gridfield g")
public class Gridfield implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String colname;

	private int gridId;

	private String header;

	public Gridfield() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColname() {
		return this.colname;
	}

	public void setColname(String colname) {
		this.colname = colname;
	}

	public int getGridId() {
		return this.gridId;
	}

	public void setGridId(int gridId) {
		this.gridId = gridId;
	}

	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

}