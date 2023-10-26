package class021;

/**
 * 归并排序：使用递归实现
 */
// 归并排序，acm练习风格
// 测试链接 : https://www.nowcoder.com/practice/bc25055fb97e4a0bb564cb4b214ffa92
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code01_MergeSort {

    // 题目没有说数据量，按道理是要说的
    // 根据实验，长度500以内够用了
    // 如果有一天牛客升级了数据量导致出错
    // 把这个值改大即可
    public static int MAXN = 501;

    public static int[] arr = new int[MAXN];

    public static int[] help = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            // mergeSort1为递归方法
            // mergeSort2为非递归方法
            // 用哪个都可以
            // mergeSort1(0, n - 1);
            mergeSort2();
            out.print(arr[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + arr[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }

    // 归并排序递归版
    // 假设l...r一共n个数
    // T(n) = 2 * T(n/2) + O(n)
    // a = 2, b = 2, c = 1
    // 根据master公式，时间复杂度O(n * logn)
    // 空间复杂度O(n)
    public static void mergeSort1(int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        merge(l, m, r);
    }

    // 归并排序非递归版
    // 时间复杂度O(n * logn)
    // 空间复杂度O(n)
    public static void mergeSort2() {
        // 一共发生O(logn)次
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            // 内部分组merge，时间复杂度O(n)
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }

    // l....r 一共有n个数
    // O(n)
    public static void merge(int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        // 左侧指针、右侧指针，必有一个越界、另一个不越界
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }


    /**
     * 归并排序思路：左边排好序，右边排好序，再左右两边merge形成整体有序
     * 递归实现归并排序
     */
    private static void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        // 左边排好序
        mergeSort(l, m);
        // 右边排好序
        mergeSort(m + 1, r);
        // merge归并整体有序
        guiBing(arr, l, r);
    }

    /**
     * 归并排序：非递归版本
     * 核心：定义步长step：1 2 4 8 16 。。。。。。
     */
    private static void mergeSortByStep() {
        int m = 0;
        // 复杂度：log(n)
        for (int left, right, step = 1; step < n; step *= 2) {
            left = 0;
            // 复杂度：n
            while (left < n) {
                m = left + step - 1;
                // 没有右侧退出：左侧不够数，右侧没有数的情况
                if (m + 1 >= n) {
                    break;
                }
                // 还有右侧
                right = Math.min(left + 2 * step - 1, n - 1);
                guiBing(arr, left, m, right);
                left = right + 1;
            }
        }
    }

    /**
     * 归并算法
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void guiBing(int[] arr, int l, int m, int r) {
        int a = l;
        int b = m + 1;
        int i = l;
        // 左右两边整体排序，保存在辅助数组上
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        // l-r范围排好序的拷贝回arr数组
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }


    /**
     * 归并算法
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void guiBing(int[] arr, int l, int r) {
        int m = (l + r) / 2;
        int a = l;
        int b = m + 1;
        int i = l;
        // 左右两边整体排序，保存在辅助数组上
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        // l-r范围排好序的拷贝回arr数组
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
    }

}