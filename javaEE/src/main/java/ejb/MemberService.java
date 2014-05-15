package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import model.Member;

/**
 * Session Bean implementation class MemberService
 */
@Stateless
@LocalBean
public class MemberService {

	@PersistenceContext(unitName = "javaEE")
	EntityManager em;

	public MemberService() {

	}

	public Member getMember(int id) {
		Member mem = em
				.createQuery("select m from Member m join fetch m.carts where m.id="+id,
						Member.class).getSingleResult();
		return mem;
	}

	public List<Member> getAllMembers() {
		CriteriaQuery<Member> criteriaQuery = em.getCriteriaBuilder()
				.createQuery(Member.class);

		List<Member> members = em.createQuery(
				criteriaQuery.select(criteriaQuery.from(Member.class)).where())
				.getResultList();

		return members;
		// em.get
	}
}
