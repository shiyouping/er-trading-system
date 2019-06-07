package com.erts.config;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import lombok.Data;

/**
 * @author <a href="mailto:ricky.shiyouping@gmail.com">Ricky Shi</a>
 *
 * @since Jun 7, 2019
 */
@Data
public class AppConfig {

	private static AppConfig instance;

	private AppConfig() {
	}

	synchronized public static AppConfig getInstance() {
		if (instance == null) {
			Yaml yaml = new Yaml(new Constructor(AppConfig.class));
			InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("application.yml");
			instance = yaml.load(inputStream);
		}

		return instance;
	}
}
