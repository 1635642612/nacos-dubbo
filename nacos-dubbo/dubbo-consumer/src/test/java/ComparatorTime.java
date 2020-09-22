import java.util.Comparator;

public class ComparatorTime implements Comparator {
    /**
     * 
     * TODO 以对象Time判断两个list对象排序（可选）.
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Object arg0, Object arg1) {
        User cb ;
        User2 rd ;
        User cb1 ;
        User2 rd1 ;
        if(arg0 instanceof User){
            cb=(User)arg0;
            if(arg1 instanceof User2){
                rd=(User2)arg1;
                return cb.getDay().compareTo(rd.getBirth());
            }else{
                cb1=(User)arg1;
                return cb.getDay().compareTo(cb1.getDay());
            }
        }else{
            rd1=(User2)arg0;
            if(arg1 instanceof User2){
                rd=(User2)arg1;
                return rd1.getBirth().compareTo(rd.getBirth());
            }else{
                cb=(User)arg1;
                return rd1.getBirth().compareTo(cb.getDay());
            }
        }
    }
}