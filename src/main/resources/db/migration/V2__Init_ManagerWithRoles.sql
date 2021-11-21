INSERT INTO user
VALUES (1, 1, 'manager', 'manager', 'manager', '$2a$08$gUILl/OPpxHGQNrmHK7Rhu9emIoLu6PtkIwbEhv6XfHK7V1Lxhjku');

INSERT INTO role
VALUES (1, 'USER');
INSERT INTO role
VALUES (2, 'MANAGER');

INSERT INTO user_role VALUES (1,1);
INSERT INTO user_role VALUES (1,2);