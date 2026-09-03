CREATE TABLE users (
                       id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE families (
                          id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          name VARCHAR(255)
);

CREATE TABLE user_family (
                             user_id BIGINT NOT NULL,
                             family_id BIGINT NOT NULL,

                             CONSTRAINT pk_user_family
                                 PRIMARY KEY (user_id, family_id),

                             CONSTRAINT fk_user_family_user
                                 FOREIGN KEY (user_id)
                                     REFERENCES users(id),

                             CONSTRAINT fk_user_family_family
                                 FOREIGN KEY (family_id)
                                     REFERENCES families(id)
);

CREATE TABLE persons (
                         id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,

                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         middle_name VARCHAR(255),

                         birth_date DATE,
                         birth_year INTEGER,

                         death_date DATE,
                         death_year INTEGER,

                         biography TEXT,

                         family_id BIGINT NOT NULL,

                         CONSTRAINT fk_person_family
                             FOREIGN KEY (family_id)
                                 REFERENCES families(id),

                         CONSTRAINT chk_birth_date_or_year
                             CHECK (
                                 NOT (birth_date IS NOT NULL AND birth_year IS NOT NULL)
                                 ),

                         CONSTRAINT chk_death_date_or_year
                             CHECK (
                                 NOT (death_date IS NOT NULL AND death_year IS NOT NULL)
                                 )
);

CREATE TABLE burial_locations (
                                  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                  latitude DOUBLE PRECISION NOT NULL,
                                  longitude DOUBLE PRECISION NOT NULL,
                                  is_exact BOOLEAN NOT NULL,
                                  description TEXT,
                                  person_id BIGINT NOT NULL UNIQUE,
                                  CONSTRAINT fk_burial_person
                                      FOREIGN KEY (person_id)
                                          REFERENCES persons(id),
                                  CONSTRAINT chk_latitude
                                      CHECK (latitude >= -90 AND latitude <= 90),
                                  CONSTRAINT chk_longitude
                                      CHECK (longitude >= -180 AND longitude <= 180)
);

CREATE TABLE person_photos (
                               id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               title VARCHAR(255),
                               person_id BIGINT NOT NULL,
                               file_url TEXT NOT NULL,
                               CONSTRAINT fk_person_photo_person
                                   FOREIGN KEY (person_id)
                                       REFERENCES persons(id)
);

CREATE TABLE grave_photos (
                              id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                              title VARCHAR(255),
                              burial_id BIGINT NOT NULL,
                              file_url TEXT NOT NULL,
                              CONSTRAINT fk_grave_photo_burial
                                  FOREIGN KEY (burial_id)
                                      REFERENCES burial_locations(id)
);