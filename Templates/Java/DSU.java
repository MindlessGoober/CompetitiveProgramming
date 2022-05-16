class DSU {
  private int[] e;
  int groupsCnt;

  DSU(int n) {
    e = new int[n];
    Arrays.fill(e, -1);
    groupsCnt = n;
  }

  int root(int x) {
    return (e[x] < 0) ? x : (e[x] = root(e[x]));
  }

  boolean connected(int a, int b) {
    return root(a) == root(b);
  }

  boolean unite(int x, int y) {
    x = root(x);
    y = root(y);
    if (x == y) {
      return false;
    }

    if (e[x] > e[y]) {
      e[x] = e[x] ^ e[y] ^ (e[y] = e[x]);
    }

    e[x] += e[y];
    e[y] = x;
    groupsCnt--;
    return true;
  }

  int[][] groups() {
    int n = e.length;
    List<Integer>[] groups = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      groups[root(i)].add(i);
    }

    List<Integer> roots = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (groups[i].size() > 0) {
        roots.add(i);
      }
    }

    int[][] result = new int[roots.size()][];
    int i = 0;
    for (int root : roots) {
      int m = groups[root].size();
      result[i] = new int[m];
      for (int j = 0; j < m; j++) {
        result[i][j] = groups[root].get(j);
      }

      i++;
    }

    return result;
  }
}
