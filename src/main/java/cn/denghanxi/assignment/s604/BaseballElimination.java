package cn.denghanxi.assignment.s604;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FlowEdge;

import java.util.ArrayList;
import java.util.List;

/**
 * 预测一支队伍是否数学上与胜利无关
 */
public class BaseballElimination {

    private List<String> teams = new ArrayList<>();
    private int[] wins;
    private int[] losses;
    private int[] remaining;
    private int[][] g;

    public BaseballElimination(String fileName) {
        In in = new In(fileName);
        int teamNum = in.readInt();
        wins = new int[teamNum];
        losses = new int[teamNum];
        remaining = new int[teamNum];
        g = new int[teamNum][teamNum];
        for (int i = 0; i < teamNum; i++) {
            teams.add(in.readString());
            wins[i] = in.readInt();
            losses[i] = in.readInt();
            remaining[i] = in.readInt();
            for (int j = 0; j < teamNum; j++) {
                g[j][i] = in.readInt();
            }
        }
    }

    public int numberOfTeams() {
        return teams.size();
    }

    public Iterable<String> teams() {
        return teams;
    }

    public int wins(String team) {
        if (!teams.contains(team)) throw new IllegalArgumentException("没有该队伍");
        int index = teams.indexOf(team);
        return wins[index];
    }

    public int losses(String team) {
        if (!teams.contains(team)) throw new IllegalArgumentException("没有该队伍");
        int index = teams.indexOf(team);
        return losses[index];
    }

    public int remaining(String team) {
        if (!teams.contains(team)) throw new IllegalArgumentException("没有该队伍");
        int index = teams.indexOf(team);
        return remaining[index];
    }

    public int against(String team1, String team2) {
        if (!teams.contains(team1) || !teams.contains(team2)) throw new IllegalArgumentException("没有该队伍");
        int x = teams.indexOf(team1);
        int y = teams.indexOf(team2);
        return g[x][y];
    }

    public boolean isEliminated(String team) {
        if (!teams.contains(team)) throw new IllegalArgumentException("没有该队伍");
        if (isTrivialEliminate(team)) return true;
        return isNonTrivialEliminate(team);
    }

    public Iterable<String> certificateOfElimination(String team) {
        if (!teams.contains(team)) throw new IllegalArgumentException("没有该队伍");
        if (isTrivialEliminate(team)) {
            List<String> team2 = new ArrayList<>(teams);
            team2.remove(team);
            return team2;
        }
        if (!isNonTrivialEliminate(team)) return null;

        Bag<String> result = new Bag<>();
        FordFulkerson fordFulkerson = ford(team);

        for (int i = 0; i < teams.size(); i++) {
            if (fordFulkerson.inCut(i)) {
                result.add(teams.get(i));
            }
        }
        return result;
    }

    private boolean isTrivialEliminate(String team) {
        int index = teams.indexOf(team);
        int sum = wins[index] + remaining[index];
        for (int i = 0; i < teams.size(); i++) {
            if (sum < wins[i]) return true;
        }
        return false;
    }

    private boolean isNonTrivialEliminate(String team) {
        int xIndex = teams.indexOf(team);
        int xTotal = wins[xIndex] + remaining[xIndex];
        int v = teams.size() + 1 + matchEdgeNum(team);
        FlowNetwork flowNetwork = new FlowNetwork(v);

        for (int i = 0; i < teams.size(); i++) {
            if (i != xIndex) {
                flowNetwork.addEdge(new FlowEdge(i, xIndex, xTotal - wins[i]));
            }
        }
        int cursor = teams.size() + 1;
        for (int j = 0; j < teams.size(); j++) {
            for (int i = 0; i < teams.size(); i++) {
                if (i > j && j != xIndex) {
                    flowNetwork.addEdge(new FlowEdge(teams.size(), cursor, g[i][j]));
                    flowNetwork.addEdge(new FlowEdge(cursor, i, Double.POSITIVE_INFINITY));
                    flowNetwork.addEdge(new FlowEdge(cursor, j, Double.POSITIVE_INFINITY));
                    cursor++;
                }
            }
        }
        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, teams.size(), xIndex);
        Iterable<FlowEdge> edges = flowNetwork.adj(teams.size());
        for (FlowEdge edge : edges) {
            if (edge.residualCapacityTo(edge.other(teams.size())) > 0) return true;
        }
        return false;
    }

    private FordFulkerson ford(String team) {
        int xIndex = teams.indexOf(team);
        int xTotal = wins[xIndex] + remaining[xIndex];
        int v = teams.size() + 1 + matchEdgeNum(team);
        FlowNetwork flowNetwork = new FlowNetwork(v);

        for (int i = 0; i < teams.size(); i++) {
            if (i != xIndex) {
                flowNetwork.addEdge(new FlowEdge(i, xIndex, xTotal - wins[i]));
            }
        }
        int cursor = teams.size() + 1;
        for (int j = 0; j < teams.size(); j++) {
            for (int i = 0; i < teams.size(); i++) {
                if (i > j && j != xIndex) {
                    flowNetwork.addEdge(new FlowEdge(teams.size(), cursor, g[i][j]));
                    flowNetwork.addEdge(new FlowEdge(cursor, i, Double.POSITIVE_INFINITY));
                    flowNetwork.addEdge(new FlowEdge(cursor, j, Double.POSITIVE_INFINITY));
                    cursor++;
                }
            }
        }
        return new FordFulkerson(flowNetwork, teams.size(), xIndex);
    }

    private int matchEdgeNum(String team) {

        int xIndex = teams.indexOf(team);
        int num = 0;
        for (int j = 0; j < teams.size(); j++) {
            for (int i = 0; i < teams.size(); i++) {
                if (i > j && j != xIndex) {
                    num++;
                }
            }
        }
        return num;
    }
}
