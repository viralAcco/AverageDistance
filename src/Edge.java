class Edge {
    int src;
    int dst;
    int wt;
    Edge(int src, int dst, int wt) {
        this.src = src;
        this.dst = dst;
        this.wt = wt;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", dst=" + dst +
                ", wt=" + wt +
                '}';
    }
}
