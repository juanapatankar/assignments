gt_100 = (\x -> if x > 100 then 1 else 0)
switch = (\ x y c -> if c == 1 then x else y)
fizzbuzz = (\x -> if x `mod` 15 == 0 then "fizzbuzz" else "nope")
question1 = (\x -> let a = x*x in 2 * a)
question2 = (\x -> let a = x + 1; b = a * a; c = 2^b in a + b -c )
bounded_square = (\x -> let a = x*x in if a < 100 then a else 100)
square_and_cube = (\x -> (x*x, x*x*x))
add_tuple = (\(a, b) -> a + b)
swap = (\(a,b) -> (b,a))
head_squared = (\list -> (head list)^2)
third = (\list -> list !! 2)
third_head = (\list -> head .tail.tail $ list)
prepend_two = (\list a b  -> a:b:list)
two_lengths = (\list1 list2 -> length (list1++list2))
make_palindrome = (\list -> list ++ reverse list)
sum_and_product list = (sum list, product list)
four_through_six = (\list -> take 3 (drop 3 list))
both_in list x y = if (x `elem` list) == True && (y `elem` list) == True then True else False
f = [x^2 |  x <- [0..9]]
only_odds list = [x | x <- list, odd x]
between a b list = [x | x <- list, x > a, x< b]
number_of_es string = length[ 1  | x <- string,  x == 'e']
proper_fizzbuzz = [if x `mod` 15 == 0 then "fizzbuzz" else if x `mod` 3 == 0 then "fizz" else if x `mod` 5 == 0 then "buzz" else show x | x <- [1..]]
