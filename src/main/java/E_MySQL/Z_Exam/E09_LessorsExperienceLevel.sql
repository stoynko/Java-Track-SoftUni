/* From the database extract the full name and experience level of the lessors.
If the year of starting work at the company is 1980 and later but before 1990 the user must see "Specialist",
if it is 1990 and later but before 2000 it should display "Advanced".
If it is 2000 and later but before 2008 it should display "Experienced",
if it is 2008 and later but before 2015 -> "Qualified",
if it is 2015 and later but before 2020  -> "Provisional" and finally if it is 2020 and later it should display "Trainee".
Order the results ascending by year of starting work, then by first_name of the lessor.
Required Columns:
    •	full_name (first_name + " " + last_name)
    •	level (experience) */

SELECT CONCAT(l.first_name, ' ', l.last_name) AS 'full_name',
       CASE
           WHEN YEAR(l.company_employee_from) >= 1980 AND YEAR(l.company_employee_from) < 1990 THEN 'Specialist'
           WHEN YEAR(l.company_employee_from) >= 1990 AND YEAR(l.company_employee_from) < 2000 THEN 'Advanced'
           WHEN YEAR(l.company_employee_from) >= 2000 AND YEAR(l.company_employee_from) < 2008 THEN 'Experienced'
           WHEN YEAR(l.company_employee_from) >= 2008 AND YEAR(l.company_employee_from) < 2015 THEN 'Qualified'
           WHEN YEAR(l.company_employee_from) >= 2015 AND YEAR(l.company_employee_from) < 2020 THEN 'Provisional'
           ELSE 'Trainee'
           END AS 'level'
FROM lessors AS l
ORDER BY YEAR(l.company_employee_from), l.first_name