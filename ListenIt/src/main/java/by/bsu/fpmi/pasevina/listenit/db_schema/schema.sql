CREATE TABLE audio
(
    audio_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    singer VARCHAR(250) NOT NULL,
    audio_name VARCHAR(250) NOT NULL,
    audio_descr VARCHAR(1000),
    audio_file LONGBLOB NOT NULL,
    USERNAME VARCHAR(128) NOT NULL
);
CREATE TABLE audio_comment
(
    comment_id INT PRIMARY KEY NOT NULL,
    user_name VARCHAR(128) NOT NULL,
    audio_id INT NOT NULL,
    comment_date DATETIME NOT NULL,
    comment_descr VARCHAR(1000) NOT NULL
);
CREATE TABLE audio_like
(
    username VARCHAR(128) NOT NULL,
    audio_id INT NOT NULL,
    like_num INT DEFAULT 0 NOT NULL
);
CREATE TABLE user
(
    USERNAME VARCHAR(128) PRIMARY KEY NOT NULL,
    PASSWORD VARCHAR(128) NOT NULL,
    SOCIAL_PROVIDER VARCHAR(20)
);
CREATE TABLE user_role
(
    USER_ROLE_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ROLE VARCHAR(45),
    USERNAME VARCHAR(128)
);
ALTER TABLE audio ADD FOREIGN KEY (USERNAME) REFERENCES user (USERNAME);
CREATE INDEX fk_username ON audio (USERNAME);
ALTER TABLE audio_comment ADD FOREIGN KEY (audio_id) REFERENCES audio (audio_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE audio_comment ADD FOREIGN KEY (user_name) REFERENCES user (USERNAME) ON DELETE CASCADE ON UPDATE CASCADE;
CREATE INDEX fk_audio_comment_idx ON audio_comment (audio_id);
CREATE INDEX fk_user_idx ON audio_comment (user_name);
CREATE INDEX fk_username_idx ON audio_comment (user_name);
ALTER TABLE audio_like ADD FOREIGN KEY (audio_id) REFERENCES audio (audio_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE audio_like ADD FOREIGN KEY (username) REFERENCES user (USERNAME) ON DELETE CASCADE ON UPDATE CASCADE;
CREATE INDEX fk_audio_like_idx ON audio_like (audio_id);
CREATE INDEX fk_user_like_idx ON audio_like (username);
