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
    eu_symbol VARCHAR(100) UNIQUE,
    ger_symbol VARCHAR(100),
    density DECIMAL(100000, 2),
    grade_group VARCHAR(100)
);

CREATE TABLE material_group(
    material_group_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(30)
);

CREATE TABLE plate_material(
    plate_material_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    dimension_A INT,
    dimension_B INT,
    thickness INT,
    weight DECIMAL(100000, 2),
    is_painted BOOLEAN,
    is_painted_both_sides BOOLEAN,
    surface_to_conserve DECIMAL(1000, 2),
    project_id BIGINT,
    material_grade_id BIGINT
);

CREATE TABLE project(
     project_id BIGINT PRIMARY KEY AUTO_INCREMENT,
     project_number VARCHAR(100),
     project_client_number VARCHAR(100)
);


