package Trees.Binary_Search_Tree.AVL_Trees;

class Node { 
	int key, height; 
	Node left, right; 

	Node(int d) { 
		key = d; 
		height = 1; 
	} 
} 

class AVLTree { 

	Node root; 

	int height(Node N) { 
		if (N == null) 
			return 0; 

		return N.height; 
	} 

	int max(int a, int b) { 
		return (a > b) ? a : b; 
	} 

	Node rightRotate(Node z) { 
		Node y = z.left; 
		Node T2 = y.right; 

		// Perform rotation 
		y.right = z; 
		z.left = T2; 

		y.height = max(height(y.left), height(y.right)) + 1; 
		z.height = max(height(z.left), height(z.right)) + 1; 

		return y; 
	} 

	Node leftRotate(Node z) { 
		Node y = z.right; 
		Node T2 = y.left; 

		// Perform rotation 
		y.left = z; 
		z.right = T2; 

		z.height = max(height(z.left), height(z.right)) + 1; 
		y.height = max(height(y.left), height(y.right)) + 1; 

		return y; 
	} 

	int getBalance(Node N) { 
		if (N == null) 
			return 0; 

		return height(N.left) - height(N.right); 
	} 

	Node insert(Node root, int key) { 

		if (root == null) 
			return (new Node(key)); 

		if (key < root.key) 
			root.left = insert(root.left, key); 
		else if (key > root.key) 
			root.right = insert(root.right, key); 
		else  
			return root; 

		root.height = 1 + max(height(root.left), 
							height(root.right)); 

		int balance = getBalance(root); 


		if (balance > 1 && key < root.left.key) 
			return rightRotate(root); 

		if (balance < -1 && key > root.right.key) 
			return leftRotate(root); 

		if (balance > 1 && key > root.left.key) { 
			root.left = leftRotate(root.left); 
			return rightRotate(root); 
		} 

		if (balance < -1 && key < root.right.key) { 
			root.right = rightRotate(root.right); 
			return leftRotate(root); 
		} 

		return root; 
	} 


    Node deleteNode(Node root,int key){
        if(root==null) return null;
        if(root.key>key) 
            root.left=deleteNode(root.left, key);
        else if(root.key<key) 
            root.right=deleteNode(root.right, key);
        else{
            if(root.left==null) 
                return root.right;
            else if(root.right==null) 
                return root.left;
            else{
                Node succ=getSucc(root);
                root.key=succ.key;
                root.right=deleteNode(root.right, succ.key);
            } 
        }
        root.height=Math.max(height(root.left),height(root.right))+1;
        int balance=getBalance(root);

        if(balance>1 && getBalance(root.left)>=0)
            return rightRotate(root);

        if(balance>1 && getBalance(root.left)<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }

        if(balance<-1 && getBalance(root.right)<=0)
            return leftRotate(root);

        if(balance<-1 && getBalance(root.right)>0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    Node getSucc(Node root){
        Node curr=root.right;
        while(curr!=null && curr.left!=null)
            curr=curr.left;
        return curr;
    }

	void inorder(Node root) { 
		if (root != null) { 
            inorder(root.left); 
			System.out.print(root.key + " "); 
			inorder(root.right); 
		} 
	} 

	public static void main(String[] args) { 
		AVLTree tree = new AVLTree(); 

		tree.root = tree.insert(tree.root, 10); 
		tree.root = tree.insert(tree.root, 20); 
		tree.root = tree.insert(tree.root, 30); 
		tree.root = tree.insert(tree.root, 40); 
		tree.root = tree.insert(tree.root, 50); 
		tree.root = tree.insert(tree.root, 25); 

		/* The constructed AVL Tree would be 
			30 
			/ \ 
		20 40 
		/ \	 \ 
		10 25 50 
		*/
		System.out.println("inorder traversal" + 
						" of constructed tree is : "); 
		tree.inorder(tree.root); 
        tree.deleteNode(tree.root, 30);
        System.out.println();
        tree.inorder(tree.root);
	} 
} 
