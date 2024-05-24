DROP TABLE IF EXISTS patients;

CREATE TABLE patients
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(250) NOT NULL,
    last_name   VARCHAR(250) NOT NULL,
    birth_date  DATE NOT NULL,
    gender      CHAR(1) NOT NULL CHECK (gender IN ('F', 'M')),
    address     VARCHAR(250) ,
    phone       VARCHAR(250)
);


INSERT
INTO
    patients
    (first_name, last_name, birth_date, gender, address, phone)
VALUES
    ('TestNone','Test', '1966-12-31' ,'F', '1 Brookside St', '100-222-3333'),
    ('TestBorderline','Test', '1945-06-24','M','2 High St', '200-333-4444'),
    ('TestInDanger','Test', '2004-06-18', 'M','3 Club Road', '300-444-5555'),
    ('TestEarlyOnset', 'Test', '2002-06-28', 'F','4 Valley Dr', '400-555-6666');