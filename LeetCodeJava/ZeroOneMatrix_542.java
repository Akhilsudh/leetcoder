//import java.util.*;
//public class ZeroOneMatrix_542 {
//    public int[][] updateMatrix(int[][] mat) {
//        int [][] out = new int[mat.length][mat[0].length];
//        Set<Integer[]> set = new HashSet<>();
//        for(int i = 0; i < mat.length; i++) {
//            for(int j = 0; j < mat[i].length; j++) {
//                if(mat[i][j] == 1) {
//                    out[i][j] = Integer.MAX_VALUE;
//                    set.add(new Integer[] {i, j});
//                }
//            }
//        }
//        recurseHelper(mat, out, set);
//    }
//
//    private void recurseHelper(int[][] mat, int[][] out, Set<Integer[]> set) {
//        for(Integer[] item: set) {
//
//        }
//    }
//}
