import java.util.Arrays;

public class ex4 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8};
        int[] c = merge(a, b);

        System.out.println(Arrays.toString(c));

        int[] d = {-5,-4,-3,-2,-1,0};
        System.out.println(Arrays.toString(merge3(a,b,d)));
    }


    // merging three sorted arrays.
    // like regular merge but with three arrays,
    // we can create a new function, or to use regular merge twice.

   /* public static int[] merge3(int[] a, int[] b, int[] c) {
        int[] d = new int[a.length + b.length + c.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length && k < c.length) {
            if (a[i++] < b[j++] && a[i++] < c[k++])
                d[i + j + k] = a[i++];
            else if (b[j++] < c[k++]){ // means b<a, but need to check if also b<c
                d[i + j + k] = b[j++];
            }
            else {
                d[i + j + k] = c[k++];
            }
        }

// putting the rest of the values but can be problem if they all length are different it can be a problem we'll need more loop for each case


        return d;
    }
    */

    // Ex1
    // lest just use merge twice
    public static int[] merge3(int[] a1, int[] a2, int[] a3) {
        return merge(a1, merge(a2, a3)); // using regular merge twice
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }


    // Ex2

}
