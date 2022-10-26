package camp;

import java.util.ArrayList;
import java.util.UUID;

public class CounselorList {
    private ArrayList<Counselor> counselors;
    private static CounselorList counselorList;
    
    private CounselorList(){
        counselors = DataLoader.loadCounselors();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of camp
     * @return the instance of camp
     */
    public static CounselorList getInstance(){
        if (counselorList == null){
            counselorList = new CounselorList();        
        }
        return counselorList;
    }

    public ArrayList<Counselor> getCounselors(){
        return counselors;
    }

    public Counselor getCounselor(UUID id) {
        for (int i = 0; i < counselors.size(); i++) {
            if (counselors.get(i).getID().equals(id)) {
                return counselors.get(i);
            }
        }
        return null; // if unable to find it
    }

}