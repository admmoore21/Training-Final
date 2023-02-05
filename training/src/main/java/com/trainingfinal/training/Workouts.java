package com.trainingfinal.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.trainingfinal.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class Workouts {

	public static void main(String[] args) {
		SpringApplication.run(Workouts.class, args);
	}
}
