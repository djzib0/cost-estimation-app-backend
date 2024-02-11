CREATE TABLE app_user(
    app_user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_created DATE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE setting(
    setting_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    app_user_id BIGINT,
    theme VARCHAR(20)
);

CREATE TABLE material_grade_dic(
    material_grade_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    eu_symbol VARCHAR(100),
    ger_symbol VARCHAR(100),
    grade_group VARCHAR(100)
);

CREATE TABLE material_group(
    material_group_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(30)
);


