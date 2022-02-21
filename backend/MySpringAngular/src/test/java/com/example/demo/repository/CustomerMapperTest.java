package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;

@SpringBootTest
@Transactional
//@Import(DbConfig.class)
public class CustomerMapperTest {

	@Autowired
	private CustomerMapper mapper;

	@Autowired
	private DataSource ds;

	private IDatabaseConnection dbconn;

	// private IDataSet inputCsvDataSet;

	@BeforeEach
	void setUp() throws Exception {
		this.dbconn = new DatabaseConnection(this.ds.getConnection());
	}

	@AfterEach
	void tearDown() throws Exception {
		this.dbconn.close();
	}

	@Test
	void testDeleteByPrimaryKey() {
		fail("まだ実装されていません");
	}

	@DisplayName("INSERT TEST: Check if  the data is inserted as expected.")
	@Test
	void testInsert() {
		Customer customer = new Customer();
		customer.setId("1001");
		customer.setUsername("user100");
		customer.setEmail("test.user@excmple.com");
		customer.setPhoneNumber("0123456789");
		customer.setPostCode("123456");

		assertEquals(1, mapper.insert(customer));
	}

	@Test
	void testSelectByPrimaryKey() {
		fail("まだ実装されていません");
	}

	@Test
	void testUpdateByPrimaryKeySelective() {
		fail("まだ実装されていません");
	}

	@Test
	void testUpdateByPrimaryKey() {
		fail("まだ実装されていません");
	}

}
