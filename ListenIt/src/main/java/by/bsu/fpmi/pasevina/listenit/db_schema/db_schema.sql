CREATE TABLE user
(
    USERNAME VARCHAR(128) PRIMARY KEY NOT NULL,
    PASSWORD VARCHAR(128) NOT NULL
);
DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role`
(
    USER_ROLE_ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ROLE VARCHAR(45),
    USERNAME VARCHAR(128)
);
ALTER TABLE user_role ADD FOREIGN KEY (USERNAME) REFERENCES user (USERNAME) ON DELETE CASCADE;
CREATE INDEX USER_FK_idx ON user_role (USERNAME);

DROP TABLE IF EXISTS audio;
CREATE TABLE audio
(
    audio_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    singer VARCHAR(250) NOT NULL,
    audio_name VARCHAR(250) NOT NULL,
    year INT,
    audio_descr VARCHAR(1000)
);

CREATE TABLE `audio_comment` (
    `comment_id` int(11) NOT NULL,
    `user_name` varchar(128) NOT NULL,
    `audio_id` int(11) NOT NULL,
    `comment_date` datetime NOT NULL,
    `comment_descr` varchar(1000) NOT NULL,
    PRIMARY KEY (`comment_id`),
    KEY `fk_username_idx` (`user_name`),
    KEY `fk_user_idx` (`user_name`),
    KEY `fk_audio_comment_idx` (`audio_id`),
    CONSTRAINT `fk_audio_comment` FOREIGN KEY (`audio_id`) REFERENCES `audio` (`audio_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_user_comment` FOREIGN KEY (`user_name`) REFERENCES `user` (`USERNAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `audio_like` (
    `username` varchar(128) NOT NULL,
    `audio_id` int(11) NOT NULL,
    `like_num` int(11) NOT NULL DEFAULT '0',
    KEY `fk_user_like_idx` (`username`),
    KEY `fk_audio_like_idx` (`audio_id`),
    CONSTRAINT `fk_audio_like` FOREIGN KEY (`audio_id`) REFERENCES `audio` (`audio_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_user_like` FOREIGN KEY (`username`) REFERENCES `user` (`USERNAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




