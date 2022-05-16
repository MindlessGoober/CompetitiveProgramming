import java.io.*;
import java.util.*;

class Main {
  private static final FastScanner scanner = new FastScanner();
  private static final PrintWriter writer = new PrintWriter(System.out);

  public static void main(String[] args) {
    final int testCases = 1;
    for (int testCase = 1; testCase <= testCases; testCase++) {
      new Main().solve(testCase);
    }

    writer.close();
  }

  void solve(int testCase) {

  }
}

class FastScanner {
  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private StringTokenizer st = new StringTokenizer("");

  String next() {
    while (!st.hasMoreElements())
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }

    return st.nextToken();
  }

  double nextDouble() {
    return Double.parseDouble(next());
  }

  int nextInt() {
    return Integer.parseInt(next());
  }

  long nextLong() {
    return Long.parseLong(next());
  }
}