package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@Table(name="cart")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int bakiye;

	private String cartcol;

	private String code;

	private String password;

	private String status;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="memberId")
	private Member member;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="cart")
	private List<Move> moves;

	public Cart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBakiye() {
		return this.bakiye;
	}

	public void setBakiye(int bakiye) {
		this.bakiye = bakiye;
	}

	public String getCartcol() {
		return this.cartcol;
	}

	public void setCartcol(String cartcol) {
		this.cartcol = cartcol;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setCart(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setCart(null);

		return move;
	}

}