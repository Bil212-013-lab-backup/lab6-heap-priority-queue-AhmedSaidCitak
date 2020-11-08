
public class PriorityQueue {
	
	private Node[] pQueue;
	private int lastNode;
	private int size;
	
	public PriorityQueue(int s) {
		size = s;
		pQueue = new Node[size+1];
		lastNode = 0;
	}
	
	public Node insert(int key, int value) {
		Node newNode = new Node(key, value);
		int both = key + value;
		if(pQueue[1] == null) {
			pQueue[1] = newNode;
			lastNode++;
		}
		else {
			int i = lastNode+1;
			while(i!=1 && pQueue[i/2].getBoth() > both) {
				pQueue[i] = pQueue[i/2];
				i = i/2;
			}
			pQueue[i] = newNode;
			lastNode++;
		}
		return newNode;
	}
	
	public Node removeMin() {
		Node newNode = pQueue[1];
		Node tmp = pQueue[lastNode];
		pQueue[lastNode] = null;
		int i=1, ci=2;
		while(i<=lastNode) {
			if(pQueue[ci].getValue() > pQueue[ci+1].getValue())
				ci++;
			if(tmp.getValue() < pQueue[ci].getValue())
				break;
			pQueue[i] = pQueue[ci];
			i=ci;
			ci=ci*2;
		}
		pQueue[i] = tmp;
		lastNode--;
		return newNode;
	}
	
	public void calculate() {
		int sum = 0;
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=i; j++) {
				sum += pQueue[j].getValue();
			}
			sum -= pQueue[i].getKey();
		}
		System.out.println(sum/size);
	}
}
