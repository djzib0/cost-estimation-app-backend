CREATE TABLE app_user(
    app_user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_created DATE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE theme(
    theme_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE setting(
    setting_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    theme_id BIGINT,
    app_user_id BIGINT
--    FOREIGN KEY (user_id) REFERENCES app_user(user_id),
--    FOREIGN KEY (theme_id) REFERENCES theme(theme_id)
);

CREATE SEQUENCE setting_sequence
start with 0
increment by 1
minvalue 0
maxvalue 100
cycle;
