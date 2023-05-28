package HashTable;

public class HashNodeGenery<K,V> {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		HashNodeGenery other = (HashNodeGenery) obj;
		if (key == null) {
			return other.key == null;
		} else return key.equals(other.key);
	}
	K key;
	V data;
	HashNodeGenery<K,V> next;

	public HashNodeGenery(K k, V v, HashNodeGenery<K,V> n){ 
		key = k; 
		data = v; 
		next = n; 
	}
	public String toString(){
		return key + ", " + data;
	}
}
