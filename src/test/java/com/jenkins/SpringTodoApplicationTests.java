package com.jenkins;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // 👈 Add this annotation
class SpringTodoApplicationTests {

	@Test
	void contextLoads() {
	}
}

