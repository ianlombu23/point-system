CREATE TABLE "point-system"."user" (
	user_id uuid NOT NULL,
	user_name varchar NOT NULL,
	created_at varchar NULL,
	updated_at timestamp NULL,
	created_by varchar NULL,
	updated_by varchar NULL,
	CONSTRAINT user_pk PRIMARY KEY (user_id)
);