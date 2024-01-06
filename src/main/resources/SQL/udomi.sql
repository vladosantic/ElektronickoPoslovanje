CREATE TABLE "vrsta" (
  "id" BIGSERIAL PRIMARY KEY,
  "naziv_vrste" varchar
);

CREATE TABLE "zivotinja" (
  "id" BIGSERIAL PRIMARY KEY,
  "ime" varchar,
  "vrsta_id" int,
  "godine" int,
  "velicina" varchar,
  "tezina" decimal,
  "slika" varchar
);

CREATE TABLE "objava" (
  "id" BIGSERIAL PRIMARY KEY,
  "korisnik_id" int NOT NULL,
  "zivotinja_id" int NOT NULL,
  "lokacija_id" int NOT NULL,
  "tekst_objave" text,
  "datum_objave" timestamp
);

CREATE TABLE "rezervacija" (
  "id" BIGSERIAL PRIMARY KEY,
  "korisnik_udomitelj_id" int NOT NULL,
  "korisnik_skrbnik_id" int NOT NULL,
  "zivotinja_id" int NOT NULL,
  "datum_rezervacije" timestamp
);

CREATE TABLE "recenzija" (
  "id" BIGSERIAL PRIMARY KEY,
  "korisnik_recezent_id" int NOT NULL,
  "korisnik_id" int NOT NULL,
  "tekst_recenzije" varchar,
  "ocjena" int,
  "datum_recenzije" timestamp
);

CREATE TABLE "komentar" (
  "id" BIGSERIAL PRIMARY KEY,
  "objava_id" int NOT NULL,
  "korisnik_id" int NOT NULL,
  "tekst_komentara" varchar,
  "datum_komentara" timestamp
);

CREATE TABLE "lokacija" (
  "id" BIGSERIAL PRIMARY KEY,
  "naziv" varchar,
  "adresa" varchar,
  "grad" varchar,
  "drzava" varchar
);

ALTER TABLE "zivotinja" ADD FOREIGN KEY ("vrsta_id") REFERENCES "vrsta" ("id");

ALTER TABLE "objava" ADD FOREIGN KEY ("korisnik_id") REFERENCES "users" ("id");

ALTER TABLE "objava" ADD FOREIGN KEY ("zivotinja_id") REFERENCES "zivotinja" ("id");

ALTER TABLE "objava" ADD FOREIGN KEY ("lokacija_id") REFERENCES "lokacija" ("id");

ALTER TABLE "rezervacija" ADD FOREIGN KEY ("korisnik_udomitelj_id") REFERENCES "users" ("id");

ALTER TABLE "rezervacija" ADD FOREIGN KEY ("korisnik_skrbnik_id") REFERENCES "korisnik" ("id");

ALTER TABLE "rezervacija" ADD FOREIGN KEY ("zivotinja_id") REFERENCES "zivotinja" ("id");

ALTER TABLE "recenzija" ADD FOREIGN KEY ("korisnik_recezent_id") REFERENCES "users" ("id");

ALTER TABLE "recenzija" ADD FOREIGN KEY ("korisnik_id") REFERENCES "users" ("id");

ALTER TABLE "komentar" ADD FOREIGN KEY ("objava_id") REFERENCES "objava" ("id");

ALTER TABLE "komentar" ADD FOREIGN KEY ("korisnik_id") REFERENCES "users" ("id");
