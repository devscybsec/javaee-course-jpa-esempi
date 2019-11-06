package it.cybsec.daos;

import java.util.*;

import javax.persistence.criteria.*;

import it.cybsec.models.Dipendente;
import it.cybsec.utils.AbstractDao;

public class DipendenteDao extends AbstractDao<Dipendente, Integer> {

	public DipendenteDao() { 
		super();
	}
	
	@Override
	public Dipendente recupera(Integer id) {
		return em.find(Dipendente.class, id);
	}

	@Override
	public List<Dipendente> recupera() {
		em.clear();
		CriteriaQuery<Dipendente> query = getCriteriaBuilder().createQuery(Dipendente.class);
		query.select(query.from(Dipendente.class));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Dipendente> recupera(CriteriaQuery<Dipendente> query) {
		em.clear();
		return em.createQuery(query).getResultList();
	}

}
