package camp;

import java.util.ArrayList;
import java.util.UUID;
/**
 * @author Natalie Crawford
 * the counselor list class
 */

public class CounselorList {
    private ArrayList<Counselor> counselors;
    private static CounselorList counselorList;
    
    /**
     * default constructor
     */
    private CounselorList(){
        counselors = DataLoader.loadCounselors();
        
    }
    
    /**
     * implements singleton design pattern, gets the instance of counselor
     * @return the instance of counselor
     */
    public static CounselorList getInstance(){
        if (counselorList == null){
            counselorList = new CounselorList();        
        }
        return counselorList;
    }

    /**
     * gets the array list of counselors
     * @return counselors
     */
    public ArrayList<Counselor> getCounselors(){
        return counselors;
    }

    /**
     * accesses a counselor via uuid
     * @param id the specific uuid
     * @return the counselor with that uuid
     */
    public Counselor getCounselor(UUID id) {
        for (int i = 0; i < counselors.size(); i++) {
            if (counselors.get(i).getID().equals(id)) {
                return counselors.get(i);
            }
        }
        return null; // if unable to find it
    }

    public Counselor getCounselor(String email) {
        for (int i=0; i < counselors.size(); i++) {
            if (counselors.get(i).getEmail().equals(email)) {
                return counselors.get(i);
            }
        }
        return null; // if unable to find it
    }

}