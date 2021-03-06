package me.zhyx.base;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author: yx.zh
 * @date: 2020-07-07 02:07
 **/
public class TreeNode {
    private String data;
    public List<TreeNode> children = new LinkedList<>();

    public TreeNode(String data) {
        this.data = data;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public Optional<String> getData() {
        return (null == this.data) ? Optional.empty() : Optional.of(this.data);
    }

}

final class TreeUtil {
    private TreeUtil() {
    }

    public static void main(String[] args) {
        String text =
                "1\n"
                        + "\t1.1\n"
                        + "\t\t1.1.1\n"
                        + "\t\t1.1.2\n"
                        + "\t1.2"
                        + "2\n"
                        + "\t2.1";

        TreeUtil.stringToTree(text);
    }

    /**
     * 根据规则将String转换为树（森林），
     * 假设text始终合法（非空且合乎规则）。
     */
    public static List<TreeNode> stringToTree(final String text) {


        //TODO: 实现此方法
        String[] treeNodeStr = text.split("\n");
        List<TreeNode> rootNode = findChildren(treeNodeStr);
        return rootNode;
    }

    private static List<TreeNode> findChildren(String[] treeNodeStr) {
        ArrayList<TreeNode> rootTreeNodes = new ArrayList<TreeNode>();
        TreeNode currentTreeNode = new TreeNode("");

        for (String s : treeNodeStr) {

            if (s.indexOf("\t") > 1) {
                //判断缩进的大小，变换层级关系。递增则子级，变小则父级。
                currentTreeNode.getChildren().add(new TreeNode(s.substring(s.indexOf(".") + 1)));
            } else {
                TreeNode rootTreeNode = new TreeNode(s);
                rootTreeNode.children = new ArrayList<>();
                rootTreeNodes.add(rootTreeNode);
                currentTreeNode = rootTreeNode;
            }
        }

        return null;
    }

    private static List<TreeNode> findRootNode(String[] treeNodeStr) {
        ArrayList<TreeNode> rootNode = new ArrayList<>();
        Arrays.stream(treeNodeStr).forEach(item -> {
            if (!item.contains("\t")) {
                TreeNode treeNode = new TreeNode(item);
                rootNode.add(treeNode);
            }
        });
        return rootNode;
    }

    /**
     * 根据规则将树（森林）转为String，
     * 假设tree始终非空。
     */
    public static String treeToString(List<TreeNode> tree) {
        //TODO: 实现此方法
        return null;
    }

    /**
     * 查找树（森林）中所有满足断言的节点的路径，
     * 假设tree始终非空。
     */
    public static List<String[]> findAllPaths(
            List<TreeNode> tree,
            Predicate<Optional<String>> action) {
        //TODO: 实现此方法
        return null;
    }

}
