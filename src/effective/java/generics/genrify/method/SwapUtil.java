package effective.java.generics.genrify.method;

public class SwapUtil {
    @SuppressWarnings("unchecked")
    public static <T> T[] swapElements(T[] arr, int i, int j) {
        T[] copy = (T[]) new Object[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        copy[i] = arr[j];
        copy[j] = arr[i];
        return copy;
    }
}
