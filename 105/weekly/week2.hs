gt_100 x = if x > 100 then 1 else 0
switch x y c = if c == 1 then x else y
fizzbuzz x = if x `mod` 15 == 0 then "Fizzbuzz!" else "Nope"

question1 x = let a = x ^ 2 in 2 * a
question2 x = let a = x+1; b = a^2; c = 2^b in a + b - c
bounded_square x = let a = x * x in if a < 100 then a else 100

square_and_cube x = (x*x, x*x*x)
add_tuple (a,b) = a + b
swap (a, b) = (b, a)

head_squared_list x = head x ^ 2
third_list x = x!!2
-- third_head list = if length list > 2 then let t = tail in show(head(t(t list))) else ""
third_head list = if length(list) > 2 then (let t = tail in head(t(t(list)))) else length(list)
prepend_two list a b = a:b:list

two_lengths list1 list2 = length list1 + length list2
make_palindrome list = list ++ reverse list
sum_and_product list = (sum list, product list)
four_through_six list = take 3(drop 3 list)
both_in list x y = if elem x list && elem y list then "True" else "False"

-- 6.1 = [101..200]
-- 6.2 = [1000,1002..1050]
-- 6.3 = [20, 19..1]
-- 6.4 = [999,1002..]

-- [x^2 | x <- [1..10]]
only_odds list = [x | x <- list, mod x 2 == 1] -- return n for each x in list, where x is odd
between a b list = [x | x <- list, a < x, x < b]
number_of_es string = "e: " ++ show(length([e | e <- string, e == 'e'])) ++ "       E: " ++ show(length([ue | ue <- string, ue == 'E']))
-- proper_fizzbuzz = ["fizz" | i <- [1..15], i `mod` 3 == 0]
--proper_fizzbuzz = [[] ++ show(i)| i <- [1.. 30], i `mod` 3 == 0 && i `mod` 5 == 0]
--proper_fizzbuzz = [] ++ ["fizzbuzz" | i <- [1.. 30], i `mod` 15 == 0] ++ [show(i) | i <- [1..30], i `mod` 15 /= 0] ++ ["fizz" | i <- [1..30], i) `mod` 3 == 0] ++ ["buzz" | i <- [1..30], head(i) `mod` 5 == 0]
--WHAT IF USE IF AND ELSE IF (?) TO ADD CORRESP RESP FOR EACH ITEM TO NEW LIST
--proper_fizzbuzz = ["fizzbuzz" | i <- [1.. 30], i `mod` 15 == 0]

{- not a multiple of 3 or 5 : [] within [1..30]
multiple of 3 or 5: [mutiple of 3only] wihtin [multiples of 15]
                  [multiple of 5 only] wihtin [multiples of 15]
                                              [multiples of 15] within [1..30]   -}
--proper_fizzbuzz = [show(i) | i <- [1..30], i `mod` 3 /= 0 && i `mod` 5 /= 0]-- not 15 | all 1..30]
--proper_fizzbuzz = [ show(i):[] | i <- [1..30], i `mod` 3 /= 0 && i `mod` 5 /= 0]
-- proper_fizzbuzz = [[1..30] !! i == "fizz" | i <- [1.. 30], i `mod` 3 == 0 || i `mod` 5 == 0]

proper_fizzbuzz = [if i `mod` 15 == 0 then "fizzbuzz" else if i `mod` 3 == 0 then "fizz" else if i `mod` 5 == 0 then "buzz" else show(i) | i <- [1..30]]
