INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by, is_active)
VALUE (
    "SYSTEM",
    "SYSTEM",
    "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y",
    "system@system.com",
    "ADMIN",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1
);

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by, is_active)
VALUE (
    "anonymousUser",
    "anonymousUser",
    "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y",
    "anonymousUser@anonymousUser.com",
    "",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1
);

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by, is_active)
VALUE (
    "admin",
    "admin",
    "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y",
    "admin@admin.com",
    "ADMIN",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1
);

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by, is_active)
VALUE (
    "test1",
    "test1",
    "$2a$10$LI/suG/VrLPuBQDRVhfG7.ntbrTV7IC7A9iSOFwEJH/t7DZaOuBk.",
    "test1@test.com",
    "NORMAL",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1
);

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by, is_active)
VALUE (
    "test2",
    "test2",
    "$2a$10$LI/suG/VrLPuBQDRVhfG7.ntbrTV7IC7A9iSOFwEJH/t7DZaOuBk.",
    "test2@test.com",
    "NORMAL",
    NOW(),
    "SYSTEM",
    NOW(),
    "SYSTEM",
    1
);

INSERT INTO categories (name, description) VALUES
("Gato", "Um gatinho bonito"),
("Cachorro", "Um cachorro bonito");