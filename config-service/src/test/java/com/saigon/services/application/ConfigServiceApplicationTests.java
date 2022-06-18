package com.saigon.services.application;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(ConfigServiceApplicationTests.ConfigServerExtension.class)
@SpringBootTest(classes = ConfigServiceApplication.class,
		// Normally spring.cloud.config.enabled:true is the default but since we have
		// the config server on the classpath
		// we need to set it explicitly.
		properties = {
				"spring.cloud.config.enabled:true",
				"management.security.enabled=false",
				"management.endpoints.web.exposure.include=*"
		}, webEnvironment = RANDOM_PORT)
@Tag("Smoke")
class ConfigServiceApplicationTests {

	private static final int CONFIG_PORT = 1000;

	private static ConfigurableApplicationContext server;

	static class ConfigServerExtension implements BeforeAllCallback, AfterAllCallback {

		@Override
		public void beforeAll(ExtensionContext extensionContext) {
			if (server == null) {
				server = new SpringApplicationBuilder(ConfigServiceApplication.class)
						.run("--server.port=" + CONFIG_PORT,
								"--spring.cloud.config.server.git.uri=???",
								"--spring.cloud.config.server.git.username=???",
								"--spring.cloud.config.server.git.password=???",
								"--spring.cloud.config.server.git.default-label=master",
								"--spring.cloud.config.server.git.search-paths=???");
			}
		}

		@Override
		public void afterAll(ExtensionContext extensionContext) {
			if (server != null) {
				server.close();
			}
		}
	}

	@Nested
	@ActiveProfiles("docker")
	@Tag("docker")
	class Docker {

		@Test
		void contextLoads() {
			assertTrue(true);
		}

	}

	@Nested
	@ActiveProfiles("kubernetes")
	@Tag("kubernetes")
	class Kubernetes {

		@Test
		void contextLoads() {
			assertTrue(true);
		}

	}
}