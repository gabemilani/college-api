package com.testes;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteJPA {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAUniversidade");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
