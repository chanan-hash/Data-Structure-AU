public class Interval {
    
    private double l , r ; // The interval is represented by 2 double values
     public Interval(double l, double r){
         this.l = l;
         this.r = r;
     }

     public Interval(Interval i){
         this.l = i.l;
         this.r = i.r;
     }
}
