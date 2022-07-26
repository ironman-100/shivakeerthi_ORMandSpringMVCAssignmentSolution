package com.crm.Service;

import java.util.List;

import com.crm.Model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

}
