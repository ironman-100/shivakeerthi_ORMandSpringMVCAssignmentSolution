package com.crm.DAO;

import java.util.List;

import com.crm.Model.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

}
