CREATE TABLE user
(
    USERNAME VARCHAR(128) PRIMARY KEY NOT NULL,
    PASSWORD VARCHAR(128) NOT NULL
);
CREATE TABLE user_role
(
    USER_ROLE_ID INT PRIMARY KEY NOT NULL,
    ROLE VARCHAR(45),
    USERNAME VARCHAR(128)
);
ALTER TABLE user_role ADD FOREIGN KEY (USERNAME) REFERENCES user (USERNAME) ON DELETE CASCADE;
CREATE INDEX USER_FK_idx ON user_role (USERNAME);