
CREATE TABLE DB2ADMIN.JOB_EXEC_HISTORY
(
  JOB_SEQ              decimal(19) NOT NULL,
  JOB_ID               VARCHAR(500),
  IP                   VARCHAR(20),
  PID                  VARCHAR(30),
  STATUS               VARCHAR(20),
  EXIT_MESSAGE         CLOB,
  LOG_FILES            VARCHAR(2000),
  ACTIVE_THREAD_COUNT  decimal(4),
  CURRENT_CPU_USAGE    decimal(5,2),
  TOTAL_CPU_USAGE      decimal(5,2),
  FREE_MEMORY          decimal(20),
  TOTAL_MEMORY         decimal(20),
  CREATE_TIME          TIMESTAMP(6),
  LAST_UPDATED         TIMESTAMP(6)
);

CREATE UNIQUE INDEX DB2ADMIN.JOB_EXEC_HISTORY_PK ON DB2ADMIN.JOB_EXEC_HISTORY
(JOB_SEQ);

CREATE INDEX DB2ADMIN.JOB_EXEC_HISTORY_I1 ON DB2ADMIN.JOB_EXEC_HISTORY
(JOB_ID, STATUS);

CREATE INDEX DB2ADMIN.JOB_EXEC_HISTORY_I2 ON DB2ADMIN.JOB_EXEC_HISTORY
(CREATE_TIME);

CREATE SEQUENCE DB2ADMIN.JOB_EXEC_SEQ AS INTEGER start with 1 increment by 1 NOCYCLE;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
CREATE TABLE DB2ADMIN.STEP_EXEC_HISTORY
(
  JOB_SEQ           decimal(19)			NOT NULL,
  STEP_ID           VARCHAR(500)	NOT NULL,
  JOB_ID            VARCHAR(500),
  PID               VARCHAR(30),
  IP                VARCHAR(20),
  STATUS            VARCHAR(20),
  EXIT_MESSAGE      CLOB,
  LOG_FILES         VARCHAR(2000),
  ACTIVE_THREAD_COUNT  decimal(4),
  CURRENT_CPU_USAGE    decimal(5,2),
  TOTAL_CPU_USAGE      decimal(5,2),
  FREE_MEMORY          decimal(20),
  TOTAL_MEMORY         decimal(20),
  CREATE_TIME       TIMESTAMP(6),
  LAST_UPDATED      TIMESTAMP(6)
);

CREATE UNIQUE INDEX DB2ADMIN.STEP_EXEC_HISTORY_PK ON DB2ADMIN.STEP_EXEC_HISTORY
(JOB_SEQ, STEP_ID);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
CREATE TABLE DB2ADMIN.RESOURCE_MANAGEMENT
(
  JOB_SEQ        decimal(19)				NOT NULL,
  STEP_ID        VARCHAR(200)		NOT NULL,
  RESOURCE_NAME  VARCHAR(200)		NOT NULL,
  IO_TYPE        VARCHAR(10)		NOT NULL,
  STATUS         VARCHAR(10),
  JOB_ID         VARCHAR(200),
  TYPE           VARCHAR(10),
  TRANSACTED_COUNT  bigint,
  CREATE_TIME    TIMESTAMP(6),
  UPDATE_TIME    TIMESTAMP(6)
);

CREATE UNIQUE INDEX DB2ADMIN.RESOURCE_MANAGEMENT_PK ON DB2ADMIN.RESOURCE_MANAGEMENT
(RESOURCE_NAME, JOB_SEQ, STEP_ID, IO_TYPE);

CREATE INDEX DB2ADMIN.RESOURCE_MANAGEMENT_I1 ON DB2ADMIN.RESOURCE_MANAGEMENT
(JOB_SEQ, STEP_ID);

CREATE INDEX DB2ADMIN.RESOURCE_MANAGEMENT_I2 ON DB2ADMIN.RESOURCE_MANAGEMENT
(RESOURCE_NAME, STATUS);




