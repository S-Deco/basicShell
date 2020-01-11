import java.util.LinkedList;

public class DirectoryTree {

    Node root = new Node("/");
    Node current = root;
    
    
    public class Node{
      String value;
      LinkedList<Node> children;
      Node parent;
      
      public Node() {
        children = new LinkedList<Node>();
        parent = null;
      }
      
      public Node(String v) {
        value = v;
        children = new LinkedList<Node>();
        parent = null;
      }
    }
	public boolean mkdir (String name) {
	    for(Node child:current.children) {
	      if(child.value.equals(name)) {
	        return false;
	      }
	    }
	      Node newNode = new Node(name);
          newNode.parent = current;
          current.children.add(newNode);
          return true;
	    
	}
	
	public boolean cd (String name) {
	    for(Node child: current.children) {
	      if(child.value.equals(name)) {
	        current = child;
	        return true;
	      }
	    }
		return false;
	}
	
	public boolean cdUp() {
	    if(current.parent != null) {
	      current = current.parent;
	      return true;
	    }
		return false;
	}
	
	public boolean rmdir (String name) {
	  for(Node child:current.children) {
	    if(child.value.contentEquals(name)) {
	      current.children.remove(child);
	      return true;
	    }
	  }
		return false;
	}

	public String ls () {
	  String ret = "";
	  for(Node child: current.children){
	    ret+= child.value + "\n";
	  }
	  return ret;
	}
	
	public String printSubTree() {
	    
		return __printSubTree(current,0);
	}
	
	private String __printSubTree(Node r, int depth) {
	  String ret = "";
	  int i = 0;
	  while (i < depth) {
	    ret += "  ";
	    i++;
	  }
	  if(r.value != "/") {
	    ret+= r.value + "\n";
	  }
	  else {
	    ret+="\n";
	  }
	  for(Node child: r.children) {
	    ret+= __printSubTree(child,depth + 1);
	  }
	  return ret;
	}
	
	public String pwd () {
	    Node pwdNode = current;
	    String ret = "/";
	    if(pwdNode.equals(root)) {
	      return ret;
	    }
	    ret = "";
	    while(!pwdNode.equals(root)) {
	        ret = "/" + pwdNode.value + ret;
	        pwdNode = pwdNode.parent;
	    }
	    
		return ret;
	}
	
	public int numNodes() {
		int num = 1;
		for(Node child:current.children) {
		  num+= 1 + __numNodes(child);
		  
		}
		return num;
	}
	private int __numNodes(Node r) {
	  int num = 0;
	  for(Node child:r.children) {
	    if(child != null) {
	      num+= 1 + __numNodes(child);
	    }
	  }
	  return num;
	}
}
