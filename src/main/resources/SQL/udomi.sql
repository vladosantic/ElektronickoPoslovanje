CREATE TABLE "Vrsta" (
  "id" int PRIMARY KEY,
  "nazivVrste" varchar
);

CREATE TABLE "Zivotinja" (
  "id" int PRIMARY KEY,
  "ime" varchar,
  "vrsta_id" int,
  "godine" int,
  "velicina" varchar,
  "tezina" decimal,
  "slika" varchar
);

CREATE TABLE "Korisnik" (
  "id" int PRIMARY KEY,
  "ime" varchar,
  "prezime" varchar,
  "email" varchar,
  "telefon" varchar,
  "lokacija" varchar,
  "korisnickoIme" varchar,
  "lozinka" varchar,
  "datumRegistracije" timestamp
);

CREATE TABLE "Objava" (
  "id" int PRIMARY KEY,
  "korisnik_id" int NOT NULL,
  "zivotinja_id" int NOT NULL,
  "lokacija_id" int NOT NULL,
  "tekstObjave" text,
  "datumObjave" timestamp
);

CREATE TABLE "Rezervacija" (
  "id" int PRIMARY KEY,
  "korisnik_udomitelj_id" int NOT NULL,
  "korisnik_skrbnik_id" int NOT NULL,
  "zivotinja_id" int NOT NULL,
  "datumRezervacije" timestamp
);

CREATE TABLE "Uloga" (
  "id" int PRIMARY KEY,
  "naziv" varchar
);

CREATE TABLE "Recenzija" (
  "id" int PRIMARY KEY,
  "korisnik_recezent_id" int NOT NULL,
  "korisnik_id" int NOT NULL,
  "tekstRecenzije" varchar,
  "ocjena" int,
  "datumRecenzije" timestamp
);

CREATE TABLE "Komentar" (
  "id" int PRIMARY KEY,
  "objava_id" int NOT NULL,
  "korisnik_id" int NOT NULL,
  "tekstKomentara" varchar,
  "datumKomentara" timestamp
);

CREATE TABLE "Lokacija" (
  "id" int PRIMARY KEY,
  "naziv" varchar,
  "adresa" varchar,
  "grad" varchar,
  "drzava" varchar
);

CREATE TABLE "Korisnik_Uloga" (
  "id" int PRIMARY KEY,
  "korisnik_id" int NOT NULL,
  "uloga_id" int
);

ALTER TABLE "Zivotinja" ADD FOREIGN KEY ("vrsta_id") REFERENCES "Vrsta" ("id");

ALTER TABLE "Objava" ADD FOREIGN KEY ("korisnik_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Objava" ADD FOREIGN KEY ("zivotinja_id") REFERENCES "Zivotinja" ("id");

ALTER TABLE "Objava" ADD FOREIGN KEY ("lokacija_id") REFERENCES "Lokacija" ("id");

ALTER TABLE "Rezervacija" ADD FOREIGN KEY ("korisnik_udomitelj_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Rezervacija" ADD FOREIGN KEY ("korisnik_skrbnik_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Rezervacija" ADD FOREIGN KEY ("zivotinja_id") REFERENCES "Zivotinja" ("id");

ALTER TABLE "Recenzija" ADD FOREIGN KEY ("korisnik_recezent_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Recenzija" ADD FOREIGN KEY ("korisnik_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Komentar" ADD FOREIGN KEY ("objava_id") REFERENCES "Objava" ("id");

ALTER TABLE "Komentar" ADD FOREIGN KEY ("korisnik_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Korisnik_Uloga" ADD FOREIGN KEY ("korisnik_id") REFERENCES "Korisnik" ("id");

ALTER TABLE "Korisnik_Uloga" ADD FOREIGN KEY ("uloga_id") REFERENCES "Uloga" ("id");
