char_to_int :: Char -> Integer
char_to_int '0' = 0
char_to_int '1' = 1
char_to_int '2' = 2
char_to_int '3' = 3
char_to_int '4' = 4
char_to_int '5' = 5
char_to_int '6' = 6
char_to_int '7' = 7
char_to_int '8' = 8
char_to_int '9' = 9

repeat_char :: Char -> Integer -> String
repeat_char c 0 = ""
repeat_char c n = c:repeat_char c (n-1)

decode "" = ""
decode (x:y:xz) = repeat_char x (char_to_int y) ++ decode xz

int_to_char 0 = '0'
int_to_char 1 = '1'
int_to_char 2 = '2'
int_to_char 3 = '3'
int_to_char 4 = '4'
int_to_char 5 = '5'
int_to_char 6 = '6'
int_to_char 7 = '7'
int_to_char 8 = '8'
int_to_char 9 = '9'

length_char c [] = 0
length_char c (x:y:z) = if x == c then 1 + length_char c (y:z) else 0

drop_char c [] = []
drop_char c (x:xs) = if c == x then drop_char c xs else x:xs

encode [] = ""
encode (x:y:xs) = x:int_to_char (length_char x (x:y:xs)): encode (drop_char x (y:xs))
