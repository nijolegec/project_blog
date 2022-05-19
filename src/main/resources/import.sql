INSERT INTO post(title, posted_text, author_name) VALUES ('Įrašas1', 'A', 'Nijolė');
INSERT INTO post(title, posted_text, author_name) VALUES ('Įrašas2', 'A2','Nijolė');
INSERT INTO post(title, posted_text, author_name) VALUES ('Įrašas3', 'A3','Nijolė');
INSERT INTO post(title, posted_text, author_name) VALUES ('Įrašas4', 'A4','Nijolė');
INSERT INTO post(title, posted_text, author_name) VALUES ('Įrašas5', 'A5','Nijolė');


INSERT INTO roles(role) VALUES ("USER");
INSERT INTO roles(role) VALUES ("ADMIN");

INSERT INTO users (name, last_name, username, password)VALUES("Asta", "Petrauskienė", "AstaP","$2a$12$h7IrjjBWq1C1NWOD2SdSNeyZyAQpIGDl/rjNmP0dV3M95dVvP/VhO" );
INSERT INTO users (name, last_name, username, password)VALUES("Rasa", "Varnaitė", "VRasa", "$2a$12$h7IrjjBWq1C1NWOD2SdSNeyZyAQpIGDl/rjNmP0dV3M95dVvP/VhO");

INSERT INTO users_roles(user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES (1, 2);


INSERT INTO users_roles(user_id, roles_id) VALUES(2, 1);