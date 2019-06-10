package com.erts.config;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.erts.exception.ErtsRuntimeException;

import lombok.Data;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
@Data
public class AppConfig {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	private static AppConfig instance;
	private String fixConfigFile;

	private AppConfig() {
	}

	synchronized public static AppConfig getInstance() {
		if (instance == null) {
			Yaml yaml = new Yaml(new Constructor(AppConfig.class));
			InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("application.yml");

			if (inputStream == null) {
				throw new ErtsRuntimeException("Failed to load application configuration.");
			}

			logger.info("Application configuration loaded.");
			instance = yaml.load(inputStream);
		}

		return instance;
	}
}
