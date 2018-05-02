/**
 * @RagulRavindiran
 */
package UOG;

import java.util.ArrayList;

public class OptModDetails {

    //Storing all optional module details to allopt ArrayList
    private ArrayList allopt = new ArrayList();

    public ArrayList getAllopt() {
        return allopt;
    }

    /**
     * This function assign the modulecode and marks for respective modules
     * @param modulecode || module code of the module
     * @param marks || marks obtained for that module
     */
    public void addOpt(String modulecode, int marks) {

        ArrayList onemodule = new ArrayList();
        onemodule.add(modulecode);
        onemodule.add(marks);
        allopt.add(onemodule);

    }
}
