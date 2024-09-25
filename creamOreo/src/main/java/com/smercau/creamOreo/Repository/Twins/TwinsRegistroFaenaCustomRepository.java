package com.smercau.creamOreo.Repository.Twins;

import com.smercau.creamOreo.Entity.Twins.TwinsRegistroFaena;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TwinsRegistroFaenaCustomRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    public List<TwinsRegistroFaena> buscarFecha(String fecha) {
        String jpql = "SELECT u FROM TwinsRegistroFaena u WHERE u.fecha = :fecha";
        TypedQuery<TwinsRegistroFaena> query = entityManager.createQuery(jpql, TwinsRegistroFaena.class);
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }
}
