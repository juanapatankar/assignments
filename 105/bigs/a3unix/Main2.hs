module Main (get_maze, print_maze, is_wall, place_player, move, can_move, game_loop, get_path, main) where 
-- DEADLINE 13/1/20
import System.Environment

--maze_path = "assignments/105/bigs/a3unix/maze-big-4.txt"
maze_path = "/newpartition/assignments/105/bigs/a3unix/maze4.txt"
--maze_path = "assignments/105/bigs/a3unix/maze4.txt"

-- Useful code from Lecture 25
-- You may use this freely in your solutions

get :: [String] -> Int -> Int -> Char
get maze x y = (maze !! y) !! x 

modify_list :: [a] -> Int -> a -> [a]
modify_list list pos new =
    let
        before = take  pos    list
        after  = drop (pos+1) list
    in
        before ++ [new] ++ after

set :: [String] -> Int -> Int -> Char -> [String]
set maze x y char = 
    let
        line = maze !! y
        new_line = modify_list line x char
        new_maze = modify_list maze y new_line
    in
        new_maze

---- Part A

-- Question 1

get_maze :: String -> IO [String]
get_maze f = do
    maze <- readFile f
    let fmaze = lines maze
    return fmaze

-- Question 2

print_maze :: [String] -> IO ()
print_maze f = putStrLn(unlines f)

-- Question 3

is_wall :: [String] -> (Int, Int) -> Bool
is_wall m (x,y)  = get m x y == '#'  

-- Question 4

place_player :: [String] -> (Int, Int) -> [String]
place_player m (x,y) = set m x y '@'


---- Part B

-- Question 5

move :: (Int, Int) -> Char -> (Int, Int)
move (x,y) c 
    | (c == 'w') = (x, y-1)
    | (c == 'a') = (x-1, y)
    | (c == 's') = (x, y+1)
    | (c == 'd') = (x+1, y)
    | otherwise = (x,y)

-- Question 6

can_move :: [String] -> (Int, Int) -> Char -> Bool
can_move m (x,y) c = not (is_wall m (move (x,y) c))

-- Question 7

game_loop :: [String] -> (Int, Int) -> IO ()
game_loop m (x,y) = do
    print_maze (place_player m (x,y))
    c <- getLine
    let dir = head(c)
    if can_move m (x,y) dir == True then game_loop m (move (x,y) dir) else game_loop m (x,y)
---- Part C

-- Question 8

search :: [String] -> (Int, Int) -> (Int, Int) -> (Int, Int) -> Maybe [(Int, Int)]
search maze target from current 
    | target == current = Just [current]
    | otherwise = path
        where left = move current 'a'
              right = move current 'd'
              up = move current 'w'
              down = move current 's'

              leftPath = if is_wall maze left || left == from then Nothing 
                         else search maze target current left
              rightPath = if is_wall maze right || right == from then Nothing 
                         else search maze target current right
              upPath = if is_wall maze up || up == from then Nothing 
                         else search maze target current up
              downPath = if is_wall maze down || down == from then Nothing 
                         else search maze target current down
 
              path = case (leftPath, rightPath, upPath, downPath) of 
                          (Just p, _, _, _) -> Just (current:p)
                          (_, Just p, _, _) -> Just (current:p)
                          (_, _, Just p, _) -> Just (current:p)
                          (_,_,_,Just p) -> Just (current:p)
                          (_, _, _, _) -> Nothing

searchr :: [String] -> (Int, Int) -> (Int, Int) -> (Int, Int) -> Maybe [(Int, Int)]
searchr maze target from current
    | target == current = Just [current]
    | otherwise = case path of [] -> Nothing
                               [(Just x)] -> Just (current:x)
       where path = filter (/= Nothing)
                  . map (search maze target current)
                  . filter (\x -> not (is_wall maze x) && x /= from)
                  . map (move current) $ "wasd"

get_path :: [String] -> (Int, Int) -> (Int, Int) -> [(Int, Int)]
get_path maze from to = path 
    where Just path = searchr maze to (-1,-1) from 
-- Question 9
plot_path :: [String] -> [(Int, Int)] -> [String]
plot_path maze path = foldl (\acc (x,y) -> set acc x y '.') maze path

main :: IO ()
main = do
    args <- getArgs
    m <- get_maze (args !! 0)
    let (tx, ty) = (length (head m) - 2, length m - 2)
        path = get_path m (1,1) (tx,ty)
    print_maze (plot_path m path) 
   






