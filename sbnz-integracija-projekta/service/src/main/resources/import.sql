insert into mechanic(username, password, role) values ('srki', '$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO', 2);
INSERT INTO car_model(name) VALUES('Model A'), ('Model B');

-- -- Insert sample client data
INSERT INTO client(name, last_name, phone) VALUES('John', 'Doe', '123456789'),('Jane', 'Smith', '987654321');

INSERT INTO car(plate, year_of_production, km, potentional_engine_issue, owner_id, model_id) VALUES('ABC123', 2020, 15000, 0, 1, 1);

INSERT INTO battery(nominal_max_charge, nominal_max_voltage) VALUES(50.0, 5.0);
INSERT INTO electric_car (id, potentional_battery_problem, percentage_battery, fault_check, battery_id) VALUES(1, 0, 80, 0, 1);

INSERT INTO breakdown(name, car_id) VALUES('KVAR 1', 1),('KVAR 2', 1);
INSERT INTO discount(percent) VALUES(10),(15);
INSERT INTO repairment(price, discount_id, mechanic_id, breakdown_id, action) VALUES(233, 1, 1, 1, 'Natocite gorivo!');
INSERT INTO repairment(price, discount_id, mechanic_id, breakdown_id, action) VALUES(233, 2, 1, 2, 'Natocite gorivo!');

