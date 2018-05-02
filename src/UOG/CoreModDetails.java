/**
 * @RagulRavindiran
 */
package UOG;

import java.util.ArrayList;

public class CoreModDetails {

    //Storing all compulsory module details to allcom ArrayList
    private ArrayList allcom = new ArrayList();

    public ArrayList getAllcom() {
        return allcom;
    }

    /**
     * This function assign the modulecode and marks for respective modules
     * @param modulecode || module code of the module
     * @param marks || marks obtained for that module
     */
    public void addCom(String modulecode, int marks) {

        ArrayList onemodule = new ArrayList();
        onemodule.add(modulecode);
        onemodule.add(marks);
        allcom.add(onemodule);

    }


}
