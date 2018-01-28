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
INSERT INTO medic (name, email) VALUES ("Medic not found", "medic.not.found@test.com");
INSERT INTO medic (name, email) VALUES ("Mercy", "Mercy@test.com");
INSERT INTO medic (name, email) VALUES ("Lt. Morales", "lt.Morales@test.com");
INSERT INTO medic (name, email) VALUES ("Jekyll", "jekyll@test.com");
INSERT INTO medic (name, email) VALUES ("Ramon y Cajal", "ramonycajal@test.com");
INSERT INTO medic (name, email) VALUES ("Watson", "watson@test.com");

DELETE FROM room;
INSERT INTO room (room_name) VALUES ("Rm001");
INSERT INTO room (room_name) VALUES ("Rm002");
INSERT INTO room (room_name) VALUES ("Rm003");
INSERT INTO room (room_name) VALUES ("Rm101");
INSERT INTO room (room_name) VALUES ("Rm102");
INSERT INTO room (room_name) VALUES ("Rm103");

DELETE FROM consult;
INSERT INTO consult (medic_id, room_id) VALUES (1, 1);
INSERT INTO consult (medic_id, room_id) VALUES (5, 4);
INSERT INTO consult (medic_id, room_id) VALUES (2, 3);
INSERT INTO consult (medic_id, room_id) VALUES (3, 5);
INSERT INTO consult (medic_id, room_id) VALUES (6, 4);
INSERT INTO consult (medic_id, room_id) VALUES (5, 2);
INSERT INTO consult (medic_id, room_id) VALUES (3, 2);

DELETE FROM appointment;
INSERT INTO appointment (patient_id, consult_id) VALUES (1, 2);
INSERT INTO appointment (patient_id, consult_id) VALUES (3, 5);
INSERT INTO appointment (patient_id, consult_id) VALUES (2, 3);
INSERT INTO appointment (patient_id, consult_id) VALUES (5, 4);
INSERT INTO appointment (patient_id, consult_id) VALUES (6, 1);
INSERT INTO appointment (patient_id, consult_id) VALUES (4, 6);
INSERT INTO appointment (patient_id, consult_id) VALUES (2, 3);





