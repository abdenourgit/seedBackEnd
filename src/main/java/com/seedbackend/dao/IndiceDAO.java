package com.seedbackend.dao;

import com.seedbackend.model.Indice;

public class IndiceDAO extends DAO<Indice> {

	@Override
	public Indice find(long id) {
		
		session.getSessionFactory();
		session.beginTransaction();
		Indice indice = (Indice) session.get(Indice.class,id);
		session.getTransaction().commit();
		session.close();
		
		
		return indice;
	}

	@Override
	public Indice create(Indice obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Indice update(Indice indice) {
		
		session.getSessionFactory();
		session.beginTransaction();
		session.saveOrUpdate(indice);
		session.getTransaction().commit();
		//indice = (Indice) session.get(Indice.class,indice.getId());
		session.close();
		
		return indice;
	}

	@Override
	public void delete(Indice obj) {
		// TODO Auto-generated method stub
	}
}
