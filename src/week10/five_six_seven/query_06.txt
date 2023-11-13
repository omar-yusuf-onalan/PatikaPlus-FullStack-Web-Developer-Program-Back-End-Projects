-- 1. Question
SELECT ROUND(AVG(rental_rate), 2) FROM film;

-- 2. Question
SELECT COUNT(title) FROM film
WHERE title LIKE 'C%';

-- 3. Question
SELECT MAX(length) FROM film
WHERE rental_rate = 0.99;

-- 4. Question
SELECT COUNT(DISTINCT replacement_cost) FROM film
WHERE length > 150;