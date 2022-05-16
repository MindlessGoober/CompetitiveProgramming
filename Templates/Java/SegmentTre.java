abstract class SegmentTree<S> {
  private int offset;
  private S[] t;

  SegmentTree(int n) {
    offset = n;
    t = (S[]) new Object[2 * n];
    Arrays.fill(t, e());
  }

  abstract S op(S a, S b);

  abstract S e();

  void set(int p, final S value) {
    for (t[p += offset] = value; (p /= 2) > 0;) {
      t[p] = op(t[2 * p], t[2 * p + 1]);
    }
  }

  S product(int l, int r) {
    S resl = e(), resr = e();
    for (l += offset, r += offset; l < r; l /= 2, r /= 2) {
      if (l % 2 == 1) {
        resl = op(resl, t[l++]);
      }

      if (r % 2 == 1) {
        resr = op(resr, t[--r]);
      }
    }

    return op(resl, resr);
  }
}
