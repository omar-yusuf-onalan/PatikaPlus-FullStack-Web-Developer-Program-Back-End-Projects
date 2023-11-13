-- 1. Question
SELECT DISTINCT replacement_cost FROM film;

-- 2. Question
SELECT COUNT(DISTINCT replacement_cost) FROM film;

-- 3. Question
SELECT COUNT(DISTINCT title) FROM film
WHERE title LIKE 'T%' AND rating = 'G'

-- 4. Question
SELECT COUNT(DISTINCT country) FROM country
WHERE country LIKE '_____';

-- 5. Question
SELECT COUNT(DISTINCT city) FROM city
WHERE city ILIKE '%R';