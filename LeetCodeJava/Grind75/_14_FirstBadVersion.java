package Grind75;

public class _14_FirstBadVersion {
    private int badVersion;

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    // Solution
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int result = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(isBadVersion(mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _14_FirstBadVersion obj = new _14_FirstBadVersion();

        obj.setBadVersion(4);
        System.out.println(obj.firstBadVersion(5));

        obj.setBadVersion(1);
        System.out.println(obj.firstBadVersion(1));

        obj.setBadVersion(1702766719);
        System.out.println(obj.firstBadVersion(Integer.MAX_VALUE));
    }

}

