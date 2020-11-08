
public class Node {

	private int key, value, both;
	
	public Node(int k, int v) {
		key = k;
		value = v;
		both = k+v;
	}
	
	public void setKey(int k) {
		key = k;
	}
	
	public void setValue(int v) {
		value = v;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getBoth() {
		return both;
	}
}
