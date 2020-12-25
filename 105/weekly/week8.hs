echo :: IO ()
echo = do
  str <- getLine
  putStrLn str
double_echo = do
  x <- getLine
  putStrLn(x++x)
put_two_strs x y = putStrLn(x ++ "\n" ++ y)
--echo

times_two = do
  x <- getLine
  let int = read x :: Int
  return (int*2)

add = do
  x <- getLine
  let int1 = read x :: Int
  y <- getLine
  let int2 = read y :: Int
  return (int1+int2)

guess_42 = do
  x <- getLine
  let num = read x :: Int
  if num == 42 then putStrLn("correct") else putStrLn("wrong")

get_bool :: IO Bool
get_bool = do
  b <- getLine
  let bool = read b :: Bool
  return bool

get_two_and_add :: IO Int
get_two_and_add = add

get_two_strings :: IO (String, String)
get_two_strings = do
  x <- getLine
--  let str1 = read x :: String
  y <- getLine
--  let str2 = read y :: String
--  putStrLn(x++ "\n" ++ y)
  return (x, y)

add_one_forever = do
  x <- getLine
  let xy = read x :: Int
  print(xy+1)
  add_one_forever

echo_until_quit :: IO ()
echo_until_quit = do
  x <- getLine
  print x
  echo_until_quit

print_numbers_between :: Int -> Int -> IO ()
print_numbers_between a b = do
  print(a)
  if (a==b) then return() else  print_numbers_between (a+1) b
  -- | otherwise = print(a+1) -- ++ putStrLn(print_numbers_between (a+1) b)
