# Inicializador de la base de datos para pruebas

DELETE FROM patient;
INSERT INTO patient (name, email) VALUES ("Not found", "not.found@test.com");
INSERT INTO patient (name, email) VALUES ("Alice", "Alice@test.com");
INSERT INTO patient (name, email) VALUES ("Bob", "Bob@test.com");
INSERT INTO patient (name, email) VALUES ("Charlie", "Charlie@test.com");
INSERT INTO patient (name, email) VALUES ("Dennis", "Dennis@test.com");
INSERT INTO patient (name, email) VALUES ("Erin", "Erin@test.com");
INSERT INTO patient (name, email) VALUES ("Frank", "Franks@test.com");

DELETE FROM consult;
INSERT INTO consult (medic) VALUES (1);
INSERT INTO consult (medic) VALUES (2);
INSERT INTO consult (medic) VALUES (3);
INSERT INTO consult (medic) VALUES (4);
INSERT INTO consult (medic) VALUES (5);
INSERT INTO consult (medic) VALUES (6);
INSERT INTO consult (medic) VALUES (7);

DELETE FROM appointment;
INSERT INTO appointment (patient_id, consult_id) VALUES (1, 2);
INSERT INTO appointment (patient_id, consult_id) VALUES (3, 5);
INSERT INTO appointment (patient_id, consult_id) VALUES (2, 3);
INSERT INTO appointment (patient_id, consult_id) VALUES (5, 4);
INSERT INTO appointment (patient_id, consult_id) VALUES (6, 1);
INSERT INTO appointment (patient_id, consult_id) VALUES (4, 6);
INSERT INTO appointment (patient_id, consult_id) VALUES (2, 3);


