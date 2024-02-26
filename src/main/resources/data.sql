INSERT INTO app_user(first_name, last_name) VALUES(
'piotr',
'sabatura'
);

INSERT INTO app_user(first_name, last_name) VALUES(
'aleksandra',
'choinska'
);

INSERT INTO setting(app_user_id, theme) VALUES(
1,
'dark'
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
'ENAW-AlMg4.5Mn0.7	', '3.3547', 8.0, 'aluminum'
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



INSERT INTO plate_material(dimension_A, dimension_B, thickness, weight, is_painted, is_painted_both_sides, surface_to_conserve, project_id, material_grade_id) VALUES (
100,
200,
30,
4.8,
TRUE,
FALSE,
0.02,
1,
1
);

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




