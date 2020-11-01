USE webshop;
  
INSERT INTO bicikli (nev, tipus, leiras, meret, sebesseg_elol, sebesseg_hatul, szin, fek, teleszkop, vaz, keszlet, netto_ar, created_at, updated_at)
VALUES (
  "ROCK MACHINE TORRENT 70-29 XC 2020",
  "MTB",
  "Rock Machine Torrent 70-29 XC 2020 29-es férfi MTB kerékpár, 12s, alumínium, 21-es vázméret, matt fekete-kék-szürke",
  21,
  1,
  12,
  "fekete",
  "hidraulikus tárcsafék",
  "SR Suntour",
  "21 col alumínium ötvözet",
  2,
  395910,
  "2020-11-01 14:48:20",
  "2020-11-01 14:48:20");
  
INSERT INTO bicikli (nev, tipus, leiras, meret, sebesseg_elol, sebesseg_hatul, szin, fek, teleszkop, vaz, keszlet, netto_ar, created_at, updated_at)
VALUES (
  "CSEPEL BLACKWOOD AMBITION 2019 26-OS VÁROSI NŐI KERÉKPÁR, ACÉL, 1S, 17-ES VÁZMÉRET, GRAFIT",
  "VAROSI",
  "Csepel Blackwood Ambition 2019 26-os városi női kerékpár, acél, 1s, 17-es vázméret, grafit. Városi kerékpár nőknek. Egyszerű kezelhetőség és alacsony karbantartás igény. Városi felhasználáshoz szükséges kiegészítőkkel szerelve.",
  17,
  1,
  1,
  "fekete",
  "Kontra + V-fékes",
  null,
  "17 col acél",
  1,
  51900,
  "2020-11-01 14:57:30",
  "2020-11-01 14:57:30");
  
INSERT INTO bicikli (nev, tipus, leiras, meret, sebesseg_elol, sebesseg_hatul, szin, fek, teleszkop, vaz, keszlet, netto_ar, created_at, updated_at)
VALUES (
  "CSEPEL TRC 200 2018 28-AS FÉRFI TREKKING KERÉKPÁR, ALU, AGYDINAMÓS, 21S, 19-ES VÁZMÉRET, MATT FEKETE",
  "TREKKING",
  "Csepel TRC 200 2018 28-as férfi trekking kerékpár, alu, agydinamós, 21s, 19-es vázméret, matt fekete",
  28,
  3,
  7,
  "fekete",
  "V-fékes",
  null,
  "19 col Alu",
  3,
  153900,
  "2020-11-01 15:00:40",
  "2020-11-01 15:00:40");

INSERT INTO kepek (bicikli_id, kep_url) VALUES (1, "/mtb1.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (1, "/mtb2.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (1, "/mtb3.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (2, "/varosi1.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (2, "/varosi2.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (2, "/varosi3.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (2, "/varosi4.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (2, "/varosi5.jpg");
INSERT INTO kepek (bicikli_id, kep_url) VALUES (2, "/varosi6.jpg");