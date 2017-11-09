package com.quytran.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quytran.webstore.domain.Customer;
import com.quytran.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> getAllCustomers() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", params, new CustomerMapper());
		return result;
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
//			customer.setCustomerId(rs.getString("ID"));
//			customer.setName(rs.getString("NAME"));
//			customer.setAddress(rs.getString("ADDRESS"));
//			customer.setNoOfOrdersMade(rs.getLong("NO_ORDERS_MADE"));
//			customer.setRole(rs.getString("ROLE"));
			return customer;
		}
	}

	@Override
	public void addCustomer(Customer customer) {
//		String SQL = "INSERT INTO CUSTOMERS (ID,"
//				+ "NAME,"
//				+ "ADDRESS,"
//				+ "NO_ORDERS_MADE, ROLE) "
//				+ "VALUES (:id, :name, :address, :noOrdersMade, :role)";
//				Map<String, Object> params = new HashMap<>();
//				params.put("id", customer.getCustomerId());
//				params.put("name", customer.getName());
//				params.put("address", customer.getAddress());
//				params.put("noOrdersMade", customer.getNoOfOrdersMade());
//				params.put("role", customer.getRole());
//				jdbcTemplate.update(SQL, params);
	}

}
