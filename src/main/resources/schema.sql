CREATE TABLE app_user(
    app_user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    date_created DATE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE setting(
    setting_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    app_user_id BIGINT,
    theme VARCHAR(20),
    steel_grade_a_default_price_per_kg NUMERIC(100, 2),
    steel_grade_s355_default_price_per_kg NUMERIC(100, 2),
    stainless_steel_default_price_per_kg NUMERIC(100, 2),
    default_material_margin NUMERIC(5, 1),
    default_outsourcing_margin NUMERIC(5, 1),
    default_sales_margin NUMERIC(5, 1)
);

CREATE TABLE material_grade_dic(
    material_grade_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    eu_symbol VARCHAR(100) UNIQUE,
    ger_symbol VARCHAR(100) UNIQUE,
    density DECIMAL(100, 2),
    grade_group VARCHAR(100)
);

CREATE TABLE material_group(
    material_group_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(30)
);

CREATE TABLE project_type(
    type_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type_name VARCHAR(30)
);

CREATE TABLE hour_type(
    type_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type_name VARCHAR(100),
    default_price_per_hour NUMERIC(100, 2)
);

--HOURS
CREATE TABLE project_operation (
    operation_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    operation_title VARCHAR(200),
    quantity INT,
    total_value NUMERIC(100, 2),
    hour_type_id BIGINT,
    hour_type_name VARCHAR(100),
    price_per_hour NUMERIC(100, 2),
    remark VARCHAR(500),
    position_in_project INT,
    project_id BIGINT
);

--MATERIALS
CREATE TABLE plate_material(
    plate_material_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    dimension_A INT,
    dimension_B INT,
    thickness INT,
    weight DECIMAL(100, 2),
    total_weight DECIMAL(100, 2),
    quantity INT,
    is_ring BOOLEAN,
    is_painted BOOLEAN,
    is_painted_both_sides BOOLEAN,
    surface_to_conserve DECIMAL(100, 2),
    cutting_time DECIMAL(100, 2),
    project_id BIGINT,
    price_per_kg NUMERIC(100, 2),
    total_value NUMERIC(100, 2),
    material_grade VARCHAR(100),
    density DECIMAL(100, 2),
    remark VARCHAR(500)
);

CREATE TABLE roundbar_material(
    roundbar_material_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    diameter INT,
    profile_length DECIMAL(100, 1),
    weight DECIMAL(100, 1),
    total_weight DECIMAL(100, 1),
    weight_per_meter DECIMAL(100, 1),
    quantity INT,
    is_painted BOOLEAN,
    surface_to_conserve DECIMAL(100, 2),
    cutting_time DECIMAL(1000, 2),
    project_id BIGINT,
    price_per_kg NUMERIC(100, 2),
    total_value NUMERIC(100, 2),
    material_grade VARCHAR(100),
    density DECIMAL(100, 2),
    remark VARCHAR(500)
);

-- PROJECT --
CREATE TABLE project(
     project_id BIGINT PRIMARY KEY AUTO_INCREMENT,
     project_number VARCHAR(100),
     project_client_number VARCHAR(100),
     title VARCHAR(200),
     type_id BIGINT,
     drawing_number VARCHAR(200),
     total_value NUMERIC(12,2) DEFAULT 0,
     material_margin NUMERIC(4,2) DEFAULT 0,
     outsourcing_margin NUMERIC(4,2) DEFAULT 0,
     sales_margin NUMERIC(4, 2) DEFAULT 0,
     date_created DATE DEFAULT CURRENT_TIMESTAMP,
     date_last_edited DATE DEFAULT CURRENT_TIMESTAMP
);


