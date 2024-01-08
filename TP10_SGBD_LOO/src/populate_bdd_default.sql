-- La base de donnée doit déjà exister pour exécuter ce script
use labo;

delete from typeAnalyse;

insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (0, "A", "hemogramme A", 10.0, 21);
insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (1, "B", "hemogramme B", 10.0, 21);
insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (2, "AB", "hemogramme AB", 10.0, 21);
insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (3, "O", "hemogramme O", 10.0, 21);

insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (4, "A", "hemogramme A 2", 20.0, 42);
insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (5, "B", "hemogramme B 2", 20.0, 42);
insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (6, "AB", "hemogramme AB 2", 20.0, 42);
insert into typeAnalyse (id, groupeSanguin, hemogramme, prix, vitesseSedimentation) values (7, "O", "hemogramme O 2", 20.0, 42);

delete from medecin;

insert into medecin (id, firstName, name, salaire, ssn) values (0, "Jean", "Luc", 10000, 18);
insert into medecin (id, firstName, name, salaire, ssn) values (1, "Régis", "son", 10000, 15);
insert into medecin (id, firstName, name, salaire, ssn) values (2, "Vincent", "Tidote", 10000, 112);
insert into medecin (id, firstName, name, salaire, ssn) values (3, "Ema", "Ladie", 10000, 17);

delete from medecin_typeAnalyse;

insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (0, 0);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (0, 2);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (0, 4);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (0, 6);

insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (1, 1);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (1, 3);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (1, 5);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (1, 6);

insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (2, 0);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (2, 1);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (2, 2);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (2, 3);

insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (3, 4);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (3, 5);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (3, 6);
insert into medecin_typeAnalyse (Medecin_id, autorisations_id) values (3, 7);
