//https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (al.isEmpty() || al.get(al.size() - 1) != a[i]) {
                    al.add(a[i]);
                }
                i++;
            } else if (a[i] > b[j]) {
                if (al.isEmpty() || al.get(al.size() - 1) != b[j]) {
                    al.add(b[j]);
                }
                j++;
            } else {
                // a[i] == b[j], add only once
                if (al.isEmpty() || al.get(al.size() - 1) != a[i]) {
                    al.add(a[i]);
                }
                i++;
                j++;
            }
        }

        // Add remaining elements from a[]
        while (i < a.length) {
            if (al.isEmpty() || al.get(al.size() - 1) != a[i]) {
                al.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from b[]
        while (j < b.length) {
            if (al.isEmpty() || al.get(al.size() - 1) != b[j]) {
                al.add(b[j]);
            }
            j++;
        }

        return al;
    }
}
