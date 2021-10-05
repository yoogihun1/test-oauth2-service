CREATE TABLE `oauth_access_token` (
                                      `token_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      `token` blob,
                                      `authentication_id` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
                                      `user_name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      `client_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      `authentication` blob,
                                      `refresh_token` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `oauth_approvals` (
                                   `userId` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                   `clientId` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                   `scope` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                   `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                   `expiresAt` timestamp NULL DEFAULT NULL,
                                   `lastModifiedAt` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `oauth_client_details` (
                                        `client_id` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `resource_ids` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `client_secret` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `scope` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `authorized_grant_types` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `web_server_redirect_uri` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `authorities` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `access_token_validity` int DEFAULT NULL,
                                        `refresh_token_validity` int DEFAULT NULL,
                                        `additional_information` varchar(4096) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `autoapprove` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `oauth_client_token` (
                                      `token_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      `token` blob,
                                      `authentication_id` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
                                      `user_name` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      `client_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                      PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `oauth_code` (
                              `code` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `oauth_refresh_token` (
                                       `token_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       `token` blob,
                                       `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci