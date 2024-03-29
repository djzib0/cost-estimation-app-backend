INSERT INTO app_user(first_name, last_name) VALUES(
'piotr',
'sabatura'
);

INSERT INTO app_user(first_name, last_name) VALUES(
'aleksandra',
'choinska'
);

INSERT INTO setting(app_user_id, theme, steel_grade_a_default_price_per_kg,
            steel_grade_s355_default_price_per_kg, stainless_steel_default_price_per_kg,
            default_material_margin, default_outsourcing_margin, default_sales_margin) VALUES(
1,
'dark',
5.03,
5.12,
21.36,
10,
10,
7.3
);


--
INSERT INTO material_grade_dic(eu_symbol, ger_symbol, density, grade_group) VALUES (
'S235J2', '1.0117', 8.0, 'steel'
);

INSERT INTO material_grade_dic(eu_symbol, ger_symbol, density, grade_group) VALUES (
'S355J2', '1.0570', 8.0, 'steel'
);

INSERT INTO material_grade_dic(eu_symbol, ger_symbol, density, grade_group) VALUES (
'316L', '1.4404', 8.0, 'st. st.'
);

INSERT INTO material_grade_dic(eu_symbol, ger_symbol, density, grade_group) VALUES (
'ENAW-AlMg4.5Mn0.7	', '3.3547', 2.7, 'aluminum'
);


-- CONSTANT VALUES --
INSERT INTO material_group(group_name) VALUES (
'steel'
);

INSERT INTO material_group(group_name) VALUES (
'st. st.'
);

INSERT INTO material_group(group_name) VALUES (
'aluminum'
);

INSERT INTO material_group(group_name) VALUES (
'other'
);


INSERT INTO project_type(type_name) VALUES (
'nozzle'
);

INSERT INTO project_type(type_name) VALUES (
'rudder'
);

INSERT INTO project_type(type_name) VALUES (
'tunnel'
);

INSERT INTO project_type(type_name) VALUES (
'other'
);

INSERT INTO hour_type(type_name, default_price_per_hour) VALUES (
'assembly',
60
);

INSERT INTO hour_type(type_name, default_price_per_hour) VALUES (
'welding',
60
);

INSERT INTO hour_type(type_name, default_price_per_hour) VALUES (
'small machining',
110
);

--ADDING HOURS
INSERT INTO project_operation(operation_title, quantity, total_value, hour_type_id,
            hour_type_name, price_per_hour, remark,
            position_in_project, project_id) VALUES (
'montaz szkieletu',
12,
720,
1,
'assembly',
60.0,
'test remark for project operation',
12,
1
);

INSERT INTO project_operation(operation_title, quantity, total_value, hour_type_id,
            hour_type_name, price_per_hour, remark,
            position_in_project, project_id) VALUES (
'framework welding',
10,
600,
2,
'welding',
60.0,
'test remark for project operation',
2,
1
);

INSERT INTO project_operation(operation_title, quantity, total_value, hour_type_id,
            hour_type_name, price_per_hour, remark,
            position_in_project, project_id) VALUES (
'machining surface',
2,
240,
3,
'small machining',
120.0,
'test remark for project operation',
3,
1
);

-- ADDING MATERIALS --
INSERT INTO plate_material(dimension_A, dimension_B, thickness, weight,
            quantity, is_ring, is_painted, is_painted_both_sides,
            surface_to_conserve, cutting_time,
            project_id, price_per_kg, material_grade, density, remark) VALUES (
100,
200,
30,
4.8,
1,
FALSE,
TRUE,
FALSE,
0.02,
4.3,
1,
5.03,
'S355J2',
8.0,
'test'
);

INSERT INTO plate_material(dimension_A, dimension_B, thickness, weight,
            quantity, is_ring, is_painted, is_painted_both_sides,
            surface_to_conserve, cutting_time,
            project_id, price_per_kg, material_grade, density, remark) VALUES (
100,
200,
30,
4.8,
1,
FALSE,
TRUE,
FALSE,
0.02,
4.3,
1,
5.03,
'nie ma takiego materiału',
8.0,
'test'
);

INSERT INTO roundbar_material(diameter, profile_length, weight, total_weight, weight_per_meter,
            quantity, is_painted, surface_to_conserve, cutting_time,
            project_id, price_per_kg, material_grade, density, remark) VALUES (
150,
350,
42.41,
42.41,
141.37,
1,
FALSE,
0,
16,
1,
11.3,
'S355J2',
8.0,
'test remark for round bar'
);



-- ADDING PROJECTS --

INSERT INTO project(project_number, project_client_number, title, type_id,
            drawing_number) VALUES (
'32549',
'NOZ14243258',
'test title 1',
1,
'1983254-A01'
);

INSERT INTO project(project_number, project_client_number, title, type_id,
            drawing_number) VALUES (
'32550',
'ZL/2024/14',
'test title 2',
2,
'1223456'
);




