public class NodeNum {

    Integer num;
    NodeNum next;

    public NodeNum(Integer num){
        this.num = num;
        next = null;
    }
    public NodeNum(Integer val, NodeNum next){
        this.num = val;
        this.next = next;
    }
}
