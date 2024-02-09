class SnapshotArray {
    List<Info>[] arr;
    int snap = 0;
    public SnapshotArray(int length) {
        arr = new ArrayList[length];
    }
    
    public void set(int index, int val) {
        if(arr[index] == null){
            arr[index] = new ArrayList<>();
        }
        int size = arr[index].size();
        if(size == 0){
            arr[index].add(new Info(val, snap));
        }else{
            if(arr[index].get(size - 1).snap == snap){
                arr[index].get(size - 1).val = val;
            }else{
                arr[index].add(new Info(val, snap));
            }
        }
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        if(arr[index] == null || arr[index].size() == 0){
            return 0;
        }
        return bs(0, arr[index].size() - 1, index, arr, snap_id);
    }

    public int bs(int low, int high, int idx, List<Info>[] arr, int target){

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[idx].get(mid).snap == target){
                return arr[idx].get(mid).val;
            }else if(arr[idx].get(mid).snap < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(high < 0){
           return 0;
        }
        return arr[idx].get(high).val;
    }

    public class Info{
        int val;
        int snap;

        public Info(int val, int snap){
            this.val = val;
            this.snap = snap;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */