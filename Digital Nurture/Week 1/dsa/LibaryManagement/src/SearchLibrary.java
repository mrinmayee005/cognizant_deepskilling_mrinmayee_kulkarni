public class SearchLibrary {

    // Linear Search
    public static Book linearSearch(Book[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].title.equalsIgnoreCase(key)) {
                return arr[i];
            }
        }
        return null;
    }
    // Binary Search
    public static Book binarySearch(Book[] arr, String key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = arr[mid].title.compareToIgnoreCase(key);

            if (result == 0) {
                return arr[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}