package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@Table(name="member")
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private int bakiye;

	private String company;

	private String email;

	private String membercol;

	private String mname;

	private String password;

	private String status;

	private String username;

	private String yetkili;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="member")
	private List<Cart> carts;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="memberBean")
	private List<Move> moves;

	public Member() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBakiye() {
		return this.bakiye;
	}

	public void setBakiye(int bakiye) {
		this.bakiye = bakiye;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMembercol() {
		return this.membercol;
	}

	public void setMembercol(String membercol) {
		this.membercol = membercol;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYetkili() {
		return this.yetkili;
	}

	public void setYetkili(String yetkili) {
		this.yetkili = yetkili;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setMember(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setMember(null);

		return cart;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setMemberBean(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setMemberBean(null);

		return move;
	}

}