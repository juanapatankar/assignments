data Direction = North | East | South | West deriving (Show, Eq, Read, Ord)
is_north :: Direction -> Bool
is_north x = if x == North then True else False
dir_to_int :: Direction -> Int
dir_to_int x
  | is_north x = 1
  | x == East = 2
  | x == South = 3
  | x == West = 4

data Point = Point Int Int deriving (Show, Eq)
same :: Int -> Point
same x = Point x x
is_zero :: Point -> Bool
is_zero x = if (x== same 0) then True else False

mult_point :: Point -> Int
mult_point (Point x y) = x * y
up_two :: Point -> Point
up_two (Point x y) = Point x (y + 2)

add_points :: Point -> Point -> Point
add_points (Point x y) (Point xx yy) = Point (x+xx) (y+yy)

-- data Maybe a = Just a | Nothing
not_nothing :: Eq a => Maybe a -> Bool
not_nothing Nothing = False
not_nothing x = True

mult_maybe :: Maybe Int -> Maybe Int -> Maybe Int
mult_maybe (Just x) (Just y) = Just (x*y)
mult_maybe x y = Nothing

return_two :: Int -> Either Bool Char
return_two 1 = Left True
return_two _ = Right 'a'

show_right :: Either String Int -> String
show_right (Left x) = x
show_right (Right y) = show y
