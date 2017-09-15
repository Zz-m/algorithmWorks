package s41;

/**
 * 搜索起点s与其连通的所有顶点
 */
public interface Search {


    /**
     * 一个顶点是否与起点连通
     *
     * @param v 该顶点
     * @return 是否与起点连通
     */
    boolean marked(int v);

    /**
     * 与起点连通的顶点数
     *
     * @return 连通的顶点数
     */
    int count();

}
