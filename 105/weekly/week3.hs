mult13 1 = 13
mult13 n = 13 + mult13(n-1)

pow3 1 = 3
pow3 n = 3 * pow3(n-1)

odd_sum 0 = 0
odd_sum 1 = 1
odd_sum n = if n `mod` 2 == 1
  then n + odd_sum(n-1)
  else odd_sum(n-1)

odd_sum_g n
  | (n == 0) = 0
  | (n == 1) = 1
  | (n `mod` 2 == 1) = n + odd_sum_g(n-1)
  | otherwise = odd_sum_g(n-1)

lucas n
  | (n == 0) = 2
  | (n == 1) = 1
  | otherwise = lucas(n-1) + lucas(n-2)

half_sum [] = 0
half_sum (x:xs) = x/2 + half_sum(xs)

mult2 [] = []
mult2 (x:xs) = x*2 : mult2(xs)

drop_evens [] = []
drop_evens (x:xs)
  | (x `mod` 2 == 1) = x:drop_evens(xs)
  | otherwise = drop_evens(xs)

mult_adjacent [] = []
mult_adjacent [x] = 0:[]
mult_adjacent (x:y:xs) = x*y : mult_adjacent xs

get_ele i [] = error "Not enough elements in the list!"
get_ele 1 (x:xs) = x
get_ele i (x:xs) = get_ele (i-1) xs

drop_ele i [] = error "Not enough elements in the list!"
drop_ele 1 (x:xs) = xs
drop_ele i (x:xs) = x:drop_ele (i-1) xs

div_list [] [] = []
div_list (x:xs) (y:ys) = i : div_list xs ys
  where i = x/y

longer list1 list2
  | i > j = True
  | otherwise = False
  where i = length(list1)
        j = length(list2)

vowels_and_consonants "" = ("","")
vowels_and_consonants (x:xs)
  | x `elem` "aeiou" = (x:vowels, conson)
  | otherwise = (vowels, x:conson)
  where (vowels, conson) = vowels_and_consonants xs
