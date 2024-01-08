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
