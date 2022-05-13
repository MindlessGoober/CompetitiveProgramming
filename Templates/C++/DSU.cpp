#include <bits/stdc++.h>

using namespace std;

template <int N = (int)1E6> class DSU {
  vector<int> e;

public:
  int groupsCount;

  DSU(int n = N) : e(n, -1), groupsCount(n) {}

  int root(int x) { return e[x] < 0 ? x : e[x] = root(e[x]); }

  bool connected(int a, int b) { return root(a) == root(b); }

  int size(int x) { return -e[root(x)]; }

  bool unite(int x, int y) {
    x = root(x), y = root(y);
    if (x == y) {
      return false;
    }

    if (e[x] > e[y]) {
      swap(x, y);
    }

    e[x] += e[y];
    e[y] = x;
    groupsCount--;
    return true;
  }

  vector<vector<int>> groups() {
    int n = e.size();
    vector<vector<int>> result(n);
    for (int i = 0; i < n; i++) {
      result[root(i)].push_back(i);
    }

    result.erase(remove_if(result.begin(), result.end(),
                           [&](const vector<int> &v) { return v.empty(); }),
                 result.end());
    return result;
  }
};