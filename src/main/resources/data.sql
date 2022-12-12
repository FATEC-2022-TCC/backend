INSERT INTO private_info (email, telephony, identification, address, picture)
VALUE ("", "", "", "", "");

INSERT INTO users (name, username, password, authority, created, created_by, updated, updated_by, is_active, is_validated, private_info_id)
VALUES
(
    "SYSTEM",
    "SYSTEM",
    "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y",
    "ADMIN",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1,
    1,
    1
),
(
    "admin",
    "admin",
    "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y",
    "ADMIN",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1,
    1,
    1
),
(
    "test1",
    "test1",
    "$2a$10$LI/suG/VrLPuBQDRVhfG7.ntbrTV7IC7A9iSOFwEJH/t7DZaOuBk.",
    "NORMAL",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1,
    1,
    1
),
(
    "test2",
    "test2",
    "$2a$10$LI/suG/VrLPuBQDRVhfG7.ntbrTV7IC7A9iSOFwEJH/t7DZaOuBk.",
    "NORMAL",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1,
    1,
    1
);

INSERT INTO categories (name, description) VALUES
("Gato", "Um gatinho bonito"),
("Cachorro", "Um cachorro bonito");