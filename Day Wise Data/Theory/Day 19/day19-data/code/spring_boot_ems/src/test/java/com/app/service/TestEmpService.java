package com.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class TestEmpService {
	@Autowired
	private EmployeeService service;

	@Test
	void test() {
		service.deleteEmpDetails(2);
	}

}
