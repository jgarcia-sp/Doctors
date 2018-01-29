# Inicializador de la base de datos para pruebas

DELETE FROM patient;
INSERT INTO patient (name, email) VALUES ("Patient not found", "patient.not.found@test.com");
INSERT INTO patient (name, email) VALUES ("Alice", "Alice@test.com");
INSERT INTO patient (name, email) VALUES ("Bob", "Bob@test.com");
INSERT INTO patient (name, email) VALUES ("Charlie", "Charlie@test.com");
INSERT INTO patient (name, email) VALUES ("Dennis", "Dennis@test.com");
INSERT INTO patient (name, email) VALUES ("Erin", "Erin@test.com");
INSERT INTO patient (name, email) VALUES ("Frank", "Franks@test.com");

DELETE FROM medic;
INSERT INTO medic (id, name, email) VALUES ("1", "Medic not found", "medic.not.found@test.com");
INSERT INTO medic (id, name, email) VALUES ("2", "Mercy", "Mercy@test.com");
INSERT INTO medic (id, name, email) VALUES ("3", "Lt. Morales", "lt.Morales@test.com");
INSERT INTO medic (id, name, email) VALUES ("4", "Jekyll", "jekyll@test.com");
INSERT INTO medic (id, name, email) VALUES ("5", "Ramon y Cajal", "ramonycajal@test.com");
INSERT INTO medic (id, name, email) VALUES ("6", "Watson", "watson@test.com");

DELETE FROM clinic;
INSERT INTO clinic (name) VALUES ("Clinic Not Found");
INSERT INTO clinic (name) VALUES ("Clinica Norte");
INSERT INTO clinic (name) VALUES ("Clinica Sur");
INSERT INTO clinic (name) VALUES ("Clinica Este");
INSERT INTO clinic (name) VALUES ("Clinica Oeste");
INSERT INTO clinic (name) VALUES ("Hospital");

DELETE FROM room;
INSERT INTO room (room_name, clinic_id) VALUES ("Room Not Found", 1);
INSERT INTO room (room_name, clinic_id) VALUES ("Rm001", 4);
INSERT INTO room (room_name, clinic_id) VALUES ("Rm002", 6);
INSERT INTO room (room_name, clinic_id) VALUES ("Rm003", 3);
INSERT INTO room (room_name, clinic_id) VALUES ("Rm101", 2);
INSERT INTO room (room_name, clinic_id) VALUES ("Rm102", 5);
INSERT INTO room (room_name, clinic_id) VALUES ("Rm103", 3);

DELETE FROM consult;
INSERT INTO consult (medic_id, room_id) VALUES (1, 1);
INSERT INTO consult (medic_id, room_id) VALUES (5, 4);
INSERT INTO consult (medic_id, room_id) VALUES (2, 3);
INSERT INTO consult (medic_id, room_id) VALUES (3, 5);
INSERT INTO consult (medic_id, room_id) VALUES (6, 4);
INSERT INTO consult (medic_id, room_id) VALUES (5, 2);
INSERT INTO consult (medic_id, room_id) VALUES (3, 2);

DELETE FROM appointment;
INSERT INTO appointment (patient_id, consult_id) VALUES (1, 1);
INSERT INTO appointment (patient_id, consult_id) VALUES (3, 5);
INSERT INTO appointment (patient_id, consult_id) VALUES (2, 3);
INSERT INTO appointment (patient_id, consult_id) VALUES (5, 4);
INSERT INTO appointment (patient_id, consult_id) VALUES (6, 1);
INSERT INTO appointment (patient_id, consult_id) VALUES (4, 6);
INSERT INTO appointment (patient_id, consult_id) VALUES (2, 3);





