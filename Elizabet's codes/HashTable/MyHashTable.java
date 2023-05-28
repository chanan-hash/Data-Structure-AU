package HashTable;

public class MyHashTable {
	private final HashNode[]  nodes;
	public MyHashTable(int size){
		nodes = new HashNode[size];
	}

	private int getIndex(String key){
		int index = key.hashCode() % nodes.length;
		if (index < 0)
			index = index + nodes.length;
		return index;
	}

	public Integer insert(String key, Integer data){
		Integer ans = null;
		int index = getIndex(key);
		HashNode node=nodes[index];
		boolean found = false;
		for (; !found && node!=null; node=node.next) {
			if (key.equals(node.key)) {
				Integer oldData = node.data;
				node.data = data;
				ans = oldData;
				found = true;
			}
		}
		if (!found){
			node = new HashNode(key, data, nodes[index]);
			nodes[index] = node;
		}
		return ans;
	}

	public Integer remove(String key){
		int index = getIndex(key);
		Integer ans = null;
		HashNode prev = null, node = nodes[index];
		boolean found = false;
		for (; !found && node != null; prev = node, node = node.next) {
			if (key.equals(node.key)) {
				if (prev != null)
					prev.next = node.next;
				else
					nodes[index] = node.next;
				ans = node.data;
				found = true;
			}
		}
		return ans;
	}

	public Integer get(String key){
		HashNode node;
		Integer value = null;
		int index = getIndex(key);
		for (node = nodes[index]; node != null; node = node.next) {
			if (key.equals(node.key))
				value =  node.data;
		}
		return value;
	}

	public String toString(){
		String ans = "[";
		for (int i=0; i<nodes.length; i++){
			if (nodes[i]!=null){
				HashNode node = nodes[i];
				while (node != null){
					ans = ans + node.toString()+"; " ;
					node = node.next;
				}
				ans = ans + "\n";
			}
		}
		return ans + "]\n";
	}
	public static void main(String[] args) {
		MyHashTable ht = new MyHashTable(3);
		ht.insert("a", 1);
		ht.insert("b", 2);
		ht.insert("c", 3);
		ht.insert("d", 4);
		ht.insert("a", 9);
		ht.insert("e", 5);
		ht.insert("f", 6);
		System.out.println(ht);
		ht.remove("a");
		System.out.println(ht);
		ht.remove("b");
		ht.remove("x");
		System.out.println(ht);
		ht.remove("c");
		System.out.println(ht);
		ht.remove("d");
		System.out.println(ht);
		ht.remove("e");
		System.out.println(ht);
		ht.remove("f");
		System.out.println(ht);
		ht.remove("c");
		ht.remove("d");
		ht.remove("e");
		System.out.println(ht);
		ht.remove("f");
	}
}
/*
[f, 6; c, 3; 
d, 4; a, 9; 
e, 5; b, 2; 
]

[f, 6; c, 3; 
d, 4; 
e, 5; b, 2; 
]

[f, 6; c, 3; 
d, 4; 
e, 5; 
]

[f, 6; 
d, 4; 
e, 5; 
]

[f, 6; 
e, 5; 
]

[f, 6; 
]

[]

[]

 */
