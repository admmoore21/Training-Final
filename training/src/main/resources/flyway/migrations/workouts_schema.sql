drop database workouts;
create database workouts;
use workouts;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS workout_category;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS workouts;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
	client_id INT AUTO_INCREMENT NOT NULL,
	first_name VARCHAR(128) NOT NULL,
	last_name VARCHAR(128) NOT NULL,
	phone VARCHAR(128) NOT NULL,
	proficiency ENUM('BEGINNER', 'INTERMEDIATE', 'EXPERIENCED', 'EXPERT') NOT NULL,
	PRIMARY KEY (client_id)
);

CREATE TABLE workouts (
	workout_id INT AUTO_INCREMENT NOT NULL,
	workout_name VARCHAR(128) NOT NULL,
	client_id INT NOT NULL,
	estimated_hrs DECIMAL(4, 2),
	price DECIMAL(7, 2),
	PRIMARY KEY (workout_id),
	FOREIGN KEY (client_id) REFERENCES clients (client_id) ON DELETE CASCADE
);

CREATE TABLE categories (
	category_id INT AUTO_INCREMENT NOT NULL,
	category_name ENUM('HYPERTROPHY', 'STRENGTH', 'SPEED', 'GENERAL', 'LEGS', 'ARMS') NOT NULL,
	PRIMARY KEY (category_id)
);

CREATE TABLE workout_category (
	workout_id INT NOT NULL,
	category_id INT NOT NULL,
	FOREIGN KEY (workout_id) REFERENCES workouts (workout_id) ON DELETE CASCADE,
	FOREIGN KEY (category_id) REFERENCES categories (category_id) ON DELETE CASCADE,
	UNIQUE KEY (workout_id, category_id)
);

CREATE TABLE exercises (
	exercise_id INT AUTO_INCREMENT NOT NULL,
	workout_id INT NOT NULL,
	exercise_name VARCHAR(128) NOT NULL,
	num_reps INT NOT NULL,
	num_sets INT NOT NULL,
	weight_lbs DECIMAL(7, 2),
    RPE ENUM('ONE', 'TWO', 'THREE', 'FOUR', 'FIVE', 'SIX', 'SEVEN', 'EIGHT', 'NINE', 'TEN') NOT NULL,
	PRIMARY KEY (exercise_id),
	FOREIGN KEY (workout_id) REFERENCES workouts (workout_id) ON DELETE CASCADE
);