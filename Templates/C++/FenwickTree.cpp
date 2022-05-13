#include <bits/stdc++.h>

using namespace std;

int lowest1Bit(int x) { return x & -x; }

template <class T, int... Ns> class BIT {
  T val = 0;

public:
  void update(T v) { val += v; }

  T query() { return val; }
};

template <class T, int N, int... Ns> class BIT<T, N, Ns...> {
  BIT<T, Ns...> bit[N + 1];

public:
  template <typename... Args> void update(int pos, Args... args) {
    for (; pos <= N; pos += lowest1Bit(pos)) {
      bit[pos].update(args...);
    }
  }

  template <typename... Args> T sum(int r, Args... args) {
    T res = 0;
    for (; r >= 1; r -= lowest1Bit(r)) {
      res += bit[r].query(args...);
    }

    return res;
  }

  template <typename... Args> T query(int l, int r, Args... args) {
    return sum(r, args...) - sum(l - 1, args...);
  }
};