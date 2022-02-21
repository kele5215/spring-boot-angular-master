package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerMapper;
import com.example.demo.service.impl.CustomerServiceImpl;

/* https://segmentfault.com/a/1190000040803747
 * https://www.kancloud.cn/apachecn/howtodoinjava-zh/1953197
 * https://juejin.cn/post/6844903924248346637
 * Spring单元测试教程（JUnit5+Mockito）
*/
public class CustomerServiceTest {

	@Mock
	// @Mock 注解会为其注解的类创建一个模拟实现。
	private CustomerMapper mapper;

	@InjectMocks
	// @InjectMock 还将创建模拟实现，另外将标有注解@Mock的从属模拟注入其中
	private CustomerServiceImpl service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@DisplayName("CREATE TEST:Check if registeration succeeded")
	@Test
	void testRegister() {
		Customer customer = new Customer();
		customer.setId("901");
		customer.setUsername("user901");
		customer.setEmail("test.user.901@EXAMPLE.com");
		customer.setPhoneNumber("7894561230");
		customer.setPostCode("123456");

		when(mapper.insert(Mockito.any(Customer.class))).thenReturn(1);
		Customer actual = service.register(customer);

		assertEquals(customer.getId(), actual.getId());
		assertEquals(customer.getUsername(), actual.getUsername());
		assertEquals("test.user.901@example.com", actual.getEmail());
		assertEquals(customer.getPhoneNumber(), actual.getPhoneNumber());
		assertEquals(customer.getPostCode(), actual.getPostCode());

		Mockito.verify(mapper, Mockito.times(1)).insert(customer);
	}

}
