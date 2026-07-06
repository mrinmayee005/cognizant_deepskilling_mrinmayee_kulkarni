public class SearchFunctions {

    // Linear Search
    public static Product linearSearch(Product[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productId == key) {
                return arr[i];
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].productId == key) {
                return arr[mid];
            } else if (arr[mid].productId < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}