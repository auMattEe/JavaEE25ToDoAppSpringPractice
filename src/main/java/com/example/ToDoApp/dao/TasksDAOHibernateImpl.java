package com.example.ToDoApp.dao;

import com.example.ToDoApp.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TasksDAOHibernateImpl implements TasksDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        TypedQuery<Task> query = currentSession.createQuery("FROM Task", Task.class);

        return query.getResultList();
    }

    @Override
    public Task findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(Task.class, id);
    }

    @Override
    public void save(Task task) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.merge(task);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        TypedQuery<Task> query = currentSession.createQuery("DELETE from Task where id=:taskId");
        query.setParameter("taskId", id);

        query.executeUpdate();
    }
}