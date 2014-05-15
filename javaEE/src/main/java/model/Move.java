package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the move database table.
 * 
 */
@Entity
@Table(name="move")
@NamedQuery(name="Move.findAll", query="SELECT m FROM Move m")
public class Move implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String desc;

	private int member;

	@Temporal(TemporalType.DATE)
	private Date tarih;

	private String type;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	@JoinColumn(name="fromId")
	private Cart cart;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="toId")
	private Member memberBean;

	public Move() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getMember() {
		return this.member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public Date getTarih() {
		return this.tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Member getMemberBean() {
		return this.memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

}