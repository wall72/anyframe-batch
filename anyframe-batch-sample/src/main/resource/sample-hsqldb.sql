-- Autogenerated: do not edit this file
DROP TABLE  BATCH_TEST IF EXISTS;
DROP TABLE  BATCH_TEST2 IF EXISTS;

-- Autogenerated: do not edit this file

CREATE Table BATCH_TEST
(
	no1 			BIGINT NOT NULL,
	no2             BIGINT,
	no3             DECIMAL,
	date1           DATE,
	timestamp1      TIMESTAMP(6),
	name 		VARCHAR(10),
	address 	VARCHAR(20),
	description VARCHAR(30)
)

CREATE Table BATCH_TEST2
(
	no1 			BIGINT NOT NULL,
	no2             BIGINT,
	no3             DECIMAL,
	date1           DATE,
	timestamp1      TIMESTAMP(6),
	name 		VARCHAR(10),
	address 	VARCHAR(20),
	description VARCHAR(30)
)
