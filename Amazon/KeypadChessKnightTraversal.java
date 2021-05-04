/*  https://www.youtube.com/watch?v=fbd-TjSqQ3M&t=607s
    You are givien a keypad (example 1-9). Along with it you are given a starting number and a length. A set is taken as how
    a knnight in a chess board would. There are also two places on the keypad which are invalid positions to fall upon. Upon 
    falling on such a place we must not consider that path Find the number of unique paths that is possible with the given 
    starting point.
    
    Example:
        Input:
            Keypad :
                X, 2, 3
                4, X, 6
                7, 8, 9
            Start : 2
            Length : 3
        Output:
            4 (This is because the possible paths of length of 3 are : 276, 292, 294, 272)
*/
import java.util.*;
public class KeypadChessKnightTraversal {
    public int calculateUniquePaths(char[][] keypad, char start, int length) {
        Set<String> res = new HashSet<String>();
        for(int i = 0; i < keypad.length; i++) {
            for(int j = 0; j < keypad[i].length; j++) {
                if(keypad[i][j] == start) {
                    traverse(keypad, res, "", length, i, j);
                    break;
                }
            }
        }
        System.out.println(res);
        return res.size();
    }
    private void traverse(char[][] keypad, Set<String> res, String path, int length, int i, int j) {
        if(i > keypad.length - 1 || i < 0 || j > keypad[0].length - 1 || j < 0 || keypad[i][j] == 'X') {
            return;
        }
        else if (length == 1) {
            path = path + keypad[i][j];
            if(!res.contains(path)) {
                res.add(path);
            }
            return;
        }
        else {
            path = path + keypad[i][j];
            traverse(keypad, res, path, length - 1, i + 2, j + 1);
            traverse(keypad, res, path, length - 1, i + 1, j + 2);
            traverse(keypad, res, path, length - 1, i + 2, j - 1);
            traverse(keypad, res, path, length - 1, i + 1, j - 2);
            traverse(keypad, res, path, length - 1, i - 1, j + 2);
            traverse(keypad, res, path, length - 1, i - 2, j + 1);
            traverse(keypad, res, path, length - 1, i - 2, j - 1);
            traverse(keypad, res, path, length - 1, i - 1, j - 2);
            return;
        }
    }
    public static void main(String[] args) {
        char[][] keypad = {
            {'X','2','3'},
            {'4','X','6'},
            {'7','8','9'}
        };
        KeypadChessKnightTraversal obj = new KeypadChessKnightTraversal();
        System.out.println(obj.calculateUniquePaths(keypad, '2', 3));
    }
}
