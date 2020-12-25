list_product list = foldr (\x acc -> acc * x) 1 list
list_any list = foldr (||) False list
product_of_evens list = foldr (\x acc ->
  if even x then x * acc else acc) 1 list
lt10 list = foldr (\x acc ->
  if x < 10 then acc + 1 else acc) 0 list

slist_product list = scanr (\x acc -> acc * x) 1 list
slist_any list = scanr (||) False list
sproduct_of_evens list = scanr (\x acc ->
  if even x then x * acc else acc) 1 list
slt10 list = scanr (\x acc ->
  if x < 10 then acc + 1 else acc) 0 list

leadingcaps (x:xs) = takeWhile (\x -> elem x ['A'..'Z']) (x:xs)
drop_caps (x:xs) = dropWhile (\x -> elem x ['A'..'Z']) (x:xs)
split_on c string = let h = (dropWhile (/=c) string) in [(takeWhile (/=c) string), tail h]

mul_lists list1 list2 = zipWith (*) list1 list2
and_lists list1 list2 = zipWith (&&) list1 list2
is_palindrome string = and(zipWith (\x y -> if x==y then True else False) string  (reverse string))
