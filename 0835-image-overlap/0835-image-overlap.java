class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int largestOverlap=0;
        for(int row=-img1.length+1;row<img1.length;row++)
            for(int col=-img1.length+1;col<img1.length;col++)
                largestOverlap=Math.max(largestOverlap,overlapsone(img1,img2,row,col));
        return largestOverlap;
    }
    private  int overlapsone(int[][] img1, int[][]img2,int rowoff,int coloff){
        int count=0;
        for(int row=0;row<img1.length;row++){
            for(int col=0;col<img1[0].length;col++){
                if((row+rowoff<0||row+rowoff>=img1.length)||(col+coloff<0||col+coloff>=img1[0].length))
                    continue;
                if(img1[row][col]+img2[row+rowoff][col+coloff]==2)
                    count++;
            }
        }
        return count;
    }
}
