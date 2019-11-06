package it.cybsec.daos;

import java.util.*;

import javax.persistence.criteria.*;

import it.cybsec.models.Ufficio;
import it.cybsec.utils.AbstractDao;

public class UfficioDao extends AbstractDao<Ufficio, Integer> {
	
	public UfficioDao() {
		super();
	}
	
	@Override
	public Ufficio recupera(Integer id) {
		return em.find(Ufficio.class, id);
	}

	@Override
	public List<Ufficio> recupera() {
		em.clear();
		CriteriaQuery<Ufficio> query = getCriteriaBuilder().createQuery(Ufficio.class);
		query.select(query.from(Ufficio.class));
		return em.createQuery(query).getResultList();
	}
	
	@Override
	public List<Ufficio> recupera(CriteriaQuery<Ufficio> query) {
		em.clear();
		return em.createQuery(query).getResultList();
	}

}
