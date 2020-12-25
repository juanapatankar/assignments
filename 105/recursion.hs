char_to_int '1' = 1
char_to_int '2' = 2
char_to_int '3' = 3
char_to_int '4' = 4
char_to_int '5' = 5
char_to_int '6' = 6
char_to_int '7' = 7
char_to_int '8' = 8
char_to_int '9' = 9
char_to_int '0' = 0

repeat_char c 0 = ""
repeat_char c n = c:"" ++ (repeat_char c (n-1))

decode "" = ""
decode (x:y:xs) = (repeat_char x (char_to_int y)) ++ decode(xs)

int_to_char 1 = '1'
int_to_char 2 = '2'
int_to_char 3 = '3'
int_to_char 4 = '4'
int_to_char 5 = '5'
int_to_char 6 = '6'
int_to_char 7 = '7'
int_to_char 8 = '8'
int_to_char 9 = '9'
int_to_char 0 = '0'

length_char c "" = 0
length_char c (x:xs) = if (c == x) then (length_char c xs) + 1 else 0

drop_char c "" = ""
drop_char c (x:xs) = if (c == x) then drop_char c xs else x:xs

encode "" = ""
encode (x:xs) = x:int_to_char((length_char x xs) +1):encode(drop_char x (x:xs))

is_int n
  | (n=='1') = True
  | (n=='2') = True
  | (n=='3') = True
  | (n=='4') = True
  | (n=='5') = True
  | (n=='6') = True
  | (n=='7') = True
  | (n=='8') = True
  | (n=='9') = True
  | (n=='0') = True
  | otherwise = False

-- str_to_int n
--   | (n=="1") = "1"
--   | (n=="2") = 2
--   | (n=="3") = 3
--   | (n=="4") = 4
--   | (n=="5") = 5
--   | (n=="6") = 6
--   | (n=="7") = 7
--   | (n=="8") = 8
--   | (n=="9") = 9
--   | (n=="0") = 0
--   | otherwise = ""


-- str_to_int "1" = 1
-- str_to_int "2" = 2
-- str_to_int "3" = 3
-- str_to_int "4" = 4
-- str_to_int "5" = 5
-- str_to_int "6" = 6
-- str_to_int "7" = 7
-- str_to_int "8" = 8
-- str_to_int "9" = 9
-- str_to_int "0" = 0

-- complex_encode (x:y:xs)
--   | (x/=y) = x:complex_encode(drop_char x (x:y:xs))
--   | (x==y) = x:show((length_char x (x:y:xs)))++complex_encode(drop_char x (x:y:xs))
--   | otherwise = ""

-- check_diff str
--   | (length str == 1) = ""
--   | (head(str) == str !! 1) = "same"
--   | (head(str) /= str !! 1) = "diff"
--
--
-- complex_encode "" = ""
-- complex_encode (x:xs)
--   | (check_diff x:xs == "diff") = x:complex_encode(xs)
--   | (xs == "") = ""
--   | otherwise = x:show((length_char x (x:xs)))++complex_encode(drop_char x (x:xs))


int_to_str 0 = "0"
int_to_str n
  | (n < 10) = int_to_char(n):""
  | otherwise = int_to_str(n `div` 10)++int_to_char(n `mod` 10):""

complex_encode "" = ""
complex_encode (x:xs)
  | ((length(xs) >= 1) && (x /= head(xs))) = x:complex_encode(xs)
  | ((length(xs) >= 1) && (x == head(xs))) = x:int_to_str((length_char x (x:xs)))++complex_encode(drop_char x (x:xs))
  | (length(x:xs) == 1) = x:xs

str_to_int "" = 0
str_to_int (x:xs)
  | (length(x:xs) == 1) = char_to_int x
  | (length(x:xs) > 1) = char_to_int x * (10 ^ (length xs)) + str_to_int(xs)

-- generate_number (x:"") "" = []
-- generate_number (x:xs)
--   | (is_int(head(xs)) == True) = x:head(xs):generate_number(tail(xs))
--   | otherwise = x:[]
--
-- complex_repeat (x:"") = x:""
-- complex_repeat (x:xs)
--   | (is_int(head(xs)) == True) = repeat_char('a' 12)
--
-- complex_decode (x:"") = x:""
-- complex_decode (x:xs)
--   -- You already know the first character is a letter
--   -- See if the second character head(xs) is the next letter or is a number
--   -- If it is a letter, don't repeat
--   | (is_int(head(xs)) == False) = x:complex_decode(xs)
--   -- If it is a number, see if the number after it is also a number. Also start repeating (big chuuunnkkk!)
--   -- This can be done by passing the REST of the string after the initial letter to generate_number
--   | (is_int(head(xs)) == True)
--     |
--
-- --complex_decode "" = ""
-- --complex_decode (x:xs) = (repeat_char x (generate_number xs)) ++ complex_decode(xs)

-- store_number "" = ""
-- store_number (x:xs)
--   | (is_int x == True) = x:store_number(xs)
--   | otherwise = x:""
-- --
-- complex_decode (x:"") = ""
-- complex_decode (x:xs)
-- --   | ( (is_int(x) == False) && (is_int(head(xs)) == False)) = x:complex_decode(xs)
--   | ( (is_int(x) == False) && (is_int(head(xs)) == True)) = complex_decode(xs)
--     | ( (is_int(x) == True) && (is_int(head(xs)) == True))
--
-- splitting "" = []
-- splitting (x:xs)
--   | (is_int x == False) = x:""

-- complex_decode "" = ""
-- complex_decode (x:y:xs)
--   | ((is_int x == False) and (is_int y == True)) = x:complex_decode(y:xs)
--   | ((is_int x == True) and (is_int y == True)) = x:complex_decode(y:xs)
--   | ((is_int x == True) and (is_int y == False)) = x:repeat_char(x str_to_int(reverse complex_decode(y:xs))):""

--
-- complex_decode "" = ""
-- complex_decode(x:y:xs)
--   | (is_int x == False) if ((is_int y) && (is_int(head xs))) then (x:y:head(xs):complex_decode(tail xs)) else if ((is_int y) && (is_int(head xs) == False)) then (x:y:complex_decode(xs)) else ""
--   | otherwise = x:""
splitme ("") = []
splitme (x:xs)
  | (is_int x == False) = [x:[]]++splitme(xs)
  | (is_int x == True) = []++[x:""]++splitme(xs)
-- complex_decode "" = ""
-- complex_decode (x:y:xs)
--   | (is_int x == False) = x:complex_decode(y:xs)
--   | (is_int x == True) = if (is_int (y == True) then (x:y:complex_decode(xs)) else complex_decode(xs)
--   | otherwise = repeat_char(x str_to_int(y:complex_decode(xs)))
complex_decode "" = ""
complex_decode str = splitme(str)!!(length(str)-1)
