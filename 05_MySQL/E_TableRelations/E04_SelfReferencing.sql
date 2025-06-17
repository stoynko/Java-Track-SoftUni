/*Create a single table as follows. Use appropriate data types.
    ┌─────────────────────────────────┐
    │             Students            │
    ├───────────┬────────┬────────────┤
    │ teacher_id│ name   │ manager_id │
    ├───────────┼────────┼────────────┤
    │ 101       │ John   │            │
    ├───────────┼────────┼────────────┤
    │ 102       │ Maya   │ 106        │
    ├───────────┼────────┼────────────┤
    │ 103       │ Silvia │ 106        │
    ├───────────┼────────┼────────────┤
    │ 104       │ Ted    │ 105        │
    ├───────────┼────────┼────────────┤
    │ 105       │ Mark   │ 101        │
    ├───────────┼────────┼────────────┤
    │ 106       │ Greta  │ 101        │
    └───────────┴────────┴────────────┘
Insert the data from the example above.
    • Add primary and foreign keys.
    • The foreign key should be between manager_id and teacher_id. */

CREATE TABLE teachers (
    teacher_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(30),
    manager_id INT,
    CONSTRAINT fk_manager_id_teacher_id
        FOREIGN KEY (manager_id)
            REFERENCES teachers(teacher_id)
);

INSERT INTO teachers (teacher_id, name) VALUES
    (101, 'John');

INSERT INTO teachers (teacher_id, name, manager_id) VALUES
    (105, 'Mark', 101),
    (106, 'Greta', 101);

INSERT INTO teachers (teacher_id, name, manager_id) VALUES
    (102, 'Maya', 106),
    (103, 'Silvia', 106),
    (104, 'Ted', 105);