
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
		
		int i = lastNode+1;
		while(i!=1 && pQueue[i/2].getBoth() > both) {
			pQueue[i] = pQueue[i/2];
			i = i/2;
		}
		pQueue[i] = newNode;
		lastNode++;
		
		return newNode;
	}
	
	public Node removeMin() {
		Node newNode = pQueue[1];
		Node tmp = pQueue[lastNode];
		pQueue[lastNode] = null;
		int i=1, ci=2;
		while(i<lastNode && ci+1<lastNode) {
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
	
	public void print() {
		for(int i=1; i<=lastNode; i++) {
			System.out.println(pQueue[i].getValue());
		}
	}
	
	public void calculate() {
		int sum = 0;
		int temp = 0;
		int point = 0;
		Node newNode;
		for(int i=1; i<=size; i++) {
			newNode = removeMin();
			sum += newNode.getValue();
			if(i==1)
				point += newNode.getBoth();
			else {
				sum += point - newNode.getKey();
				point += newNode.getValue();
			}
//			System.out.println(sum);
		}
		System.out.println(sum/size);
	}
}


/*
   for(int i=1; i<=size; i++) {
			newNode = removeMin();
			sum += newNode.getValue()+temp;
			temp += newNode.getValue(); 
//			point += newNode.getBoth();
			if(i!=1)
				sum -= newNode.getKey();
			System.out.println(sum);
		}
*/