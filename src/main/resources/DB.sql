CREATE TABLE admin (
                       id_admin SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL,
                       admin_password VARCHAR(50) NOT NULL
);

CREATE TABLE app_user (
                          id_user SERIAL PRIMARY KEY,
                          username VARCHAR(50) NOT NULL,
                          userLastName VARCHAR(50) NOT NULL,
                          phoneNumber VARCHAR(50) NOT NULL,
                          password VARCHAR(50) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          address VARCHAR(50) NOT NULL,
                          id_type_payment INT NOT NULL,
                          id_admin INT NOT NULL,
                          FOREIGN KEY (id_admin) REFERENCES admin(id_admin)
);

CREATE TABLE loginhistory (
                              id_loginhistory SERIAL PRIMARY KEY,
                              id_user INT NOT NULL,
                              logintime TIMESTAMP NOT NULL,
                              FOREIGN KEY (id_user) REFERENCES app_user(id_user)
);

CREATE TABLE manage (
                        id_manage SERIAL PRIMARY KEY,
                        id_admin INT NOT NULL,
                        id_loginhistory INT NOT NULL,
                        FOREIGN KEY (id_admin) REFERENCES admin(id_admin),
                        FOREIGN KEY (id_loginhistory) REFERENCES loginhistory(id_loginhistory)
);

CREATE TABLE type_payment (
                              id_type_payment SERIAL PRIMARY KEY,
                              name VARCHAR(50) NOT NULL
);

CREATE TABLE town (
                      id_town SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      date DATE NOT NULL,
                      population INT NOT NULL
);

CREATE TABLE vehicle (
                         id_vehicle SERIAL PRIMARY KEY,
                         id_town INT NOT NULL,
                         vehicle_type VARCHAR(50) NOT NULL,
                         available BOOL NOT NULL,
                         FOREIGN KEY (id_town) REFERENCES town(id_town)
);

CREATE TABLE travel (
                        id_travel SERIAL PRIMARY KEY,
                        id_vehicle INT NOT NULL,
                        id_user INT NOT NULL,
                        departure_date DATE,
                        placenumber INT NOT NULL,
                        online BOOL NOT NULL,
                        FOREIGN KEY (id_vehicle) REFERENCES vehicle(id_vehicle),
                        FOREIGN KEY (id_user) REFERENCES app_user(id_user)
);

CREATE TABLE reservation (
                             id_reservation SERIAL PRIMARY KEY,
                             date_reservation DATE NOT NULL,
                             online_booking BOOL,
                             seat_number INT,
                             id_user INT NOT NULL,
                             id_travel INT NOT NULL,
                             FOREIGN KEY (id_user) REFERENCES app_user(id_user),
                             FOREIGN KEY (id_travel) REFERENCES travel(id_travel)
);

CREATE TABLE payment (
                         id_payment SERIAL PRIMARY KEY,
                         amount INT NOT NULL,
                         payment_date TIMESTAMP NOT NULL,
                         id_travel INT NOT NULL,
                         payment_status VARCHAR(50) NOT NULL,
                         FOREIGN KEY (id_travel) REFERENCES travel(id_travel)
);