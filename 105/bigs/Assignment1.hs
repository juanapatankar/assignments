-- Do not alter the following line
module Assignment1 (char_to_int, repeat_char, decode, int_to_char, length_char, drop_char, encode, complex_encode, complex_decode) where


-- Part A
-- Converts a given numerical character into an integer
char_to_int :: Char -> Integer
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

-- Repeats a given character a select number of times
repeat_char :: Char -> Integer -> String
repeat_char c 0 = ""
repeat_char c n = c:"" ++ (repeat_char c (n-1))

-- Decodes a simple repeat encoded string (where a character does not appear more than 9 times consecutively)
decode :: String -> String
decode "" = ""
decode (x:y:xs) = (repeat_char x (char_to_int y)) ++ decode(xs)


-- Part B
-- Converts an integer into a character
int_to_char :: Integer -> Char
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
--

-- Gives the number of times that a character consecutively appears at the start of a given string. If the character is different, this returns 0
length_char :: Char -> String -> Integer
length_char c "" = 0
length_char c (x:xs) = if (c == x) then (length_char c xs) + 1 else 0

-- Gives the remainder of the string after the leading characters are removed if they are the same
drop_char :: Char -> String -> String
drop_char c "" = ""
drop_char c (x:xs) = if (c == x) then drop_char c xs else x:xs

-- Encodes a given string as long as no character appears more than 9 times in a row
encode :: String -> String
encode "" = ""
encode (x:xs) = x:int_to_char((length_char x xs) +1):encode(drop_char x (x:xs))



-- Part C
-- Checks if a character in the given string is a number
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

-- Converts any positive integer into a string
int_to_str 0 = "0"
int_to_str n
  | (n < 10) = int_to_char(n):""
  | otherwise = int_to_str(n `div` 10)++int_to_char(n `mod` 10):""

-- Converts a string of numbers into an integer
str_to_int "" = 0
str_to_int (x:xs)
  | (length(x:xs) == 1) = char_to_int x
  | (length(x:xs) > 1) = char_to_int x * (10 ^ (length xs)) + str_to_int(xs)

-- Encodes any string into the same form as above, except non-repeated characters don't have the 1. The number of repeats is not limited to under 10
complex_encode :: String -> String
complex_encode "" = ""
complex_encode (x:xs)
  | ((length(xs) >= 1) && (x /= head(xs))) = x:complex_encode(xs)
  | ((length(xs) >= 1) && (x == head(xs))) = x:int_to_str((length_char x (x:xs)))++complex_encode(drop_char x (x:xs))
  | (length(x:xs) == 1) = x:xs

-- Splits the encoded string into its individual characters to identify which are numbers and need to be put together to get number of repeats
splitme ("") = []
splitme (x:xs)
  | (is_int x == False) = [x:[]]++splitme(xs)
  | (is_int x == True) = []++[x:""]++splitme(xs)

-- Should have decoded any string but I couldn't figure out how to do it :( so this just returns the last element from the splitme for the encoded string given
complex_decode :: String -> String
complex_decode "" = ""
complex_decode str = splitme(str)!!(length(str)-1)
