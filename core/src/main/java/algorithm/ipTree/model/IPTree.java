package algorithm.ipTree.model;

/**
 * 用二叉树结构存取和查询IP，节省空间，提高效率。
 * 可用于IP白黑名单，IP获取地理位置等ip相关的信息。
 */
public class IPTree {
    private Element root;
    private IPTree(){
        root = new Element();
    }
    public static IPTree getInstance(){
        return IPTreeHolder.ipTree;
    }

    private static class IPTreeHolder{
        private static IPTree ipTree = new IPTree();
    }

    public Element getRoot() {
        return root;
    }

    public void setRoot(Element root) {
        this.root = root;
    }
}
