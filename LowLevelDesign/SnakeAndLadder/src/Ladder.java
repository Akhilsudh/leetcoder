public class Ladder {
    int start;
    int end;

    public Ladder(int start, int end) {
        if(start >= end || start > 100 || start < 0 || end < 0 || end > 100) {
            throw new RuntimeException("Ladder has invalid start and end point");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
