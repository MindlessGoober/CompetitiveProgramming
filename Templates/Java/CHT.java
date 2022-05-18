class Line implements Comparable<Line> {
  long m, c;

  Line(long m, long c) {
    this.m = m;
    this.c = c;
  }

  @Override
  public int compareTo(Line line) {
    return Long.compare(m, line.m);
  }

  long eval(long x) {
    return m * x + c;
  }
}

class CHT {
  private Line[] hull;
  final private long OO = Long.MAX_VALUE;
  private int lPtr = 0, rPtr = 0;

  CHT(int sz) {
    hull = new Line[sz];
    for (int i = 0; i < sz; i++) {
      hull[i] = new Line(0, 0);
    }
  }

  long div(long a, long b) {
    long res = a / b;
    if ((a ^ b) < 0 && a % b != 0) {
      res--;
    }

    return res;
  }

  long intersectAt(Line l0, Line l1) {
    if (l0.m == l1.m) {
      return l0.c > l1.c ? OO : -OO;
    }

    return div(l1.c - l0.c, l0.m - l1.m);
  }

  void add(long m, long c) {
    Line line = new Line(m, c);
    while (rPtr - lPtr >= 2 && intersectAt(line, hull[rPtr - 1]) < intersectAt(hull[rPtr - 1], hull[rPtr - 2])) {
      rPtr--;
    }

    hull[rPtr++] = line;
  }

  long query(long x) {
    while (rPtr - lPtr >= 2 && hull[lPtr].eval(x) >= hull[lPtr + 1].eval(x)) {
      lPtr++;
    }

    return hull[lPtr].eval(x);
  }
}
