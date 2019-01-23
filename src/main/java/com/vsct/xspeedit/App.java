package com.vsct.xspeedit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.vsct.xspeedit.exceptions.XspeeditIllegalException;
import com.vsct.xspeedit.services.FitOnTheBoxAdvancedService;
import com.vsct.xspeedit.services.FitOnTheBoxBasicService;
import com.vsct.xspeedit.util.Config;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySources({ @PropertySource("file:..\\conf\\xspeedit-solution.properties") })

public class App implements CommandLineRunner {

	private static Logger LOGGER = LogManager.getLogger(App.class);

	@Autowired
	private FitOnTheBoxBasicService fitOnTheBoxBasic;

	@Autowired
	private FitOnTheBoxAdvancedService fitOnTheBoxAdvanced;

	@Autowired
	private Config conf;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws XspeeditIllegalException {
		// 163841689525773
		LOGGER.info(args[0].toString());

		int capacity = conf.CAPACITY;
		fitOnTheBoxBasic.fitOnTheBox(args, capacity);
		fitOnTheBoxAdvanced.fitOnTheBox(args, capacity);
	}

}
