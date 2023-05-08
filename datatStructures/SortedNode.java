public class SortedNode {
    String data;
    SortedNode next;

    public SortedNode(String data ,SortedNode next){
        this.data = data;
        this.next = next;
    }

    public SortedNode(String data){
        this.data = data;
        this.next = null;
    }
    public String toString(){
        return this.data;
    }
}
