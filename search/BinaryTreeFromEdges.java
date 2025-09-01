package tree;

import java.util.*;

/**
 * 간선 쌍 [parent, child] 로 이진 트리를 구성하는 템플릿
 * - 입력은 방향성 있는 간선(부모 → 자식)이라고 가정
 * - 각 노드는 최대 2자식(왼→오 순서로 채움)
 * - 다중 부모/다중 루트/3자식 이상이면 IllegalArgumentException
 */
public class BinaryTreeFromEdges {

    // --------- Node ----------
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { this.val = v; }
    }

    /**
     * 간선 리스트로 이진 트리 구성
     * @param edges 각 원소는 [parent, child]
     * @return 루트 노드
     */
    public static TreeNode buildBinaryTree(int[][] edges) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Map<Integer, Integer> indeg = new HashMap<>(); // 진입차수(부모 수) 체크

        for (int[] e : edges) {
            int p = e[0], c = e[1];
            TreeNode P = nodes.computeIfAbsent(p, TreeNode::new);
            TreeNode C = nodes.computeIfAbsent(c, TreeNode::new);

            // 왼쪽 먼저, 그다음 오른쪽
            if (P.left == null) P.left = C;
            else if (P.right == null) P.right = C;
            else throw new IllegalArgumentException("node " + p + " has > 2 children");

            indeg.put(c, indeg.getOrDefault(c, 0) + 1);
            if (indeg.get(c) > 1) throw new IllegalArgumentException("node " + c + " has multiple parents");
            indeg.putIfAbsent(p, indeg.getOrDefault(p, 0));
        }

        // 루트(진입차수 0) 찾기
        TreeNode root = null;
        for (int v : nodes.keySet()) {
            if (indeg.getOrDefault(v, 0) == 0) {
                if (root != null) throw new IllegalArgumentException("multiple roots detected");
                root = nodes.get(v);
            }
        }
        if (root == null) throw new IllegalArgumentException("root not found");
        return root;
    }

    // --------- 유틸(선택) ----------
    /** 레벨순 출력(검증용) */
    public static void printLevelOrder(TreeNode root) {
        if (root == null) { System.out.println("(empty)"); return; }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        System.out.println();
    }

    // --------- 예시 ----------
    public static void main(String[] args) {
        int[][] pairs = {
            {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
        };
        TreeNode root = buildBinaryTree(pairs);
        System.out.println("root = " + root.val);
        System.out.print("LevelOrder: ");
        printLevelOrder(root);
    }
}
