package com.dxctraining.computer.dao;

import org.springframework.stereotype.Repository;

import com.dxctraining.computer.entities.Computer;
import com.dxctraining.computer.exceptions.ComputerNotFoundException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ComputerDaoImpl implements IComputerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Computer save(Computer computer) {
		entityManager.persist(computer);
		return computer;
	}

	@Override
	public Computer findComputerById(int id) {
		Computer computer = entityManager.find(Computer.class, id);
		if (computer == null) {
			throw new ComputerNotFoundException("computer not found for the given id" +id);
		}
		return computer;
	}
	@Override
    public List<Computer> computerList() {
        String jpaQuery = "from computer";
       TypedQuery<Computer>computerquery= entityManager.createQuery(jpaQuery, Computer.class);
        List<Computer> resultList = computerquery.getResultList();
        return resultList;
    }
	@Override
	public void remove(int id) {
		Computer computer = findComputerById(id);
		entityManager.remove(computer);
	}
	@Override
	public List<Computer> findComputerBySupplier(int supplierId) {
		String jpaql = "from Computer where supplierId=:supplier";
		TypedQuery<Computer> query = entityManager.createQuery(jpaql, Computer.class);
		query.setParameter("supplier", supplierId);
		List<Computer> computerList = query.getResultList();
		return computerList;
	}
}
