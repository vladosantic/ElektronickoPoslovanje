CREATE TABLE "vrsta" (
  "id" int PRIMARY KEY,
  "naziv_vrste" varchar
);

CREATE TABLE "zivotinja" (
  "id" int PRIMARY KEY,
  "ime" varchar,
  "vrsta_id" int,
  "godine" int,
  "velicina" varchar,
  "tezina" decimal,
  "slika" varchar
);

CREATE TABLE "korisnik" (
  "id" int PRIMARY KEY,
  "ime" varchar,
  "prezime" varchar,
  "email" varchar,
  "telefon" varchar,
  "lokacija" varchar,
  "korisnicko_ime" varchar,
  "lozinka" varchar,
  "datum_registracije" timestamp
);

CREATE TABLE "objava" (
  "id" int PRIMARY KEY,
  "korisnik_id" int NOT NULL,
  "zivotinja_id" int NOT NULL,
  "lokacija_id" int NOT NULL,
  "tekst_objave" text,
  "datum_objave" timestamp
);

CREATE TABLE "rezervacija" (
  "id" int PRIMARY KEY,
  "korisnik_udomitelj_id" int NOT NULL,
  "korisnik_skrbnik_id" int NOT NULL,
  "zivotinja_id" int NOT NULL,
  "datum_rezervacije" timestamp
);

CREATE TABLE "uloga" (
  "id" int PRIMARY KEY,
  "naziv" varchar
);

CREATE TABLE "recenzija" (
  "id" int PRIMARY KEY,
  "korisnik_recezent_id" int NOT NULL,
  "korisnik_id" int NOT NULL,
  "tekst_recenzije" varchar,
  "ocjena" int,
  "datum_recenzije" timestamp
);

CREATE TABLE "komentar" (
  "id" int PRIMARY KEY,
  "objava_id" int NOT NULL,
  "korisnik_id" int NOT NULL,
  "tekst_komentara" varchar,
  "datum_komentara" timestamp
);

CREATE TABLE "lokacija" (
  "id" int PRIMARY KEY,
  "naziv" varchar,
  "adresa" varchar,
  "grad" varchar,
  "drzava" varchar
);

CREATE TABLE "korisnik_uloga" (
  "id" int PRIMARY KEY,
  "korisnik_id" int NOT NULL,
  "uloga_id" int
);

ALTER TABLE "zivotinja" ADD FOREIGN KEY ("vrsta_id") REFERENCES "vrsta" ("id");

ALTER TABLE "objava" ADD FOREIGN KEY ("korisnik_id") REFERENCES "korisnik" ("id");

ALTER TABLE "objava" ADD FOREIGN KEY ("zivotinja_id") REFERENCES "zivotinja" ("id");

ALTER TABLE "objava" ADD FOREIGN KEY ("lokacija_id") REFERENCES "lokacija" ("id");

ALTER TABLE "rezervacija" ADD FOREIGN KEY ("korisnik_udomitelj_id") REFERENCES "korisnik" ("id");

ALTER TABLE "rezervacija" ADD FOREIGN KEY ("korisnik_skrbnik_id") REFERENCES "korisnik" ("id");

ALTER TABLE "rezervacija" ADD FOREIGN KEY ("zivotinja_id") REFERENCES "zivotinja" ("id");

ALTER TABLE "recenzija" ADD FOREIGN KEY ("korisnik_recezent_id") REFERENCES "korisnik" ("id");

ALTER TABLE "recenzija" ADD FOREIGN KEY ("korisnik_id") REFERENCES "korisnik" ("id");

ALTER TABLE "komentar" ADD FOREIGN KEY ("objava_id") REFERENCES "objava" ("id");

ALTER TABLE "komentar" ADD FOREIGN KEY ("korisnik_id") REFERENCES "korisnik" ("id");

ALTER TABLE "korisnik_uloga" ADD FOREIGN KEY ("korisnik_id") REFERENCES "korisnik" ("id");

ALTER TABLE "korisnik_uloga" ADD FOREIGN KEY ("uloga_id") REFERENCES "uloga" ("id");
