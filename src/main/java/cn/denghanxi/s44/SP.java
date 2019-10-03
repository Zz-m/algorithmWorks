package cn.denghanxi.s44;

/**
 * Created by dhx on 2018/7/4.
 * single-source shortest path API
 */
public interface SP {

    /**
     * 到v点距离（权重和）
     * @param v 点v
     * @return 权重和
     */
    double distTo(int v);

    /**
     * 是否有到v点的路径
     * @param v 点v
     * @return 是否存在路径
     */
    boolean hasPathTo(int v);

    /**
     * 到v点的路径
     * @param v v点
     * @return 路径
     */
    Iterable<DirectedEdge> pathTo(int v);


}
