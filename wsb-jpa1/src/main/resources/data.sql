insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'Uliczna', 'Uliczka', 'Szczecin', '62-012'),
                   (2, 'Kosciuszki', 'Kopciuszki', 'Wroclaw', '50-018'),
                   (3, 'Mac', 'Os', 'San Francisco', '12-345'),
                   (4, 'Light', 'Street', 'Leicester', '20-123'),
                   (5, 'Szara', 'Czarna', 'Poznan', '24-015'),
                   (6, 'Winna', 'Piwna', 'Rzeszow', '88-018'),
                   (7, 'Kocia', 'Psia', 'Lublin', '99-919');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id )
            values (1, 'Michal', 'Tluszcz', '123-123-123', 'tluszczyk@gmail.com', '1', 'GP', 1),
                   (2, 'Andrzej', 'Wroclawski', '123-111-123', 'wrocek@gmail.com', '2', 'SURGEON', 3),
                   (3, 'Alina', 'Kotowska', '123-123-111', 'kotek@gmail.com', '3', 'GP', 2),
                   (4, 'Shibina', 'Piesel', '222-123-123', 'piesek@gmail.com', '4', 'DERMATOLOGIST', 4 ),
                   (5, 'Halyna', 'Fryta', '123-222-123', 'frytki@gmail.com', '5', 'OCULIST', 1),
                   (6, 'Patrycja', 'Ziemniok', '123-123-222', 'ziemniaki@gmail.com', '6', 'OCULIST', 1);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id,HAS_ALLERGY)
            values (1, 'Monika', 'Szatan', '555-111-333', 'satan@dzimail.com', '1', '2000-01-02', 1,false),
                   (2, 'Valerie', 'Bonbon', '123-123-123', 'bonbon@dzimail', '2', '2010-09-09', 2,false),
                   (3, 'Andrew', 'Stolica', '123-123-123', 'stolica@dzimail', '3', '2010-09-09', 3,false),
                   (4, 'Lara', 'Pilka', '123-123-123', 'pilka@dzimail', '4', '2010-09-09', 4,true),
                   (5, 'Pablo', 'Mescal', '123-123-123', 'crazy@dzimail', '5', '2010-09-09', 5,true),
                   (6, 'Madonna', 'Efdwa', '123-123-123', 'city@dzimail', '6', '1900-09-09', 6,false);

insert into MEDICAL_TREATMENT (id, description, type)
            values (1, 'use the rtg', 'RTG'),
                   (2, 'do the usg', 'USG'),
                   (3, 'ekg is needed', 'EKG');

insert into visit (id, description, time, doctor_id, medical_treatment_id, patient_id,version)
            values (1, 'the visit was a visit', '2022-09-09 11:00:00',
            (SELECT id FROM DOCTOR WHERE id = 1), 1, 1,1),
            (2, 'the visit was a visit number 2', '2010-09-09 11:00:00',
            (SELECT id FROM DOCTOR WHERE id = 2), 2, 3,1),
            (3, 'the visit was a visit number 3', '2021-09-09 11:00:00',
            (SELECT id FROM DOCTOR WHERE id = 3), 3, 4,1),
            (4, 'the visit was a visit number 4', '2000-09-09 11:00:00',
            (SELECT id FROM DOCTOR WHERE id = 4), 1, 6,1),
            (5, 'the visit was a visit number 5', '1999-09-09 11:00:00',
            (SELECT id FROM DOCTOR WHERE id = 5), 2,2,1);
