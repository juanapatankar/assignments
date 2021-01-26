mult13 1 = 13
mult13 n = 13 * mult13 (n-1)

pow3 0 = 1
pow3 n = 3 * pow3 (n-1)

odd_sum 1 = 1
odd_sum n = if even n then (n-1) + odd_sum(n-2) else n + odd_sum (n-2)

lucas 0 =2
lucas 1 = 1
lucas n = lucas (n-1) + lucas (n-2)

half_sum [] = 0
half_sum (x:xs) = (x/2) + half_sum xs

mult2 [x] = [x*2]
mult2 (x:xs) = (x*2):mult2 xs

drop_evens [] = []
drop_evens [x] = [x]
drop_evens (x:xs) = [x] ++ drop_evens xs

mult_adjacent [] = []
mult_adjacent [x] = [x]
mult_adjacent (x:y:xs) = (x*y):mult_adjacent xs

get_ele 1 list  = head list
get_ele _ [] = error "not enough"
get_ele i (x:xs) = get_ele (i-1) xs

drop_ele _ [] = error "not enough"
drop_ele 1 (x:xs)  = xs
drop_ele i (x:xs) = x: drop_ele(i-1) xs
div_list [] [] = []
div_list (x:xs) (y:ys) = (x/y): div_list xs ys

longer [] [] = False
longer [] _ = False 
longer _ [] = True
longer (x:xs) (y:ys) = longer xs ys

vowels_and_consonants "" = ("","")
vowels_and_consonants (x:xs)
    | (x `elem` "aeiou") = (x:vowels, consonants)
    | otherwise = (vowels, x:consonants)
    where (vowels, consonants) = vowels_and_consonants xs
