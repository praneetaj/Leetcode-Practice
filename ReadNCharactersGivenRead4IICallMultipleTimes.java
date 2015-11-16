package leetcodePractice;

/*
Difficulty: Hard
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, 
it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

Note:
The read function may be called multiple times.
 */

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class ReadNCharactersGivenRead4IICallMultipleTimes {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     
    public char[] internalBuf;
    public int internalCnt;
    public int offset;
    public Solution() {
        internalBuf = new char[4];
        internalCnt = 0;
        offset = 0;
    }
    public int read(char[] buf, int n) {
        if (n == 0)
            return 0;
        boolean eof = false;
        int cnt, currCnt, start;
        cnt = currCnt = start = 0;
        while (!eof && cnt<n) {
            if (internalCnt > 0) {
                currCnt = internalCnt;
                start = offset;
                internalCnt = 0;
            } else {
                internalBuf = new char[4];
                currCnt = read4(internalBuf);
                start = offset = 0;
                if (currCnt < 4)
                    eof = true;
            }
            int itemsToCopy = Math.min(n-cnt, currCnt);
            if (currCnt >= n-cnt) {
                internalCnt = currCnt - itemsToCopy;
                if (internalCnt == 0)
                    offset = 0;
                else
                    offset = offset + itemsToCopy;
            }
            if (itemsToCopy == 0)
                eof = true;
            System.arraycopy(internalBuf, start, buf, cnt, itemsToCopy);
            cnt = cnt + itemsToCopy;
        }
        return cnt;
    }   
}
