package com.crm.DAO;

import java.util.List;

import javax.transaction.Transactional;

import com.crm.Model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
@Transactional
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		List<Customer> customers = hibernateTemplate.loadAll(Customer.class);
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		hibernateTemplate.saveOrUpdate(customer);

	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		hibernateTemplate.delete(customer);
	}

}
