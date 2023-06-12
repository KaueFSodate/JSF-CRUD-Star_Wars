package br.com.backend.dao;

import br.com.backend.models.Planeta;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
public class PlanetaDAO {
    private EntityManagerFactory emf;

    public PlanetaDAO() {
        emf = Persistence.createEntityManagerFactory("planeta");
    }

    public void salvar(Planeta planeta) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(planeta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void atualizar(Planeta planeta) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(planeta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Planeta buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Planeta.class, id);
        } finally {
            em.close();
        }
    }

    public List<Planeta> buscarPorNome(String nome) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Planeta> query = em.createQuery("SELECT p FROM Planeta p WHERE p.nome = :nome", Planeta.class);
            query.setParameter("nome", nome);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Planeta> buscarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Planeta> query = em.createQuery("SELECT p FROM Planeta p", Planeta.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Planeta planeta = em.find(Planeta.class, id);
            em.remove(planeta);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }
}
