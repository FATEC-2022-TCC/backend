INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by)
VALUE ("SYSTEM", "SYSTEM", "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y", "system@system.com", "ADMIN", NOW(), "SYSTEM", NOW(), "SYSTEM");

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by)
VALUE ("anonymousUser", "anonymousUser", "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y", "system@system.com", "ADMIN", NOW(), "SYSTEM", NOW(), "SYSTEM");

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by)
VALUE ("admin", "admin", "$2a$10$YFn5pXKY/ktIlIkCQ2OpmehUMriXHjdoJ12GWDyjKGT6cpa4Dhv4y", "anonymousUser@anonymousUser.com", "", NOW(), "SYSTEM", NOW(), "SYSTEM");

INSERT INTO users (name, username, password, email, authority, created, created_by, updated, updated_by)
VALUE ("test", "test", "$2a$10$LI/suG/VrLPuBQDRVhfG7.ntbrTV7IC7A9iSOFwEJH/t7DZaOuBk.", "test@test.com", "NORMAL", NOW(), "SYSTEM", NOW(), "SYSTEM");