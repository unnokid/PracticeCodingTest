package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MyCalendar3 {

  public static void main(String[] args) {

  }
  static class MyCalendarThree {
    private Map<Integer,Integer> vals;
    private Map<Integer,Integer> lazy;
    public MyCalendarThree() {
      vals = new HashMap<>();
      lazy = new HashMap<>();
    }
    public void change(int start, int end, int left,int right,int idx){
      if(start > right || end < left){
        return;
      }

      if(start<=left && right <= end){
        vals.put(idx,vals.getOrDefault(idx,0)+1);
        lazy.put(idx,lazy.getOrDefault(idx,0)+1);
      }else{
        int mid = (left+right)/2;
        change(start,end,left,mid,idx*2);
        change(start,end,mid+1,right,idx*2+1);
        vals.put(idx,lazy.getOrDefault(idx,0)+Math.max(vals.getOrDefault(idx*2,0),vals.getOrDefault(idx*2+1,0)));
      }
    }

    public int book(int start, int end) {
      change(start,end-1,0,1000000000,1);
      return vals.getOrDefault(1,0);
    }
  }
}
