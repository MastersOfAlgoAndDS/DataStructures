package EPI;

public class Problem_9_2_Inorder_With_Parent_Pointer {

	private class TreeNode<T> {
		TreeNode<T> left;
		TreeNode<T> right;
		TreeNode<T> parent;
		T value;

		/**
		 * @param left
		 * @param right
		 * @param parent
		 * @param value
		 */
		public TreeNode(T value) {
			super();
			this.left = null;
			this.right = null;
			this.parent = null;
			this.value = value;
		}

		public TreeNode<T> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		public TreeNode<T> getRight() {
			return right;
		}

		public void setRight(TreeNode<T> right) {
			this.right = right;
		}

		public TreeNode<T> getParent() {
			return parent;
		}

		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "TreeNode [left=" + left + ", right=" + right + ", parent="
					+ parent + ", value=" + value + "]";
		}

	}

	public static void inorderTraversal(TreeNode<Integer> root) {
		if (root == null)
			return;
		TreeNode<Integer> curr, prev = null, next;
		curr = root;

		if (prev != null && (prev.getLeft() == curr || prev.getRight() == curr)) {
			if (curr.getLeft() != null) {
				next = curr.getLeft();
			} else {
				System.out.println(curr.getValue() + " ");
				next = (curr.getRight() != null ? curr.getRight() : curr
						.getParent());
			}
		} else if (curr.getLeft() == prev) {
			System.out.println(curr.getValue() + " ");
			next = (curr.getRight() != null ? curr.getRight() : curr
					.getParent());
		} else {
			next = curr.getParent();
		}

		prev = curr;
		curr = next;

	}

	public static void main(String[] args) {
		Problem_9_2_Inorder_With_Parent_Pointer s = new Problem_9_2_Inorder_With_Parent_Pointer();
		TreeNode<Integer> root = s.new TreeNode<Integer>(1);
		TreeNode<Integer> lc = s.new TreeNode<Integer>(2);
		TreeNode<Integer> rc = s.new TreeNode<Integer>(2);
		lc.setParent(root);
		rc.setParent(root);
		root.setLeft(lc);
		root.setRight(rc);
		inorderTraversal(root);
	}
}
