INSERT INTO "vrsta" ("id", "naziv_vrste") VALUES (1, 'Pas');
INSERT INTO "vrsta" ("id", "naziv_vrste") VALUES (2, 'Macka');
INSERT INTO "vrsta" ("id", "naziv_vrste") VALUES (3, 'Hrcak');
INSERT INTO "vrsta" ("id", "naziv_vrste") VALUES (4, 'Jez');
INSERT INTO "vrsta" ("id", "naziv_vrste") VALUES (5, 'Ptica');

INSERT INTO "zivotinja" ("id", "ime", "vrsta_id", "godine", "velicina", "tezina", "slika") VALUES (1, 'Rex', 1, 3, 'Velika', 15.5, 'rex.jpg');
INSERT INTO "zivotinja" ("id", "ime", "vrsta_id", "godine", "velicina", "tezina", "slika") VALUES (2, 'Mia', 2, 2, 'Srednja', 5.2, 'mia.jpg');
INSERT INTO "zivotinja" ("id", "ime", "vrsta_id", "godine", "velicina", "tezina", "slika") VALUES (3, 'Leo', 3, 4, 'Mala', 1.2, 'leo.jpg');
INSERT INTO "zivotinja" ("id", "ime", "vrsta_id", "godine", "velicina", "tezina", "slika") VALUES (4, 'Luna', 4, 1, 'Mala', 1.0, 'luna.jpg');
INSERT INTO "zivotinja" ("id", "ime", "vrsta_id", "godine", "velicina", "tezina", "slika") VALUES (5, 'Tiger', 5, 5, 'Mala', 1.3, 'tiger.jpg');

INSERT INTO "users" ("id", "name", "email", "password")
VALUES (1, 'Simun Jelic', 'simun.jelic@fsre.sum.ba', '');

INSERT INTO "users" ("id", "name", "email", "password")
VALUES (2, 'Blaz Stipic', 'blaz.stipic@fsre.sum.ba', '');

INSERT INTO "users" ("id", "name", "email", "password")
VALUES (3, 'Vlado Santic', 'vlado.santic@fsre.sum.ba', '');

INSERT INTO "lokacija" ("id", "naziv", "adresa", "grad", "drzava")
VALUES (1, 'Azil Mostar', 'Stjepana Radica 1a', 'Mostar', 'Bosna i Hercegovina');

INSERT INTO "lokacija" ("id", "naziv", "adresa", "grad", "drzava")
VALUES (2, 'Azil Sarajevo', 'Setaliste Petra Preradovica 4', 'Sarajevo', 'Bosna i Hercegovina');

INSERT INTO "lokacija" ("id", "naziv", "adresa", "grad", "drzava")
VALUES (3, 'Azil Banja Luka', 'Trg Nikole Hosta 2', 'Banja Luka', 'Bosna i Hercegovina');

INSERT INTO "objava" ("id", "korisnik_id", "zivotinja_id", "lokacija_id", "tekst_objave", "datum_objave")
VALUES (1, 1, 1, 1, 'Hitno! Potreban dom što prije.', '2024-01-02 13:45:00');

INSERT INTO "objava" ("id", "korisnik_id", "zivotinja_id", "lokacija_id", "tekst_objave", "datum_objave")
VALUES (2, 2, 2, 2, 'Trazi se dom.', '2024-01-03 09:30:00');

INSERT INTO "objava" ("id", "korisnik_id", "zivotinja_id", "lokacija_id", "tekst_objave", "datum_objave")
VALUES (3, 3, 3, 3, 'Potreban dom.', '2024-01-04 17:15:00');

INSERT INTO "rezervacija" ("id", "korisnik_udomitelj_id", "korisnik_skrbnik_id", "zivotinja_id", "datum_rezervacije")
VALUES (1, 1, 2, 1, '2024-01-05 10:00:00');

INSERT INTO "roles" ("id", "name") VALUES (1, 'Admin');
INSERT INTO "roles" ("id", "name") VALUES (2, 'korisnik');

INSERT INTO "recenzija" ("id", "korisnik_recezent_id", "korisnik_id", "tekst_recenzije", "ocjena", "datum_recenzije")
VALUES (1, 3, 1, 'Odgovoran i brz.', 5, '2024-01-06 15:30:00');

INSERT INTO "komentar" ("id", "objava_id", "korisnik_id", "tekst_komentara", "datum_komentara")
VALUES (1, 1, 2, 'Kod mene nema mjesta, steta, bas je sladak :D', '2024-01-07 09:45:00');

INSERT INTO "users_roles" ("user_id", "role_id") VALUES (1, 1);
INSERT INTO "users_roles" ("user_id", "role_id") VALUES (2, 1);
INSERT INTO "users_roles" ("user_id", "role_id") VALUES (3, 1);