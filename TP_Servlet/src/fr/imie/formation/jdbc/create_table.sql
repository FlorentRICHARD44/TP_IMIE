-- Table: usager

-- DROP TABLE usager;

CREATE TABLE usager
(
  id serial NOT NULL,
  nom character varying(250) NOT NULL,
  prenom character varying(250) NOT NULL,
  datenaissance date,
  email character varying(250),
  nb_connexion integer DEFAULT 0,
  CONSTRAINT usager_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usager
  OWNER TO postgres;
