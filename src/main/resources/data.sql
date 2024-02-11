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
INSERT INTO material_grade_dic(eu_symbol, ger_symbol, grade_group) VALUES (
'S235J2', '1.0117', 'steel'
);

INSERT INTO material_grade_dic(eu_symbol, ger_symbol, grade_group) VALUES (
'S355J2', '1.0570', 'steel'
);

INSERT INTO material_grade_dic(eu_symbol, ger_symbol, grade_group) VALUES (
'316L', '1.4404', 'st. st.'
);

INSERT INTO material_grade_dic(eu_symbol, ger_symbol, grade_group) VALUES (
'ENAW-AlMg4.5Mn0.7	', '3.3547', 'aluminum'
);

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




