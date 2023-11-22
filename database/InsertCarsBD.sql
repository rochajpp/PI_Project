INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Lampadati", "Corsita", 1795000.00, "The Corsita is powered by a V12 engine whose model is derived from cars like the Infernus Classic, Torero, and Toros. It is mated to an 8-speed gearbox in a rear mid-engine, rear-wheel-drive layout, and it uses the same engine sound as cars like the Itali GTO and Itali RSX, albeit with a sharper tone.", "/img/car1.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Grotti", "Turismo R", 500000.00, "The Turismo R falls short of being one of the fastest Super Cars. Acceleration is excellent, and there is good wheel rotation. The top speed is also very good, being as fast as the Zentorno. Since the car contains an electric motor, there is no power loss during gear changes.", "/img/car2.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Itali", "GTO", 1965000.00, "It has a good top speed, good drivability, but low durability, sharing the same attributes as the Itali GTB. The Itali GTO is powered by a V-shaped engine that drives all four wheels through a 6-speed gearbox. The engine model emulates the V12 engine of the Ferrari 812.", "/img/car3.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Ocelot", "Pariah", 1420000.00, "In terms of performance, the Pariah is in a league of its own. It excels in the Sports class more than others like the Elegy RH8, Neo, and Jugular, and it would be competitive in the Supers class. Despite being powered by what seems to be a large-displacement inline-4 engine, it has supercar levels of power, providing unusually high top speed and acceleration.", "/img/car4.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Annis", "S80RR", 2575000.00, "The acceleration of the S80RR is surprisingly good for a rear-wheel-drive vehicle. The top speed is comparable to most cars in the supercar class. Handling is almost unique compared to other cars, with the ability to turn very sharply and easily recover control if the car starts to slide.", "/img/car5.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Vigilante", "WarStock", 3750000.00, "The Vigilante is a high-performance sports car that also combines offensive capabilities of armed and heavy vehicles. It has good acceleration, traction, and decent handling, and its mass, similar to the Insurgent, allows it to navigate through traffic with ease, mainly due to its front.", "/img/car6.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Canis", "Kalahari", 40000.00, "The Kalahari performs very well, with good top speed and acceleration, but it also performs well off-road. Although this vehicle has good acceleration, its top speed is not suitable when competing against faster vehicles. Additionally, the thin tire profiles make it less desirable for off-road purposes.", "/img/car7.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Stinger", "GT", 875000.00, "The Stinger GT, being a grand tourer, is a high-performance car for its class. The in-game engine model shows a V8 engine with a single overhead camshaft, equipped with 4 dual-choke downdraft carburetors. Unlike the standard Stinger, the Stinger GT has its engine mounted in a rear mid-engine layout, while the Stinger has the engine placed in the front mid-engine layout.", "/img/car8.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Bravado", "Banshee", 536750.00, "Overall, the Banshee is one of the most agile cars, with excellent top speed and acceleration. However, due to its large body and wide axles, its handling is low. If the driver does not use the handbrake correctly in tight corners, the car can lose control and collide violently with walls. Its braking is excellent, requiring only a few meters of road to come to a complete stop.", "/img/car9.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Benefactor", "Krieger", 2285000.00, "The Krieger can be considered an excellent versatile supercar. It not only has a good top speed and drivability but also boasts excellent acceleration and traction, allowing it to move quickly after deceleration. The all-wheel-drive layout also offers good capabilities on roads and off-road environments, but obstacles can be a problem for its stability.", "/img/car10.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Pfister", "811", 1135000.00, "The 811 has phenomenal performance. With its lightweight body, all-wheel drive, and excellent aerodynamics, the car has extreme acceleration, surpassing all non-electric motorcycles and supercars. According to records, the vehicle's top speed is similar to that of the T20, making it the third-fastest car. The rear-engine layout of the car appears to be beneficial in terms of power-to-weight ratio.", "/img/car11.png", 1, 2023, 2023, "2023-09-29");

INSERT INTO car (brand, model, value, description, image, interest, manufactureyear, modelyear, registerdate)
VALUES
("Entity", "XF", 795000.00, "The car is capable of reaching very high speeds. Its top speed is slightly lower than that of the Adder, but it has better acceleration than all other supercars. It also has very high traction due to its all-wheel-drive system and excellent weight distribution. From 0 to 100 km/h in 3.5 seconds, 6-speed transmission, V8 engine.", "/img/car12.png", 1, 2023, 2023, "2023-09-29");

UPDATE car SET interest = 0 WHERE interest = 1;


SHOW GRANTS FOR 'root'@'localhost';