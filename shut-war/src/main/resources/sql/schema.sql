SET DATABASE SQL SYNTAX MSS TRUE;

DROP TABLE SHUT_TRANSACTION IF EXISTS;

CREATE TABLE SHUT_TRANSACTION
  (
    -- Déclaration normale pour le schema MSSQL Server
    -- TRANSACTION_ID         BIGINT PRIMARY KEY IDENTITY,
    TRANSACTION_ID         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY (START WITH 10000 INCREMENT BY 1),
    TRANSACTION_NAME       VARCHAR(256) NOT NULL ,
    CLIENTTIME_MS          BIGINT ,
    SERVERTIME_MS          BIGINT ,
    ENDUSERRESPONSETIME_MS BIGINT ,
    CLIENT_SERVER_REP 	   FLOAT ,
    NB_SVCCALLS            BIGINT,
    ASYNC_SVCCALLS         VARCHAR(12) ,
    START_TIMESTAMP        DATETIME ,
    END_TIMESTAMP          DATETIME ,
    FILEPATH               VARCHAR(256) ,
    DOMAINE                VARCHAR(64) NOT NULL ,
    PROCESS                VARCHAR(128) NOT NULL ,
    PROCESSID              VARCHAR(64) ,
    BUSINESSID             VARCHAR(64) ,
    TASKTYPE               VARCHAR(128) ,
    TASKID                 VARCHAR(64) ,
    STEP                   VARCHAR(128) ,
    ACTION                 VARCHAR(128) ,
    ENV                    VARCHAR(32) NOT NULL ,
    POSTE                  VARCHAR(32) NOT NULL ,
    SESSIONID              VARCHAR(32) NOT NULL ,
    DIRTY                  BIGINT DEFAULT 0 NOT NULL ,
    NB_PARTENAIRES         BIGINT ,
    NB_BUSINESS_ITEMS      BIGINT ,
    BUSINESS_CASE          VARCHAR(256) ,
    NB_PARTENAIRES_DESC    VARCHAR(512) ,
    NB_BUSINESS_ITEMS_DESC VARCHAR(512) ,
    BUSINESS_CASE_DESC     VARCHAR(512) ,
    START_GDI_OBJ          INTEGER,
    END_GDI_OBJ            INTEGER,
    START_USER_OBJ         INTEGER,
    END_USER_OBJ           INTEGER,
    START_MEMORY           INTEGER,
    END_MEMORY             INTEGER,
    INJECTION_DATE         DATETIME NOT NULL ,
    DEPARTEMENT            VARCHAR(100)
  );

  
DROP TABLE SHUT_SERVICE_CALLS IF EXISTS;

CREATE TABLE SHUT_SERVICE_CALLS
  (
    -- Déclaration normale pour le schema MSSQL Server
    -- REQUEST_ID                BIGINT PRIMARY KEY IDENTITY,
    REQUEST_ID                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY (START WITH 100000, INCREMENT BY 1),
    TRANSACTION_ID            BIGINT NOT NULL ,
    TRANSACTION_NAME          VARCHAR(512) NOT NULL ,
    SERVICE                   VARCHAR(64) ,
    METHOD                    VARCHAR(64) ,
    INVOCATION_DETAILS        VARCHAR(512) ,
    OVERALL_TIME_MS           BIGINT ,
    REQUEST_SERIAL_TIME_MS    BIGINT ,
    SERVER_TIME_MS            BIGINT ,
    RESPONSE_DESERIAL_TIME_MS BIGINT ,
    URL                       VARCHAR(256) ,
    HTTP_STATUS_CODE          VARCHAR(32) ,
    REQUEST_CONTENT_BYTE      BIGINT ,
    RESPONSE_CONTENT_BYTE     BIGINT ,
    OVERALL_START_TIMESTAMP   DATETIME ,
    OVERALL_END_TIMESTAMP     DATETIME ,
    THREAD                    VARCHAR(256) ,
    FILEPATH                  VARCHAR(256) ,
    DOMAINE                   VARCHAR(32) ,
    PROCESSUS                 VARCHAR(128) ,
    PROCESSID                 VARCHAR(128) ,
    BUSINESSID                VARCHAR(128) ,
    TASKTYPE                  VARCHAR(256) ,
    TASKID                    VARCHAR(128) ,
    STEP                      VARCHAR(128) ,
    ACTION                    VARCHAR(128) ,
    ENV                       VARCHAR(32) NOT NULL ,
    POSTE                     VARCHAR(32) NOT NULL ,
    SESSIONID                 VARCHAR(32) NOT NULL ,
    DIRTY                     BIGINT DEFAULT 0 ,
    INJECTION_DATE            DATETIME NOT NULL ,
    DEPARTEMENT               VARCHAR(100)
  );
