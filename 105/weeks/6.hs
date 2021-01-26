list_product list = foldr (\x acc -> x * acc) 1 list
list_any list = foldr (\x acc -> if x || acc then True else False) False list
product_of_evens list = foldr (\x acc -> if even x then acc * x else acc) 1 list
lt10 list = foldr (\x acc -> if x < 10 then x:acc else acc) [] list

leading_caps string = takeWhile (\x -> x `elem` ['A'..'Z']) string
drop_caps string = dropWhile (\x -> x `elem` ['A'..'Z']) string
split_on c string = let 
                        remain = takeWhile (/= c) string; 
                        rest = dropWhile (/=c) string
                    in (remain, (tail rest))

mul_lists list1 list2 = zipWith (*) list1 list2
and_lists list1 list2 = zipWith (&&) list1 list2
is_palindrome string = and (zipWith (==) string (reverse string) )
