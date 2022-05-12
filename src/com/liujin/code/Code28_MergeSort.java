package com.liujin.code;

//归并排序
public class Code28_MergeSort {
    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，请让这个范围上的数，有序！
    public static void process(int[] arr, int L, int R) {
        //说明只有一个元素，是有序的
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    //merge合并
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        // 要么p1越界，要么p2越界
        // 不可能出现：共同越界
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p2越界了p1继续
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        //p1越界了p2继续
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //最后把help数组上的元素赋值到arr
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    //非递归方法实现   研究步数，考虑边界问题
    public static void mergesort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N) {
            int L = 0;
            while (L < N) {
                int M = 0;
                /**
                 * 根据L找M位置
                 * 如果左组最后一组凑不齐
                 *N-1-L+1--->N-L 找L-N-1有多少个数
                 */
                if (N - L >= step) {
                    //说明能够凑齐，M能来一个正常的位置
                    M = L + step - 1;
                } else {
                    //凑不齐
                    M = N - 1;
                }
                /**
                 * 上面的问题导致你M是N-1，说明你没有右组，就直接结束了
                 * 有可能左组也没凑齐默认的N-1
                 * L...M
                 */
                if (M == N - 1) {
                    break;
                }
                //L...M M+1...R
                //根据M找R位置
                int R = 0;
                if (N-1-M >= step){
                    //R能够来一个正常的位置
                    //M+1-step-1--->M+step
                    R = M + step;
                }else {
                    //右组凑不齐
                    R = N - 1;
                }
                //merge合并L...M M+1...R
                merge(arr, L, M, R);
                //如果我R来到N-1位置了说明在往下位置不存在左组了
                if (R == N-1){
                    break;
                }else {
                    //如果没有来到N-1位置，说明有继续的左组，L来到R+1位置
                    L = R + 1;
                }
            }
            //除2是向下取整所以不能>=2(假设17这个数，步长到8是不够的，但17向下取整8就停止了，就到不了16导致出错了)
            if (step > N / 2) {
                break;
            }
            step *= 2;
        }
    }


    // 非递归方法实现
//	public static void mergeSort2(int[] arr) {
//		if (arr == null || arr.length < 2) {
//			return;
//		}
//		int N = arr.length;
//		int mergeSize = 1;
//		while (mergeSize < N) {
//			int L = 0;
//			while (L < N) {
//				if (mergeSize >= N - L) {
//					break;
//				}
//				int M = L + mergeSize - 1;
//				int R = M + Math.min(mergeSize, N - M - 1);
//				merge(arr, L, M, R);
//				L = R + 1;
//			}
//			if (mergeSize > N / 2) {
//				break;
//			}
//			mergeSize <<= 1;
//		}
//	}
    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergesort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }



}
