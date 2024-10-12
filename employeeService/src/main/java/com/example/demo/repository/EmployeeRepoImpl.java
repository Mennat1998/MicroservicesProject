package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<Employee> findById(Long id) {

		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :id",
				Employee.class);
		query.setParameter("id", id);

		try {
			Employee employee = (Employee) query.getSingleResult();
			return Optional.of(employee);
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}
	
	
	@Override
	public boolean findByNationalId (String nationalId)
	{
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.NationalId = :nationalId",
				Employee.class);
		query.setParameter("nationalId", nationalId);

		try {
			Employee employee = (Employee) query.getSingleResult();
			if(employee ==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (NoResultException e) {
			return false;
		}
	}
	
	

	@Override
	public List<Employee> findAll() {
		try {
			TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	@Transactional
	public Employee insert(Employee emp) {
		entityManager.persist(emp);
		return emp;
	}

	@Override
	@Transactional
	public Employee update(Employee emp) {
		return entityManager.merge(emp);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			entityManager.remove(employee);
		} else {
			throw new NoResultException("Employee with id " + id + " not found.");
		}
	}

}
