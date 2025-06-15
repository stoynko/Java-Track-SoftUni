/* Delete all rental companies, which do not offer cross-border usage. */

DELETE FROM rental_companies
WHERE cross_border_usage = FALSE