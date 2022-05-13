#include <bits/stdc++.h>

using namespace std;

template <class S, S (*op)(S, S), int N = (int)1E6> class SegmentTree {
  int offset;
  vector<S> t;

public:
  SegmentTree(int n = N) : offset(n), t(2 * n) {}

  void set(int p, const S &value) {
    for (t[p += offset] = value; p /= 2;) {
      t[p] = op(t[2 * p], t[2 * p + 1]);
    }
  }

  S product(int l, int r) {
    S resl = S(), resr = S();
    for (l += offset, r += offset; l < r; l /= 2, r /= 2) {
      if (l & 1) {
        resl = op(resl, t[l++]);
      }

      if (r & 1) {
        resr = op(resr, t[--r]);
      }
    }

    return op(resl, resr);
  }
};