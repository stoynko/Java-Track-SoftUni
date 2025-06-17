-- Create the connection via foreign key between the "products" and "categories" tables that you've created earlier.
-- Make "category_id" foreign key linked to "id" in the "categories" table.

ALTER TABLE `products`
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id) REFERENCES categories(id);
