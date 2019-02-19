package LC400_04_Tree;

import java.util.*;

/**
 * Created by Gary on 2018-12-28.
 */
public class LC236 {
    /*
     * 找两个节点的公共最低祖先，例如上面的树，5和1的公共最低祖先是3；2和8的公共最低祖先是3；6和4的公共最低祖先是5
     * 自己可以是自己的祖先， 例如5和4的最低公共祖先是5。
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root空，说明该路径上不可能有p或q节点，返回null
        // 如果递归到root恰好就是p或q，那么就没必要继续递归了，因为公共祖先只可能是该节点
        if (root == null || root == p || root == q) return root;
        // 向左子树寻找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 向右子树寻找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 说明p和q分布在左右两侧，返回root即可
        if (left != null && right != null) return root;
        // 若left不空，说明在left分支上找到p或q，返回；否则返回right
        return left != null ? left : right;
    }
    /*其实画图可以看到，如果找6和4的公共最小父亲的时候，
      递归到(5,6,4)left=5已经找到，不用再对右子树进行扫描了。直接终止就行。
      右子树也是。加上判断条件可以提高效率
    */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        // 此处如果递归left 已经是root，直接返回。
        if (left == root) return root;
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        // 此处如果递归right 已经是root，直接返回。
        if (right == root) return root;
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // BFS迭代法
    public TreeNode lowestCommonAncestorBFS(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> mapNodeParent = new HashMap<>();
        mapNodeParent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 一直广搜，把p和q的父节点都存到map中为止
        while (!mapNodeParent.containsKey(p) || !mapNodeParent.containsKey(q)) {
            root = queue.poll();
            if (root != null) {
                mapNodeParent.put(root.left, root);
                mapNodeParent.put(root.right, root);
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        // 把p的所有父亲都找到，放入set中
        Set<TreeNode> parentsOfP = new HashSet<>();
        while (p != null) {
            parentsOfP.add(p);
            p = mapNodeParent.get(p);
        }
        // 找到公共父节点
        while (!parentsOfP.contains(q)) {
            q = mapNodeParent.get(q);
        }
        // 返回
        return q;
    }
}
