package class020;

// 用这个例子讲解递归如何执行
public class GetMaxValue {

    public static int maxValue(int[] arr) {
        return f(arr, 0, arr.length - 1);
    }

    /**
     * 递归的理解：
     * 递归方法不停入栈，入栈的递归方法遇到终止条件，递归方法出栈！
     *
     * 递归总可以用非递归的方式实现，即递归一定可以改成非递归！
     *
     * 递归在工程上尽量避免，因为递归层数多的话，容易造成栈溢出！
     *
     *
     * 递归找到数组最大值
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int findMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int m = (l + r) / 2;
        int lMax = findMax(arr, l, m);
        int rMax = findMax(arr, m + 1, r);
        return Math.max(lMax, rMax);
    }

    // arr[l....r]范围上的最大值
    public static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int m = (l + r) / 2;
        int lmax = f(arr, l, m);
        int rmax = f(arr, m + 1, r);
        return Math.max(lmax, rmax);
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, 4, 5, 1, 2};
        System.out.println("数组最大值 : " + maxValue(arr));
    }


}
