package tryingProject;

import java.util.*;

public class ProductTree {
    TreeNode root;

    public ProductTree() {
        root = new TreeNode("root", 0);
    }

    public void takeNewOrder(ArrayList<String> order) {
        Collections.sort(order);
        TreeNode current = root;

        for (String product : order) {
            if (!current.getProducts().containsKey(product)) {
                TreeNode newProductNode = new TreeNode(product, 0);
                current.getProducts().put(product, newProductNode);
            }

            current = current.getProducts().get(product);
            current.setCountByIncreasing();
        }
    }

    public void removeProducts(ArrayList<String> list) {
        Collections.sort(list);
        System.out.println("If the order " + list + " is cancelled:");
        removeProductsRecursive(root, list, 0);
        printTree(); // Güncellenmiş ağacı yazdır
    }

    private boolean removeProductsRecursive(TreeNode current, ArrayList<String> list, int index) {
        if (index >= list.size()) return false;

        String product = list.get(index);
        if (!current.getProducts().containsKey(product)) return false;

        TreeNode child = current.getProducts().get(product);
        boolean shouldRemove = removeProductsRecursive(child, list, index + 1);

        // Eğer bu düğüm ya da alt düğümleri kaldırılması gerekiyorsa, sayaç azaltılır
        child.setCountByDecreasing();
        if (child.getCount() == 0) {
            current.getProducts().remove(product); // Sayaç sıfırsa düğümü sil
        } else if (shouldRemove) {
            return current.getProducts().isEmpty();
        }

        return false;
    }

    public int queryProductSet(List<String> products) {
        return queryRecursive(root, products, 0);
    }

    private int queryRecursive(TreeNode current, List<String> products, int index) {
        if (index == products.size()) {
            return current.getCount();
        }
        String product = products.get(index);
        int sum = 0;
        for (Map.Entry<String, TreeNode> entry : current.getProducts().entrySet()) {
            if (entry.getKey().equals(product)) {
                sum += queryRecursive(entry.getValue(), products, index + 1);
            }
        }
        return sum;
    }
    public void printTree() {
        System.out.println("Output (Current Tree):");
        System.out.println("      root");
        root.printTree();
}
}