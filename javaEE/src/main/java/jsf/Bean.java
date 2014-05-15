package jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Cart;
import model.Member;
import ejb.MemberService;

@Named
@ViewScoped
public class Bean {
	String message;

	List<Member> members;

	@EJB
	private MemberService service;

	@Inject
	private CDIBean bean;

	public Bean() {
		System.out.println("bean cons called");
		this.message = "hello from jsf bean xxx";
	}

	@PostConstruct
	public void init() {
		System.out.println("postcontruc:" + bean.getClass().getName());

		this.members = service.getAllMembers();

		Member m = service.getMember(1);
		System.out.println(m.getEmail());
		for (Cart c : m.getCarts()) {
			System.out.println(c.getCode());
		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
