public class LeeadLL {
    public class MyLL {

        private LLNode head, tail;

        // O(1)
        public void addHead(int data) {
            LLNode tempNode = new LLNode(data);
            tempNode.setNext(head);
            head = tempNode;
            if(tail == null) tail = tempNode;
        }

        // O(1)
        public void addTail(int data) {
            LLNode tempNode = new LLNode(data);
            if(head == null)
                head = tempNode;
            else
                tail.setNext(tempNode);
            tail = tempNode;
        }

        // O(1)
        public int deleteHead() {
            int answer = Integer.MAX_VALUE;
            if(head == null) tail = null;
            else {
                answer = head.getData();
                head = head.getNext();
            }
            return answer;
        }

        // O(n)
        public int deleteTail() {
            int answer = Integer.MAX_VALUE;
            if(tail == null) return answer;
            if(head == tail) {
                answer = tail.getData();
                head = null;
                tail = null;
                return answer;
            }

            LLNode temp = head;
            while(temp.getNext().getNext() != null)
                temp = temp.getNext();

            answer = tail.getData();
            tail = temp;
            temp.setNext(null);
            return answer;
        }

        private class LLNode {

            private int data;
            private LLNode next;

            public LLNode(int init_data) {
                data = init_data;
            }

            public LLNode getNext() {
                return next;
            }

            public void setNext(LLNode next) {
                this.next = next;
            }

            public int getData() {
                return data;
            }

        }

    }
}
