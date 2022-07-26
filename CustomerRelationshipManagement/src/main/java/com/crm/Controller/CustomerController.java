package com.crm.Controller;

import java.util.List;

import com.crm.Model.Customer;
import com.crm.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String getCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		System.out.println(customers);
		return "customerlist";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.deleteCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showaddform")
	public String showAddForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customerform";
	}

	@GetMapping("/showupdateform")
	public String showUpdateForm(@ModelAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", customer);
		return "customerform";
	}
}
