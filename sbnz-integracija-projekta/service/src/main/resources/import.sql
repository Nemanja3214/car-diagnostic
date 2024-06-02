insert into mechanics(username, password, role) values ('srki', '$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO', 2);
insert into models(name) values ('AUDI A4');
-- ALTER TABLE clients ALTER COLUMN id RESTART WITH 1;
insert into clients(name, lastname) values ('Mika', 'Mikic');
insert into cars(plate, year_of_production, km, owner_id, model_id, potentional_engine_issue) values ('NS2222', 2001, 324432, 1, 1, false);