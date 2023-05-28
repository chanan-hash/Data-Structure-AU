package HashTable;
// http://en.literateprograms.org/Hash_table_%28Java%29
public class MyHashTableGenery<K,V> {
	private HashNodeGenery<K,V>[] nodes;

	@SuppressWarnings("unchecked")
	public MyHashTableGenery(int size){
		nodes = new HashNodeGenery[size];
	}


	private int getIndex(K key){
		int hash = key.hashCode() % nodes.length;
		if (hash < 0)
			hash = hash + nodes.length;
		return hash;
	}

	public V insert(K key, V data){
		int hash = getIndex(key);
		for (HashNodeGenery<K,V> node=nodes[hash]; node!=null; node=node.next) {
			if (key.equals(node.key)) {
				V oldData = node.data;
				node.data = data;
				return oldData;
			}
		}
		HashNodeGenery<K,V> node = new HashNodeGenery<K,V>(key, data, nodes[hash]);
		nodes[hash] = node;
		return null;
	}


	public boolean remove(K key){
		int hash = getIndex(key);

		HashNodeGenery<K,V> prevNode = null;
		for (HashNodeGenery<K,V> node = nodes[hash]; node != null; node = node.next) {
			if (key.equals(node.key)) {
				if (prevNode != null)
					prevNode.next = node.next;
				else
					nodes[hash] = node.next;
				return true;
			}
			prevNode = node;
		}
		return false;
	}

	public V get(K key){
		HashNodeGenery<K,V> node;
		V value = null;
		int hash = getIndex(key);
		for (node = nodes[hash]; node != null; node = node.next) {
			if (key.equals(node.key))
				value =  node.data;
		}
		return value;
	}

	public void resize(int size){
		MyHashTableGenery<K,V> newTable = new MyHashTableGenery<K,V>(size);
		for (int i=0; i<nodes.length; i++){
			HashNodeGenery<K,V> node = nodes[i];
		//for (HashNodeGenery<K,V> node : nodes) {
			for ( ; node != null; node = node.next) {
				newTable.insert(node.key, node.data);
				remove(node.key);
			}
		}
		nodes = newTable.nodes;
	}
	public void printTable(){
		for (int i=0; i<nodes.length; i++){
			if (nodes[i]!=null){
				HashNodeGenery<K,V> node = nodes[i];
				while (node != null){
					System.out.print(node.toString()+"; " );
					node = node.next;
				}
				System.out.println();
			}
		}
	}


	public static void main(String[] args){
		MyHashTableGenery<String,String> ht = new MyHashTableGenery<String,String>(8);

		ht.insert("031234567", "Israel");
		ht.insert("043216549", "Haiim");
		ht.insert("053369852", "Rahel");
		ht.insert("314123456", "Lea");
		ht.insert("302145698", "Dan");
		ht.insert("665123456", "Rivka");

		ht.printTable();

		String i = ht.get("031234567");
		System.out.println("031234567: " + (i != null ? i : "-"));
		String r = ht.get("053369852");
		System.out.println("053369852: " + (r != null ? r : "-"));

		ht.remove("053369852");

		System.out.println("After remove:");
		r = ht.get("053369852");
		System.out.println("053369852: " + (r != null ? r : "-"));
		i = ht.get("314123456");
		System.out.println("314123456: " + (i != null ? i : "-"));

		System.out.println("After resize:");
		ht.resize(3);
		ht.printTable();

		i = ht.get("302145698");
		System.out.println("302145698: " + (i != null ? i : "-"));
	}
}


