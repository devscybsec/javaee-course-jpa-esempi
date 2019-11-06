package it.cybsec.daos;

import java.util.*;

import javax.persistence.criteria.*;

import it.cybsec.models.Ruolo;
import it.cybsec.utils.AbstractDao;

public class RuoloDao extends AbstractDao<Ruolo, Integer> {
	
	public RuoloDao() {
		super();
	}
	
	@Override
	public Ruolo recupera(Integer id) {
		return em.find(Ruolo.class, id);
	}

	@Override
	public List<Ruolo> recupera() {
		em.clear();
		CriteriaQuery<Ruolo> query = getCriteriaBuilder().createQuery(Ruolo.class);
		query.select(query.from(Ruolo.class));
		return em.createQuery(query).getResultList();
	}
	
	@Override
	public List<Ruolo> recupera(CriteriaQuery<Ruolo> query) {
		return em.createQuery(query).getResultList();
	}

}
