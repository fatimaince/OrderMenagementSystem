
package tryingProject;
	import java.util.*;
	/**
	 *
	 * @author February12
	 */
	public class TreeNode {
	    private String productName;
	    private int count;
	    private HashMap<String,TreeNode>products;
	    public TreeNode(String productName,int count){
	        this.count=count;
	        this.productName=productName;
	        this.products=new HashMap<>();
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public int getCount() {
	        return count;
	    }
	    public void setCountByIncreasing(){
	        count++;
	    }
	    public void setCountByDecreasing(){
	        count--;
	    }

	    public HashMap<String, TreeNode> getProducts() {
	        return products;
	    }
	  
	    public void printTree() {
	    printTreeMain("  ", true);  
	}

	private void printTreeMain(String prefix, boolean isLast) {
	    if (!productName.equals("root")) {
	        System.out.println(prefix + (isLast ? "+--" : "|--") + productName + " (" + count + ")");
	    }

	    List<TreeNode> children = new ArrayList<>(products.values());
	    for (int i = 0; i < children.size(); i++) {
	        children.get(i).printTreeMain(prefix + (isLast ? "    " : "|  "), i == children.size() );
	 
            }
        }
        }

