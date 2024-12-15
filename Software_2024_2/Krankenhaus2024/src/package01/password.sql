CREATE database password;
use Password ;

CREATE TABLE PermissionClass (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    acctype VARCHAR(30) NOT NULL,
    description TEXT,
    pin VARCHAR(10) NOT NULL
);

INSERT INTO PermissionClass (name, acctype, description, pin)
VALUES ('Admin', 'Admin', 'Full access permissions', '1234'),
('Mitarbeiter', 'Mitarbeiter', 'Mitarbeiter permissions', '45678');

