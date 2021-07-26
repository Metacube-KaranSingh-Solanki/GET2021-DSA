package linkedlist;

/**
 * Defines the structure to store terms
 */
class MultiNode{
	int degree;
	String variate;
	MultiNode next;
	
	 MultiNode(String variant, int degree) {
		this.degree = degree;
		this.variate = variant;
		next = null;
	}
}

/**
 * Implement multivariate polynomial
 */
public class MultiVariatePolynomial {
	LinkedList<MultiNode> multiVarPolynomial = new LinkedList<>();
	
	/** Add term to the list
	 * @param term String array where index define degree
	 */
	public void addMVP(String[] term) {
		if(term.length<=0)
			throw new AssertionError("Wrong Term");
		
		MultiNode multiNode = null, nextNode,node=null;
		if(term[0].equals("0")) return;
		
		for (int i = 0; i < term.length; i++) {
			if(term[i].equals("0")) continue;
			if(multiNode==null) {
				nextNode =  new MultiNode(term[i], i);
				node=nextNode;
				multiNode = nextNode;
			}else {
				nextNode =  new MultiNode(term[i], i);
				multiNode.next = nextNode;
				multiNode = nextNode;
			}	
		
		}
		multiVarPolynomial.append(node);
	}
	
	/**
	 * Print the list
	 */
	public void printList() {
		Node<MultiNode> node = multiVarPolynomial.getHead();
		while(node!=null) {
			MultiNode tempNode = node.data;
			while (tempNode != null) {
				System.out.print(tempNode.variate + "^" + tempNode.degree + " ");
				tempNode = tempNode.next;
			}
			node = node.next;
			System.out.println();
		}
	}
	
	/**
	 * Calculate the maximum degree of the give polynomial for E.g. (x^2y + y^2) >> max degree will be 2+1 = 3
	 * @return highest degree
	 */
	public int calculateMaxDegree() {
		if( multiVarPolynomial.getHead()==null)
			throw new AssertionError("List is Empty");
		Node<MultiNode> node = multiVarPolynomial.getHead();
		int max=0, sum=0;
		while(node!=null) {
			sum=0;
			MultiNode tempNode = node.data;
			while (tempNode != null) {
				sum +=tempNode.degree;
				tempNode = tempNode.next;
			}
			node = node.next;
			max = max<sum? sum:max;
		}
		return max;
	}
	
} 
